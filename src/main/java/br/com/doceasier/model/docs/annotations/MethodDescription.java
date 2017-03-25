package br.com.doceasier.model.docs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodDescription {
	String description() default "Nenhuma descrição adicionada para este método :(";
	String createdBy() default "Autor inexistente ! Por favor, verifique";
	String date() default "Data de criação não configurada! Por favor, verifique";
}
