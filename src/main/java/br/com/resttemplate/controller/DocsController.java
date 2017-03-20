package br.com.resttemplate.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import br.com.resttemplate.model.docs.Clazz;
import br.com.resttemplate.model.docs.annotations.ClassDescription;
import br.com.resttemplate.model.docs.annotations.EnableDocumentation;
import br.com.resttemplate.model.docs.annotations.MethodDescription;
import br.com.resttemplate.model.docs.annotations.ParamDescription;

import com.google.gson.Gson;
import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

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
			List<Clazz> clazz = new ArrayList<Clazz>();
			Gson gson = new Gson();

			for (Map.Entry<String, Object> obj : beanFactory.getBeansWithAnnotation(EnableDocumentation.class).entrySet()) {
				clazz.add(new Clazz(obj.getValue().getClass()));
			}

			response.setContentType("application/json");
			response.getWriter().write(gson.toJson(clazz));

		} catch (Exception ex) {
			throw new Exception("Alguma coisa deu errado :( "+ex);
		}
	}
}
