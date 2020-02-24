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
      <h1>${readBoard.subject}</h1>
      
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
                  <label for="noti_no">글번호</label> 
                </div>
                <div class="colgroup4">
                  <p>${readBoard.idx}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="writer">작성자</label> 
                </div>
                <div class="colgroup4">
                  <p>${readBoard.writer}</p>
                </div>
              </li>
              
              <li>
                <div class="colgroup3">
                  <label for="editdate">등록일자</label> 
                </div>
                <div class="colgroup4">
                  <p>${readBoard.editdate}</p>
                </div>
              
                <div class="colgroup3">
                  <label for="userid">글 카테고리</label> 
                </div>
                <div class="colgroup4">
                  <p>${readBoard.cate}</p>
                </div>
              </li>
              
            </ul>
            
            <div class="substance-inner">
                <div class="colgroup8">
                  <label for="name">내용</label> 
                </div>
                <div class="colgroup9">
                  <p>${readBoard.content}</p>
                </div>
			</div>
            
            
              

            
                <div class="cleafix">
                  <form style="float: right;" onsubmit="return confirm('공지를 삭제 하시겠습니까?');" id="notice_delete_form" method="post" action="${pageContext.request.contextPath}/admin/service/notice_delete_ok.do">
                    <input type="submit" value="공지삭제" class="btn" style="float: right; background-color: #005495; color: #ffffff;  display:inline-block; margin-left:10px; margin-bottom:10px;">
                    <input type="hidden" id="noti_no" name="noti_no" value="${readBoard.idx}">
                    
                  </form>
                  <a href="${pageContext.request.contextPath}/admin/service/notice_edit.do?noti_no=${readBoard.idx}" class="btn" style="float: right; background-color: #005495; color: #ffffff; display:inline-block; margin-left:10px; margin-bottom:10px;">공지수정</a>
                  <a href="${pageContext.request.contextPath}/admin/service/notice_list.do" class="btn" style="float: right; background-color: #005495; color: #ffffff; margin-bottom:10px;">돌아가기</a>
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
