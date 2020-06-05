<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="reward_table">
    <c:forEach var="role" items="${roles}" varStatus="status">
        <c:if test="${status.count % 2 == 1}">
            <tr>
        </c:if>
        <th class="role_name" id="role_${role.id}_name"><c:out
                value="${role.name}" /></th>
        <td id="role_${role.id}_magnification"><c:out
                value="${role.magnification}" /></td>
        <c:if test="${status.count % 2 == 0}">
            </tr>
        </c:if>
    </c:forEach>
    <c:if test="${fn:length(roles) % 2 == 1}">
        </tr>
    </c:if>
</table>
