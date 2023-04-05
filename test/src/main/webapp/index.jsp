<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main>
<h1>메인페이지</h1>
    <c:if test="${member == null}">
        <a href="<c:url value='/member/join' />">회원가입</a>
        <a href="<c:url value='/member/login' />">로그인</a>
    </c:if>
    <c:if test="${member != null}">
        ${member.userId}님
        <a href="<c:url value='/member/logout'  />">로그아웃</a>
    </c:if>
</layout:main>