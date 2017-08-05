<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>


	<spring:url value="/static/js/jquery-1.12.1.min.js"
	var="jqueryJs" />
		<script type="text/javascript" src="${jqueryJs}"></script>
	<spring:url value="/static/js/jquery.dataTables.js"
	var="datatable" />
		<script type="text/javascript" src="${datatable}"></script>

