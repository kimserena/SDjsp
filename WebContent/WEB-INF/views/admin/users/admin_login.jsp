<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/admin_head.jsp"%>
</head>
<body style="overflow-y: scroll;">
<%@ include file="/WEB-INF/views/inc/admin_header.jsp"%>
      <form class="modal-content animate" action="${pageContext.request.contextPath}/admin/users/admin_login_ok.do" method="post">
        <div class="imgcontainer">
          <img src="${pageContext.request.contextPath}/asset/img/app-gray.png" alt="로고" class="logo">
          <h1>관리자 로그인</h1>
        </div>

        <div class="modal_container">
          <label for="userid"><b>아이디</b></label>
          <input type="text" placeholder="아이디를 입력해 주세요." id="userid" name="userid" required>

          <label for="pw"><b>비밀번호</b></label>
          <input type="password" placeholder="패스워드를 입력해 주세요." id="pw" name="pw" required>

          <button type="submit">로그인</button>
          <label class="checkbox_container">
            <input type="checkbox" checked="checked" name="remember"> 기억하기 <span class="checkmark"></span>
          </label>
        </div>
      </form>


<%@ include file="/WEB-INF/views/inc/admin_footer.jsp"%>
</body>
</html>
