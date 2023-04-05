<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main>
    <h3><a href="http://localhost:3000/test">HOME</a></h3>
    <h1>회원가입</h1>
    <form method="post" action="<c:url value='/member/join' />" target="ifrm">
        <dl>
            <dt>아이디</dt>
            <dd>
                <input type="text" name="userId">
            </dd>
        </dl>
        <dl>
            <dt>비밀번호</dt>
            <dd>
                <input type="password" name="userPw">
            </dd>
        </dl>
        <button type="submit">가입하기</button>
    </form>
</layout:main>
