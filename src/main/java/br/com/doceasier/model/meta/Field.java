package br.com.doceasier.model.meta;

import java.lang.reflect.Modifier;

import br.com.doceasier.model.annotations.DocField;


public class Field {

	private String name;
	private String description;
	private String type;
	private String modifier;

	public Field(java.lang.reflect.Field f) {
		if(f.isAnnotationPresent(DocField.class)){
			this.name = f.getName();
			this.type = f.getType().getCanonicalName();
			this.modifier = Modifier.toString(f.getModifiers());
			this.description = (String) f.getAnnotation(DocField.class).description();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	
}
