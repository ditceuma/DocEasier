package br.com.doceasier.model.docs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamDescription {

	String description() default "Nenhuma descrição adicionada para este parâmetro :(";
	boolean optional() default true;
	
}
