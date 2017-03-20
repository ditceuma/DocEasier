package br.com.doceasier.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.doceasier.model.docs.annotations.ClassDescription;
import br.com.doceasier.model.docs.annotations.EnableDocumentation;
import br.com.doceasier.model.docs.annotations.MethodDescription;
import br.com.doceasier.model.docs.annotations.ParamDescription;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/doc")
@EnableDocumentation
@ClassDescription(classAuthor = "Marcus Cartágenes", classDescription = "Classe responsável por documentação de Serviços")
public class DocsController {

	@Autowired
	private ListableBeanFactory beanFactory;
	
	@RequestMapping(value="/show")
	public String showPage(){
		return "showDocs";
	}

	@RequestMapping(value="/getAllInformations", method=RequestMethod.GET)
	@MethodDescription(
			author="Marcus Cartágenes", 
			description="Método para exibir a documentação do projeto",
			dateCreated="19/03/2017")
	public void showDocumentation(@ParamDescription(description="ServletResponse", optional=false)HttpServletResponse response) throws Exception {
		try {
			List<br.com.doceasier.model.docs.Class> clazz = new ArrayList<br.com.doceasier.model.docs.Class>();
			Gson gson = new Gson();

			for (Map.Entry<String, Object> obj : beanFactory.getBeansWithAnnotation(EnableDocumentation.class).entrySet()) {
				clazz.add(new br.com.doceasier.model.docs.Class(obj.getValue().getClass()));
			}

			response.setContentType("application/json");
			response.getWriter().write(gson.toJson(clazz));

		} catch (Exception ex) {
			throw new Exception("Alguma coisa deu errado :( "+ex);
		}
	}
}
