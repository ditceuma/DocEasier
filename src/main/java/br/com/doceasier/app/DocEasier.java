package br.com.doceasier.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.doceasier.model.docs.annotations.EnableDocumentation;

import com.google.gson.Gson;

@Component
public class DocEasier {

	public static String storeMyDocIntoAJson(ListableBeanFactory beanFactory) throws Exception {
		try {
			List<br.com.doceasier.model.docs.Class> clazz = new ArrayList<br.com.doceasier.model.docs.Class>();
			Gson gson = new Gson();
	
			for (Map.Entry<String, Object> obj : beanFactory.getBeansWithAnnotation(EnableDocumentation.class).entrySet()) {
				clazz.add(new br.com.doceasier.model.docs.Class(obj.getValue().getClass()));
			}
			return gson.toJson(clazz);
		} catch (Exception ex) {
			throw new Exception("Alguma coisa deu errado :( "+ex);
		}
	}
}
