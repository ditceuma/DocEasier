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

### 3. Adicionando informações sobre o Projeto * <i style="color:red">Importante</i>
1º Clone o repositório
2º Construa o projeto através do maven com o comando: mvn eclipse:eclipse<br/>
3º Importe em seu workspace e seja feliz :D
