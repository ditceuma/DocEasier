package br.com.resttemplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.resttemplate.model.Pessoa;
import br.com.resttemplate.model.docs.annotations.ClassDescription;
import br.com.resttemplate.model.docs.annotations.EnableDocumentation;
import br.com.resttemplate.model.docs.annotations.MethodDescription;
import br.com.resttemplate.model.docs.annotations.ParamDescription;


@RestController
@RequestMapping("/hello")
@EnableDocumentation
@ClassDescription(classAuthor="Marcus Cartágenes", classDescription="Classe de Teste")
public class PessoaController {

	@RequestMapping(value="/teste", method= RequestMethod.GET)
	@MethodDescription(description="Método responsável por recuperar Usuário", author="Marcus Cartágenes",dateCreated="19/03/2017")
	public @ResponseBody Pessoa teste(
			@ParamDescription(description="Nome do usuario", optional=false)String nome,
			@ParamDescription(description="CPF do Usuario", optional=false)String cpf,
			@ParamDescription(description="Idade do Usuario", optional=false)String idade,
			@ParamDescription(description="Objeto Pessoa", optional=false)Pessoa pe){
		Pessoa p = new Pessoa(1, "Marcus Cartágenes", "06058838312");
		return p;
	}
	
	@RequestMapping(value="/salvarUsuario")
	@MethodDescription(
			description="Método Responsável por salvar o usuário", 
			author="Marcus Cartágenes",
			dateCreated="19/03/2017")
	public void salvarPessoa(@ParamDescription(description="Pessoa que vai ser salva", optional=false)Pessoa p){
		
	}
	
	@RequestMapping(value="/getPessoa")
	public void getPessoa(String nome){
		
	}
}
