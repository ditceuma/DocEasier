package br.com.doceasier.sample;

import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.model.annotations.DocClass;
import br.com.doceasier.model.annotations.DocConstructor;
import br.com.doceasier.model.annotations.DocField;
import br.com.doceasier.model.annotations.DocMethod;
import br.com.doceasier.model.annotations.DocParam;
import br.com.doceasier.model.annotations.EnableDocumentation;
import br.com.doceasier.model.annotations.Project;
import br.com.doceasier.model.sample.Employee;
import br.com.doceasier.model.sample.Erro;

@Project(description="teste", masterUrl="/etste", name="teste")
@EnableDocumentation
@DocClass(	createdBy="Marcus Cartágenes", 
			date="24/03/2017", 
			description="Classe responsável pelo controle da Biblioteca Virtual")
public class Sample {
	
	@DocField(description="Proxy da rede")
	private String proxy;
	
	@DocField(description="Senha do proxy")
	private String senha;
	
	@DocConstructor(description="Construtor para uso de WebService")
	public Sample(String nome) {
		// TODO Auto-generated constructor stub
	}
	
	@DocConstructor(description="Construtor para o Domínio da aplicação")
	public Sample(String idade, String nome) {
		// TODO Auto-generated constructor stub
	}
	
	@DocMethod(createdBy="Marcus Cartágenes", date="24/03/2017", 
			description="Método de Exemplo (Sem parametros)", 
			typeRequest=TypeRequest.GET,url="/myapp/sampleMethod",modelSucess=Employee.class, modelError=Error.class)
	public void sampleMethod(){
		System.out.println("Hi ! I'm a sample method without arguments :D");
	}
	
	@DocMethod(createdBy="Marcus Cartágenes", date="24/03/2017", 
			description="Método de Exemplo (Com parametros)", 
			typeRequest=TypeRequest.GET,url="/myapp/sampleMethod", modelError=Employee.class,modelSucess=Erro.class)
	public void anotherSampleMethod(@DocParam(description="Nome do usuario",optional=false)String nome, 
									@DocParam(description="Idade do usuario",optional=false)String idade, 
									@DocParam(description="sexo do usuario",optional=false)String sexo, 
									@DocParam(description="Cpf do usuario",optional=false)String cpf){
		
		System.out.println("Hi ! I'm a sample method with arguments :D");
		
	}

}
