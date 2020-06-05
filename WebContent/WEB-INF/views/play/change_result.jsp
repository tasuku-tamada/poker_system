<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <script type="text/javascript"
            src='<c:url value="../js/change_result.js"/>'></script>
        <h2>カード交換結果</h2>
        <c:import url="roles.jsp" />
        <br>
        <table id="hand_table">
            <c:import url="hand.jsp" />
        </table>
        <div id="message">
            <c:choose>
                <c:when test="${double_up_flag}">
                    結果は${player.role}!<br>
                    ダブルアップに挑戦しますか？
                    <a class = "double_up_button" href="<c:url value='/play/double_up'/>">はい</a>
                    <button class = "double_up_button" onclick ="change_message()">いいえ</button>>
                </c:when>
                <c:otherwise>
                     残念！<br>
                     ゲームを続行しますか？
                </c:otherwise>
            </c:choose>
        </div>
        <c:choose>
            <c:when test="${double_up_flag}">
                <a class = "yesno_button" href="<c:url value='/play/double_up'/>">はい</a>
                <button class = "yesno_button" onclick ="change_message()">いいえ</button>
            </c:when>
            <c:otherwise>
                <a class = "yesno_button" href="<c:url value='/play/bet'/>">はい</a>
                <a class = "yesno_button" href="<c:url value='/top/index'/>">いいえ</a>
            </c:otherwise>
        </c:choose>
        <form method="post" action="<c:url value='/play/change_result'/>">
            <span class="coin">コイン ${player.coin}枚 </span> <span class="bet">賭け金
                ${player.bet}枚</span> <input type="submit" value="決定">
        </form>
    </c:param>
</c:import>