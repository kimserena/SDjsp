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
      <h1>서브아이디정보상세보기</h1>
      
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
                  <label for="useridx">서브아이디번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readSubId.useridx}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="userid">아이디</label> 
                </div>
                <div class="colgroup4">
                  <p>${readSubId.userid}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="name">이름</label> 
                </div>
                <div class="colgroup4">
                  <p>${readSubId.name}</p>
                </div>
              
                
              </li>
              
              
              
            </ul>
            
            
            
            
              
   <h3>농장별권한정보</h3>
   <div>
     <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center">농장번호</th>
					<th class="text-center">농장이름</th>
					<th class="text-center">농장소재지</th>
					<th class="text-center">권한정보</th>
					<th class="text-center">권한정보수정</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(locationsAssignList) > 0}">
          <c:forEach var="locationsAssignList" items="${locationsAssignList}">
              <tr>
                <td class="text-center" style="vertical-align: middle;">${locationsAssignList.locationid}</td>
                <td class="text-center" style="vertical-align: middle;">${locationsAssignList.locationname}</td>
                <td class="text-center" style="vertical-align: middle;">${locationsAssignList.location}</td>
                <td class="text-center" style="vertical-align: middle;">
                <c:choose>
                  <c:when test="${locationsAssignList.level eq 0}">
                    권한없음
                  </c:when>
                  <c:when test="${locationsAssignList.level eq 1}">
                    읽기권한
                  </c:when>
                  <c:when test="${locationsAssignList.level eq 2}">
                    읽기/쓰기권한
                  </c:when>
                </c:choose>
                
                </td>
                <td class="text-center">
                  <form onsubmit="return confirm('농장 권한 정보를 수정 하시겠습니까?');" id="locations_assignments_edit" method="post" action="${pageContext.request.contextPath}/admin/users/locations_assignments_edit_ok.do">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <input type="hidden" id="locationid" name="locationid" value="${locationsAssignList.locationid}">
                    <input type="hidden" id="sub_useridx" name="sub_useridx" value="${sub_useridx}">
                    
                    <select id="level" name="level" style="width: 137px; padding:0;">
                      <option value="">선택해주세요</option>
                      <option value="0">권한없음</option>
                      <option value="1">읽기권한</option>
                      <option value="2">읽기/쓰기권한</option>
                    </select>
                    
                    <input type="submit" value="권한수정"/>
                  </form>
                </td>
                <%-- <td class="text-center">
                  
                  
                  <form onsubmit="return confirm('돈사를 삭제 하시겠습니까?');" id="building_delete_form" method="post" action="${pageContext.request.contextPath}/admin/users/building_delete_ok.do">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <input type="hidden" id="locationid" name="locationid" value="${LocationsList.locationid}">
                    <input type="hidden" id="buildingid" name="buildingid" value="${buildingsList.buildingid}">
                    <input type="submit" value="삭제"/>
                  </form>
                  
          
                </td> --%>
                
              </tr>


          </c:forEach>

               
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="5" class="text-center" style="line-height: 100px">조회된 농장별 권한 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
    </div>
            
                <div class="cleafix">
                  <form style="float: right;" onsubmit="return confirm('서브아이디를 삭제 하시겠습니까?');" id="subid_delete_form" method="post" action="${pageContext.request.contextPath}/admin/users/sub_delete_ok.do">
                    <input type="submit" value="서브아이디삭제" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <input type="hidden" id="sub_useridx" name="sub_useridx" value="${sub_useridx}">
                    
                  </form>
                  <a href="${pageContext.request.contextPath}/admin/users/sub_edit.do?sub_useridx=${sub_useridx}&useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">서브아이디수정</a>
                  <a href="${pageContext.request.contextPath}/admin/users/admin_user_info.do?useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-bottom:10px;">돌아가기</a>
                </div>
                

              
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
