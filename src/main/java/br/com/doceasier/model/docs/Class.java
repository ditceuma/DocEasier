package br.com.doceasier.model.docs;

import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.model.docs.annotations.ClassDescription;

public class Class {

	private transient java.lang.Class nativeClazz;
	private String name;
	private String origin;
	private String description;
	private List<Method> methods = new ArrayList<Method>();
	
	@SuppressWarnings("unchecked")
	public Class(@SuppressWarnings("rawtypes") java.lang.Class c) {
		getClassConfiguration(c);
		
	}
	
	@SuppressWarnings("unchecked")
	private void getClassConfiguration(java.lang.Class c){
		
		this.nativeClazz = c;
		this.origin = c.getPackage().toString();
		this.name = c.getSimpleName();
		
		if(nativeClazz.isAnnotationPresent(ClassDescription.class)){
			ClassDescription classDescription = (ClassDescription) nativeClazz.getAnnotation(ClassDescription.class);
			this.description = classDescription.description();
		}
		
		for(java.lang.reflect.Method m: this.nativeClazz.getDeclaredMethods()){
			this.methods.add(new Method(m));
		}
	}
}
