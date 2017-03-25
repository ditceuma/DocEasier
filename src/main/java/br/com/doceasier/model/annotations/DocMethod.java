package br.com.doceasier.model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.doceasier.enumerators.TypeRequest;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DocMethod {
	String description() default "Nenhuma descrição adicionada para este método :(";
	String createdBy() default "Autor inexistente ! Por favor, verifique";
	String date() default "Data de criação não configurada! Por favor, verifique";
	TypeRequest[] typeRequest();
	String url();
}
