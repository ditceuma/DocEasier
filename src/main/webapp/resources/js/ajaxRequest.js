
var dataJson = [];
$(document).ready(function(){
	$.ajax({
		url: "/doc/getAllInformations/",
		type: "GET",
		data:null,
		contentType: "application/json; charset=utf-8",
		async:false,
		success: function(retorno){
			dataJson = retorno;
			configureAllViews(retorno);
		}
	});	
//	$(".result-data").click(function(){
//		alert("Clicou !");
//	});
//	
	
	$("#btnSearch").click(function(){
		debugger;
		var valueSearch = document.getElementById("valorBusca").value;
		var filterBy = document.getElementById("filter").value;
		$.each(dataJson,function(idx,obj){
			if(filterBy === 'method'){
				$.each(obj.method,function(index, method){
					if(method.name.indexOf(valueSearch) !== -1){
						console.log("ENTROU NO IF");
					}else{
						console.log("NAO ENTROU NO IF");
					}
				});
			}else{
				console.log("Não é METHOD");
			}
		});
	});
});

function configureAllViews(retorno){
	var resultDiv = document.getElementById("res");
	$(jQuery.parseJSON(JSON.stringify(retorno))).each(function() {
		var classElement = configureClassElement(resultDiv, this);
		$(jQuery.parseJSON(JSON.stringify(this.methods))).each(function() {
			var methodElement = configureMethodElement(classElement,this);
			var lenghtParameters = this.parameters.length;
			if(lenghtParameters > 0){
				var parameterElement = methodElement.appendChild(document.createElement("div"));
				parameterElement.setAttribute("class", "param-data");
				//parameterElement.appendChild(document.createElement("h3").appendChild(document.createTextNode(" - Parâmetros")));
				methodElement.appendChild(parameterElement);
				
				$(jQuery.parseJSON(JSON.stringify(this.parameters))).each(function() {
					configureParameterElement(parameterElement,this, lenghtParameters);
				});
			}else{
				var element = document.createElement("p");
				element.setAttribute("class", "warning-label");
				element.appendChild(document.createTextNode("O método não recebe parametros :)"));
				methodElement.appendChild(element);
			}
		});
	});
}

function configureClassElement(masterElement, classObj){
	var classDiv = document.createElement("div");
		classDiv.setAttribute("class", "result-data");
		
	var classLabel = document.createElement("p");
		classLabel.appendChild(document.createTextNode(classObj.name +" - "+classObj.description));
	
	classDiv.appendChild(classLabel);
	masterElement.appendChild(classDiv);
	
	return classDiv;
}

function configureMethodElement(classElement,methodObj){
	
	var methodDiv = document.createElement("div");
		methodDiv.setAttribute("class", "method-data");
	
	var methodLabelAuthor = document.createElement("p");
		methodLabelAuthor.appendChild(document.createTextNode("Autor: "+methodObj.author));
		if(methodObj === "Autor inexistente ! Por favor, verifique"){
			methodLabelAuthor.setAttribute("class", "error-label");
		}
		
	var methodLabelName = document.createElement("p");
		methodLabelName.appendChild(document.createTextNode("Método: "+methodObj.name));
	
	var methodLabelDescription = document.createElement("p");
		methodLabelDescription.appendChild(document.createTextNode("Descrição: "+methodObj.description));
		if(methodObj.description === "Nenhuma descrição adicionada para este método :("){
			methodLabelDescription.setAttribute("class", "error-label");
		}
	
	var methodLabelType = document.createElement("p");
		methodLabelType.appendChild(document.createTextNode("Retorno: "+methodObj.returnType));
	
	var methodLabelCreatedWhen = document.createElement("p");
		methodLabelCreatedWhen.appendChild(document.createTextNode("Criado em:"+methodObj.dateCreation));
		
	methodDiv.appendChild(methodLabelAuthor);	
	methodDiv.appendChild(methodLabelName);
	methodDiv.appendChild(methodLabelDescription);
	methodDiv.appendChild(methodLabelType);
	methodDiv.appendChild(methodLabelCreatedWhen);
	
	classElement.appendChild(methodDiv);
	
	return methodDiv;
}

function configureParameterElement(paramElement, parameterObj, length){
	if(length === 0){
		paramElement.appendChild(document.createElement("p").appendChild(document.createTextNode("O método não recebe parametros")));
	}else{
		var separator = document.createElement("hr");
			separator.setAttribute("class", "pattern-separator");
		
		var nomeParam = document.createElement("p");
			nomeParam.appendChild(document.createTextNode("Nome: "+parameterObj.name));
		var descriParam = document.createElement("p");
			descriParam.appendChild(document.createTextNode("Descrição: "+parameterObj.description));
		if(parameterObj.description === "Nenhuma descrição adicionada para este parâmetro :("){
			descriParam.setAttribute("class", "error-label");
		}
		var isOptional = document.createElement("p");
			isOptional.appendChild(document.createTextNode("Opcional: "+parameterObj.optional));
		var typeParam = document.createElement("p");
			typeParam.appendChild(document.createTextNode("Tipo: "+parameterObj.type));
			
		paramElement.appendChild(nomeParam);
		paramElement.appendChild(descriParam);
		paramElement.appendChild(isOptional);
		paramElement.appendChild(typeParam);
		
		if(length > 1){
			paramElement.appendChild(separator);
		}

	}
}
