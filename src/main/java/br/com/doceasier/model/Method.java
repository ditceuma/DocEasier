package br.com.doceasier.model;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.model.annotations.DocMethod;

import com.thoughtworks.paranamer.Paranamer;

public class Method {

	private String name;
	private String description;
	private String returnType;
	private String dateCreation;
	private List<TypeRequest> typesRequest = new ArrayList<TypeRequest>();
	private String author;
	private String url;
	private List<br.com.doceasier.model.Parameter> parameters = new ArrayList<br.com.doceasier.model.Parameter>();

	public Method(java.lang.reflect.Method method) {
		getMethodConfiguration(method);
	}

	/**
	 * 
	 * @param method
	 *            Método que será configurado
	 * @author marcus.cartagenes
	 * @since 24/03/2017
	 * @see br.com.doceasier.model.Parameter
	 * @see Class
	 */
	private void getMethodConfiguration(java.lang.reflect.Method method) {
		this.name = method.getName();
		this.returnType = method.getReturnType().getCanonicalName();
		DocMethod doc = method.getAnnotation(DocMethod.class);
		if (method.isAnnotationPresent(DocMethod.class)) {
			this.description = doc.description();
			this.author = doc.createdBy();
			this.dateCreation = doc.date();
			this.typesRequest = Arrays.asList(doc.typeRequest());
			this.url = doc.url();
			
			String[] paramName = ParanamerUtil.getParanamer().lookupParameterNames(method);
			Parameter[] param = method.getParameters();

			if (paramName.length == param.length) {
				for (int i = 0; i < param.length; i++) {
					parameters.add(new br.com.doceasier.model.Parameter(param[i], paramName[i]));
				}
			}
		}

	}
}