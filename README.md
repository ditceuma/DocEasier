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
<ul>
	<li>Escolha uma classe anotada com @EnableDocumentation</li>
	<li>Anote-a com @Project para definir as informações sobre o seu <b>projeto</b></li>
</ul>
```java
	@EnableDocumentation
	@Project
	public class MyController{
		//DO THINGS;
	}
```

### 4. Anotações auxiliares para documentação
#### 4.1 `EnableDocumentation`
Escopo: Classe
```java
	@EnableDocumentation //Elege classes para serem documentadas
```
#### 4.2 `Project`
Escopo: Classe
```java
	@Project //Anotação para definir informações do Projeto documentado. Possui 3 atributos:
		 //1. name: Nome literal do Projeto *
		 //2. description: Descrição bem sintética do seu projeto *
		 //3. masterUrl: Contexto da sua aplicação, ex: /myContextPath *
```
#### 4.3 `DocClass`
Escopo: Classe
```java
	@DocClass //Anotação para atribuir informaçoes sobre a classe anotada. 
		 //1. name: Nome literal do Projeto *
		 //2. description: Descrição bem sintética do seu projeto *
		 //3. masterUrl: Contexto da sua aplicação, ex: /myContextPath *
```
