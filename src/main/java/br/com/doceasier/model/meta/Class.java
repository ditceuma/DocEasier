package br.com.doceasier.model.meta;

import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.annotations.DocClass;
import br.com.doceasier.model.annotations.DocIgnore;

@SuppressWarnings({"rawtypes", "unchecked" })
public class Class {

	private final String name;
	private final String origin;
	private String description;
	private String url;
	private final List<Constructor> constructors = new ArrayList<Constructor>();
	private final List<Field> fields = new ArrayList<Field>();
	private final List<Method> methods = new ArrayList<Method>();

	public Class(java.lang.Class c) throws DoceasierException {
		this.origin = c.getPackage().toString();
		this.name = c.getSimpleName();
		if (c.isAnnotationPresent(DocClass.class)) {
			DocClass classDescription = (DocClass) c.getAnnotation(DocClass.class);
			this.description = classDescription.description();
			this.url = classDescription.url();
		}

		for (java.lang.reflect.Constructor con : c.getConstructors()) {
			this.constructors.add(new Constructor(con));
		}

		for (java.lang.reflect.Field f : c.getDeclaredFields()) {
			this.fields.add(new Field(f));
		}

		for (java.lang.reflect.Method m : c.getDeclaredMethods()) {
			if(!m.isAnnotationPresent(DocIgnore.class)){
				this.methods.add(new Method(m));
			}
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public List<Constructor> getConstructors() {
		return constructors;
	}

	public List<Field> getFields() {
		return fields;
	}

	public List<Method> getMethods() {
		return methods;
	}
	
	
}
