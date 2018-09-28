<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
   <jsp:param value="" name="pageTitle"/>
</jsp:include>

<span class="font30 blue bold">01</span> <span class="font25 bold">장바구니 목록</span>
<table class="table tblBorderBottom" id="tblBasketList">
	<thead class="thead-light">
		<tr>
			<th>
				<input type="checkbox" id="allCheck" name="allCheck" onchange="fn_checkAll(this.checked);">
			</th>
	        <th>상품정보</th>
	        <th>판매가</th>
	        <th>수량</th>
	        <th>합계</th>
	        <th>선택</th>
		</tr>
	</thead>
	<c:if test="${not empty basketList }">
    	<c:forEach var="i" items="${basketList }" varStatus="vs">
	    	<tr>
				<td class="tbl-td">
	            	<input type="checkbox" class="form-control basketList" name="basketList" id="basketItem${vs.count }" onclick="fn_toggle(basketItem${vs.count }, this.checked)">
	           	</td>
	            <td class="tbl-td">
	           		<div id="tbl-img-row">
	                	<img class="bookImage marginR10" src="${pageContext.request.contextPath }/resources/img/${i['bookImage']}" alt="">
	                    <span>[${i["categoryName"]}] &nbsp; ${i["bookTitle"]}</span>
	                </div>
	           	</td>
	            <td class="tbl-td">
	            	<input type="hidden" value="${i['bookPrice']}" name="bookPrice"/>
	            	<fmt:formatNumber value="${i['bookPrice']}" type="currency" currencySymbol=""/>원
	            	<%-- <span class="bookPrice">${i['bookPrice']}</span>원 --%>
	           	</td>
	           	<td class="tbl-td">
	           		<input type="number" class="form-control inline width60 bookAmount" name="bookAmount" value="${i['bookAmount']}" min="1">
	           		<button type="button" class="btn btn-light updateBasket">수정</button>
	            </td>
	            <td class="tbl-td">
	            	<input type="hidden" value="${i['bookAmount']*i['bookPrice']}" name="bookPrice"/>
	                <%-- <fmt:formatNumber value="${i['bookAmount']*i['bookPrice']}" type="currency" currencySymbol=""/>원 --%> 
	                <span class="amountXprice" >${i['bookAmount']*i['bookPrice']}</span>원
	            </td>
	            <td class="tbl-td">
		            <input type="hidden" value="${i['basketNo'] }" name="basketNo"/>
		            <button type="button" class="btn btn-outline-success" onclick="window.location.href='${pageContext.request.contextPath }/purchase/purchase.do?basketNo=${i['basketNo'] }&memberId=${memberLoggedIn.memberId }'">구매</button> &nbsp;
		            <button type="button" class="btn btn-outline-danger deleteBasket">삭제</button>
	       		</td>
	        </tr>
    	</c:forEach>
   	</c:if>
   	<c:if test="${empty basketList }">
    	<tr>
			<td colspan="6">
				<p class="textAlignCenter marginBottom0">장바구니에 담긴 상품이 없습니다.</p>
			</td>
		</tr>
	</c:if>
</table> 
	
<button type="button" class="btn btn-danger marginBottom100 block" id="deleteChkItem">선택상품 삭제</button>

<span class="font30 blue bold">02</span> <span class="font25 bold">금액 정보</span>
<table class="table">
	<tr>
		<th>상품금액</th>
		<th>배송비</th>
		<th>총 결제금액</th>
	</tr>
	<tr>
		<td class="tbl-td"><fmt:formatNumber value="0" type="currency" currencySymbol="" />원</td>
       	<td class="tbl-td"><fmt:formatNumber value="2000" type="currency" currencySymbol="" />원</td>
       	<td class="tbl-td"><fmt:formatNumber value="2000" type="currency" currencySymbol="" />원</td>
	</tr>
	<tr>
		<td colspan="3">
			<div>
         		<button type="button" class="btn btn-primary floatRight marginR10" id="purchaseAll" onclick="return purchaseAll();">전체상품 주문</button>
         		<button type="button" class="btn btn-success floatRight marginR10" id="purchaseChk" onclick="return purchaseChk();">선택상품 주문</button>
      		</div>                     
   	  	</td>
   	</tr>
</table>
  

<script>
function fn_checkAll(bool) {
    var chkboxes = document.getElementsByName("basketList");

    for(var i=0; i<chkboxes.length; i++) {
        chkboxes[i].checked = bool;
    }
}

function fn_toggle(bool) {
    var chkboxes = document.getElementsByName("basketList");
    var chkall = document.getElementById("allCheck");
     
    // 클래스명 부여
    if(bool == true) {
        // parent_td.className = 'on';
    } else{
        // parent_td.className = 'off';
        chkall.checked = false;
    }

    var count = 0;
    for(var i=0; i<chkboxes.length; i++) {
        if(chkboxes[i].checked == true)
            count++;
    }
    
    if(count==chkboxes.length) chkall.checked = true;
    // else chkall.checked = false;
}

function purchaseAll() {
   var chkboxes = document.getElementsByName("basketList");
   var basketNo = "";
   
   for(var i=0; i<chkboxes.length; i++) {
      basketNo += $(chkboxes[i]).parent().parent().find("[name=basketNo]").val();     
      basketNo += "/";
    }
   
   location.href="${pageContext.request.contextPath}/purchase/purchase.do?basketNo="+basketNo+"&memberId=${memberId }";
}

function purchaseChk() {
   var basketNo = "";
   
   $("[name=basketList]:checked").filter(function() {
      basketNo += $(this).parent().parent().find("[name=basketNo]").val();
      basketNo += "/";
    });
   
   if(basketNo !== "") {
      location.href="${pageContext.request.contextPath}/purchase/purchase.do?basketNo="+basketNo+"&memberId=${memberId }";
   }
   else {
      alert("선택된 상품이 없습니다.");
   } 
}

/* 3자리마다 콤마찍어주기 */
function addCommaSearch(value) {
	str = String(value);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}


$(function() {

	/* $(".bookPrice").text(addCommaSearch(parseInt($(".bookPrice").text()))); */
	/* $(".amountXprice").text(addCommaSearch(parseInt($(".amountXprice").text()))); */
	/* $(".updateBasket").trigger("click"); */
	
	// 삭제 버튼
	$(".deleteBasket").click(function() {
		var basketNo = $(this).parent().find("[name=basketNo]").val();
		
		if(confirm("장바구니에서 삭제하시겠습니까?")) {
	    	$.ajax({
	        	url:"${pageContext.request.contextPath}/basket/deleteBasket.do",
	         	data: {
	            	basketNo : basketNo
	         	},
	         	success:function(data) {
	         		location.href = "${pageContext.request.contextPath}/basket/selectBasketList.do?memberId=${memberLoggedIn.memberId }";
	         	},
	         	error:function(jqxhr, textStatus, errorThrown) {
	         		console.log("ajax처리실패!");
	            	console.log(jqxhr);
	             	console.log(textStatus);
	             	console.log(errorThrown);
	         	}
	      	});
	   	}
	});
   
	// 수량 직접 입력 시
   	$(".bookAmount").on("blur", function() {
   		var bookAmount = $(this).val();
      	
   		if(!$.isNumeric(bookAmount) || bookAmount < 1) {
   			alert("수량을 입력하세요.");
   			$(this).val(1);
   		}
   	});
   
   
	// 수량 수정 버튼
	$(".updateBasket").click(function() { 
    	var basketNo = $(this).parent().parent().find("[name=basketNo]").val();
      	var bookAmount = $(this).parent().find("[name=bookAmount]").val();
      	var bookPrice = $(this).parent().parent().find("[name=bookPrice]").val();
		var amountXprice = $(this).parent().parent().find(".amountXprice");
      	$.ajax({
        	url:"${pageContext.request.contextPath}/basket/updateBasket.do",
         	data: {
            	basketNo : basketNo,
            	bookAmount : bookAmount
         	},
         	success:function(data) {
         		amountXprice.text(addCommaSearch(parseInt(data.bookAmount)*bookPrice));
         	},
         	error:function(jqxhr, textStatus, errorThrown) {
        		console.log("ajax처리실패!");
             	console.log(jqxhr);
             	console.log(textStatus);
             	console.log(errorThrown);
         	}
      	});
   	});
   
	// 선택상품 삭제 버튼
	$("#deleteChkItem").click(function() {
    	var basketNo = "";
      	$("[name=basketList]:checked").filter(function() {
        	basketNo += $(this).parent().parent().find("[name=basketNo]").val();
         	basketNo += "/";
      	});
      
      	if(basketNo === "") {
        	alert("선택된 상품이 없습니다.");
      	} else {      
        	if(confirm("장바구니에서 삭제하시겠습니까?")) {
        		$.ajax({
	           		url:"${pageContext.request.contextPath}/basket/deleteBasket.do",
               		data: {
                  		basketNo : basketNo
               		},
               		success:function(data) {
            	   		location.href = "${pageContext.request.contextPath}/basket/selectBasketList.do?memberId=${memberLoggedIn.memberId }";
               		},
               		error:function(jqxhr, textStatus, errorThrown) {
                  		console.log("ajax처리실패!");
                  		console.log(jqxhr);
                  		console.log(textStatus);
                  		console.log(errorThrown);
               		}
            	});
         	}
      	}
   	});
});
</script> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>