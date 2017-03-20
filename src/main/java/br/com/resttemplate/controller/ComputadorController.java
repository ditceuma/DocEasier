package br.com.resttemplate.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.resttemplate.model.docs.annotations.ClassDescription;
import br.com.resttemplate.model.docs.annotations.EnableDocumentation;
import br.com.resttemplate.model.docs.annotations.MethodDescription;
import br.com.resttemplate.model.docs.annotations.ParamDescription;

@RestController
	@EnableDocumentation
@ClassDescription(classAuthor="Marcus Cartágenes", classDescription="Controller responsável por gerenciar computadores")
public class ComputadorController {

	
	@MethodDescription(author="Marcus Cartágenes", dateCreated="20/03/2017", description="Retornar um computador")
	public String retornarComputador(@ParamDescription(description="Id do computador", optional=false)String pid){
		return null;
	}
	
	
}
