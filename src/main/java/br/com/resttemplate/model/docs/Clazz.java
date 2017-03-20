package br.com.resttemplate.model.docs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.resttemplate.model.docs.annotations.ClassDescription;

public class Clazz {

	private transient Class nativeClazz;
	private String name;
	private String origin;
	private String description;
	private List<Method> methods = new ArrayList<Method>();
	
	@SuppressWarnings("unchecked")
	public Clazz(@SuppressWarnings("rawtypes") Class c) {
		this.nativeClazz = c;
		this.origin = c.getPackage().toString();
		this.name = c.getSimpleName();
		//SET CLASS DESCRIPTION
		if(nativeClazz.isAnnotationPresent(ClassDescription.class)){
			ClassDescription classDescription = (ClassDescription) nativeClazz.getAnnotation(ClassDescription.class);
			this.description = classDescription.classDescription();
		}else{
			this.description = "Nenhuma descrição adicionada para esta classe :(";
		}
		
		for(java.lang.reflect.Method m: this.nativeClazz.getDeclaredMethods()){
			this.methods.add(new Method(m));
		}
	}
}
