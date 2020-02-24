var tempstring = "";

function getToday() {
  var date = new Date();
  return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

/*일보조회*/

var companyname = $('#companyname').val();
var ceoname = $('#ceoname').val();

//전체통합월보(누적)테이블출력
var ajaxCallback = function (data) {
    var result = '';
    var dailynews = data["report"];
    var jaga = dailynews["jaga"];
    
    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;
    var sum7 = 0;
    var sum8 = 0;
    
    today = getToday();
    
    result += '<colgroup>';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '</colgroup>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="font-size:18px; font-weight:bold; text-align:center; padding:30px 0;" rowspan="3" colspan="11">스마트데일리 통합월보(누적)</td>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">상호</td>';
    result += '<td style="text-align:center;" colspan="4">'+ companyname +' 대표이사 '+ ceoname +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회기간</td>';
    result += '<td style="text-align:center;" colspan="3">'+ $("#sdate").val() + "~" + $("#edate").val() +'</td>';
    result += '<td style="background: #ddd; text-align:center;" colspan="2">현재 총 사육두수</td>';
    result += '</tr>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">조회농장</td>';
    result += '<td style="text-align:center;" colspan="4">전체 농장</td>';
    result += '<td style="background: #ddd; text-align:center;">조회일자</td>';
    result += '<td style="text-align:center;" colspan="3">' + getToday() +'</td>';
    result += '<td style="text-align:center;" colspan="2" class="nowallsum1"></td>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td colspan="11">&nbsp;</td>';
    result += '</tr>';
    
    result += '</thead>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">구분</td>';
    result += '<td style="background: #ddd; text-align:center;">소재지별</td>';
    result += '<td style="background: #ddd; text-align:center;">돈사</td>';
    result += '<td style="background: #ddd; text-align:center;">면적</td>';
    result += '<td style="background: #ddd; text-align:center;">시작</td>';
    result += '<td style="background: #ddd; text-align:center;">전입</td>';
    result += '<td style="background: #ddd; text-align:center;">전출</td>';
    result += '<td style="background: #ddd; text-align:center;">폐사</td>';
    result += '<td style="background: #ddd; text-align:center;">출하</td>';
    result += '<td style="background: #ddd; text-align:center;">예상</td>';
    result += '<td style="background: #ddd; text-align:center;">AI 실제</td>';
    result += '</tr>';
    result += '</thead>';     
    
    result += '<tbody id="JagaList">';
    
    if ( jaga != null && jaga.length > 0) {

    result += '<tr>';
    
//    var jagasize = 0;
//    var wetaksize = 0;
    
    //  농장 반복
    $.each(jaga, function (index_nongjang, nongjang) {
        var nname = nongjang["locationname"];
        var donsaArray = nongjang["building"];
        var hap1 = 0;
        var hap2 = 0;
        var hap3 = 0;
        var hap4 = 0;
        var hap5 = 0;
        var hap6 = 0;
        var hap7 = 0;
        var hap8 = 0;
        if (donsaArray != null) {
            //  돈사 데이터 반복
            $.each(donsaArray, function (index_donsa, donsa) {
            	result += '<td style="text-align:center;" class="jagatable">자가 농장</td>';
            	
                var dname = donsa["buildingname"];
                result += '<td style="text-align:center;" class = "sojaeji">' + nname + '</td>';
                result += '<td style="text-align:center;">' + dname + '</td>';
                var gap1 = donsa["areasize"];
                var gap2 = donsa["start_count"];
                var gap3 = donsa["in_count"];
                var gap4 = donsa["move_count"];
                var gap5 = donsa["die_count"];
                var gap6 = donsa["out_count"];
                var gap7 = donsa["expect_count"];
                var gap8 = donsa["ai_count"];
                hap1 += gap1;
                hap2 += gap2;
                hap3 += gap3;
                hap4 += gap4;
                hap5 += gap5;
                hap6 += gap6;
                hap7 += gap7;
                hap8 += gap8;
                result += '<td>' + gap1 + '</td>';
                result += '<td>' + gap2 + '</td>';
                result += '<td>' + gap3 + '</td>';
                result += '<td>' + gap4 + '</td>';
                result += '<td>' + gap5 + '</td>';
                result += '<td>' + gap6 + '</td>';
                result += '<td>' + gap7 + '</td>';
                result += '<td>' + gap8 + '</td>';
                result += '</tr>';
            })
        }
        if (donsaArray != null) {
            result += '<tr>';
            result += '<td colspan="2" style="background: #eee; text-align:center;">소&emsp;&emsp;&emsp;계</td>';
            result += '<td style="background: #eee;">' + hap1 + '</td>';
            result += '<td style="background: #eee;">' + hap2 + '</td>';
            result += '<td style="background: #eee;">' + hap3 + '</td>';
            result += '<td style="background: #eee;">' + hap4 + '</td>';
            result += '<td style="background: #eee;">' + hap5 + '</td>';
            result += '<td style="background: #eee;">' + hap6 + '</td>';
            result += '<td style="background: #eee;">' + hap7 + '</td>';
            result += '<td style="background: #eee;">' + hap8 + '</td>';
            result += '</tr>';
            sum1 += hap1;
            sum2 += hap2;
            sum3 += hap3;
            sum4 += hap4;
            sum5 += hap5;
            sum6 += hap6;
            sum7 += hap7;
            sum8 += hap8;
        }
    });
    
    }
    
    result += '</tbody>';
    result += '<tbody id="WetakList">';
    
    var wetak = dailynews["wetak"];
    
    if ( wetak != null && wetak.length > 0) {
    	
    	result += '<tr>';
        result += '<td colspan="11">&nbsp;</td>';
        result += '</tr>';
        
	    result += '<tr>';
	    
	    //  농장 반복
	    $.each(wetak, function (index_wnongjang, wnongjang) {
	        var wnname = wnongjang["locationname"];
	        var wdonsaArray = wnongjang["building"];
	        var whap1 = 0;
	        var whap2 = 0;
	        var whap3 = 0;
	        var whap4 = 0;
	        var whap5 = 0;
	        var whap6 = 0;
	        var whap7 = 0;
	        var whap8 = 0;
	        
	        if (wdonsaArray != null) {
	            //  돈사 데이터 반복
	            $.each(wdonsaArray, function (index_wdonsa, wdonsa) {
	            	result += '<td style="text-align:center;" class="wetaktable">위탁 농장</td>';
	            	
	                var wdname = wdonsa["buildingname"];
	                result += '<td style="text-align:center;" class="wsojaeji">' + wnname + '</td>';
	                result += '<td style="text-align:center;">' + wdname + '</td>';
	                var wgap1 = wdonsa["areasize"];
	                var wgap2 = wdonsa["start_count"];
	                var wgap3 = wdonsa["in_count"];
	                var wgap4 = wdonsa["move_count"];
	                var wgap5 = wdonsa["die_count"];
	                var wgap6 = wdonsa["out_count"];
	                var wgap7 = wdonsa["expect_count"];
	                var wgap8 = wdonsa["ai_count"];
	                whap1 += wgap1;
	                whap2 += wgap2;
	                whap3 += wgap3;
	                whap4 += wgap4;
	                whap5 += wgap5;
	                whap6 += wgap6;
	                whap7 += wgap7;
	                whap8 += wgap8;
	                result += '<td>' + wgap1 + '</td>';
	                result += '<td>' + wgap2 + '</td>';
	                result += '<td>' + wgap3 + '</td>';
	                result += '<td>' + wgap4 + '</td>';
	                result += '<td>' + wgap5 + '</td>';
	                result += '<td>' + wgap6 + '</td>';
	                result += '<td>' + wgap7 + '</td>';
	                result += '<td>' + wgap8 + '</td>';
	                result += '</tr>';
	            })
	            var wsum1 = 0;
	            var wsum2 = 0;
	            var wsum3 = 0;
	            var wsum4 = 0;
	            var wsum5 = 0;
	            var wsum6 = 0;
	            var wsum7 = 0;
	            var wsum8 = 0;
	            wsum1 += whap1;
	            var wsumArray = new Array();
	            wsumArray[0] = wsum1;
	        }
	        if (wdonsaArray != null) {
	            result += '<tr>';
	            result += '<td colspan="2" style="background: #eee; text-align:center;">소&emsp;&emsp;&emsp;계</td>';
	            result += '<td style="background: #eee;">' + whap1 + '</td>';
	            result += '<td style="background: #eee;">' + whap2 + '</td>';
	            result += '<td style="background: #eee;">' + whap3 + '</td>';
	            result += '<td style="background: #eee;">' + whap4 + '</td>';
	            result += '<td style="background: #eee;">' + whap5 + '</td>';
	            result += '<td style="background: #eee;">' + whap6 + '</td>';
	            result += '<td style="background: #eee;">' + whap7 + '</td>';
	            result += '<td style="background: #eee;">' + whap8 + '</td>';
	            result += '</tr>';
	            sum1 += whap1;
	            sum2 += whap2;
	            sum3 += whap3;
	            sum4 += whap4;
	            sum5 += whap5;
	            sum6 += whap6;
	            sum7 += whap7;
	            sum8 += whap8;
	        }
	    });
    }
    
    result += '<tr>';
    result += '<td colspan="3" style="background: #ddd; text-align:center;">합&emsp;&emsp;&emsp;계</td>';
    result += '<td style="background: #ddd;">' + sum1 + '</td>';
    result += '<td style="background: #ddd;">' + sum2 + '</td>';
    result += '<td style="background: #ddd;">' + sum3 + '</td>';
    result += '<td style="background: #ddd;">' + sum4 + '</td>';
    result += '<td style="background: #ddd;">' + sum5 + '</td>';
    result += '<td style="background: #ddd;">' + sum6 + '</td>';
    result += '<td style="background: #ddd;">' + sum7 + '</td>';
    result += '<td style="background: #ddd;">' + sum8 + '</td>';
    result += '</tr>';
    
    result += '</tbody>';
    $('#table1').append(result).addClass("unique");
    $(".jagatable").each(function () {
        var rows = $(".jagatable:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length+jaga.length);
            rows.not(":eq(0)").remove();
        }
    }); 
    $(".wetaktable").each(function () {
        var rows = $(".wetaktable:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length+wetak.length);
            rows.not(":eq(0)").remove();
        }
    });    
    $(".sojaeji").each(function () {
        var rows = $(".sojaeji:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
    $(".wsojaeji").each(function () {
        var rows = $(".wsojaeji:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
    var NowAllsum= sum7;
    $(".nowallsum1").append(NowAllsum);
};

//전체통합월보(누적) 출력
$("#AccrueMonthlyReport").submit(function(){
    $(".unique").empty();
    var useridx = $("#useridx").val();
    console.log("useridx=", useridx);
    
    var allData = {"useridx": useridx, "start_month": $("#sdate").val(), "end_month": $("#edate").val()};
    // start_month 체크박스의 선택된 값을 가져온다.

    //동적으로 원격에 있는 JSON 파일(결과값)을 로드 
    $.ajax({
        url: "http://101.101.162.62:8081/smartdaily/req_monthly_all1"
        , dataType: "json"
        , type: "POST"
        , data: allData
        , success: ajaxCallback
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
}); // end submit()


//전체통합월보(월별) 테이블 출력
var ajaxCallback2 = function (data) {
    var result = '';
    var Adailynews = data["report"];
    var Ajaga = Adailynews["jaga"];
    
    result += '<colgroup>';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '<col width="9.09%">';
    result += '</colgroup>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="font-size:18px; font-weight:bold; text-align:center; padding:30px 0;" rowspan="3" colspan="11">스마트데일리 통합월보(월별)</td>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">상호</td>';
    result += '<td style="text-align:center;" colspan="4">'+ companyname +' 대표이사 '+ ceoname +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회기간</td>';
    result += '<td style="text-align:center;" colspan="3" class="excelToInt">'+ $(".mdate").val() +'</td>';
    result += '<td style="background: #ddd; text-align:center;" colspan="2">현재 총 사육두수</td>';
    result += '</tr>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">조회농장</td>';
    result += '<td style="text-align:center;" colspan="4">전체 농장</td>';
    result += '<td style="background: #ddd; text-align:center;">조회일자</td>';
    result += '<td style="text-align:center;" colspan="3">' + getToday() +'</td>';
    result += '<td style="text-align:center;" colspan="2" class="nowallsum2"></td>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td colspan="11">&nbsp;</td>';
    result += '</tr>';
    
    result += '</thead>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">구분</td>';
    result += '<td style="background: #ddd; text-align:center;">소재지별</td>';
    result += '<td style="background: #ddd; text-align:center;">돈사</td>';
    result += '<td style="background: #ddd; text-align:center;">면적</td>';
    result += '<td style="background: #ddd; text-align:center;">시작</td>';
    result += '<td style="background: #ddd; text-align:center;">전입</td>';
    result += '<td style="background: #ddd; text-align:center;">전출</td>';
    result += '<td style="background: #ddd; text-align:center;">폐사</td>';
    result += '<td style="background: #ddd; text-align:center;">출하</td>';
    result += '<td style="background: #ddd; text-align:center;">예상</td>';
    result += '<td style="background: #ddd; text-align:center;">AI 실제</td>';
    result += '</tr>';
    result += '</thead>';     
   
    result += '<tbody id="AJagaList">';
    
    if ( Ajaga != null && Ajaga.length > 0) {
    
    result += '<tr>';
    
    var Ajagasize = 0;
    var Awetaksize = 0;
    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;
    var sum7 = 0;
    var sum8 = 0;
    //  농장 반복
    $.each(Ajaga, function (Aindex_nongjang, Anongjang) {
        var Anname = Anongjang["locationname"];
        var AdonsaArray = Anongjang["building"];
        var hap1 = 0;
        var hap2 = 0;
        var hap3 = 0;
        var hap4 = 0;
        var hap5 = 0;
        var hap6 = 0;
        var hap7 = 0;
        var hap8 = 0;
        
        var Lastgap=0;
        if (AdonsaArray != null) {
//            Ajagasize += AdonsaArray.length + 1;
            //  돈사 데이터 반복
            $.each(AdonsaArray, function (Aindex_donsa, Adonsa) {
            	
            	result += '<td style="text-align:center;" class="Ajagatable">자가 농장</td>';
            	
                var Adname = Adonsa["buildingname"];
                result += '<td style="text-align:center;" class = "Asojaeji">' + Anname + '</td>';
                result += '<td style="text-align:center;">' + Adname + '</td>';
                var gap1 = Adonsa["areasize"];
                var gap2 = Adonsa["start_count"];
                var gap3 = Adonsa["in_count"];
                var gap4 = Adonsa["move_count"];
                var gap5 = Adonsa["die_count"];
                var gap6 = Adonsa["out_count"];
                var gap7 = Adonsa["expect_count"];
                var gap8 = Adonsa["ai_count"];
                hap1 += gap1;
                hap2 += gap2;
                hap3 += gap3;
                hap4 += gap4;
                hap5 += gap5;
                hap6 += gap6;
                hap7 += gap7;
                hap8 += gap8;
                result += '<td>' + gap1 + '</td>';
                result += '<td>' + gap2 + '</td>';
                result += '<td>' + gap3 + '</td>';
                result += '<td>' + gap4 + '</td>';
                result += '<td>' + gap5 + '</td>';
                result += '<td>' + gap6 + '</td>';
                result += '<td>' + gap7 + '</td>';
                result += '<td>' + gap8 + '</td>';
                result += '</tr>';
                
            })
        }
        if (AdonsaArray != null) {            
            result += '<tr>';
            result += '<td colspan="2" style="background: #eee; text-align:center;">소&emsp;&emsp;&emsp;계</td>';
            result += '<td style="background: #eee;">' + hap1 + '</td>';
            result += '<td style="background: #eee;">' + hap2 + '</td>';
            result += '<td style="background: #eee;">' + hap3 + '</td>';
            result += '<td style="background: #eee;">' + hap4 + '</td>';
            result += '<td style="background: #eee;">' + hap5 + '</td>';
            result += '<td style="background: #eee;">' + hap6 + '</td>';
            result += '<td style="background: #eee;">' + hap7 +'</td>';
            result += '<td style="background: #eee;">' + hap8 + '</td>';
            result += '</tr>';
            sum1 += hap1;
            sum2 += hap2;
            sum3 += hap3;
            sum4 += hap4;
            sum5 += hap5;
            sum6 += hap6;
            sum7 += hap7;
            sum8 += hap8;
        }
    });
    
    }
    
    result += '</tbody>';
    result += '<tbody id="AWetakList">';
    
    result += '<tr>';
    result += '<td colspan="11">&nbsp;</td>';
    result += '</tr>';
    
    var Awetak = Adailynews["wetak"];
    
    if ( Awetak != null && Awetak.length > 0 ) {
    result += '<tr>';
    
    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;
    var sum7 = 0;
    var sum8 = 0;
    
    //  농장 반복
    $.each(Awetak, function (Aindex_wnongjang, Awnongjang) {
        var Awnname = Awnongjang["locationname"];
        var AwdonsaArray = Awnongjang["building"];
        var whap1 = 0;
        var whap2 = 0;
        var whap3 = 0;
        var whap4 = 0;
        var whap5 = 0;
        var whap6 = 0;
        var whap7 = 0;
        var whap8 = 0;
        if (AwdonsaArray != null) {
//            Awetaksize += AwdonsaArray.length + 1;
            
            //  돈사 데이터 반복
            $.each(AwdonsaArray, function (Aindex_wdonsa, Awdonsa) {
            	result += '<td style="text-align:center;" class="Awetaktable">위탁 농장</td>';
            	
                var Awdname = Awdonsa["buildingname"];
                result += '<td style="text-align:center;" class="Awsojaeji">' + Awnname + '</td>';
                result += '<td style="text-align:center;">' + Awdname + '</td>';
                var wgap1 = Awdonsa["areasize"];
                var wgap2 = Awdonsa["start_count"];
                var wgap3 = Awdonsa["in_count"];
                var wgap4 = Awdonsa["move_count"];
                var wgap5 = Awdonsa["die_count"];
                var wgap6 = Awdonsa["out_count"];
                var wgap7 = Awdonsa["expect_count"];
                var wgap8 = Awdonsa["ai_count"];
                whap1 += wgap1;
                whap2 += wgap2;
                whap3 += wgap3;
                whap4 += wgap4;
                whap5 += wgap5;
                whap6 += wgap6;
                whap7 += wgap7;
                whap8 += wgap8;
                result += '<td>' + wgap1 + '</td>';
                result += '<td>' + wgap2 + '</td>';
                result += '<td>' + wgap3 + '</td>';
                result += '<td>' + wgap4 + '</td>';
                result += '<td>' + wgap5 + '</td>';
                result += '<td>' + wgap6 + '</td>';
                result += '<td>' + wgap7 + '</td>';
                result += '<td>' + wgap8 + '</td>';
                result += '</tr>';
            })
            
//            wsum1 += whap1;
//            var AwsumArray = new Array();
//            AwsumArray[0] = wsum1;
        }
        if (AwdonsaArray != null) {
            result += '<tr>';
            result += '<td colspan="2" style="background: #eee; text-align:center;">소&emsp;&emsp;&emsp;계</td>';
            result += '<td style="background: #eee;">' + whap1 + '</td>';
            result += '<td style="background: #eee;">' + whap2 + '</td>';
            result += '<td style="background: #eee;">' + whap3 + '</td>';
            result += '<td style="background: #eee;">' + whap4 + '</td>';
            result += '<td style="background: #eee;">' + whap5 + '</td>';
            result += '<td style="background: #eee;">' + whap6 + '</td>';
            result += '<td style="background: #eee;">' + whap7 + '</td>';
            result += '<td style="background: #eee;">' + whap8 + '</td>';
            result += '</tr>';
            sum1 += whap1;
            sum2 += whap2;
            sum3 += whap3;
            sum4 += whap4;
            sum5 += whap5;
            sum6 += whap6;
            sum7 += whap7;
            sum8 += whap8;
        }
    });
    
    }
    
    result += '<tr>';
    result += '<td colspan="3" style="background: #ddd; text-align:center;">합&emsp;&emsp;&emsp;계</td>';
    result += '<td style="background: #ddd;">' + sum1 + '</td>';
    result += '<td style="background: #ddd;">' + sum2 + '</td>';
    result += '<td style="background: #ddd;">' + sum3 + '</td>';
    result += '<td style="background: #ddd;">' + sum4 + '</td>';
    result += '<td style="background: #ddd;">' + sum5 + '</td>';
    result += '<td style="background: #ddd;">' + sum6 + '</td>';
    result += '<td style="background: #ddd;">' + sum7 + '</td>';
    result += '<td style="background: #ddd;">' + sum8 + '</td>';
    result += '</tr>';
    $('#table2').append(result).addClass("unique2");
//    $('#Ajagatable').attr("rowspan", Ajagasize);
//    $('#Awetaktable').attr("rowspan", Awetaksize);
    $(".Ajagatable").each(function () {
        var rows = $(".Ajagatable:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length+Ajaga.length);
            rows.not(":eq(0)").remove();
        }
    });
    $(".Awetaktable").each(function () {
        var rows = $(".Awetaktable:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length+Awetak.length);
            rows.not(":eq(0)").remove();
        }
    });
    $(".Asojaeji").each(function () {
        var rows = $(".Asojaeji:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
    $(".Awsojaeji").each(function () {
        var rows = $(".Awsojaeji:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
    var NowAllsum= sum7;
    $(".nowallsum2").append(NowAllsum);
};

//전체통합월보(월별) 출력

$("#AllMonthlyReport").submit(function(){
    $(".unique2").empty();
    var useridx = $("#useridx").val();
    console.log("useridx=", useridx);
    
    var allData2 = {"useridx": useridx, "pick_month": $(".mdate").val()};
     //동적으로 원격에 있는 JSON 파일(결과값)을 로드 
    $.ajax({
        url: "http://101.101.162.62:8081/smartdaily/req_monthly_all2"
        , dataType: "json"
        , type: "POST"
        , data: allData2
        , success: ajaxCallback2
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
}); // end submit()


//전체통합일보 테이블 출력
var ajaxCallback3 = function (data) {
    var result = '';
    var dailynews3 = data;
    
    result += '<colgroup>';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '</colgroup>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="font-size:18px; font-weight:bold; text-align:center; padding:30px 0;" rowspan="3" colspan="9">스마트데일리 통합일보</td>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">상호</td>';
    result += '<td style="text-align:center;" colspan="4">'+ companyname +' 대표이사 '+ ceoname +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회기간</td>';
    result += '<td style="text-align:center;" colspan="3" class="excelToInt">'+ $(".mdate").val() +'</td>';
    result += '</tr>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">조회농장</td>';
    result += '<td style="text-align:center;" colspan="4">전체 농장</td>';
    result += '<td style="background: #ddd; text-align:center;">조회일자</td>';
    result += '<td style="text-align:center;" colspan="3">' + getToday() +'</td>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td colspan="9">&nbsp;</td>';
    result += '</tr>';
    
    result += '</thead>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">구분</td>';
    result += '<td style="background: #ddd; text-align:center;">날짜</td>';
    result += '<td style="background: #ddd; text-align:center;">시작</td>';
    result += '<td style="background: #ddd; text-align:center;">전입</td>';
    result += '<td style="background: #ddd; text-align:center;">전출</td>';
    result += '<td style="background: #ddd; text-align:center;">폐사</td>';
    result += '<td style="background: #ddd; text-align:center;">출하</td>';
    result += '<td style="background: #ddd; text-align:center;">예상</td>';
    result += '<td style="background: #ddd; text-align:center;">AI 실제</td>';
    result += '</tr>';
    result += '</thead>';     
    
    result += '<tbody id="tableList3">';
    
    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;

    //  농장 반복
    $.each(dailynews3, function (index_nongjang, nongjang) {        
        var gap1 = nongjang["recordday"];
        var gap2 = nongjang["start_count"];
        var gap3 = nongjang["in_count"];
        var gap4 = nongjang["move_count"];
        var gap5 = nongjang["die_count"];
        var gap6 = nongjang["out_count"];
        var gap7 = nongjang["expect_count"];
        var gap8 = nongjang["ai_count"];
        
        sum1 += gap3;
        sum2 += gap4;
        sum3 += gap5;
        sum4 += gap6;
        sum5 += gap7;
        sum6 += gap8;
        
        result += '<tr>';
        result += '<td style="text-align:center;" class="alltable3">전체</td>';
        result += '<td style="text-align:center;">' + gap1 + '</td>';
        result += '<td>' + gap2 + '</td>';
        result += '<td>' + gap3 + '</td>';
        result += '<td>' + gap4 + '</td>';
        result += '<td>' + gap5 + '</td>';
        result += '<td>' + gap6 + '</td>';
        result += '<td>' + gap7 + '</td>';
        result += '<td>' + gap8 + '</td>';
        result += '</tr>';
    });
    var Lastexp = dailynews3[dailynews3.length-1]["expect_count"];
    var Lastai = dailynews3[dailynews3.length-1]["ai_count"];
    
    result += '<tr>';
    result += '<td colspan="3" style="background: #ddd; text-align:center;">합&emsp;&emsp;&emsp;계</td>';
    result += '<td style="background: #ddd;">' + sum1 + '</td>';
    result += '<td style="background: #ddd;">' + sum2 + '</td>';
    result += '<td style="background: #ddd;">' + sum3 + '</td>';
    result += '<td style="background: #ddd;">' + sum4 + '</td>';
    result += '<td style="background: #ddd;">' + Lastexp + '</td>';
    result += '<td style="background: #ddd;">' + Lastai + '</td>';
    result += '</tr>';
    result += '</tbody>';
    
    $('#table3').append(result).addClass("unique3");
    $(".alltable3").each(function () {
        var rows = $(".alltable3:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
};

//전체통합일보 출력
$("#TotalDailyReport").submit(function(){
    $(".unique3").empty();
    var useridx = $("#useridx").val();
    console.log("useridx=", useridx);
    
    var allData3 = {"useridx": useridx, "pick_month": $(".mdate").val()};
     //동적으로 원격에 있는 JSON 파일(결과값)을 로드 
    $.ajax({
        url: "http://101.101.162.62:8081/smartdaily/req_daily_all"
        , dataType: "json"
        , type: "POST"
        , data: allData3
        , success: ajaxCallback3
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
}); // end submit()

//농장별 월보 테이블 출력
var ajaxCallback4 = function (data) {
    var result = '';
    var dailynews4 = data;
    
    result += '<colgroup>';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '<col width="10%">';
    result += '</colgroup>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="font-size:18px; font-weight:bold; text-align:center; padding:30px 0;" rowspan="3" colspan="10">스마트데일리 돈사별 월보</td>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">상호</td>';
    result += '<td style="text-align:center;" colspan="3">'+ companyname +' 대표이사 '+ ceoname +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회기간</td>';
    result += '<td style="text-align:center;" colspan="3">'+ $(".ydate").val() +'</td>';
    result += '<td style="background: #ddd; text-align:center;" colspan="2">현재 총 사육두수</td>';
    result += '</tr>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">조회농장</td>';
    result += '<td style="text-align:center;" colspan="3">'+ $("#selectBox4 option:selected").text() +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회일자</td>';
    result += '<td style="text-align:center;" colspan="3">' + getToday() +'</td>';
    result += '<td style="text-align:center;" colspan="2" class="nowallsum4"></td>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td colspan="10">&nbsp;</td>';
    result += '</tr>';
    
    result += '</thead>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">구분</td>';
    result += '<td style="background: #ddd; text-align:center;">돈사</td>';
    result += '<td style="background: #ddd; text-align:center;">월별</td>';
    result += '<td style="background: #ddd; text-align:center;">시작</td>';
    result += '<td style="background: #ddd; text-align:center;">전입</td>';
    result += '<td style="background: #ddd; text-align:center;">전출</td>';
    result += '<td style="background: #ddd; text-align:center;">폐사</td>';
    result += '<td style="background: #ddd; text-align:center;">출하</td>';
    result += '<td style="background: #ddd; text-align:center;">예상</td>';
    result += '<td style="background: #ddd; text-align:center;">AI 실제</td>';
    result += '</tr>';
    result += '</thead>';     
    
    result += '<tbody id="tableList4">';
    
    result += '<tr>';
    

    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;
    var sum7 = 0;
    var sum8 = 0;
    
    //  농장 반복
    $.each(dailynews4, function (index_nongjang, nongjang) {
        var dname = nongjang["buildingname"];
        var donsaArray = nongjang["report"];
        var hap1 = 0;
        var hap2 = 0;
        var hap3 = 0;
        var hap4 = 0;
        var hap5 = 0;
        var hap6 = 0;
        var hap7 = 0;
        var hap8 = 0;
        
        if (donsaArray != null) {
            //  돈사 데이터 반복
            $.each(donsaArray, function (index_donsa, donsa) {
                var gap1 = donsa["month"];
                var gap2 = donsa["start_count"];
                var gap3 = donsa["in_count"];
                var gap4 = donsa["move_count"];
                var gap5 = donsa["die_count"];
                var gap6 = donsa["out_count"];
                var gap7 = donsa["expect_count"];
                var gap8 = donsa["ai_count"];
                hap1 += gap1;
                hap2 += gap2;
                hap3 += gap3;
                hap4 += gap4;
                hap5 += gap5;
                hap6 += gap6;
//                hap7 += gap7;
//                hap8 += gap8;
                
                result += '<td style="text-align:center;" class="seltable4"></td>';
                
                result += '<td style="text-align:center;" class="alltable4">' + dname + '</td>';
                result += '<td style="text-align:center;" class="excelToInt">' + gap1 + '</td>';
                result += '<td>' + gap2 + '</td>';
                result += '<td>' + gap3 + '</td>';
                result += '<td>' + gap4 + '</td>';
                result += '<td>' + gap5 + '</td>';
                result += '<td>' + gap6 + '</td>';
                result += '<td>' + gap7 + '</td>';
                result += '<td>' + gap8 + '</td>';
                result += '</tr>';
            })
            
            var Lastexp=  donsaArray[donsaArray.length-1]["expect_count"];
            var Lastai=  donsaArray[donsaArray.length-1]["ai_count"];

            result += '<tr>';
            result += '<td colspan="3" style="background: #eee; text-align:center;">소&emsp;&emsp;&emsp;계</td>';
            result += '<td style="background: #eee;">' + hap3 + '</td>';
            result += '<td style="background: #eee;">' + hap4 + '</td>';
            result += '<td style="background: #eee;">' + hap5 + '</td>';
            result += '<td style="background: #eee;">' + hap6 + '</td>';
            result += '<td style="background: #eee;">' + Lastexp + '</td>';
            result += '<td style="background: #eee;">' + Lastai + '</td>';
            result += '</tr>';
            sum1 += hap1;
            sum2 += hap2;
            sum3 += hap3;
            sum4 += hap4;
            sum5 += hap5;
            sum6 += hap6;
            sum7 += Lastexp;
            sum8 += Lastai;
        }
    });
    result += '<tr>';
    result += '<td colspan="3" style="background: #ddd; text-align:center;">합&emsp;&emsp;&emsp;계</td>';
    result += '<td style="background: #ddd;">' + sum3 + '</td>';
    result += '<td style="background: #ddd;">' + sum4 + '</td>';
    result += '<td style="background: #ddd;">' + sum5 + '</td>';
    result += '<td style="background: #ddd;">' + sum6 + '</td>';
    result += '<td style="background: #ddd;">' + sum7 + '</td>';
    result += '<td style="background: #ddd;">' + sum8 + '</td>';
    result += '</tr>';
    result += '</tbody>';
    
    $('#table4').append(result).addClass("unique4");
    var data4 = $("#selectBox4").val();
    $('.seltable4').text(data4);
    $(".alltable4").each(function () {
        var rows = $(".alltable4:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
    $(".seltable4").each(function () {
        var rows = $(".seltable4:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length+dailynews4.length+1);
            rows.not(":eq(0)").remove();
        }
    });
    var NowAllsum= sum7;
    $(".nowallsum4").append(NowAllsum);
};

//농장별 월보 출력
$("#FarmMonthlyReport").submit(function(){
    $(".unique4").empty();
    
    var data4idx = $("#selectBox4 option").index($("#selectBox4 option:selected"));
    var allData4 = {"pick_year": $(".ydate").val(), "locationid": data4idx};
     //동적으로 원격에 있는 JSON 파일(결과값)을 로드 
    $.ajax({
         url: "http://101.101.162.62:8081/smartdaily/req_location_monthly"
        , dataType: "json"
        , type: "POST"
        , data: allData4
        , success: ajaxCallback4
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
}); // end submit()

//농장별 일보 테이블 출력
var ajaxCallback5 = function (data) {
    var result = '';
    var dailynews5 = data;
    
    result += '<colgroup>';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '</colgroup>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="font-size:18px; font-weight:bold; text-align:center; padding:30px 0;" rowspan="3" colspan="9">스마트데일리 농장별 일보</td>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">상호</td>';
    result += '<td style="text-align:center;" colspan="4">'+ companyname +' 대표이사 '+ ceoname +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회기간</td>';
    result += '<td style="text-align:center;" colspan="3" class="excelToInt">'+ $(".mdate").val() +'</td>';
    result += '</tr>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">조회농장</td>';
    result += '<td style="text-align:center;" colspan="4">'+ $("#selectBox5 option:selected").text() +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회일자</td>';
    result += '<td style="text-align:center;" colspan="3">' + getToday() +'</td>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td colspan="9">&nbsp;</td>';
    result += '</tr>';
    
    result += '</thead>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">구분</td>';
    result += '<td style="background: #ddd; text-align:center;">날짜</td>';
    result += '<td style="background: #ddd; text-align:center;">시작</td>';
    result += '<td style="background: #ddd; text-align:center;">전입</td>';
    result += '<td style="background: #ddd; text-align:center;">전출</td>';
    result += '<td style="background: #ddd; text-align:center;">폐사</td>';
    result += '<td style="background: #ddd; text-align:center;">출하</td>';
    result += '<td style="background: #ddd; text-align:center;">예상</td>';
    result += '<td style="background: #ddd; text-align:center;">AI 실제</td>';
    result += '</tr>';
    result += '</thead>';     
    
    result += '<tbody id="tableList5">';
    
    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;

    //  농장 반복
    $.each(dailynews5, function (index_nongjang, nongjang) {
        result += '<tr>';
        result += '<td style="text-align:center;" class="alltable5">전체</td>';
        var gap1 = nongjang["recordday"];
        var gap2 = nongjang["start_count"];
        var gap3 = nongjang["in_count"];
        var gap4 = nongjang["move_count"];
        var gap5 = nongjang["die_count"];
        var gap6 = nongjang["out_count"];
        var gap7 = nongjang["expect_count"];
        var gap8 = nongjang["ai_count"];
        
        sum1 += gap3;
        sum2 += gap4;
        sum3 += gap5;
        sum4 += gap6;
        sum5 += gap7;
        sum6 += gap8;
        
        result += '<td style="text-align:center;">' + gap1 + '</td>';
        result += '<td>' + gap2 + '</td>';
        result += '<td>' + gap3 + '</td>';
        result += '<td>' + gap4 + '</td>';
        result += '<td>' + gap5 + '</td>';
        result += '<td>' + gap6 + '</td>';
        result += '<td>' + gap7 + '</td>';
        result += '<td>' + gap8 + '</td>';
        result += '</tr>';
        
    });
    var Lastexp = dailynews5[dailynews5.length-1]["expect_count"];
    var Lastai = dailynews5[dailynews5.length-1]["ai_count"];
    
    result += '<tr>';
    result += '<td colspan="3" style="background: #ddd; text-align:center;">합&emsp;&emsp;&emsp;계</td>';
    result += '<td style="background: #ddd;">' + sum1 + '</td>';
    result += '<td style="background: #ddd;">' + sum2 + '</td>';
    result += '<td style="background: #ddd;">' + sum3 + '</td>';
    result += '<td style="background: #ddd;">' + sum4 + '</td>';
    result += '<td style="background: #ddd;">' + Lastexp + '</td>';
    result += '<td style="background: #ddd;">' + Lastai + '</td>';
    result += '</tr>';
    result += '</tbody>';
    
    $('#table5').append(result).addClass("unique5");    
    $(".alltable5").each(function () {
        var rows = $(".alltable5:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
};

//농장별 일보 출력
$("#FarmDailyReport").submit(function(){
    $(".unique5").empty();
    
    var data5idx = $("#selectBox5 option").index($("#selectBox5 option:selected"));
    console.log(data5idx);
    var allData5 = { "pick_month": $(".mdate").val() , "locationid": data5idx };
     //동적으로 원격에 있는 JSON 파일(결과값)을 로드 
    $.ajax({
        url: "http://101.101.162.62:8081/smartdaily/req_location_daily"
        , dataType: "json"
        , type: "POST"
        , data: allData5
        , success: ajaxCallback5
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
}); // end submit()

var ajaxCallback6 = function (data) {    
    var result = '';
    var dailynews6 = data;
    
    result += '<colgroup>';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '<col width="11.11%">';
    result += '</colgroup>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="font-size:18px; font-weight:bold; text-align:center; padding:30px 0;" rowspan="3" colspan="9">스마트데일리 돈사별 일보</td>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    result += '<tr>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">상호</td>';
    result += '<td style="text-align:center;" colspan="4">'+ companyname +' 대표이사 '+ ceoname +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회기간</td>';
    result += '<td style="text-align:center;" colspan="3" class="excelToInt">'+ $(".mdate").val() +'</td>';
    result += '</tr>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">조회농장</td>';
    result += '<td style="text-align:center;" colspan="4">'+ $("#selectBox6 option:selected").text() +'</td>';
    result += '<td style="background: #ddd; text-align:center;">조회일자</td>';
    result += '<td style="text-align:center;" colspan="3">' + getToday() +'</td>';
    result += '</tr>';
    
    result += '<tr>';
    result += '<td colspan="9">&nbsp;</td>';
    result += '</tr>';
    
    result += '</thead>';
    
    result += '<thead>';
    result += '<tr>';
    result += '<td style="background: #ddd; text-align:center;">구분</td>';
    result += '<td style="background: #ddd; text-align:center;">날짜</td>';
    result += '<td style="background: #ddd; text-align:center;">시작</td>';
    result += '<td style="background: #ddd; text-align:center;">전입</td>';
    result += '<td style="background: #ddd; text-align:center;">전출</td>';
    result += '<td style="background: #ddd; text-align:center;">폐사</td>';
    result += '<td style="background: #ddd; text-align:center;">출하</td>';
    result += '<td style="background: #ddd; text-align:center;">예상</td>';
    result += '<td style="background: #ddd; text-align:center;">AI 실제</td>';
    result += '</tr>';
    result += '</thead>';     
    
    result += '<tbody id="tableList6">';
        
    var sum1 = 0;
    var sum2 = 0;
    var sum3 = 0;
    var sum4 = 0;
    var sum5 = 0;
    var sum6 = 0;

    //  농장 반복
    $.each(dailynews6, function (index_nongjang, nongjang) {
        
        var gap1 = nongjang["recordday"];
        var gap2 = nongjang["start_count"];
        var gap3 = nongjang["in_count"];
        var gap4 = nongjang["move_count"];
        var gap5 = nongjang["die_count"];
        var gap6 = nongjang["out_count"];
        var gap7 = nongjang["expect_count"];
        var gap8 = nongjang["ai_count"];
        
        sum1 += gap3;
        sum2 += gap4;
        sum3 += gap5;
        sum4 += gap6;
        sum5 += gap7;
        sum6 += gap8;
        
        result += '<tr>';
        result += '<td style="text-align:center;" class="seltable6"></td>';
        result += '<td style="text-align:center;">' + gap1 + '</td>';
        result += '<td>' + gap2 + '</td>';
        result += '<td>' + gap3 + '</td>';
        result += '<td>' + gap4 + '</td>';
        result += '<td>' + gap5 + '</td>';
        result += '<td>' + gap6 + '</td>';
        result += '<td>' + gap7 + '</td>';
        result += '<td>' + gap8 + '</td>';
        result += '</tr>';
        
    });
    
    var Lastexp = dailynews6[dailynews6.length-1]["expect_count"];
    var Lastai = dailynews6[dailynews6.length-1]["ai_count"];
    
    result += '<tr>';
    result += '<td colspan="3" style="background: #ddd; text-align:center;">합&emsp;&emsp;&emsp;계</td>';
    result += '<td style="background: #ddd;">' + sum1 + '</td>';
    result += '<td style="background: #ddd;">' + sum2 + '</td>';
    result += '<td style="background: #ddd;">' + sum3 + '</td>';
    result += '<td style="background: #ddd;">' + sum4 + '</td>';
    result += '<td style="background: #ddd;">' + Lastexp + '</td>';
    result += '<td style="background: #ddd;">' + Lastai + '</td>';
    result += '</tr>';
    result += '</tbody>'; 
    
    $('#table6').append(result).addClass("unique6");
    var data6 = $("#good").val();
    $('.seltable6').text(data6);
    $(".seltable6").each(function () {
        var rows = $(".seltable6:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });    
};

//농장별 일보 출력
$("#FarmDonsaDailyReport").submit(function(){
    $(".unique6").empty();
    
    var data6idx = $("#good option").index($("#good option:selected"));    
    // 선택된 월(날짜문자열)과 셀렉트박스에서 선택된 돈사아이디(buildingid) 값을 name/value 형태로 담는다.
    var allData = { "pick_month": $(".mdate").val() , "buildingid": data6idx };
    //동적으로 원격에 있는 JSON 파일(결과값)을 로드
    $.ajax({
        url: "http://101.101.162.62:8081/smartdaily/req_building_daily"
        , dataType: "json"
        , type: "POST"
        , data: allData
        , success: ajaxCallback6
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
}); // end submit()

var useriddata;

//농장 돈사별 일보 테이블 출력
var useridCallback = function (data) {
    var result = '';
    useriddata = data;
    
    result += '<tr>';
    
    $("#selectBox4").append("<option value='농장 선택'>농장 선택</option>");
    $("#selectBox5").append("<option value='농장 선택'>농장 선택</option>");
    $("#selectBox6").append("<option value='농장 선택'>농장 선택</option>");
   
    //  농장 반복
    $.each(useriddata, function (index_nongjang, nongjang) {
        var nname = nongjang["locationname"];
        var nid = nongjang["locationid"];
        var donsaArray = nongjang["buildings"];
        
        $("#selectBox4").append("<option value='"+ nname +"'>"+ nname +"</option>");
        $("#selectBox5").append("<option value='"+ nid +"'>"+ nname +"</option>");       
        $("#selectBox6").append("<option value='"+ nid +"'>"+ nname +"</option>");
        
        if (donsaArray != null) {
            //  돈사 데이터 반복
            $.each(donsaArray, function (index_donsa, donsa) {
                var dname = donsa["buildingname"];
                var did = donsa["buildingid"];
                
                result += '<td class="temtable6">' + nname + '</td>';
                result += '<td>' + nid + '</td>';
                result += '<td>' + dname + '</td>';
                result += '<td>' + did + '</td>';
                result += '</tr>';
            })
        }
    });
//    $('#tempdata').append(result).addClass("removetem");
    $(".temtable6").each(function () {
        var rows = $(".temtable6:contains('" + $(this).text() + "')");
        if (rows.length > 1) {
            rows.eq(0).attr("rowspan", rows.length);
            rows.not(":eq(0)").remove();
        }
    });
};

//일보조회 셀렉트
function categoryChange(e) {
    $(".removegood").remove();
    
    var donsaArray = useriddata[e.value-1].buildings;
    
    $.each (donsaArray, function (index_building, donsaOne){
        var donsaName= donsaOne["buildingname"];
        $("#good").append("<option class='removegood' value='"+ donsaName +"'>"+donsaName+"</option>");
    })
}

$('ul.tabs li').click(function () {
    $(".removetem").empty();
    $("#selectBox4").empty();
    $("#selectBox5").empty();
    $("#selectBox6").empty();
    var useridx = $("#useridx").val();
    console.log("useridx=", useridx);
    // 유저 인덱스를 가져온다.
    var useridx = {"useridx":useridx};
    
    $.ajax({
        url: "http://101.101.162.62:8081/smartdaily/req_user_building"
        , dataType: "json"
        , type: "POST"
        , data: useridx
        , success: useridCallback
        , error: function () {
            alert("해당 조건을 올바르게 선택해주세요.");
        }
    });
    return false;
})

//시작-종료달력출력
$(document).ready(function () {    
    $.datepicker.regional['ko'] = {
        closeText: '닫기'
        , prevText: '이전달'
        , nextText: '다음달'
        , currentText: '오늘'
        , monthNames: ['1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)', '5월(MAY)', '6월(JUN)'
            , '7월(JUL)', '8월(AUG)', '9월(SEP)', '10월(OCT)', '11월(NOV)', '12월(DEC)']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
            , '7월', '8월', '9월', '10월', '11월', '12월']
        , weekHeader: 'Wk'
        , dateFormat: 'yy-mm-dd'
        , firstDay: 0
        , isRTL: false
        , showMonthAfterYear: true
        , yearSuffix: ''
        , changeMonth: true
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
        , onClose: function (selectedDate) {
            //시작일(startDate) datepicker가 닫힐때
            //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
            $('#edate').datepicker('option', 'minDate', selectedDate);
        }
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
    $('#sdate').datepicker('setDate', 'today');
    var datepicker_default = {
        showOn: 'both'
        , currentText: "이번달"
        , changeMonth: true
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
        , showOtherMonths: true
        , selectOtherMonths: true
    }
    datepicker_default.closeText = "선택";
    datepicker_default.dateFormat = "yy-mm";
    datepicker_default.onClose = function (dateText, inst) {
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker("option", "defaultDate", new Date(year, month, 1));
        $(this).datepicker('setDate', new Date(year, month, 1));
    }
    datepicker_default.beforeShow = function () {
        var selectDate = $("#sdate").val().split("-");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) - 1;
        $(this).datepicker("option", "defaultDate", new Date(year, month, 1));
    }
    $("#sdate").datepicker(datepicker_default);
    $.datepicker.regional['ko'] = {
        closeText: '닫기'
        , prevText: '이전달'
        , nextText: '다음달'
        , currentText: '오늘'
        , monthNames: ['1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)', '5월(MAY)', '6월(JUN)'
            , '7월(JUL)', '8월(AUG)', '9월(SEP)', '10월(OCT)', '11월(NOV)', '12월(DEC)']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
            , '7월', '8월', '9월', '10월', '11월', '12월']
        , weekHeader: 'Wk'
        , dateFormat: 'yy-mm-dd'
        , firstDay: 0
        , isRTL: false
        , showMonthAfterYear: true
        , yearSuffix: ''
        , changeMonth: true
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
        , onClose: function (selectedDate) {
            // 종료일(endDate) datepicker가 닫힐때
            // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
            $("#sdate").datepicker("option", "maxDate", selectedDate);
        }
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
    var datepicker_default = {
        showOn: 'both'
        , currentText: "이번달"
        , changeMonth: true
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
        , showOtherMonths: true
        , selectOtherMonths: true
    }
    datepicker_default.closeText = "선택";
    datepicker_default.dateFormat = "yy-mm";
    datepicker_default.onClose = function (dateText, inst) {
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker("option", "defaultDate", new Date(year, month, 1));
        $(this).datepicker('setDate', new Date(year, month, 1));
    }
    datepicker_default.beforeShow = function () {
        var selectDate = $("#edate").val().split("-");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) - 1;
        $(this).datepicker("option", "defaultDate", new Date(year, month, 1));
    }
    $("#edate").datepicker(datepicker_default);
});

//월별달력출력
$(document).ready(function () {
    $.datepicker.regional['ko'] = {
        closeText: '닫기'
        , prevText: '이전달'
        , nextText: '다음달'
        , currentText: '오늘'
        , monthNames: ['1월(JAN)', '2월(FEB)', '3월(MAR)', '4월(APR)', '5월(MAY)', '6월(JUN)'
                , '7월(JUL)', '8월(AUG)', '9월(SEP)', '10월(OCT)', '11월(NOV)', '12월(DEC)']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
                , '7월', '8월', '9월', '10월', '11월', '12월']
        , weekHeader: 'Wk'
        , dateFormat: 'yy-mm-dd'
        , firstDay: 0
        , isRTL: false
        , showMonthAfterYear: true
        , yearSuffix: '년'
        , showOn: 'both'
        , changeMonth: true
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
    , };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
    var datepicker_default = {
        showOn: 'both'
        , currentText: "이번달"
        , changeMonth: true
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
        , showOtherMonths: true
        , selectOtherMonths: true
    }
    datepicker_default.closeText = "선택";
    datepicker_default.dateFormat = "yy-mm";
    datepicker_default.onClose = function (dateText, inst){ 
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker("option", "defaultDate", new Date(year, month));
        $(this).datepicker('setDate', new Date(year, month));
        // ------------year는 4자리 month는 00 두자리 문자로 만듬.------------
        var pmonth = new Date(year, Number(month) + 1);
        $('.mdate').val(pmonth.toISOString().substring(0,7));
    }
    datepicker_default.beforeShow = function () {
        var selectDate = $(".mdate").val().split("-");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) ;
        $(this).datepicker("option", "defaultDate", new Date(year, month));
    }
    $(".mdate").datepicker(datepicker_default);
});

//년별달력출력
$(document).ready(function () {
    $.datepicker.regional['ko'] = {
        closeText: '닫기'
        , currentText: '오늘'
        , monthNames: ['1월', '2월', '3월', '4월', '5월', '6월'
                , '7월', '8월', '9월', '10월', '11월', '12월']
        , monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월'
                , '7월', '8월', '9월', '10월', '11월', '12월']
        , weekHeader: 'Wk'
        , dateFormat: 'yy-mm-dd'
        , firstDay: 0
        , isRTL: false
        , showMonthAfterYear: true
        , yearSuffix: '년'
        , showOn: 'both'
        , changeMonth: false
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
    , };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
    var datepicker_default = {
        showOn: 'both'
        , currentText: "이번년"
        , changeMonth: false
        , changeYear: true
        , showButtonPanel: true
        , yearRange: 'c-10:c+10'
        , showOtherMonths: false
        , selectOtherMonths: false
    }
    datepicker_default.closeText = "선택";
    datepicker_default.dateFormat = "yy";
    datepicker_default.onClose = function (dateText, inst) {
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker("option", "defaultDate", new Date(year , 1));
        $(this).datepicker('setDate', new Date(year, 1));
    }
    datepicker_default.beforeShow = function () {
        var selectDate = $(".ydate").val().split("-");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) - 1;
        $(this).datepicker("option", "defaultDate", new Date(year, month, 1));
    }
    $(".ydate").datepicker(datepicker_default);
});

//일보조회 엑셀다운로드
function fnExcelReport11(id, title) {
    var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
    tab_text = tab_text + '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
    tab_text = tab_text + '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
    tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
    tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
    tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml> <style> .excelToInt{mso-number-format:"yyyy\-mm\";} </style></head><body>';
    tab_text = tab_text + "<table border='1px'>";
    tab_text = tab_text + "<colgroup>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "</colgroup>";
    var exportTable = $('#' + id).clone();
    exportTable.find('input').each(function (index, elem) {
        $(elem).remove();
    });
    tab_text = tab_text + exportTable.html();
    tab_text = tab_text + '</table></body></html>';
    var data_type = 'data:application/vnd.ms-excel';
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");
    var fileName = title + '.xls';
    //Explorer 환경에서 다운로드
    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
        if (window.navigator.msSaveBlob) {
            var blob = new Blob([tab_text], {
                type: "application/csv;charset=utf-8;"
            });
            navigator.msSaveBlob(blob, fileName);
        }
    }
    else {
        var blob2 = new Blob([tab_text], {
            type: "application/csv;charset=utf-8;"
        });
        var filename = fileName;
        var elem = window.document.createElement('a');
        elem.href = window.URL.createObjectURL(blob2);
        elem.download = filename;
        document.body.appendChild(elem);
        elem.click();
        document.body.removeChild(elem);
    }
}

function fnExcelReport10(id, title) {
    var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
    tab_text = tab_text + '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
    tab_text = tab_text + '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
    tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
    tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
    tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml> <style> .excelToInt{mso-number-format:"yyyy\-mm\";} </style></head><body>';
    tab_text = tab_text + "<table border='1px'>";
    tab_text = tab_text + "<colgroup>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "</colgroup>";
    var exportTable = $('#' + id).clone();
    exportTable.find('input').each(function (index, elem) {
        $(elem).remove();
    });
    tab_text = tab_text + exportTable.html();
    tab_text = tab_text + '</table></body></html>';
    var data_type = 'data:application/vnd.ms-excel';
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");
    var fileName = title + '.xls';
    //Explorer 환경에서 다운로드
    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
        if (window.navigator.msSaveBlob) {
            var blob = new Blob([tab_text], {
                type: "application/csv;charset=utf-8;"
            });
            navigator.msSaveBlob(blob, fileName);
        }
    }
    else {
        var blob2 = new Blob([tab_text], {
            type: "application/csv;charset=utf-8;"
        });
        var filename = fileName;
        var elem = window.document.createElement('a');
        elem.href = window.URL.createObjectURL(blob2);
        elem.download = filename;
        document.body.appendChild(elem);
        elem.click();
        document.body.removeChild(elem);
    }
}

function fnExcelReport9(id, title) {
    var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
    tab_text = tab_text + '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
    tab_text = tab_text + '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
    tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
    tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
    tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml> <style> .excelToInt{mso-number-format:"yyyy\-mm\";} </style></head><body>';
    tab_text = tab_text + "<table border='1px'>";
    tab_text = tab_text + "<colgroup>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "<col width='110'>";
    tab_text = tab_text + "</colgroup>";
    var exportTable = $('#' + id).clone();
    exportTable.find('input').each(function (index, elem) {
        $(elem).remove();
    });
    tab_text = tab_text + exportTable.html();
    tab_text = tab_text + '</table></body></html>';
    var data_type = 'data:application/vnd.ms-excel';
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");
    var fileName = title + '.xls';
    //Explorer 환경에서 다운로드
    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
        if (window.navigator.msSaveBlob) {
            var blob = new Blob([tab_text], {
                type: "application/csv;charset=utf-8;"
            });
            navigator.msSaveBlob(blob, fileName);
        }
    }
    else {
        var blob2 = new Blob([tab_text], {
            type: "application/csv;charset=utf-8;"
        });
        var filename = fileName;
        var elem = window.document.createElement('a');
        elem.href = window.URL.createObjectURL(blob2);
        elem.download = filename;
        document.body.appendChild(elem);
        elem.click();
        document.body.removeChild(elem);
    }
}