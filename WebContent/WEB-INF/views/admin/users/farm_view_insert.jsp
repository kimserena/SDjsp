<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h1>농장별 읽기 권한 추가</h1>
				<input type="hidden" id="useridx_main" name="useridx_main" value="${useridx}">

				<div class="form_row">
					<div class="form_col-100">
						<div class="container">
							<div class="form_row">
								<div class="form_col-50">
									<div>
            <div>
     <table	class="table table-spriped table table-condensed table table-hover">
			<thead>
				<tr>
					<th class="text-center" style="width: 50%;">농장주</th>
					<th class="text-center" style="width: 50%;">농장이름</th>
					
				</tr>
			</thead>
	  <tbody>
				<c:choose>
					<c:when test="${fn:length(farmUsersList) > 0}">
			<tr>
                <td class="text-center">
				
                  <select id="useridx" name="useridx" style="padding: 0px; margin: 0px;">
                    <option value="">선택해주세요</option>
                    <c:forEach var="farmUsersList" items="${farmUsersList}">
                    <option value="${farmUsersList.useridx}">${farmUsersList.companyname}</option>
                    </c:forEach>
                    
                  </select>
                  <input type="submit" class="com_submit" value="선택"/>
                </td>
                <td class="text-center" style="vertical-align: middle;">
                  
                  <form onsubmit="return confirm('읽기 권한을 부여 하시겠습니까?');" id="farm_view_insert_ok" method="post" action="${pageContext.request.contextPath}/admin/users/farm_view_insert_ok.do">
                    <select id="locationid" name="locationid" style="width: 38%; padding: 0px; margin: 0px;">
                      <option id="options" value="">농장주를 먼저 선택해주세요</option>
                      
                    
                    </select>
                    <input type="submit" value="권한부여"/>
                  </form>
                    
                </td>
                
             </tr>
					</c:when>
					
				</c:choose>
	</tbody>
	</table>
	
<script type="text/javascript">
$(function(){
	$('.com_submit').click(function(){
		var idx = $("#useridx option:selected").val();
		var useridx_main = $("#useridx_main").val();
		console.log('idx =',idx);
		var param = {"useridx": idx};
		$("option#options").remove();
		$("input#main_useridx").remove();
		$("#farm_view_insert_ok").append("<input type='hidden' id='main_useridx' name='main_useridx' value ="+useridx_main+">");
		/* $("input#farm_useridx").remove();
		$("#farm_view_insert_ok").append("<input type='hidden' id='farm_useridx' name='farm_useridx' value ="+idx+">"); */
		$.ajax({
            url:'${pageContext.request.contextPath}/admin/users/locations_search_ok.do',
            type:'POST',
            dataType: "json",
            data: param, 
            success:function(data){
                
                
                /* alert('data load ' + data); */
                console.log("data=",data);
                
                
                
                $('html').css("cursor","auto");
                $.each(data,function(index, locationsList){
                	
                    
                	$("#locationid").append("<option id='options' value=''>선택해주세요</option>");
                	
                	
                		$.each(locationsList, function(i, row){
                			
                			
                			$("#locationid").append("<option id='options' value="+locationsList[i].locationid+">"+locationsList[i].locationname+"</option>");
                		});
                		
                		

                    	
                	 
                	
                	
                	
                    
                    
                });
                
                
                
            },
            
            error:function(){
                alert("예상치 못한 이유로 ajax통신이 실패했습니다. 다시 시도해 주세요.");
                $('html').css("cursor","auto");
            }

        }); 
	});
});


	
</script>
	
	<div class="cleafix">
	  
      <a href="${pageContext.request.contextPath}/admin/users/farm_view_set.do?useridx=${useridx}" class="btn" style="float: right; background-color: #005495; color: #ffffff;">돌아가기</a>
	
	</div>
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
