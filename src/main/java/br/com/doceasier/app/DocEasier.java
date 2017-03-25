package br.com.doceasier.app;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.doceasier.model.annotations.EnableDocumentation;

import com.google.gson.Gson;

public class DocEasier {
	
	public static void main(String... args) throws URISyntaxException {
		List<Class> classes = new ArrayList<Class>(new Scanner().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET));
		List<br.com.doceasier.model.Class> clazz = new ArrayList<br.com.doceasier.model.Class>();
		Gson gson = new Gson();
		for (Class c : classes) {
			clazz.add(new br.com.doceasier.model.Class(c));
		}
		System.out.println(gson.toJson(clazz));
	}
	
	
}
