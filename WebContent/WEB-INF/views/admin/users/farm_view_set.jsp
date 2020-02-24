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
      <h1>농장별 권한정보 </h1>
      
      <div class="form_row">
    <div class="form_col-100">
      <div class="container">
        <div class="form_row">
          <div class="form_col-50">
   
   <div>
     <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center">농장소유주</th>
					<th class="text-center">농장이름</th>
					<th class="text-center">농장소재지</th>
					<th class="text-center">자가/위탁</th>
					<th class="text-center">권한정보</th>
					<th class="text-center">삭제버튼</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(joinList) > 0}">
          <c:forEach var="joinList" items="${joinList}">
              <tr>
                <td class="text-center">${joinList.companyname}</td>
                <td class="text-center">${joinList.locationname}</td>
                <td class="text-center">${joinList.location}</td>
                <td class="text-center">
                <c:choose>
                  <c:when test="${joinList.locationsort eq 1}">
                    자가
                  </c:when>
                  <c:when test="${joinList.locationsort eq 2}">
                    위탁
                  </c:when>
                </c:choose>
                </td>
                
                <td class="text-center">
                <c:choose>
                  <c:when test="${joinList.level eq 0}">
                    권한없음
                  </c:when>
                  <c:when test="${joinList.level eq 1}">
                    읽기권한
                  </c:when>
                  <c:when test="${joinList.level eq 2}">
                    읽기/쓰기권한
                  </c:when>
                </c:choose>
                </td>
                
                <td class="text-center">
                  <form onsubmit="return confirm('이 농장의 권한정보를 삭제 하시겠습니까?');" method="post" action="${pageContext.request.contextPath}/admin/users/farm_view_delete_ok.do">
                    <input type="hidden" id="locationid" name="locationid" value="${joinList.locationid}">
                    <input type="hidden" id="useridx" name="useridx" value="${joinList.useridx}">
                    <input type="submit" value="삭제"/>
                  </form>
                </td>
                
              </tr>
            
          </c:forEach>
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="6" class="text-center" style="line-height: 100px">조회된 농장별 권한 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
	<div class="cleafix">
	  <a href="${pageContext.request.contextPath}/admin/users/farm_view_insert.do?useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-left:10px; margin-bottom:10px;">농장 권한 추가</a>
      <a href="${pageContext.request.contextPath}/admin/users/admin_user_info.do?useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-bottom:10px;">돌아가기</a>
	
	</div>
	</div>
        </div>
        
      </div>
    </div>
  </div>
    </div>
    
    </div>
  </div>



</section>

<%@ include file="/WEB-INF/views/inc/admin_footer.jsp"%>
</body>
</html>
