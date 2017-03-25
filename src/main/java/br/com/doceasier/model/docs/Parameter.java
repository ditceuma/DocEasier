package br.com.doceasier.model.docs;

import br.com.doceasier.model.docs.annotations.ParamDescription;


public class Parameter {

	private transient java.lang.reflect.Parameter nativeParameter;
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
		this.nativeParameter = p;
		this.name = name;
		this.type = p.getType().getCanonicalName();
		
		if(p.isAnnotationPresent(ParamDescription.class)){
			this.description = (String) p.getAnnotation(ParamDescription.class).description();
			this.optional = (boolean) p.getAnnotation(ParamDescription.class).optional();
		}
	}
}
