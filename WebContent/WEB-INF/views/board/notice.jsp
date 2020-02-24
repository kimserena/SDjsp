<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/head.jsp"%>
<!-- bootstrap -->
		<%-- <link href="${pageContext.request.contextPath}/asset/js/bootstrap.min.js" rel="stylesheet"/> --%>
        <%-- <link href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" rel="stylesheet"/> --%>
</head>
<body style="overflow-y: scroll;">
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

	<section>
		<div id="wrap">
			<div class="serviceintro">
				<div class="sub-top-background3">
					<div class="navbarbackg">
						<div class="container">
							<div class="navbar">
								<a href="${pageContext.request.contextPath}/index.do"><i class="fas fa-home"></i></a>
								<div class="dropdown">
									<button class="dropbtn">
										고객센터 <i class="arrow down"></i>
									</button>
									<div class="dropdown-content">
										<a href="${pageContext.request.contextPath}/board/service_info.do">서비스 소개</a> 
										<a href="${pageContext.request.contextPath}/users/user_edit.do">서비스 이용</a> 
										<a href="${pageContext.request.contextPath}/board/notice.do">고객센터</a>
										<a href="${pageContext.request.contextPath}/board/estimate_enquiry.do" class="dropbtn-color">견적문의</a>
									</div>
								</div>
								<div class="dropdown">
									<button class="dropbtn">
										공지 사항<i class="arrow down"></i>
									</button>
									<div class="dropdown-content">
										<a href="${pageContext.request.contextPath}/board/notice.do" class="dropbtn-color">공지 사항</a> 
										<a href="${pageContext.request.contextPath}/board/support.do">문의 하기</a> 
										<a href="${pageContext.request.contextPath}/board/menual.do">매뉴얼</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h2 class="text-border">공지 사항</h2>
			</div>
 <!-- 어드민 컨텐트 영역 -->
<div class="container" >
  
  <h2 style="margin-top:40px; font-size:30px;">공지사항 리스트</h2>
  <%-- <c:choose>
    <c:when test="${adminLoginInfo == null}">
      <!-- 작성자 -->
      <div class="form-group">
        <h1>로그인 후 이용 가능합니다.</h1>
        <div class="pull-right">
        <a href="${pageContext.request.contextPath}/admin/users/admin_login.do" class="btn btn-warning">관리자 로그인</a>
      </div>
      </div>
    </c:when>
    <c:otherwise> --%>
       <%-- <a href="${pageContext.request.contextPath}/board/notice_insert.do" class="btn" style="float: right; background-color: #005495; color: #ffffff;">공지등록</a> --%>
    <div style="padding-top: 30px;">
    
<%--   <!-- 검색 폼 -->
  <div class="pull-left">
    <form method="get" action="${pageContext.request.contextPath}/board/notice_list.do" style="width: 200px">
      
      <div class="input-group">
        <input type="text" name="keyword" class="form-control" placeholder="회원 아이디 검색" value="${keyword}"/>
        <span class="input-group-btn">
          <button class="btn btn-success" type="submit">검색</button>
        </span>
      
      </div>
    </form>
  
  </div> --%>
    
      <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center" style="padding:8px 0px;">공지번호</th>
					<th class="text-center" style="padding:8px 0px;">제목</th>
					<th class="text-center" style="padding:8px 0px;">작성자</th>
					<th class="text-center" style="padding:8px 0px;">등록날짜</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(noticeList) > 0}">
          <c:forEach var="noticeList" items="${noticeList}">
              <tr>
                <td class="text-center" style="padding:4px 0px;">${noticeList.idx}</td>
                <td class="text-center" style="padding:4px 0px;">
                  <c:url var="readUrl" value="/board/read_notice.do">
                    <c:param name="noti_no" value="${noticeList.idx}"/>
                  </c:url>
                  <a href="${readUrl}">${noticeList.subject}</a>
                </td>
                <td class="text-center" style="padding:4px 0px;">${noticeList.writer}</td>
                <td class="text-center" style="padding:4px 0px;">${noticeList.editdate}</td>
                
                
                
              </tr>
            
          </c:forEach>
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="4" class="text-center" style="line-height: 100px">조회된 공지 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
    </div>

    <!-- 페이지 번호 시작 -->
		<div class="content-list-bottom text-center">
			<nav>
				<ul class="pagination-notice">
					<!-- 이전 그룹으로 이동 -->
					<c:choose>
						<c:when test="${pageHelper.prevPage > 0}">
							<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
							<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
							<c:url var="prevUrl" value="/board/notice.do">
							    <%-- <c:param name="keyword" value="${keyword}"></c:param> --%>
								<c:param name="page" value="${pageHelper.prevPage}"></c:param>
							</c:url>
	
							<li><a href="${prevUrl}"><i class="fas fa-angle-left"></i></a></li>
						</c:when>
	
						<c:otherwise>
							<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
							<li class="disabled-notice"><a href="#"><i class="fas fa-angle-left"></i></a></li>
						</c:otherwise>
					</c:choose>
	
					<!-- 페이지 번호 -->
					<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
					<c:forEach var="i" begin="${pageHelper.startPage}"
						end="${pageHelper.endPage}" step="1">
						<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
						<c:url var="pageUrl" value="/board/notice.do">
	                        <%-- <c:param name="keyword" value="${keyword}"></c:param> --%>
							<c:param name="page" value="${i}"></c:param>
						</c:url>
	
						<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
						<c:choose>
							<c:when test="${pageHelper.page == i}">
								<li class="active-notice"><a href="#">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageUrl}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
	
					<!-- 다음 그룹으로 이동 -->
					<c:choose>
						<c:when test="${pageHelper.nextPage > 0}">
							<!-- 다음 그룹에 대한 페이지 번호가 존재한다면? -->
							<!-- 다음 그룹으로 이동하기 위한 URL을 생성해서 "nextUrl"에 저장 -->
							<c:url var="nextUrl" value="/board/notice.do">
							    <%-- <c:param name="keyword" value="${keyword}"></c:param> --%>
								<c:param name="page" value="${pageHelper.nextPage}"></c:param>
							</c:url>
	
							<li><a href="${nextUrl}"><i class="fas fa-angle-right"></i></a></li>
						</c:when>
	
						<c:otherwise>
							<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
							<li class="disabled-notice"><a href="#"><i class="fas fa-angle-right"></i></a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
		<!-- // 페이지 번호 끝 -->
    

  

        <%-- </c:otherwise>
  </c:choose> --%>
  


</div>

		</div>
	</section>

	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
