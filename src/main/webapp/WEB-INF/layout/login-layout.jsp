<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>	
	<%@ page isELIgnored="false" %>
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
	 
</head>
<body>
<section id="content">
	<tiles:insertAttribute name="body" />
</section>
<footer id="footer">
	<tiles:insertAttribute name="footer" />
</footer>
</body>
</html>