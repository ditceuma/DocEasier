# DocEasier - 0.0.1
O DocEasier é uma API construida em java para auxiliar a documentação do seu WebProject. Siga os passos abaixo para utilizar.<br/>

### 1. Importe a dependência dentro do seu `pom.xml`
```xml
    <dependency>
	<groupId>br.com.doceasier</groupId>
	<artifactId>DocEasier</artifactId>
	<version>0.0.1-SNAPSHOT</version>
    </dependency>
```

### 2. Elegendo classes para documentação. 
Para sinalizar uma classe que irá ser enxergada pelo `DocEasier` você só precisa anotá-la com `@EnableDocumentation`
```java
@EnableDocumentation
public class MyController{
	//DO THINGS;
}
```

### 3. Adicionando informações sobre o seu Projeto
<i>Passo Essencial *</i>
	1.Escolha uma classe anotada com @EnableDocumentation<br/>
	2.Anote-a com @Project para definir as informações sobre o seu <b>projeto</b>
```java
@EnableDocumentation
@Project
public class MyController{
	//DO THINGS;
}
```

### 4. Anotações auxiliares para documentação
#### 4.1 `EnableDocumentation`
Elege classes para serem documentadas <b>Escopo: Classe</b>
```java
@EnableDocumentation
public class MyController(){
	//DO THINGS;
}
```
#### 4.2 `Project`
Anotação para definir informações do Projeto documentado <b>Escopo: Classe</b>
```java
@Project(name="Nome do meu projeto", description="teste", masterUrl="/meuContextPath", )	
public class MyController(){
	 //1. name: Nome literal do Projeto *
	 //2. description: Descrição bem sintética do seu projeto *
	 //3. masterUrl: Contexto da sua aplicação, ex: /myContextPath *
}
```
#### 4.3 `DocClass`
Anotação para atribuir informaçoes sobre a classe anotada. <b>Escopo: Classe</b>
```java
@DocClass(description="Descrição do meu controller...",createdBy="Marcus Cartágenes", date="24/03/2017",url="/myController")
public class MyController(){
	//1. description: Descrição sintétizada da classe
	 //2. createdBy: Criador da classe
	 //3. date: Data de criação da classe com o pattern "dd/MM/yyyy". Ex: 01/01/2017
	 //4. url: URL master para acessar a classe.
}
```
#### 4.4 `DocConstructor`
Anotação para descrever construtores da classe. <b>Escopo: Construtor</b>
```java
@EnableDocumentation
public class MyController(){	
	@DocConstructor(description="Construtor default da classe")
	MyController(){
		//1. description: Descrição sintetizada do construtor
	}
}
```

#### 4.5 `DocMethod`
Anotação para descrever os métodos de determinada classe. <b>Escopo: Método</b>
```java
@EnableDocumentation
public class MyController(){
@DocMethod(createdBy="Marcus Cartágenes", date="24/03/2017", description="Método de Exemplo (Com parametros)", 
			   typeRequest=TypeRequest.GET,url="/myapp/sampleMethod", onSucess = Employee.class)		
public void myMethod(){
	//1. createdBy: Criador do método
	//2. date: Data de criação do método
	//3. description: Descrição sintetizada do método
	//4. typeRequest: Tipo de requisição que o método suporta
	//5. url: Url para acessar o método *
	//6. onSucess: Modelo de classe que será retornado caso seu método seja executado com sucesso *
	}
}
```

#### 4.6 `DocParam`
Anotação para classificar os parâmetros dos métodos anotados com `@DocMethod`. <b>Escopo: Parâmetro</b>
```java
@EnableDocumentation
public class MyController

@DocMethod(createdBy="Marcus Cartágenes", date="24/03/2017", description="Método de Exemplo (Com parametros)", 
			   typeRequest=TypeRequest.GET,url="/myapp/sampleMethod", onSucess = Employee.class)
public void myMethod(){
	@DocParam(description="Descrição do primeiro parâmetro",optional=true)String nome String param1, 
	@DocParam(description="Descrição do segundo parâmetro",optional=false)String nome Date param2){
	//1. description: Descrição do parâmetro 
	//2. optional: Sinaliza se o parâmetro e obrigatório ou não	
}
}
```
