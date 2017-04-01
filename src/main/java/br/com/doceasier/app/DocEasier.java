package br.com.doceasier.app;

import java.net.URISyntaxException;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.meta.Project;

public abstract class DocEasier {
	
	public static Object storeMyDocIntoAJson() throws URISyntaxException, DoceasierException {
		Project project = new Project(new Scanner().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET));
		return project;
	}
	
	/*public static void main(String... args) throws URISyntaxException, Exception{
		Project project = new Project(new Scanner().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET));
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		gsonBuilder.setPrettyPrinting();
		Gson g = gsonBuilder.create();
		System.out.println(g.toJson(project));
		Project p = (Project) storeMyDocIntoAJson();
		System.out.println(p);
	}*/
	
	
}
