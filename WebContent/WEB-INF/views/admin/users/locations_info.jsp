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
      <h1>농장정보상세보기</h1>
      
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
                  <label for="locationid">농장번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readLocations.locationid}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="locationname">농장이름</label> 
                </div>
                <div class="colgroup4">
                  <p>${readLocations.locationname}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="location">농장소재지</label> 
                </div>
                <div class="colgroup4">
                  <p>${readLocations.location}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="locationsort">농장구분</label> 
                </div>
                <div class="colgroup4">
                  <c:choose>
                    <c:when test="${readLocations.locationsort eq 1}">
                    <p>자가</p>
                    </c:when>
                    <c:when test="${readLocations.locationsort eq 2}">
                    <p>위탁</p>
                    </c:when>
                  </c:choose>
                </div>
              </li>
              
              
              
            </ul>
            
            
            
            
              
   <h3>돈사정보</h3>
   <div>
     <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center">돈사번호</th>
					<th class="text-center">돈사이름</th>
					<th class="text-center">돈사면적(m²)</th>
					<th class="text-center">삭제버튼</th>
				</tr>
			</thead>
	  <tbody>
      <c:choose>
        <c:when test="${fn:length(buildingsList) > 0}">
          <c:forEach var="buildingsList" items="${buildingsList}">
              <tr>
                <td class="text-center">${buildingsList.buildingid}</td>
                <td class="text-center">${buildingsList.buildingname}</td>
                <td class="text-center">${buildingsList.areasize}</td>
                <td class="text-center">
                  
                  <%-- <c:url var="readUrl" value="/admin/users/building_delete.do">
                    <c:param name="buildingid" value="${buildingsList.buildingid}"/>
                    <c:param name="useridx" value="${useridx}"/>
                  </c:url> --%>
                  <!-- <button id="building_delete_btn" style="margin: 1px 1px 1px 1px !important;">삭제</button> -->
                  <form onsubmit="return confirm('돈사를 삭제 하시겠습니까?');" id="building_delete_form" method="post" action="${pageContext.request.contextPath}/admin/users/building_delete_ok.do">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <input type="hidden" id="locationid" name="locationid" value="${readLocations.locationid}">
                    <input type="hidden" id="buildingid" name="buildingid" value="${buildingsList.buildingid}">
                    <input type="submit" value="삭제"/>
                  </form>
                  
          
                </td>
                
              </tr>


          </c:forEach>

               
        </c:when>
        
        
        <c:otherwise>
          <tr>
            <td colspan="4" class="text-center" style="line-height: 100px">조회된 돈사 목록이 없습니다.</td>
          </tr>
        </c:otherwise>
      </c:choose>
      </tbody>
	</table>
    </div>
            
                <div class="cleafix">
                  <a href="${pageContext.request.contextPath}/admin/users/building_insert.do?locationid=${readLocations.locationid}&useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">돈사추가</a>
                  <form style="float: right;" onsubmit="return confirm('농장을 삭제 하시겠습니까?');" id="Location_delete_form" method="post" action="${pageContext.request.contextPath}/admin/users/location_delete_ok.do">
                    <input type="submit" value="농장정보삭제" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <input type="hidden" id="locationid" name="locationid" value="${readLocations.locationid}">
                    
                  </form>
                  <a href="${pageContext.request.contextPath}/admin/users/location_edit.do?locationid=${readLocations.locationid}&useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">농장정보수정</a>
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
