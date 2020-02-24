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

                  
  
                  
                  <form class="join-content" method="post" action="${pageContext.request.contextPath}/admin/service/notice_insert_ok.do">
                    
                    <div class="container" style="padding-top: 130px;">
<!--                      <div class="logo"><img src="img/logo-e.png" alt="로고"></div>-->
                      <h1>공지사항 등록</h1>
                      
                      
                      <div class="form_row">
                        <div class="form_col-100">
                          <div class="container">
                            <div class="form_row">
                              <div class="form_col-50">
                              
                              <ul>
                                <li>
                                  <div class="colgroup3">
                                    <label for="subject">공지제목</label>
                                  </div>
                                  <div class="colgroup4" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input style="width: 410px; margin: 5px 0;" type="text" id="subject" name="subject" data-required="공지제목" required>
                                  </div>
                                  
                                  
                                </li>
                                
                                <li class="heighthigh">
                                  <div class="colgroup1">
                                    <label for="content">공지내용</label>
                                  </div>
                                  <div class="colgroup4" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <textarea rows="50" cols="10" id="content" name="content" style="height:245px;"></textarea>
                                    <!-- <input style="width: 410px;" type="textarea" id="content" name="content" data-required="공지내용" required> --> 
                                  </div>
                                </li>
                                
                              </ul>
                            <div class="form_row">
                          </div>
                        </div>
                      </div>
                        
                        <div class="clearfix">
                          <button type="button" onclick="history.back();" class="cancelbtn">취소</button>
                          <button type="submit" class="signupbtn">공지등록</button>
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
