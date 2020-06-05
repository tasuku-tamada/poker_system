<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <script type="text/javascript"
            src='<c:url value="../js/role_coin_change.js"/>'></script>
        <h2>賭け金設定</h2>
        <c:import url="roles.jsp" />
        <form method="post" action="<c:url value='/play/change'/>">
            <span class="coin">コイン ${player.coin}枚 </span> <span class="bet">賭け金
                <input type="number" name="bet" min="1" max="${player.coin}"
                value="1" oninput="update_role(this)">
            </span> <input type="submit" name="決定">
        </form>
    </c:param>
</c:import>