package br.com.doceasier.model.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.doceasier.exception.DoceasierException;

@SuppressWarnings({"rawtypes"})
public class Project {

	private String name;
	private String description;
	private String url;
	private List<Class> classes = new ArrayList<Class>();
	
	@SuppressWarnings("unchecked")
	public Project(Set<java.lang.Class<?>> c) throws DoceasierException {
		for (java.lang.Class clazz : c) {
			if(clazz.isAnnotationPresent(br.com.doceasier.model.annotations.Project.class)){
				br.com.doceasier.model.annotations.Project pA = (br.com.doceasier.model.annotations.Project) clazz.getAnnotation(br.com.doceasier.model.annotations.Project.class);
				this.name = pA.name();
				this.description = pA.description();
				this.url = pA.masterUrl();
			}
			classes.add(new Class(clazz));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
	
	
}
