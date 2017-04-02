package br.com.doceasier.model.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.doceasier.exception.DoceasierException;

@SuppressWarnings({"unused","rawtypes"})
public class Project {

	private String name;
	private String description;
	private String url;
	private List<Class> classes = new ArrayList<Class>();
	
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
	
}
