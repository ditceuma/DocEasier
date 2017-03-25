package br.com.doceasier.model.docs;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.model.docs.annotations.MethodDescription;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

public class Method {

	private transient Paranamer info = new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));
	private transient java.lang.reflect.Method nativeMethod;
	private String name;
	private String description;
	private String returnType;
	private String dateCreation;
	private String author;
	private String[] url;
	private List<br.com.doceasier.model.docs.Parameter> parameters = new ArrayList<br.com.doceasier.model.docs.Parameter>();

	public Method(java.lang.reflect.Method method) {
		getMethodConfiguration(method);
	}

	/**
	 * 
	 * @param method
	 *            Método que será configurado
	 * @author marcus.cartagenes
	 * @since 24/03/2017
	 * @see br.com.doceasier.model.docs.Parameter
	 * @see Class
	 */
	private void getMethodConfiguration(java.lang.reflect.Method method) {
		this.nativeMethod = method;
		this.name = method.getName();
		this.returnType = method.getReturnType().getCanonicalName();
		if (method.isAnnotationPresent(MethodDescription.class)) {
			this.description = (String) method.getAnnotation(MethodDescription.class).description();
			this.author = (String) method.getAnnotation(MethodDescription.class).createdBy();
			this.dateCreation = (String) method.getAnnotation(MethodDescription.class).date();


			String[] paramName = this.info.lookupParameterNames(method);
			Parameter[] param = method.getParameters();

			if (paramName.length == param.length) {
				for (int i = 0; i < param.length; i++) {
					parameters.add(new br.com.doceasier.model.docs.Parameter(param[i], paramName[i]));
				}
			}
		}

	}
}