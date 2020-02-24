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

<section style="padding-top: 100px;">

 <!-- 어드민 컨텐트 영역 -->
<div class="container">
  
  <h1>고장문의 리스트</h1>
  <c:choose>
    <c:when test="${adminLoginInfo == null}">
      <!-- 작성자 -->
      <div class="form-group">
        <h1>로그인 후 이용 가능합니다.</h1>
        <div class="pull-right">
        <a href="${pageContext.request.contextPath}/admin/users/admin_login.do" class="btn btn-warning">관리자 로그인</a>
      </div>
      </div>
    </c:when>
    <c:otherwise>
       <%-- <a href="${pageContext.request.contextPath}/admin/service/notice_insert.do" class="btn" style="float: right; background-color: #005495; color: #ffffff;">공지등록</a> --%>
    <div style="padding-top: 30px;">
    
<%--   <!-- 검색 폼 -->
  <div class="pull-left">
    <form method="get" action="${pageContext.request.contextPath}/admin/service/afterservice_list_list.do" style="width: 200px">
      
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
					<th class="text-center">문의번호</th>
					<th class="text-center">내용</th>
					<th class="text-center">작성자</th>
					<th class="text-center">등록날짜</th>
					<th class="text-center">처리상태</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(asList) > 0}">
          <c:forEach var="asList" items="${asList}">
              <tr>
                <td class="text-center">${asList.idx}</td>
                <td class="text-center">
                  <c:url var="readUrl" value="/admin/service/afterservice_read.do">
                    <c:param name="as_no" value="${asList.idx}"/>
                  </c:url>
                  <a style="max-width: 150px; display:inline-block; vertical-align: middle; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;" href="${readUrl}">${asList.content}</a>
                </td>
                <td class="text-center">${asList.writer}</td>
                <td class="text-center">${asList.editdate}</td>
                <td class="text-center">
                  <c:if test="${asList.board_confirm==1}">처리대기</c:if>
                  <c:if test="${asList.board_confirm==2}">처리완료</c:if>
                </td>
                
                
              </tr>
            
          </c:forEach>
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="5" class="text-center" style="line-height: 100px">조회된 고장문의 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
    </div>

    <!-- 페이지 번호 시작 -->
		<div class="content-list-bottom text-center">
			<nav>
				<ul class="pagination">
					<!-- 이전 그룹으로 이동 -->
					<c:choose>
						<c:when test="${pageHelper.prevPage > 0}">
							<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
							<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
							<c:url var="prevUrl" value="/admin/service/afterservice_list.do">
							    <%-- <c:param name="keyword" value="${keyword}"></c:param> --%>
								<c:param name="page" value="${pageHelper.prevPage}"></c:param>
							</c:url>
	
							<li><a href="${prevUrl}">&laquo;</a></li>
						</c:when>
	
						<c:otherwise>
							<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
							<li class="disabled"><a href="#">&laquo;</a></li>
						</c:otherwise>
					</c:choose>
	
					<!-- 페이지 번호 -->
					<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
					<c:forEach var="i" begin="${pageHelper.startPage}"
						end="${pageHelper.endPage}" step="1">
						<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
						<c:url var="pageUrl" value="/admin/service/afterservice_list.do">
	                        <%-- <c:param name="keyword" value="${keyword}"></c:param> --%>
							<c:param name="page" value="${i}"></c:param>
						</c:url>
	
						<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
						<c:choose>
							<c:when test="${pageHelper.page == i}">
								<li class="active"><a href="#">${i}</a></li>
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
							<c:url var="nextUrl" value="/admin/service/afterservice_list.do">
							    <%-- <c:param name="keyword" value="${keyword}"></c:param> --%>
								<c:param name="page" value="${pageHelper.nextPage}"></c:param>
							</c:url>
	
							<li><a href="${nextUrl}">&raquo;</a></li>
						</c:when>
	
						<c:otherwise>
							<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
							<li class="disabled"><a href="#">&raquo;</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
		<!-- // 페이지 번호 끝 -->
    

  

        </c:otherwise>
  </c:choose>
  


</div>

    

    
</section>

<%@ include file="/WEB-INF/views/inc/admin_footer.jsp"%>
</body>
</html>
