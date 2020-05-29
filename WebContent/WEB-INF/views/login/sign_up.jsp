<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test= "${errors != null}">
           <div id="flush_error">
               入力内容にエラーがあります。<br />
               <c:forEach var="error" items="${errors}">
                   <c:out value="${error}" />
                   <br />
               </c:forEach>
           </div>
        </c:if>
        <h2>ユーザー登録</h2>
        <form method="POST" action="<c:url value='/sign_up' />">
            <label for="name">プレイヤー名</label><br />
            <input type="text" name="name" value="${name}" />
            <br /><br />

            <label for="password">パスワード</label><br />
            <input type="password" name="password" />
            <br /><br />


            <input type="hidden" name="_token" value="${_token}" />
            <button type="submit">登録</button>
        </form>
    </c:param>
</c:import>
