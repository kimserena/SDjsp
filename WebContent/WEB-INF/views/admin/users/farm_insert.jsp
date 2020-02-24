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
            
           <div id="id02" class="join-modal">
<!--                  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>-->

                  
  
                  
                  <form class="modal-join-content" method="post" action="${pageContext.request.contextPath}/admin/users/farm_insert_ok.do">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <div class="container" style="padding-top: 130px;">
<!--                      <div class="logo"><img src="img/logo-e.png" alt="로고"></div>-->
                      <h1>농장 추가</h1>
                      
                      
                      <div class="form_row">
                        <div class="form_col-100">
                          <div class="container">
                            <div class="form_row">
                              <div class="form_col-50">
                              
                              <ul>
                                <li>
                                  <div class="colgroup3">
                                    <label for="locationname">농장이름</label>
                                  </div>
                                  <div class="colgroup5" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input style="width: 410px;" type="text" id="locationname" name="locationname" data-required="농장이름" required>
                                  </div>
                                  
                                  <div class="colgroup3">
                                    <label for="location">소재지</label>
                                  </div>
                                  <div class="colgroup5" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input style="width: 410px;" type="text" id="location" name="location" data-required="소재지" required> 
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup3">
                                    <label for="name">농장구분</label>
                                  </div>
                                  <div class="colgroup4">
                                    <input type="radio" name="locationsort" id="locationsort1" value="1"/> 자가
                                    <input type="radio" name="locationsort" id="locationsort2" value="2"/> 위탁
                                     
                                  </div>
                                </li>
                              </ul>
                            <div class="form_row">
                          </div>
                        </div>
                      </div>
                        
                        <div class="clearfix">
                          <button type="button" onclick="history.back();" class="cancelbtn">취소</button>
                          <button type="submit" class="signupbtn">농장추가</button>
                        </div>
                    </div>
                  </div>
                </div>
                      
                      <hr>
                      
                      
                      
                    </div>
                  </form>
                </div>
        </div>
    </section>

<%@ include file="/WEB-INF/views/inc/admin_footer.jsp"%>
</body>
</html>
