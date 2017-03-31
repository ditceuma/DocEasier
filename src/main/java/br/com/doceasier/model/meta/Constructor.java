package br.com.doceasier.model.meta;

import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.model.annotations.DocConstructor;

@SuppressWarnings({"unchecked","unused","rawtypes"})
public class Constructor {

	private String description;
	private List<br.com.doceasier.model.meta.Parameter> parameters = new ArrayList<br.com.doceasier.model.meta.Parameter>();
	

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
}
