package br.com.doceasier.model;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.model.annotations.DocMethod;
import br.com.doceasier.model.sample.Erro;

public class Method {

	private String name;
	private String description;
	private String returnType;
	private String dateCreation;
	private TypeRequest typesRequest;
	private String author;
	private String url;
	private String modifier;
	private String jsonSampleSuccess;
	private String jsonSampleError;
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
		this.modifier = Modifier.toString(method.getModifiers());
		DocMethod doc = method.getAnnotation(DocMethod.class);

		if (method.isAnnotationPresent(DocMethod.class)) {
			this.getJson(doc.modelSucess());
			this.description = doc.description();
			this.author = doc.createdBy();
			this.dateCreation = doc.date();
			this.typesRequest = doc.typeRequest();
			this.url = doc.url();

			String[] paramName = ParanamerUtil.getParanamer()
					.lookupParameterNames(method);
			java.lang.reflect.Parameter[] param = method.getParameters();

			if (paramName.length == param.length) {
				for (int i = 0; i < param.length; i++) {
					parameters.add(new br.com.doceasier.model.Parameter(
							param[i], paramName[i]));
				}
			}
		}
	}

	private void getJson(java.lang.Class c) {
		try {
			Object o = c.newInstance();
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.serializeNulls();
			Gson gson = gsonBuilder.create();
			System.out.println(gson.toJson(o));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}