<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD com Hibernate e JSF usando Eclipse e Banco de Dados MySQL</title>
</head>
<body>
<f:view>
<h:form id="form">
	
	<h:messages />
	<h:commandLink action="#{usuarioMB.adicionarUsuario}" value="Novo Usuario" rendered="#{!usuarioMB.exibirForm}"/>
		
	<!-- Inicio: Formulario de Cadastro de Usuario -->
	<h:panelGrid border="1" columns="2" rendered="#{usuarioMB.exibirForm}">
		<f:facet name="header">
			<h:outputText value="Cadastro de Usuario"/>
		</f:facet>
		<h:outputLabel for="nome" value="Nome: " />
		<h:inputText id="nome" value="#{usuarioMB.usuario.nome}" required="true" />
		<h:outputLabel for="email" value="Email: " />
		<h:inputText id="email" value="#{usuarioMB.usuario.email}" required="true" />
		<h:outputLabel for="senha" value="Senha: " />
		<h:inputSecret id="senha" value="#{usuarioMB.usuario.senha}" required="true" redisplay="true" />
		<f:facet name="footer">
			<h:panelGroup>
				<h:commandButton value="Salvar" action="#{usuarioMB.salvarUsuario}"/>
				<h:commandButton value="Cancelar" action="#{usuarioMB.cancelarCadastroUsuario}" immediate="true"/>
			</h:panelGroup>
		</f:facet>
	</h:panelGrid>
	<!-- Fim: Formulario de Cadastro de Usuario -->	
	<br />
	
	<!-- Inicio: Tabela de Usuarios Cadastrados -->
	<h:dataTable var="item" value="#{usuarioMB.usuarios}" border="1" cellpadding="1" cellspacing="1" 
		rendered="#{usuarioMB.usuarios.rowCount > 0}">
		<f:facet name="header">
			<h:outputText value="Usuarios Cadastrados"/>
		</f:facet>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Nome"/>
			</f:facet>
			<h:outputText value="#{item.nome}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Email"/>
			</f:facet>
			<h:outputText value="#{item.email}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Senha"/>
			</f:facet>
			<h:outputText value="#{item.senha}" />
		</h:column>
		<h:column rendered="#{!usuarioMB.exibirForm}">
			<f:facet name="header">
				<h:outputText value="Alterar"/>
			</f:facet>
			<h:commandLink action="#{usuarioMB.alterarUsuario}">
				<h:outputText value="Alterar" />
				<f:setPropertyActionListener value="#{item}" target="#{usuarioMB.usuario}"/>
			</h:commandLink>
		</h:column>
		<h:column rendered="#{!usuarioMB.exibirForm}">
			<f:facet name="header">
				<h:outputText value="Excluir"/>
			</f:facet>
			<h:commandLink action="#{usuarioMB.excluirUsuario}">
				<h:outputText value="Excluir" />
				<f:setPropertyActionListener value="#{item}" target="#{usuarioMB.usuario}"/>
			</h:commandLink>
		</h:column>
		<f:facet name="footer">
			<h:outputText value="Contagem: #{usuarioMB.usuarios.rowCount}"/>
		</f:facet>
	</h:dataTable>
	<!-- Fim: Tabela de Usuarios Cadastrados -->
	
</h:form>
</f:view>
</body>
</html>