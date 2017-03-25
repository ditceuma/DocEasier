package br.com.doceasier.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.doceasier.model.docs.annotations.EnableDocumentation;

import com.google.gson.Gson;

@EnableDocumentation
public class DocEasier {
	
	public static String storeMyDocIntoAJson(String beanFactory) throws Exception {
		try {
			List<br.com.doceasier.model.docs.Class> clazz = new ArrayList<br.com.doceasier.model.docs.Class>();
			Gson gson = new Gson();
			/*for (Map.Entry<String, Object> obj : beanFactory.getBeansWithAnnotation(EnableDocumentation.class).entrySet()) {
				clazz.add(new br.com.doceasier.model.docs.Class(obj.getValue().getClass()));
			}*/
			return gson.toJson(clazz);
		} catch (Exception ex) {
			throw new Exception("Alguma coisa deu errado :( "+ex);
		}
	}
	
	public static void main(String[] args) {
		new ScannerTest().scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET);
	}
	
	
}
