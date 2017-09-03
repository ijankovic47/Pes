<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="main-container" style="overflow: hidden;">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="players" style="float: left;">
<table border="1">
<tr><th>Image</th><th>Player name</th><th>Stats</th><th>Edit</th></tr>
<c:forEach items="${players}" var="player">
<tr><td><img src="<c:url value='/resources/images/players/${player.image}'/>" style="height: 200px;width: 200px;"></td><td>${player.name}</td>
<td><button class="playerStatsBtn" value="${player.id}">Stats</button></td><td><sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_PLAYERS')"><button class="playerEditBtn" value="${player.id}">Edit</button></sec:authorize></td></tr>
</c:forEach>
</table>

<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_PLAYERS')"><button id="addPlayerBtn">Add new player</button></sec:authorize>

<div id="playerEditForm" style="visibility: hidden;">
<form action="${contextPath}/player/saveOrUpdatePlayer" method="POST" enctype="multipart/form-data">
<input type="text" id="playerId" name="playerId" readonly="readonly">
<input type="text" id="playerName" name="playerName">
<input type="file" name="file" accept="image/jpeg,image/png,image/gif">
<input type="submit" value="Save"> 
</form>
</div>
</div>

<div id="playerStats" style="float: right;">
</div>
<div id="playerStatsPerTeam">
</div>
<div id="playerMatches">
</div>
</div>

