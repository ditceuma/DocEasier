package br.com.doceasier.model.meta;

import br.com.doceasier.model.annotations.DocParam;


@SuppressWarnings("unused")
public class Parameter {
	private String name;
	private String description;
	private String type;
	private boolean optional;
	
	protected Parameter(java.lang.reflect.Parameter p, String name) {
		configParameter(p, name);
	}
	
	/**
	 * 
	 * @param p - Parameter
	 * @param name - Parameter name
	 */
	private void configParameter(java.lang.reflect.Parameter p, String name){
		this.name = name;
		this.type = p.getType().getCanonicalName();
		if(p.isAnnotationPresent(DocParam.class)){
			this.description = (String) p.getAnnotation(DocParam.class).description();
			this.optional = (boolean) p.getAnnotation(DocParam.class).optional();
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

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	
	
}
