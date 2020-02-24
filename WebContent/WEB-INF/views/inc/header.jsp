<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<header>
  <div class="header-inner">
            <div class="logo">
                <a href="${pageContext.request.contextPath}/index.do">
                    <img src="${pageContext.request.contextPath}/asset/img/logo.png" alt="로고"><span></span>
                </a>
            </div>
            <div class="nav">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/board/service_info.do" class="nav_down">서비스 소개</a></li>
                    <li><a href="${pageContext.request.contextPath}/users/user_edit.do" class="nav_down">서비스 이용</a></li>
                    <li><a href="${pageContext.request.contextPath}/board/notice.do" class="nav_down">고객센터</a></li>
                    <li><a href="${pageContext.request.contextPath}/board/estimate_enquiry.do">견적 문의</a></li>
                </ul>
                
            </div>
            <div class="login">
            <c:choose>
        <c:when test="${loginInfo==null}">
                <ul>
                    <li><button onclick="document.getElementById('id01').style.display='block'" style="width:auto;" class="login_button">로그인</button> <div class="line"></div></li>
                    <li><button onclick="location.href='${pageContext.request.contextPath}/users/user_join.do'">회원 가입</button></li>
                </ul>
                </c:when>
        <c:otherwise>
            <!-- 로그인 된 경우 -->

                <div class="dropdown-login">
				  <span><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding: 5px; color:#337ab7; font-size:14px;">${loginInfo.name}님 <span class="caret"></span></a></span>
				  <div class="dropdown-login-content">
				    <button class="logout" onclick="location.href='${pageContext.request.contextPath}/users/logout.do'">로그아웃</button>
				  </div>
				</div>
      
      <!-- // 로그인 된 경우 -->
        </c:otherwise>
      </c:choose>
            </div>
        </div>
        <div class="sub-navi">
                <div class="wrap">
                    <div class="sub-menu">
                        <ul class="sub sub1">
                            <li><a href="${pageContext.request.contextPath}/board/service_info.do">서비스 정보</a></li>
                            <li><a href="${pageContext.request.contextPath}/board/operation_guide.do">이용 안내</a></li>
                        </ul>
                        <ul class="sub sub2">
                            <li><a href="${pageContext.request.contextPath}/users/user_edit.do">개인정보 관리</a></li>
<!--                            <li><a href="support.do">고장 접수</a></li>-->
                            <li><a href="${pageContext.request.contextPath}/board/daily_check.do">일보 조회</a></li>
                        </ul>
                        <ul class="sub sub3">
                            <li><a href="${pageContext.request.contextPath}/board/notice.do">공지사항</a></li>
                            <li><a href="${pageContext.request.contextPath}/board/support.do">문의 하기</a></li>
                            <li><a href="${pageContext.request.contextPath}/board/menual.do">매뉴얼</a></li>
                        </ul>
                        <ul class="sub sub4">
                            
                        </ul>
                    </div>
                </div>
            </div>
    </header>