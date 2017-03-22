package br.com.doceasier.model.docs;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private RequestMethod[] typeRequest;
	private List<br.com.doceasier.model.docs.Parameter> parameters = new ArrayList<br.com.doceasier.model.docs.Parameter>();
	
	public Method(java.lang.reflect.Method method) {
		this.nativeMethod = method;
		this.name = method.getName();
		this.returnType = method.getReturnType().getCanonicalName();
		if(method.isAnnotationPresent(MethodDescription.class)){
			this.description = (String) method.getAnnotation(MethodDescription.class).description();
			this.author = (String) method.getAnnotation(MethodDescription.class).author();
			this.dateCreation =(String) method.getAnnotation(MethodDescription.class).dateCreated();
		}else{
			this.description = "Nenhuma descrição adicionada para este método :(";
			this.author = "Autor inexistente ! Por favor, verifique";
			this.dateCreation = "Data de criação não configurada! Por favor, verifique";
		}
		
		if(method.isAnnotationPresent(RequestMapping.class)){
			this.typeRequest = method.getAnnotation(RequestMapping.class).method();
			this.url = method.getAnnotation(RequestMapping.class).value();
		}
		
		String[] paramName = this.info.lookupParameterNames(method);
		Parameter[] param = method.getParameters();
		
		if(paramName.length == param.length){
			for(int i=0;i<param.length;i++){
				parameters.add(new br.com.doceasier.model.docs.Parameter(param[i], paramName[i]));
			}
		}
	}

	
}
