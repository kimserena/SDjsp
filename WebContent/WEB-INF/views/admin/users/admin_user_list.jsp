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

    <section>
        <div id="wrap">
          <div class="serviceintro">
                <%-- <div class="sub-top-background2"> 
                <div class="navbarbackg">
                       <div class="container">
                        <div class="navbar"> <a href="#home"><i class="fas fa-home"></i> <!--<span class="font-gray"><i class="xi-angle-right-thin"></i></span>--></a>
                            <div class="dropdown">
                                <button class="dropbtn">고객관리 <i class="arrow down"></i> </button>
                                <div class="dropdown-content">
                                  <a href="${pageContext.request.contextPath}/admin/index/admin_index.do">서비스신청관리</a> 
                                  <a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do" class="dropbtn-color">고객관리</a> 
                                  <a href="${pageContext.request.contextPath}/">고객지원</a> 
                                  <a href="${pageContext.request.contextPath}/">견적 문의</a>
                                </div>
                            </div>
                            <div class="dropdown">
                                <button class="dropbtn">거래처리스트<i class="arrow down"></i> </button>
                                <div class="dropdown-content"> 
                                  <a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do" class="dropbtn-color">거래처리스트</a> 
                                  <a href="${pageContext.request.contextPath}/">거래처수정</a>
                                  <a href="${pageContext.request.contextPath}/">권한요청리스트</a>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
                
                <h2 class="text-border">거래처리스트</h2> --%>
                
 <!-- 어드민 컨텐트 영역 -->
<div class="container">
  
  <h1>유저 리스트</h1>
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
    <div>
    
  <!-- 검색 폼 -->
  <div class="pull-left">
    <form method="get" action="${pageContext.request.contextPath}/admin/users/admin_user_list.do" style="width: 200px">
      
      <div class="input-group">
        <input type="text" name="keyword" class="form-control" placeholder="회원 아이디 검색" value="${keyword}"/>
        <span class="input-group-btn">
          <button class="btn btn-success" type="submit">검색</button>
        </span>
      
      </div>
    </form>
  
  </div>
    
      <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center">회원번호</th>
					<th class="text-center">아이디</th>
					<th class="text-center">가입자이름</th>
					<th class="text-center">법인명</th>
					<th class="text-center">대표자이름</th>
					<th class="text-center">업태</th>
					<th class="text-center">업종</th>
					<th class="text-center">팩스번호</th>
					<th class="text-center">담당자이름</th>
					<th class="text-center">담당자이메일</th>
					<th class="text-center">담당자전화번호</th>
					<th class="text-center">담당자핸드폰번호</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(userList) > 0}">
          <c:forEach var="userList" items="${userList}">
              <tr>
                <td class="text-center">${userList.useridx}</td>
                <td class="text-center">
                  <c:url var="readUrl" value="/admin/users/admin_user_info.do">
                    <c:param name="useridx" value="${userList.useridx}"/>
                  </c:url>
                  <a href="${readUrl}">${userList.userid}</a>
                </td>
                <td class="text-center">${userList.name}</td>
                <c:choose>
                  <c:when test="${userList.companyname eq null}">
                    <td class="text-center">*</td>
                  </c:when>
                  <c:otherwise>
                    <td class="text-center">${userList.companyname}</td>
                  </c:otherwise>
                </c:choose>
                <td class="text-center">${userList.ceoname}</td>
                <td class="text-center">${userList.busicondition}</td>
                <td class="text-center">${userList.cateofbusiness}</td>
                <td class="text-center">${userList.fax}</td>
                <td class="text-center">${userList.responsiblename}</td>
                <td class="text-center">${userList.responsibleemail}</td>
                <c:choose>
                  <c:when test="${userList.responsibletel eq null}">
                    <td class="text-center">*</td>
                  </c:when>
                  <c:otherwise>
                    <td class="text-center">${userList.responsibletel}</td>
                  </c:otherwise>
                </c:choose>
                
                <c:choose>
                  <c:when test="${userList.responsiblesellphon eq null}">
                    <td class="text-center">*</td>
                  </c:when>
                  <c:otherwise>
                    <td class="text-center">${userList.responsiblesellphon}</td>
                  </c:otherwise>
                </c:choose>
                
                
              </tr>
            
          </c:forEach>
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="12" class="text-center" style="line-height: 100px">조회된 회원 목록이 없습니다.</td>
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
							<c:url var="prevUrl" value="/admin/users/admin_user_list.do">
							    <c:param name="keyword" value="${keyword}"></c:param>
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
						<c:url var="pageUrl" value="/admin/users/admin_user_list.do">
	                        <c:param name="keyword" value="${keyword}"></c:param>
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
							<c:url var="nextUrl" value="/admin/users/admin_user_list.do">
							    <c:param name="keyword" value="${keyword}"></c:param>
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
                
                
            </div>
           
        </div>
    </section>
    <div class="cleafix"></div>

<%@ include file="/WEB-INF/views/inc/admin_footer.jsp"%>
</body>
</html>
