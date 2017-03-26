package br.com.doceasier.app;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.Project;
import br.com.doceasier.model.annotations.EnableDocumentation;

import com.google.gson.Gson;

public class DocEasier {
	
	public static void main(String... args) throws URISyntaxException, DoceasierException {
		Project project = new Project(new Scanner().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET));
		System.out.println(new Gson().toJson(project));
	}
	
	
}
