package br.com.doceasier.model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.doceasier.enumerators.TypeRequest;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("rawtypes")
public @interface DocMethod {
	String description() default "Nenhuma descri��o adicionada para este m�todo :(";
	String createdBy() default "Autor inexistente ! Por favor, verifique";
	String date() default "Data de cria��o n�oo configurada! Por favor, verifique";
	TypeRequest typeRequest() default TypeRequest.GET;
	String url();
	Class<?> onSucess();
}
