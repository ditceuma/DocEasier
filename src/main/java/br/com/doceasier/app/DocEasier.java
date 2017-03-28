package br.com.doceasier.app;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.Project;
import br.com.doceasier.model.annotations.EnableDocumentation;

import com.google.gson.Gson;

public abstract class DocEasier {
	
	public static String storeMyDocIntoAJson() throws URISyntaxException, Exception {
		Project project = new Project(new Scanner().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET));
		return (new Gson().toJson(project));
	}
	
	public static void main(String... args) throws URISyntaxException, Exception{
		Project project = new Project(new Scanner().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET));
	}
	
	
}
