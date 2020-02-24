<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
    <footer>
        <div class="container">
           <div id="footer-logo"><img src="${pageContext.request.contextPath}/asset/img/logo-e.png" alt="로고"></div>
            <div id="company-info">
                대표이사 : 최승규 <span></span> 사업자등록번호 : 779-87-00956 <span></span> 법인등록번호 : 165011-0062463 <span></span> 대표 전화 : 041-356-5084 <span></span> 대표 팩스 : 041-356-5086 <span></span> 이메일 : abchoi2018@gmail.com
            </div>
            <div id="copyright">Copyright ⓒ 2019 스마트데일리 All Rights Reserved.</div>
        </div>
    </footer>
    
    <button class="m_tops" id="myBtn" title="Go to Top"><i class="fas fa-chevron-up"></i><p>맨 위로</p></button>
    
    <div id="id01" class="modal">
      <form class="modal-content animate" action="${pageContext.request.contextPath}/users/login_ok.do" method="post">
        <div class="imgcontainer">
          <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
          <img src="${pageContext.request.contextPath}/asset/img/app-gray.png" alt="로고" class="logo">
          <h1>로그인</h1>
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

        <div class="modal_container">
          <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">취소</button>
          <span class="psw"><a href="#">패스워드 찾기</a></span>
        </div>
      </form>
    </div>
    
    
    
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
        <link href="${pageContext.request.contextPath}/asset/css/common.css" rel="stylesheet" type="text/css">
        <!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.4.js"></script> -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <!-- <script type="text/javascript" src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script> -->
        
    	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/tab_menu.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/daily_check.js"></script>
    	<script src="https://kit.fontawesome.com/b55569e153.js" crossorigin="anonymous"></script>
    	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    	<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/asset/js/common.js"></script>
        <script src="https://kit.fontawesome.com/b55569e153.js" crossorigin="anonymous"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/x-icon" href="img/app-blue.png">
        
        <!-- 다음 우편번호 -->
        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        
	    <!-- <script src="http://code.jquery.com/jquery.min.js"></script> -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<%-- <script src="${pageContext.request.contextPath}/asset/js/jquery-3.1.1.js"></script> --%>
		
		<!-- Twitter Bootstrap3 & jQuery -->
		<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/> -->