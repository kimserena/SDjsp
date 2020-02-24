<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<header>
  <div class="header-inner">
            <div class="logo">
                <a href="${pageContext.request.contextPath}/admin/index/admin_index.do">
                    <img src="${pageContext.request.contextPath}/asset/img/logo-master.png" alt="로고"><span></span>
                </a>
            </div>
            <div class="nav">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/admin/index/admin_index.do" class="nav_down">서비스신청관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/service/afterservice_list.do" class="nav_down">고객지원</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do" class="nav_down">고객관리</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/service/notice_list.do">공지사항</a></li>
                </ul>
                
            </div>
            
           <div class="login">
            <c:choose>
        <c:when test="${adminLoginInfo==null}">
                <button onclick="location.href='${pageContext.request.contextPath}/admin/users/admin_login.do'" style="width:auto;" class="login_button">로그인</button> <div class="line"></div>
        </c:when>
        <c:otherwise>
            <!-- 로그인 된 경우 -->
                
                <div class="dropdown-login">
				  <span><a href="#" class="dropdown-toggle" data-toggle="dropdown">${adminLoginInfo.name}님 <span class="caret"></span></a></span>
				  <div class="dropdown-login-content">
				    <button class="logout" onclick="location.href='${pageContext.request.contextPath}/admin/users/logout.do'">로그아웃</button>
				  </div>
				</div>
      
      <!-- // 로그인 된 경우 -->
        </c:otherwise>
      </c:choose>
            </div>
            <%-- <div class="login">
                <ul>
                    <li><button onclick="document.getElementById('id01').style.display='block'" style="width:auto;" class="login_button">로그인</button> <div class="line"></div></li>
                    <li><button onclick="location.href='${pageContext.request.contextPath}/users/user_join.do'">회원 가입</button></li>
                </ul>
            </div> --%>
        </div>
        <div class="sub-navi">
                <div class="wrap">
                    <div class="sub-menu">
                        <ul class="sub sub1">
                            <li><a href="${pageContext.request.contextPath}/admin/index/admin_index.do">신규가입자관리</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/service/estimate_list.do">견적문의</a></li>
                        </ul>
                        <ul class="sub sub2">
                            <li><a href="${pageContext.request.contextPath}/admin/service/afterservice_list.do">고장문의</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/service/qna_list.do">서비스문의</a></li>
                        </ul>
                        <ul class="sub sub3">
                            <li><a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do">유저리스트</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/service/farm_view_auth_list.do">권한요청리스트</a></li>
                            <li><a href="${pageContext.request.contextPath}/admin/users/suspenduse_user_list.do">정지유저리스트</a></li>
                        </ul>
                        
                        <ul class="sub sub4">
                            <li><a href="${pageContext.request.contextPath}/admin/service/notice_list.do">공지사항</a></li>
                        </ul>
                    </div>
                </div>
            </div>
    </header>