package br.com.doceasier.model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.model.appenders.Return;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("rawtypes")
public @interface DocMethod {
	String description() default "Nenhuma descrição adicionada para este método :(";
	String createdBy() default "Autor inexistente ! Por favor, verifique";
	String date() default "Data de criação nÃoo configurada! Por favor, verifique";
	TypeRequest typeRequest() default TypeRequest.GET;
	String url();
	Class<?> onSucess();
}
