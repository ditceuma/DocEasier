package br.com.doceasier.model.meta;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.exception.DoceasierException;
import br.com.doceasier.model.annotations.DocMethod;

import com.google.gson.GsonBuilder;

@SuppressWarnings({ "unused" })
public class Method {

	private String name;
	private String description;
	private String returnType;
	private String dateCreation;
	private TypeRequest typesRequest;
	private String author;
	private String url;
	private String modifier;
	private String onSuccess;
	private List<br.com.doceasier.model.meta.Parameter> parameters = new ArrayList<br.com.doceasier.model.meta.Parameter>();

	public Method(java.lang.reflect.Method method) throws DoceasierException {
			getMethodConfiguration(method);
	}

	/**
	 * 
	 * @param method
	 *            Método que será configurado
	 * @author marcus.cartagenes
	 * @since 24/03/2017
	 * @see br.com.doceasier.model.meta.Parameter
	 * @see Class
	 */
	private void getMethodConfiguration(java.lang.reflect.Method method) throws DoceasierException {
		DocMethod doc = method.getAnnotation(DocMethod.class);
		try {
			this.name = method.getName();
			this.returnType = method.getReturnType().getCanonicalName();
			this.modifier = Modifier.toString(method.getModifiers());

			if (method.isAnnotationPresent(DocMethod.class)) {
				this.onSuccess = this.serializeObject(doc.onSucess().newInstance());
				this.description = doc.description();
				this.author = doc.createdBy();
				this.dateCreation = doc.date();
				this.typesRequest = doc.typeRequest();
				this.url = doc.url();

				String[] paramName = ParanamerUtil.getParanamer().lookupParameterNames(method);
				java.lang.reflect.Parameter[] param = method.getParameters();

				if (paramName.length == param.length) {
					for (int i = 0; i < param.length; i++) {
						parameters.add(new br.com.doceasier.model.meta.Parameter(param[i], paramName[i]));
					}
				}
			}
		} catch (InstantiationException ex) {
			throw new DoceasierException("Não encontramos um construtor na classe ["+doc.onSucess().getName()+"] que possa ser utilizado pelo DocEasier. Crie um construtor em branco !");
		} catch( IllegalAccessException ex){
			throw new DoceasierException("Oops ! Aconteceu algo errado :("+ex);
		}
	}
	
	private String serializeObject(Object o) throws InstantiationException, IllegalAccessException{
		
		for(Field f: o.getClass().getDeclaredFields()){
			f.setAccessible(true);
			existeSubTipo(f,o);
		}
	
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		return gsonBuilder.create().toJson(o);
	}
	
	private void existeSubTipo(Field f, Object o) throws InstantiationException, IllegalAccessException{
		if(f.getType().getName().equals("java.lang.Integer")){
			f.set(o, Integer.valueOf(10));
		}
		else if(f.getType().getName().equals("java.lang.Double")){
			f.set(o, 10D);
		}
		else if(f.getType().getName().equals("java.lang.Long")){
			f.set(o, 10L);
		}
		else if(f.getType().getName().equals("java.lang.Float")){
			f.set(o, 10F);
		}
		else if(f.getType().getName().equals("java.lang.Byte")){
			f.set(o, 10);
		}
		else if(f.getType().getName().equals("java.lang.Short")){
			f.set(o, 10);
		}
		else if(f.getType().getName().equals("java.lang.Character")){
			f.set(o, 'C');
		}
		else if(f.getType().getName().equals("java.lang.String")){
			f.set(o, "-");
		}
		else if(f.getType().getName().equals("java.lang.Boolean")){
			f.set(o, false);
		}else if(f.getType().isPrimitive()){
			if(!f.getType().getName().equals("char")){
				f.set(o, 10);
			}else{
				f.set(o, 'C');
			}
		}else{
			f.set(o.getClass().newInstance(), f.getType().newInstance());
			for(Field fieldAux: f.getType().getDeclaredFields()){
				fieldAux.setAccessible(true);
				existeSubTipo(fieldAux,f.getType().newInstance());
			}
		}
		
		System.out.println("Variável do tipo ["+f.getType()+"] encontrada !");
		
	}
}