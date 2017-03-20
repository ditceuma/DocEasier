<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>
		<div class="searchBar">		
			<form action="#" method="GET" class="form"><br/><br/>
			<div class="row">
				<div class="col-md-4">
					<h3>O que você está procurando?</h3>
				</div>
				<div class="col-md-2">
					<select class="form-control" id="filter">
						<option value="class">Classe</option>
						<option value="method">Método</option>
					</select>
				</div>
				<div class="col-md-4">
					<input type="text" class="form-control" id="valorBusca"/>
				</div>
				<div class="col-md-2"> 
					<input type="button" id="btnSearch" class="btn btn-success" value="Pesquisar"/>
				</div>
			</div>
			</form>
			
			<div class="result" id="res">
			
			</div>
		</div>
	</jsp:body>
</t:template>