package br.com.doceasier.app;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.annotations.EnableDocumentation;
import br.com.doceasier.model.annotations.Project;

@SuppressWarnings({ "rawtypes" })
public final class Scanner {
	
	private List<Class> classes;
	private List<Class> classesAnnotedWithProject;
	
	public Scanner() {
		classes = new ArrayList<Class>();
		classesAnnotedWithProject = new ArrayList<Class>();
	}
	
	protected List<Class> scan(ClassLoader classLoader, Set<String> locations,Set<String> packages) throws URISyntaxException, Exception {
		if (!(classLoader instanceof URLClassLoader)) {
			return null;
		}
		URLClassLoader urlLoader = (URLClassLoader) classLoader;
		URL[] urls = urlLoader.getURLs();
		for (URL url : urls) {
			String path = url.getFile();
			File location = null;
			try {
				location = new File(url.toURI());
			} catch (URISyntaxException e) {
				throw new URISyntaxException(path, e.getReason());
			}
			if (matchesAny(path, locations)) {
				if (location.isDirectory()) {
					this.getClassesInDirectory(null, location, packages);
				}
			}
			
			if(this.classesAnnotedWithProject.size() == 0){
				throw new Exception("Você precisa anotar uma classe com @Project, e esta classe precisa estar anotada com @EnableDocumentation");
			}
		}
		return classes;
	}
	protected void getClassesInDirectory(String parent, File location,
			Set<String> packagePatterns) throws Exception {
		File[] files = location.listFiles();
		StringBuilder builder = null;
		for (File file : files) {
			builder = new StringBuilder(100);
			builder.append(parent).append("/").append(file.getName());
			String packageOrClass = (parent == null ? file.getName() : builder.toString());
			if (file.isDirectory()) {
				getClassesInDirectory(packageOrClass, file, packagePatterns);
			} else if (file.getName().endsWith(".class")) {
				if (matchesAny(packageOrClass, packagePatterns)) {
					String className = packageOrClass.replace("/", ".");
					try{
						Class c = Class.forName(className.replace(".class", ""));
						this.verifyClass(c, classesAnnotedWithProject);
					}catch(ClassNotFoundException ex){
						throw new Exception("Classe não encontrada :( "+file.getName().replace("/", "."));
					}
				}
			}
		}
	}
	
	
/*	protected static void getClassesInJar(File location,Set<String> packagePatterns) {
		try {
			JarFile jar = new JarFile(location);
			Enumeration entries = jar.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				String name = entry.getName();
				if (!entry.isDirectory() && name.endsWith(".class")) {
					if (matchesAny(name, packagePatterns)) {
						
					}
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}*/
	
	
	@SuppressWarnings("unchecked")
	private void verifyClass(Class c, List<Class> annotedClassesWithProject) throws DoceasierException{
		if(c.isAnnotationPresent(EnableDocumentation.class)){
			if(c.isAnnotationPresent(Project.class)){
				this.addClassAnnotedWithProject(c);
			}
			this.addClass(c);
		}
		
		if(!c.isAnnotationPresent(EnableDocumentation.class) && c.isAnnotationPresent(Project.class)){
			throw new DoceasierException("A anotação @Project precisa estar em uma classe com @EnableDocumentation");
		}
		
		if(annotedClassesWithProject.size() > 1){
			this.classesAnnotedWithProject.clear();
			throw new DoceasierException("A anotação @Project só pode estar em um classe, e esta classe precisa estar anotada com @Documentation");
		}
	}
	
	private static boolean matchesAny(String text, Set<String> filters) {
		if (filters == null || filters.size() == 0) {
			return true;
		}
		for (String filter : filters) {
			if (text.indexOf(filter) != -1) {
				return true;
			}
		}
		return false;
	}
	
	private void addClass(@SuppressWarnings("rawtypes") Class c){
		this.classes.add(c);
	}
	
	private void addClassAnnotedWithProject(Class c){
		this.classesAnnotedWithProject.add(c);
	}
}