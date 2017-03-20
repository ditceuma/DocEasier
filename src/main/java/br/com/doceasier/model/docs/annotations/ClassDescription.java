package br.com.doceasier.model.docs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassDescription {
	String classDescription() default "Classe anotada pelo DocEasier, porém não foi definida uma descrição !";
	String classAuthor() default "Classe anotada pelo DocEasier, porém não foi definido um autor !";
}
