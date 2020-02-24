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

                  
  
                  
                  <form class="join-content" method="post" action="${pageContext.request.contextPath}/admin/users/admin_sub_insert_ok.do">
                    <input type="hidden" id="useridx" name="useridx" value="${useridx}">
                    <div class="container" style="padding-top: 130px;">
<!--                      <div class="logo"><img src="img/logo-e.png" alt="로고"></div>-->
                      <h1>서브아이디생성</h1>
                      
                      
                      <div class="form_row">
                        <div class="form_col-100">
                          <div class="container">
                            <div class="form_row">
                              <div class="form_col-50">
                              
                              <ul>
                                <li>
                                  <div class="colgroup3">
                                    <label for="userid">유저아이디</label>
                                  </div>
                                  <div class="colgroup4" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input style="width: 410px;" type="text" id="userid" name="userid" data-required="유저아이디" required>
                                  </div>
                                  
                                  <div class="colgroup3">
                                    <label for="name">이름</label>
                                  </div>
                                  <div class="colgroup4" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input style="width: 410px;" type="text" id="name" name="name" data-required="이름" required> 
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup3">
                                    <label for="pw">비밀번호</label>
                                  </div>
                                  <div class="colgroup4" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input type="password" id="pw" name="pw" data-required="비밀번호" placeholder="비밀번호를 입력해 주세요." required>
                                  </div>
                                  
                                  <div class="colgroup3">
                                    <label for="pw_re">비밀번호 확인</label>
                                  </div>
                                  <div class="colgroup4" style="display: contents; width: 420px; padding: 12px 15px; height: 50px;">
                                    <input type="password" id="pw_re" name="pw_re" data-required="비밀번호 확인" placeholder="비밀번호를 똑같이 입력해 주세요." required> 
                                  </div>
                                </li>
                                
                              </ul>
                            <div class="form_row">
                          </div>
                        </div>
                      </div>
                        
                        <div class="clearfix">
                          <button type="button" onclick="history.back();" class="cancelbtn">취소</button>
                          <button type="submit" class="signupbtn">서브아이디생성</button>
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
