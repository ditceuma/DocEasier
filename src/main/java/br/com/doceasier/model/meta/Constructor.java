package br.com.doceasier.model.meta;

import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.model.annotations.DocConstructor;

@SuppressWarnings({"unchecked","rawtypes"})
public class Constructor {

	private String description;
	private final List<br.com.doceasier.model.meta.Parameter> parameters = new ArrayList<br.com.doceasier.model.meta.Parameter>();
	

	public Constructor(java.lang.reflect.Constructor c) {
		DocConstructor doc = (DocConstructor) c.getAnnotation(DocConstructor.class);
		if(c.isAnnotationPresent(DocConstructor.class)){
			this.description = doc.description();
			String[] paramName = ParanamerUtil.getParanamer().lookupParameterNames(c);
			java.lang.reflect.Parameter[] param = c.getParameters();
			if (paramName.length == param.length) {
				for (int i = 0; i < param.length; i++) {
					parameters.add(new br.com.doceasier.model.meta.Parameter(param[i], paramName[i]));
				}
			}
		}
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<br.com.doceasier.model.meta.Parameter> getParameters() {
		return parameters;
	}
	
	
}
