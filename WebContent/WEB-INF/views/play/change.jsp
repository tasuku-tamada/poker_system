<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <script type="text/javascript"
            src='<c:url value="../js/select_change_card.js"/>'></script>
        <h2>カード交換</h2>
        <c:import url="roles.jsp" />
        <br>
        <table id="hand_table">
            <c:import url="hand.jsp" />
            <tr>
                <c:forEach begin="0" end="4" step="1" varStatus="status">
                    <td class="change_0">
                        <button id="button_${status.index}" onclick="select_change(this)">そのまま</button>
                    </td>
                </c:forEach>
            </tr>
        </table>
        <form method="post" action="<c:url value='/play/change_result'/>">
            <c:forEach begin="0" end="4" step="1" varStatus="status">
                <input type="hidden" id = "send_${status.index}" name="select[]" value="false">
            </c:forEach>
            <span class="coin">コイン ${player.coin}枚 </span> <span class="bet">賭け金
                ${player.bet}枚</span> <input type="submit" value="決定">
        </form>
    </c:param>
</c:import>