package br.com.doceasier.model;

import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.model.annotations.DocClass;

@SuppressWarnings({"unused","rawtypes","unchecked"})
public class Class {

	private String name;
	private String origin;
	private String description;
	private List<Constructor> constructors = new ArrayList<Constructor>();
	private List<Field> fields = new ArrayList<Field>();
	private List<Method> methods = new ArrayList<Method>();
	
	public Class(java.lang.Class c) {
		getClassConfiguration(c);
	}

	private void getClassConfiguration(java.lang.Class c){
		this.origin = c.getPackage().toString();
		this.name = c.getSimpleName();
		
		if(c.isAnnotationPresent(DocClass.class)){
			DocClass classDescription = (DocClass) c.getAnnotation(DocClass.class);
			this.description = classDescription.description();
		}
		
		for(java.lang.reflect.Constructor con: c.getConstructors()){
			this.constructors.add(new Constructor(con));
		}
		
		for(java.lang.reflect.Field f: c.getDeclaredFields()){
			this.fields.add(new Field(f));
		}
		
		for(java.lang.reflect.Method m: c.getDeclaredMethods()){
			this.methods.add(new Method(m));
		}
	}
}
