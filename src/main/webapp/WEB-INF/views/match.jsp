<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="main-container">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<input type="text" value="${exhibition.team1.id}" name="team1name" id="team1name" hidden>
<input type="text" value="${exhibition.team2.id}" name="team2name" id="team2name" hidden>

<form:form commandName="exhibition" action="${contextPath}/match/playExhibition" method="POST">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div id="wrapper" style="overflow: hidden;">
<div id="player1info" style="float: left">

<div>
 <form:select name="player1" id="player1" path="player1.id">
 <option value="0" hidden="true">Player1</option>
 <c:forEach items="${players}" var="player">
 <form:option value="${player.id}">${player.name}</form:option>
 </c:forEach>
 </form:select>
 <div id="viewStats"></div>
 </div>
 <div>
 <img alt="/images/NoImage.JPG" id="player1pic" src="resources/images/NoImage.JPG" style="height: 200px;width: 200px;">
 </div>
 <div>
 <select name="league1" id="league1">
 <option value="0" hidden="true">League/Continent</option>
 <c:forEach items="${leagues}" var="league">
 <c:choose>
 <c:when test="${league.name==league1name}">

 <option value="${league.name}" selected>${league.name}</option>
 </c:when>
 <c:otherwise>
 <option value="${league.name}">${league.name}</option>
 </c:otherwise>
 </c:choose>
 </c:forEach>
 
 <c:forEach items="${continents}" var="continent">
 <c:choose>
 <c:when test="${continent.name==league1name}">
 <option value="${continent.name}" selected> ${continent.name} </option>
 </c:when>
 <c:otherwise>
 <option value="${continent.name}"> ${continent.name}</option>
 </c:otherwise>
 </c:choose>
</c:forEach>
 </select>
 </div>
 <div>
 <img id="league1pic" alt="resources/images/NoImage.JPG" src="resources/images/NoImage.JPG" style="height: 200px;width: 200px;">
 </div>
 <div>
 <form:select path="team1.id" id="team1" onchange="changeTeamEmblem(1)"></form:select>
 </div>
 <div>
 <img id="team1pic" alt="resources/images/NoImage.JPG" src="resources/images/NoImage.JPG" style="height: 200px;width: 200px;">
 </div>
 <div>
 <form:input path="score1"/>
 </div>
</div>


<div id="player2info" style="float: right;">
<div>
 <form:select name="player2" id="player2" path="player2.id">
 <option value="0" hidden="true">Player2</option>
 <c:forEach items="${players}" var="player">
 <form:option value="${player.id}">${player.name}</form:option>
 </c:forEach>
 </form:select>
 </div>
 <div>
 <img alt="resources/images/NoImage.JPG" id="player2pic" src="resources/images/NoImage.JPG" style="height: 200px;width: 200px;">
 </div>
 <div>
 <select name="league2" id="league2">
 <option value="0" hidden="true">League/Continent</option>
 <c:forEach items="${leagues}" var="league">
 <c:choose>
 <c:when test="${league.name==league2name}">
 <option value="${league.name}" selected>${league.name}</option>
 </c:when>
 <c:otherwise>
 <option value="${league.name}">${league.name}</option>
 </c:otherwise>
 </c:choose>
 </c:forEach>
 
 <c:forEach items="${continents}" var="continent">
 <c:choose>
 <c:when test="${continent.name==league2name}">
 <option value="${continent.name}" selected> ${continent.name} </option>
 </c:when>
 <c:otherwise>
 <option value="${continent.name}" > ${continent.name} </option>
 </c:otherwise>
 </c:choose>
</c:forEach>
 </select>
 </div>
 <div>
 <img id="league2pic" alt="resources/images/NoImage.JPG" src="resources/images/NoImage.JPG" style="height: 200px;width: 200px;">
 </div>
 <div>
 <form:select path="team2.id" id="team2" onchange="changeTeamEmblem(2)"></form:select>
 </div>
 <div>
 <img id="team2pic" alt="resources/images/NoImage.JPG" src="resources/images/NoImage.JPG" style="height: 200px;width: 200px;">
 </div>
 <div>
 <form:input path="score2"/>
 </div>
</div>
</div>
<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_PLAY_MATCH')"><div style="text-align: center;"><input type="submit" value="Kick off"> </div></sec:authorize>
</form:form>
</div>
