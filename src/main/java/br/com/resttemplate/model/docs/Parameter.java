package br.com.resttemplate.model.docs;

import br.com.resttemplate.model.docs.annotations.ParamDescription;


public class Parameter {

	private transient java.lang.reflect.Parameter nativeParameter;
	private String name;
	private String description;
	private String type;
	private boolean optional;
	
	public Parameter(java.lang.reflect.Parameter p, String name) {
		this.nativeParameter = p;
		this.name = name;
		this.type = p.getType().getCanonicalName();
		
		if(p.isAnnotationPresent(ParamDescription.class)){
			this.description = (String) p.getAnnotation(ParamDescription.class).description();
			this.optional = (boolean) p.getAnnotation(ParamDescription.class).optional();
		}else{
			this.description = "Nenhuma descrição adicionada para este parâmetro :(";
		}
	}
}
