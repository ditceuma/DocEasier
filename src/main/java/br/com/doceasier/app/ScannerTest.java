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

import br.com.doceasier.model.docs.annotations.EnableDocumentation;

public class ScannerTest {
	
	private List<Class> classes;
	public ScannerTest() {
		classes = new ArrayList<Class>();
	}
	
	public void scan(ClassLoader classLoader, Set<String> locations,
			Set<String> packages) {
		if (!(classLoader instanceof URLClassLoader)) {
			return;
		}
		URLClassLoader urlLoader = (URLClassLoader) classLoader;
		URL[] urls = urlLoader.getURLs();
		for (URL url : urls) {
			String path = url.getFile();
			File location = null;
			try {
				location = new File(url.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return;
			}
			// Only process the URL if it matches one of our filter strings
			if (matchesAny(path, locations)) {
				if (location.isDirectory()) {
					this.getClassesInDirectory(null, location, packages);
				} else {
					getClassesInJar(location, packages);
				}
			}
		}
		System.out.println(classes);
	}
	public void getClassesInDirectory(String parent, File location,
			Set<String> packagePatterns) {
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
						@SuppressWarnings({ "rawtypes", "rawtypes" })
						Class c = Class.forName(className.replace(".class", ""));
						this.verifyClass(c);
					}catch(ClassNotFoundException ex){
						System.err.println("Classe não encontrada :( "+file.getName().replace("/", "."));
					}
				}
			}
		}
	}
	public static void getClassesInJar(File location,Set<String> packagePatterns) {
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
	}
	
	
	public void verifyClass(Class c){
		if(c.isAnnotationPresent(EnableDocumentation.class)){
			this.addClass(c);
		}
	}
	
	public static boolean matchesAny(String text, Set<String> filters) {
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
	
	private void addClass(Class c){
		this.classes.add(c);
	}
}