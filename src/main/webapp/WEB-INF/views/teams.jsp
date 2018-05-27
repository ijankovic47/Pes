<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<div class="main-container">
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table border="1">
<c:forEach items="${leagues}" var="league">
<tr>
<td>
<c:choose>
<c:when test="${league.emblem!=null}">
<img alt="/images/NoImage.JPG" src="${league.emblem}" style="height: 80px;width: 80px;">
</c:when>
<c:otherwise><img alt="/images/NoImage.JPG" src="<c:url value='/resources/images/NoImage.JPG'/>" style="height: 80px;width: 80px;"></c:otherwise>
</c:choose>

${league.name}<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_LEAGUES')"><button class="leagueEditBtn" value="${league.id}">Edit</button></sec:authorize></td>
<c:forEach items="${clubs}" var="club">
<c:if test="${club.league.id==league.id}">
<td>
<c:choose>
<c:when test="${club.emblem!=null}">
<img alt="/images/NoImage.JPG" src="${club.emblem}" style="height: 80px;width: 80px;">
</c:when>
<c:otherwise><img alt="/images/NoImage.JPG" src="<c:url value='/resources/images/NoImage.JPG'/>" style="height: 80px;width: 80px;"></c:otherwise>
</c:choose>
${club.name}<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_CLUBS')"> <button class="clubEditBtn" value="${club.id}">Edit</button></sec:authorize></td>
</c:if>
</c:forEach>
</tr>
</c:forEach>

<c:forEach items="${continents}" var="continent">
<tr>
<td>
<c:choose>
<c:when test="${continent.emblem!=null}">
<img alt="/images/NoImage.JPG" src="${continent.emblem}" style="height: 80px;width: 80px;">
</c:when>
<c:otherwise><img alt="/images/NoImage.JPG" src="<c:url value='/resources/images/NoImage.JPG'/>" style="height: 80px;width: 80px;"></c:otherwise>
</c:choose>
${continent.name}<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_CONTINENTS')"><button class="continentEditBtn" value="${continent.id}">Edit</button></sec:authorize>
</td>
<c:forEach items="${nations}" var="nation">
<c:if test="${nation.continent.id==continent.id}">
<td>
<c:choose>
<c:when test="${nation.emblem!=null}">
<img alt="/images/NoImage.JPG" src="${nation.emblem}" style="height: 80px;width: 80px;">
</c:when>
<c:otherwise><img alt="/images/NoImage.JPG" src="<c:url value='/resources/images/NoImage.JPG'/>" style="height: 80px;width: 80px;"></c:otherwise>
</c:choose>
${nation.name} <sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_NATIONS')"><button class="nationEditBtn" value="${nation.id}">Edit</button></sec:authorize>
</td></c:if>
</c:forEach>
</tr>
</c:forEach>
</table>
<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_CLUBS')"><button id="addClubBtn">Add new club</button></sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_NATIONS')"><button id="addNationBtn">Add new nation</button></sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_LEAGUES')"><button id="addLeagueBtn">Add new league</button></sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_EDIT_CONTINENTS')"><button id="addContinentBtn">Add new continent</button></sec:authorize>	

<div id="clubEditForm" style="visibility: hidden;">
<form action="${contextPath}/team/saveOrUpdateClub" method="POST">
<input type="text" id="clubId" name="clubId" readonly="readonly">
<input type="text" id="clubName" name="clubName">
<select id="clubLeague" name="clubLeague">
<c:forEach items="${leagues}" var="league">
<option value="${league.id}">${league.name}</option>
</c:forEach>
</select>
<input type="text" name="clubEmblem" id="clubEmblem">
<input type="submit" value="Save">
</form>
</div>



<div id="nationEditForm" style="visibility: hidden;">
<form action="${contextPath}/team/saveOrUpdateNation" method="POST">
<input type="text" id="nationId" name="nationId" readonly="readonly">
<input type="text" id="nationName" name="nationName">
<select id="nationContinent" name="nationContinent">
<c:forEach items="${continents}" var="continent">
<option value="${continent.id}">${continent.name}</option>
</c:forEach>
</select>
<input type="text" name="nationEmblem" id="nationEmblem">
<input type="submit" value="Save">
</form>
</div>

<div id="leagueEditForm" style="visibility: hidden;">
<form action="${contextPath}/league/saveOrUpdateLeague" method="POST">
<input type="text" id="leagueId" name="leagueId" readonly="readonly">
<input type="text" id="leagueName" name="leagueName">
<select id="leagueNation" name="leagueNation">
<c:forEach items="${nations}" var="nation">
<option value="${nation.id}">${nation.name}</option>
</c:forEach>
</select>
<input type="text" name="leagueEmblem" id="leagueEmblem">
<input type="submit" value="Save">
</form>
</div>

<div id="continentEditForm" style="visibility: hidden;">
<form action="${contextPath}/continent/saveOrUpdateContinent" method="POST">
<input type="text" id="continentId" name="continentId" readonly="readonly">
<input type="text" id="continentName" name="continentName">
<input type="text" id="continentEmblem" name="continentEmblem">
<input type="submit" value="Save">
</form>

</div>
</div>
