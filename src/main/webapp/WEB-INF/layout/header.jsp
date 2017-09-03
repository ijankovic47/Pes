<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>	
	<div class="main-manu-wrap nav">
		<ul>
			<li><a href="<c:url value="/match" />">Match</a></li>
			<li><a href="<c:url value="/player" />">Players</a></li>
			<li><a href="<c:url value="/team" />">Teams</a></li>			
		</ul>
	</div>	
	
	<div class="user-details-wrap usr">		
	<sec:authorize access="isAuthenticated()">
	 <ul>
	 	<li>operater: <strong><sec:authentication property="principal.username"/></strong></li>
	 	<li>
	 		<form action="${contextPath}/logout" method="post">
			<button type="submit" id="btn-logout">Log out</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	 	</li>	 	
	 </ul>
	</sec:authorize>		
	</div>