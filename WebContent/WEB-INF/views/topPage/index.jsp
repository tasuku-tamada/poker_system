<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <c:if test="${flush != null}">
       <div id="flush_success">
           <c:out value="${flush}"></c:out>
       </div>
    </c:if>
        <h2>プレイ記録</h2>
        <table id="play_log">
                <tr>
                    <th class="player_name">氏名</th>
                    <td class="player_name"><c:out value="${player.name}" /></td>
                </tr>
                <tr>
                    <th class="player_coin">所持コイン数</th>
                    <td class="player_coin"><c:out value="${player.coin}" />枚</td>
                </tr>
                <tr>
                    <th class="best_double_up">最高ダブルアップ回数</th>
                    <td class="best_double_up"><c:out value="${best_double_up}" /></td>
                </tr>
        </table>
    </c:param>
</c:import>