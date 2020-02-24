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
    <div class="container" style="padding-top: 130px;">
      <h1>유저정보상세보기</h1>
      
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
  <div class="form_row">
    <div class="form_col-100">
      <div class="container">
        <div class="form_row">
          <div class="form_col-50">
            <ul>
              <li>
                <div class="colgroup3">
                  <label for="useridx">회원번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.useridx}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="userid">아이디</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.userid}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="name">가입자이름</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.name}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="companyname">법인명</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.companyname}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="corpregistno">법인등록번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.corpregistno}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="ceoname">대표자성명</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.ceoname}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="companyno">사업자등록번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.companyno}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="busicondition">업태</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.busicondition}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="cateofbusiness">업종</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.cateofbusiness}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="fax">팩스번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readUsers.fax}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="responsiblename">담당자이름</label>
                </div>
                <div class="colgroup4">
                  <p>${readUsers.responsiblename}</p>
                </div>
              
                <div class="colgroup3">
                   <label for="responsibleemail">담당자이메일</label>
                </div>
                <div class="colgroup4">
                  <p>${readUsers.responsibleemail}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                   <label for="responsibletel">담당자전화번호</label>
                </div>
                <div class="colgroup4">
                  <p>${readUsers.responsibletel}</p>
                </div>
              
                <div class="colgroup3">
                   <label for="responsiblesellphon">담당자휴대전화</label>
                </div>
                <div class="colgroup4">
                   <p>${readUsers.responsiblesellphon}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup6">
                  <label for="address">주소</label>
                </div>
                <div class="colgroup7">
                  <p>${readUsers.postcode}</p>
                  <p>${readUsers.address1} ${readUsers.address2}</p>
                </div>
              </li>
              
            </ul>
            
            
            
            <c:choose>
              <c:when test="${readUsers.usertype eq '1' }">
              
   <h3>소유농장정보</h3>
   <div>
     <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center">농장번호</th>
					<th class="text-center">농장이름</th>
					<th class="text-center">농장소재지</th>
					<th class="text-center">자가/위탁</th>
					<th class="text-center">상세보기</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(locationsList) > 0}">
          <c:forEach var="locationsList" items="${locationsList}">
              <tr>
                <td class="text-center">${locationsList.locationid}</td>
                <td class="text-center">${locationsList.locationname}</td>
                <td class="text-center">${locationsList.location}</td>
                <td class="text-center">
                <c:choose>
                  <c:when test="${locationsList.locationsort eq 1}">
                    자가
                  </c:when>
                  <c:when test="${locationsList.locationsort eq 2}">
                    위탁
                  </c:when>
                </c:choose>
                </td>
                
                <td class="text-center">
                  <c:url var="readUrl" value="/admin/users/locations_info.do">
                    <c:param name="useridx" value="${readUsers.useridx}"/>
                    <c:param name="locationid" value="${locationsList.locationid}"/>
                  </c:url>
                  <a style="margin: 1px 1px 1px 1px !important;" href="${readUrl}">상세보기</a>
                </td>
                
              </tr>
            
          </c:forEach>
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="5" class="text-center" style="line-height: 100px">조회된 농장 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
    </div>
    
    <h3>관리용 서브 아이디 목록</h3>
   <div>
     <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
				    <th class="text-center">서브아이디번호</th>
					<th class="text-center">아이디</th>
					<th class="text-center">이름</th>
					<th class="text-center">상세보기</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(subIdList) > 0}">
          <c:forEach var="subIdList" items="${subIdList}">
              <tr>
                <td class="text-center">${subIdList.useridx}</td>
                <td class="text-center">${subIdList.userid}</td>
                <td class="text-center">${subIdList.name}</td>
                
                <td class="text-center">
                  <c:url var="readUrl" value="/admin/users/subid_read.do">
                    <c:param name="sub_useridx" value="${subIdList.useridx}"/>
                    <c:param name="useridx" value="${readUsers.useridx}"/>
                  </c:url>
                  <a style="margin: 1px 1px 1px 1px !important;" href="${readUrl}">상세보기</a>
                  
                </td>
              </tr>
            
          </c:forEach>
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="5" class="text-center" style="line-height: 100px">조회된 서브아이디 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
    </div>
                
                
                
                <div class="cleafix">
                  <a href="${pageContext.request.contextPath}/admin/users/admin_sub_insert.do?useridx=${readUsers.useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">서브아이디생성</a>
                  <%-- <a href="${pageContext.request.contextPath}/admin/users/farm_view_edit.do" class="btn" style="float: right; background-color: #005495; color: #ffffff;">농장보기권한설정</a> --%>
                  <a href="${pageContext.request.contextPath}/admin/users/farm_insert.do?useridx=${readUsers.useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">농장추가</a>
                  <a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-bottom:10px;">목록보기</a>
                </div>
              </c:when>
              <c:when test="${readUsers.usertype eq '2' }">
                <div class="cleafix">
                  
                  <a href="${pageContext.request.contextPath}/admin/users/farm_view_set.do?useridx=${readUsers.useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">농장보기권한설정</a>
                  <a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-bottom:10px;">목록보기</a>
                </div>
              </c:when>
              <c:otherwise>
                <a href="${pageContext.request.contextPath}/admin/users/admin_user_list.do" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-bottom:10px;">목록보기</a>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
        
      </div>
    </div>
  </div>
    </c:otherwise>
  </c:choose>
  
    </div>
  </div>



</section>


<%@ include file="/WEB-INF/views/inc/admin_footer.jsp"%>
</body>
</html>
