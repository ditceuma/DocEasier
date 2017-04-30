package br.com.doceasier.app;

import org.reflections.Reflections;

import com.google.gson.Gson;

import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.annotations.EnableDocumentation;
import br.com.doceasier.model.meta.Project;

public abstract class DocEasier {
	public static Object generateDocs() throws DoceasierException {
		Reflections reflections = new Reflections("");
		if(reflections.getTypesAnnotatedWith(br.com.doceasier.model.annotations.Project.class).size() != 1){
			throw new DoceasierException("Você só pode ter uma classe anotada com @Project");
		}else if(reflections.getTypesAnnotatedWith(br.com.doceasier.model.annotations.Project.class).size() == 1){
			for(Class<?> c:reflections.getTypesAnnotatedWith(br.com.doceasier.model.annotations.Project.class)){
				if(!c.isAnnotationPresent(EnableDocumentation.class)){
					throw new DoceasierException("A anotação @Project precisa estar em uma classe com @EnableDocumentation");
				}else{
					Project project = new Project(reflections.getTypesAnnotatedWith(EnableDocumentation.class));
					return project;
				}
			}
		}
		return null;
	}
}
