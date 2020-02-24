<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/head.jsp"%>
</head>
<body style="overflow-y: scroll;">
<%@ include file="/WEB-INF/views/inc/header.jsp"%>

    <section>
        <div id="wrap">
          <div class="serviceintro">
                <div class="sub-top-background2"> 
                <div class="navbarbackg">
                       <div class="container">
                        <div class="navbar"> <a href="${pageContext.request.contextPath}/index.do"><i class="fas fa-home"></i> <!--<span class="font-gray"><i class="xi-angle-right-thin"></i></span>--></a>
                            <div class="dropdown">
                                <button class="dropbtn">서비스 이용 <i class="arrow down"></i> </button>
                                <div class="dropdown-content"> <a href="${pageContext.request.contextPath}/board/service_info.do">서비스 소개</a> <a href="${pageContext.request.contextPath}/users/user_edit.do" class="dropbtn-color">서비스 이용</a> <a href="${pageContext.request.contextPath}/board/notice.do">고객센터</a> <a href="${pageContext.request.contextPath}/board/estimate_enquiry.do">견적 문의</a></div>
                            </div>
                            <div class="dropdown">
                                <button class="dropbtn">개인정보 관리<i class="arrow down"></i> </button>
                                <div class="dropdown-content"> <a href="${pageContext.request.contextPath}/users/user_edit.do" class="dropbtn-color">개인정보 관리</a> <a href="${pageContext.request.contextPath}/board/daily_check.do">일보 조회</a></div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
                
                <h2 class="text-border">개인 정보 관리</h2>
            </div>
           <div id="id02" class="join-modal">
<!--                  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>-->

                  
  
                  <form class="modal-join-content" method="post" action="${pageContext.request.contextPath}/users/user_edit_ok.do">
                    <div class="container">
<!--                      <div class="logo"><img src="img/logo-e.png" alt="로고"></div>-->
                      <h1 style="margin-bottom:30px; font-size:30px;">개인 정보 관리</h1>
                      
                      
                      <div class="form_row">
                        <div class="form_col-100">
                          <div class="container">
                            <div class="form_row">
                              <div class="form_col-50">
                              
                              <ul>
                                <li>
                                  <div class="colgroup1">
                                    <label for="usertype">가입자 타입</label>
                                  </div>
                                  <div class="colgroup2" style="padding:25px 17px;">
                                    <input type="radio" name="usertype" id="usertype1" value="1" <c:if test="${readUser.usertype == '1'}">checked</c:if>/> 돈사
                                    <input type="radio" name="usertype" id="usertype2" value="2" <c:if test="${readUser.usertype == '2'}">checked</c:if>/> 협력업체
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="userid">아이디</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="userid" name="userid" data-required="아이디" required value="${readUser.userid}" readonly/> 
                                  </div>
                                
                                  <div class="colgroup1">
                                    <label for="name">이름</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="name" name="name" data-required="이름" required value="${readUser.name}"> 
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="pw">비밀번호 확인</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="password" id="pw" name="pw" data-required="비밀번호" placeholder="비밀번호를 입력해 주세요." required> 
                                  </div>
                                
                                  <div class="colgroup1">
                                    <label for="pw_re">새 비밀번호</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="password" id="pw_re" name="pw_re" data-required="비밀번호 확인" placeholder="비밀번호를 똑같이 입력해 주세요."> 
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="companyname">법인명</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="companyname" name="companyname" data-required="법인명" value="${readUser.companyname}" placeholder=""> 
                                  </div>
                                
                                  <div class="colgroup1">
                                    <label for="corpregistno">법인등록번호</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="corpregistno" name="corpregistno" data-required="법인등록번호" value="${readUser.corpregistno}"> 
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="ceoname">대표자성명</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="ceoname" name="ceoname" data-required="대표자성명" value="${readUser.ceoname}"> 
                                  </div>
                                  
                                  <div class="colgroup1">
                                    <label for="companyno">사업자 등록번호</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="companyno" name="companyno" data-required="사업자등록번호" placeholder="" value="${readUser.companyno}"> 
                                  </div>
                                
                                  
                                </li>
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="busicondition">업태</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="busicondition" name="busicondition" data-required="업태" placeholder="" required value="${readUser.busicondition}"> 
                                  </div>
                                
                                  <div class="colgroup1">
                                    <label for="cateofbusiness">업종</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="text" id="cateofbusiness" name="cateofbusiness" data-required="업종" required value="${readUser.cateofbusiness}"> 
                                  </div>
                                </li>
                                
                                <li>
                                  
                                  <div class="colgroup1">
                                    <label for="fax">팩스 번호</label>
                                  </div>
                                  <div class="colgroup2">
                                    <input type="tel" name="compFax1" id="faxCompTel1" size="3" maxlength="3" title="팩스번호 첫 자리" data-required="팩스 번호 첫 자리" required value="${comFax1}"> -
                                    <input type="tel" name="compFax2" id="faxCompTel2" size="5" maxlength="4" title="팩스번호 중간자리" data-required="팩스 번호 중간자리" required value="${comFax2}"> -
                                    <input type="tel" name="compFax3" id="faxCompTel3" size="5" maxlength="4" title="팩스번호 뒷자리" data-required="팩스 번호 뒷자리" required value="${comFax3}"> 
                                  </div>
                                </li>
                                
                                <li class="heightlow">
                                  <div class="colgroup1">
                                    <label for="address">주소입력</label>
                                  </div>
                                  <div class="colgroup2">
                                    
                                    <input type="text" name="postcode" id="sample6_postcode" style="width: 200px;" class="d_form mini" placeholder="우편번호" value="${readUser.postcode}">
                                    <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="d_btn">
                                    
                                    </br>
                                    <input type="text" name="address11" id="sample6_address" class="d_form large" placeholder="주소" value="${readUser.address1}">
                                    </br>
                                    <input type="text" name="address22" id="sample6_detailAddress" class="d_form" placeholder="상세주소" value="${readUser.address2}">
                                    <input type="hidden" id="sample6_extraAddress" style="width: 200px;" placeholder="참고항목">
                                    
                                  </div>
                                </li>
                                
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
                                
                                
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="responsiblename">담당자 이름</label>
                                  </div>
                                  <div class="colgroup2">
                                  
                                    <input type="text" name="responsiblename" id="responsiblename" title="담당자 이름" data-required="담당자 이름" required value="${readUser.responsiblename}">
                                     
                                  
                                  </div>
                                  
                                  <div class="colgroup1">
                                    <label for="e-mail">담당자 이메일</label>
                                  </div>
                                  <div class="colgroup2">
                                    <dd>
                                    <input type="text" name="mngMail1" id="frmMngMail1" style="width: 100px;" title="담당자 전자우편 ID" data-required="담당자 전자우편" required value="${email1}"> @
                                    <input type="text" name="mngMail2" id="frmMngMail2" style="width: 200px;" title="담당자 전자우편 주소" data-required="담당자 전자우편" required value="${email2}"> 
                                    </dd>
                                  </div>
                                </li>
                                
                                <li>
                                  <div class="colgroup1">
                                    <label for="responsibletel">담당자 전화번호</label>
                                  </div>
                                  <div class="colgroup2">
                                    <select name="responsibletel1" id="frhCompTel1" title="전화 번호 첫자리" data-required="전화 번호 첫자리" required>
                                      <option value="">선택</option>
                                      
                                      <option value="02" <c:if test="${responsibletel1 == '02'}">selected</c:if>>02</option>
                                      <option value="031" <c:if test="${responsibletel1 == '031'}">selected</c:if>>031</option>
                                      <option value="032" <c:if test="${responsibletel1 == '032'}">selected</c:if>>032</option>
                                      <option value="033" <c:if test="${responsibletel1 == '033'}">selected</c:if>>033</option>
                                      <option value="041" <c:if test="${responsibletel1 == '041'}">selected</c:if>>041</option>
                                      <option value="042" <c:if test="${responsibletel1 == '042'}">selected</c:if>>042</option>
                                      <option value="043" <c:if test="${responsibletel1 == '043'}">selected</c:if>>043</option>
                                      <option value="051" <c:if test="${responsibletel1 == '051'}">selected</c:if>>051</option>
                                      <option value="052" <c:if test="${responsibletel1 == '052'}">selected</c:if>>052</option>
                                      <option value="053" <c:if test="${responsibletel1 == '053'}">selected</c:if>>053</option>
                                      <option value="054" <c:if test="${responsibletel1 == '054'}">selected</c:if>>054</option>
                                      <option value="055" <c:if test="${responsibletel1 == '055'}">selected</c:if>>055</option>
                                      <option value="061" <c:if test="${responsibletel1 == '061'}">selected</c:if>>061</option>
                                      <option value="062" <c:if test="${responsibletel1 == '062'}">selected</c:if>>062</option>
                                      <option value="063" <c:if test="${responsibletel1 == '063'}">selected</c:if>>063</option>
                                      <option value="064" <c:if test="${responsibletel1 == '064'}">selected</c:if>>064</option>
                                      <option value="0502" <c:if test="${responsibletel1 == '0502'}">selected</c:if>>0502</option>
                                      <option value="0505" <c:if test="${responsibletel1 == '0505'}">selected</c:if>>0505</option>
                                      <option value="070" <c:if test="${responsibletel1 == '070'}">selected</c:if>>070</option>
                                      
                                    </select> -
                                    <input type="tel" name="responsibletel2" id="frhCompTel2" size="5" maxlength="4" title="전화 번호 중간자리" data-required="전화 번호 중간자리" required value="${responsibletel2}"> -
                                    <input type="tel" name="responsibletel3" id="frhCompTel3" size="5" maxlength="4" title="전화 번호 뒷자리" data-required="전화 번호 뒷자리" required value="${responsibletel3}"> 
                                  </div>
                                  
                                  <div class="colgroup1">
                                    <label for="responsiblesellphon">담당자 휴대전화</label>
                                  </div>
                                  <div class="colgroup2">
                                    <select name="responsiblesellphon1" id="frmCompTel1" title="전화 번호 첫자리" data-required="전화 번호 첫자리" required>
                                      <option value="">선택</option>
                                      <option value="010" <c:if test="${responsiblesellphon1 == '010'}">selected</c:if>>010</option>
                                      <option value="011" <c:if test="${responsiblesellphon1 == '011'}">selected</c:if>>011</option>
                                      <option value="013" <c:if test="${responsiblesellphon1 == '013'}">selected</c:if>>013</option>
                                      <option value="016" <c:if test="${responsiblesellphon1 == '016'}">selected</c:if>>016</option>
                                      <option value="017" <c:if test="${responsiblesellphon1 == '017'}">selected</c:if>>017</option>
                                      <option value="018" <c:if test="${responsiblesellphon1 == '018'}">selected</c:if>>018</option>
                                      <option value="019" <c:if test="${responsiblesellphon1 == '019'}">selected</c:if>>019</option>
                                      
                                    </select> -
                                    <input type="tel" name="responsiblesellphon2" id="frmCompTel2" size="5" maxlength="4" title="전화 번호 중간자리" data-required="전화 번호 중간자리" required value="${responsiblesellphon2}"> -
                                    <input type="tel" name="responsiblesellphon3" id="frmCompTel3" size="5" maxlength="4" title="전화 번호 뒷자리" data-required="전화 번호 뒷자리" required value="${responsiblesellphon3}"> 
                                  </div>
                                </li>
                                
                              </ul>
                            <div class="form_row">
                          </div>
                        </div>
                      </div>
                        
                        
                        <!-- <label for="checkbox">
                          <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> 계정을 만들면 <a href="#" style="color:dodgerblue">이용약관에</a> 동의하는 것 입니다.
                        </label> -->

                        <div class="clearfix">
                          <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">취소</button>
                          <button type="submit" class="signupbtn">수정하기</button>
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
    <div class="cleafix"></div>


<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
