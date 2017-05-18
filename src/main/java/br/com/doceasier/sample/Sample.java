package br.com.doceasier.sample;

import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.model.annotations.DocClass;
import br.com.doceasier.model.annotations.DocMethod;
import br.com.doceasier.model.annotations.DocParam;
import br.com.doceasier.model.sample.Employee;

//@Project(description="teste", masterUrl="/etste", name="teste")
@DocClass(	createdBy="Marcus Cartágenes", 
			date="24/03/2017", 
			description="Classe responsável pelo controle da Biblioteca Virtual")
public class Sample {
	
	@DocMethod(createdBy="Marcus Cartágenes", date="24/03/2017", 
			description="Método de Exemplo (Sem parametros)", 
			typeRequest=TypeRequest.GET,url="/myapp/sampleMethod", onSucess=Employee.class)
	public void sampleMethod(){
		System.out.println("Hi ! I'm a sample method without arguments :D");
	}
	
	@DocMethod(createdBy="Marcus Cartágenes", date="24/03/2017", 
			description="Método de Exemplo (Com parametros)", 
			typeRequest=TypeRequest.GET,url="/myapp/sampleMethod", onSucess = Employee.class)
	public void anotherSampleMethod(@DocParam(description="Nome do usuario",optional=false)String nome, 
									@DocParam(description="Idade do usuario",optional=false)String idade, 
									@DocParam(description="sexo do usuario",optional=false)String sexo, 
									@DocParam(description="Cpf do usuario",optional=false)String cpf){
		
		System.out.println("Hi ! I'm a sample method with arguments :D");
		
	}

}
