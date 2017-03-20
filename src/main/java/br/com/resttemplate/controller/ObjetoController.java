package br.com.resttemplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.resttemplate.model.docs.annotations.ClassDescription;
import br.com.resttemplate.model.docs.annotations.MethodDescription;
import br.com.resttemplate.model.docs.annotations.ParamDescription;

@RestController
@RequestMapping("/objeto")
@ClassDescription(classAuthor="Marcus Cartágenes", classDescription="Descrição da Classe")
public class ObjetoController {
	
	@RequestMapping(value="/nome")
	@MethodDescription(description="Retornar nome do usuário", author="Marcus Cartágenes", dateCreated="19/03/2017")
	public String nome(@ParamDescription(description="Nome", optional=false)String nome){
		return new String();
	}

}
