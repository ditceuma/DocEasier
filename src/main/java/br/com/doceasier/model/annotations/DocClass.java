package br.com.doceasier.model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DocClass {
	String description() default "Nenhuma descrição adicionada para esta classe :(";
	String createdBy() default "";
	String date() default "";
	String url() default "";
}
