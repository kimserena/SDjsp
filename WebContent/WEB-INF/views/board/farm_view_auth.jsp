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
                <div class="sub-top-background2-2"> 
                <div class="navbarbackg">
                        <div class="container">
                            <div class="navbar"> <a href="#home"><i class="fas fa-home"></i></a>
                                <div class="dropdown">
                                    <button class="dropbtn">고객센터 <i class="arrow down"></i> </button>
                                    <div class="dropdown-content"> <a href="service_info.html">서비스 소개</a> <a href="user_info.html">서비스 이용</a> <a href="notice.html" class="dropbtn-color">고객센터</a> <a href="estimate_enquiry.html">견적 문의</a></div>
                                </div>
                                <div class="dropdown">
                                    <button class="dropbtn">서비스 문의<i class="arrow down"></i> </button>
                                    <div class="dropdown-content"> <a href="notice.html">공지 사항</a> <a href="support.html" class="dropbtn-color">서비스 문의</a> <a href="menual.html">매뉴얼</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <h2 class="text-border">권한 신청/해지 요청</h2>
            </div>
            <div id="sub-visual-bg-basic">
                <div id="sub-visual">
                    <div class="container">
                        <div class="sub-form-info">
                            <div class="sub-content">
                                <div class="form_row">
                                    <div class="form_col-100">
                  <form class="modal-join-content" method="post" action="${pageContext.request.contextPath}/board/farm_view_auth_ok.do">
                    <input type="hidden" name="writer_useridx" value="${writer_useridx}">                                    
                                        <div class="container">
                                            <!-- <form action="/action_page.php"> -->
                                                <div class="form_row">
                                                    <div class="form_col-50">
                                                        <h3>신청자 정보 입력</h3>
                                                        <ul>
                                                            <li>
                                                                <div class="colgroup1">
                                                                    <label for="name">이름</label>
                                                                </div>
                                                                <div class="colgroup2">
                                                                    <input type="text" id="name" name="name" data-required="이름" value="${name}" autofocus required> </div>
                                                            </li>
                                                            <li>
                                                                <div class="colgroup1">
                                                                    <label for="responsibletel">담당자 전화번호</label>
                                                                </div>
                                                                <div class="colgroup2">
                                                                    <select name="responsibletel1" id="frmCompTel1" title="전화 번호 첫자리" data-required="전화 번호 첫자리" required="">
                                                                        <option value="">선택</option>
                                                                        <optgroup label="일반전화">
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
                                                                        </optgroup>
                                                                        <optgroup label="휴대전화">
                                                                            <option value="010">010</option>
                                                                            <option value="011">011</option>
                                                                            <option value="013">013</option>
                                                                            <option value="016">016</option>
                                                                            <option value="017">017</option>
                                                                            <option value="018">018</option>
                                                                            <option value="019">019</option>
                                                                        </optgroup>
                                                                    </select> -
                                                                    <input type="tel" name="responsibletel2" id="frmCompTel2" size="5" maxlength="4" title="전화 번호 중간자리" data-required="전화 번호 중간자리" required value="${responsibletel2}"> -
                                                                    <input type="tel" name="responsibletel3" id="frmCompTel3" size="5" maxlength="4" title="전화 번호 뒷자리" data-required="전화 번호 뒷자리" required value="${responsibletel3}"> </div>
                                                            </li>
                                                            <li>
                                                                <%-- <div class="colgroup1">
                                                                    <label for="e-mail">이메일</label>
                                                                </div>
                                                                <div class="colgroup2">
                                                                    <dd>
                                                                        <input type="text" name="mngMail1" id="frmMngMail1" title="담당자 전자우편 ID" data-required="담당자 전자우편" required value="${email1}"> @
                                                                        <input type="text" name="mngMail2" id="frmMngMail2" title="담당자 전자우편 주소" data-required="담당자 전자우편" required value="${email2}"> </dd>
                                                                </div> --%>
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
                                                            
                                                            
                                                            <li class="heightlow">
                                                              <div class="colgroup1">
                                                                <label for="address">농장주소</label>
                                                              </div>
                                                              <div class="colgroup2">
                                    
                                                                <input type="text" name="postcode" id="sample6_postcode" style="width: 200px;" class="d_form mini" placeholder="우편번호" value="${postcode}">
                                                                <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="d_btn">
                                    
                                                                </br>
                                                                <input type="text" name="address11" id="sample6_address" class="d_form large" placeholder="주소" value="${address1}">
                                                                </br>
                                                                <input type="text" name="address22" id="sample6_detailAddress" class="d_form" placeholder="상세주소" value="${address2}">
                                                                <input type="hidden" id="sample6_extraAddress" style="width: 200px;" placeholder="참고항목">
                                    
                                                              </div>
                                                            </li>

<script type="text/javascript">
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
                                                            
                                                            <!-- <li class="heightlow">
                                                                <div class="colgroup1">
                                                                    <label for="adr">농장주소</label>
                                                                </div>
                                                                <div class="colgroup2">
                                                                    <input type="text" name="compAddress1" id="frmCompAddress1" title="기업 기본 주소" class="w89" data-required="기업 주소" required="">
                                                                    <input type="text" name="compAddress2" id="frmCompAddress2" title="기업 상세 주소" class="w100" style="margin-top:6px"> </div>
                                                            </li> -->
                                                        </ul>
                                                        <div class="form_row">
                                                            <div class="form_col-50">
                                                                <label class="checkbox_container">
                                                                    <input type="checkbox" checked="checked" name="sameadr"> 개인정보 수집 및 이용에 동의합니다. <span class="checkmark"></span> </label>
                                                                <label for="zip" class="font-red"><i class="fas fa-exclamation-circle"></i> 입력하신 정보가 정확하지 않을 경우 서비스가 취소 또는 지연될 수 있습니다.</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form_col-50">
                                                        <h3>요청 정보 입력</h3>
                                                        <!-- <ul>
                                                            <li> -->
                                                            <%-- <input type="hidden" value="${usertype}"> --%>
                                                              <c:choose>
					                                            <c:when test="${usertype==2}">
					                                    <ul>
                                                            <li>
                                                                <div class="colgroup1">
                                                                    <label for="inquire_cate">신청 농장</label>
                                                                    <input type="hidden" name="inquire_cate" value="추가권한신청">
                                                                </div>
                                                                <!--surround the select box with a "custom-select" DIV element. Remember to set the width:-->
                                                                <div class="colgroup2">
                                                                    <div class="custom-select" style="width:200px;">
                                                                      <c:choose>
					                                                    <c:when test="${fn:length(farmUsersList) > 0}">
					                                                    <select id="subject" name="subject" style="padding: 0px; margin: 0px;">
                                                                          <option value="">선택해주세요</option>
                                                                          <c:forEach var="farmUsersList" items="${farmUsersList}">
                                                                          <option value="${farmUsersList.companyname}">${farmUsersList.companyname}</option>
                                                                          </c:forEach>
                                                                          
                    
                                                                        </select>
                                                                        </c:when>
				                                                       </c:choose>
                                                                        
                                                                        <!-- <select name="inquire_cate">
                                                                            <option value="">선택 안함</option>
                                                                            <option value="권한신청">권한신청</option>
                                                                            <option value="권한해지">권한해지</option>
                                                                        </select> -->
                                                                    </div>
                                                                </div>
                                                             </li>
                                                             
                                                             <li class="heighthigh">
                                                                <div class="colgroup1">
                                                                    <label for="content">상세내용</label>
                                                                </div>
                                                                <div class="colgroup2">
                                                                    <textarea type="text" placeholder="상세 농장 명을 입력해주세요" name="content"></textarea>
                                                                </div>
                                                            </li>
                                                            
                                                        </ul>
                                                                </c:when>
                                                                
                                                                <c:when test="${usertype==1}">
                                                                
                                                        <ul>
                                                            <li>
                                                                <div class="colgroup1">
                                                                    <label for="inquire_cate">해지 협력사</label>
                                                                    <input type="hidden" name="inquire_cate" value="권한해지신청">
                                                                </div>
                                                                <!--surround the select box with a "custom-select" DIV element. Remember to set the width:-->
                                                                <div class="colgroup2">
                                                                    <div class="custom-select" style="width:200px;">
                                                                      <c:choose>
					                                                    <c:when test="${fn:length(subcontractorList) > 0}">
					                                                    <select id="subject" name="subject" style="padding: 0px; margin: 0px;">
                                                                          <option value="">선택해주세요</option>
                                                                          <c:forEach var="subcontractorList" items="${subcontractorList}">
                                                                          <option value="${subcontractorList.companyname}">${subcontractorList.companyname}</option>
                                                                          </c:forEach>
                                                                          
                    
                                                                        </select>
                                                                        </c:when>
				                                                       </c:choose>
                                                                        
                                                                        <!-- <select name="inquire_cate">
                                                                            <option value="">선택 안함</option>
                                                                            <option value="권한신청">권한신청</option>
                                                                            <option value="권한해지">권한해지</option>
                                                                        </select> -->
                                                                    </div>
                                                                </div>
                                                                
                                                            </li>
                                                            <li class="heighthigh">
                                                                <div class="colgroup1">
                                                                    <label for="content">상세내용</label>
                                                                </div>
                                                                <div class="colgroup2">
                                                                    <textarea type="text" placeholder="내용을 입력해주세요" name="content"></textarea>
                                                                </div>
                                                            </li>
                                                            
                                                        </ul>
                                                            
                                                            
                                                                </c:when>
				                                              </c:choose>
                                                            <!-- </li>
                                                            
                                                            
                                                        </ul> -->
                                                    </div>
                                                </div>
                                                <input type="submit" value="접수하기" class="btn"> 
                                              </form>
                                        </div>
                                        <!-- </form> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
    </section>

<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
</body>
</html>
