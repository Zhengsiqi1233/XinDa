$(function(){
	$.ajax({
		type:"get",
		url:"/business/bussinessorderlist",
		dataType:"json",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderList;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				txt += `<tr> 
					<td>${bussinessOrderList[i].memberName}</td>
					<td>${format(bussinessOrderList[i].createTime)}</td>
					<td>${bussinessOrderList[i].businessNo}</td>
					<td>¥${bussinessOrderList[i].orderSum}</td>
                    <td>${bussinessOrderList[i].payType}</td>										
					<td>${bussinessOrderList[i].orderInfo}*${bussinessOrderList[i].orderNum}</td>		                  
				</tr>`
				}
			console.log(txt);
			$("#bussinessorderlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
/*
 * 查询所有订单的金额总和
 */

$.ajax({
		type:"get",
		url:"/business/bussinessordersum",
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderSum = data.bussinessOrderSum;
			$("#bussinessordersum").html("");
			var txt = "";
			txt = `
			交易金额 
			<span class="font-red">${bussinessOrderSum}
			</span>`
				console.log(txt);
			
			$("#bussinessordersum").html(txt);

		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
$(function(){
	$("#username").html("");
	var txt="";
	txt += sessionStorage.getItem("username")
	$("#username").append(txt);
})
function format(time){
	var date = new Date(time);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}
/*
 * 查询当天的所有订单
 */
$(".todaylist").on("click",function(){
	$.ajax({
		type:"get",
		url:"/business/bussinessordertoday",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderToday;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				txt += `<tr> 
					<td>${bussinessOrderList[i].memberName}</td>
					<td>${format(bussinessOrderList[i].createTime)}</td>
					<td>${bussinessOrderList[i].businessNo}</td>
					<td>¥${bussinessOrderList[i].orderSum}</td>
                    <td>${bussinessOrderList[i].payType}</td>										
					<td>${bussinessOrderList[i].orderInfo}*${bussinessOrderList[i].orderNum}</td>		                  
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#bussinessorderlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	$.ajax({
		type:"get",
		url:"/business/bussinessordertodaysum",
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderSum = data.bussinessOrderTodaySum;
			$("#bussinessordersum").html("");
			var txt = "";
			txt = `
			交易金额 
			<span class="font-red">${bussinessOrderSum}
			</span>`
				console.log(txt);
			
			$("#bussinessordersum").html(txt);

		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})	
})
/*
 * 查询本周的所有订单
 */
$(".weeklist").on("click",function(){
	$.ajax({
		type:"get",
		url:"/business/bussinessorderweek",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderWeek;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				txt += `<tr> 
					<td>${bussinessOrderList[i].memberName}</td>
					<td>${format(bussinessOrderList[i].createTime)}</td>
					<td>${bussinessOrderList[i].businessNo}</td>
					<td>¥${bussinessOrderList[i].orderSum}</td>
                    <td>${bussinessOrderList[i].payType}</td>										
					<td>${bussinessOrderList[i].orderInfo}*${bussinessOrderList[i].orderNum}</td>		                  
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#bussinessorderlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	$.ajax({
		type:"get",
		url:"/business/bussinessorderweeksum",
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderSum = data.bussinessOrderWeekSum;
			$("#bussinessordersum").html("");
			var txt = "";
			txt = `
			交易金额 
			<span class="font-red">${bussinessOrderSum}
			</span>`
				console.log(txt);
			
			$("#bussinessordersum").html(txt);

		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})	
	
})
/*
 * 查询本月的所有订单
 */
$(".monthlist").on("click",function(){
	$.ajax({
		type:"get",
		url:"/business/bussinessordermonth",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderMonth;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				txt += `<tr> 
					<td>${bussinessOrderList[i].memberName}</td>
					<td>${format(bussinessOrderList[i].createTime)}</td>
					<td>${bussinessOrderList[i].businessNo}</td>
					<td>¥${bussinessOrderList[i].orderSum}</td>
                    <td>${bussinessOrderList[i].payType}</td>										
					<td>${bussinessOrderList[i].orderInfo}*${bussinessOrderList[i].orderNum}</td>		                  
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#bussinessorderlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	$.ajax({
		type:"get",
		url:"/business/bussinessordermonthsum",
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderSum = data.bussinessOrderMonthSum;
			$("#bussinessordersum").html("");
			var txt = "";
			txt = `
			交易金额 
			<span class="font-red">${bussinessOrderSum}
			</span>`
				console.log(txt);
			
			$("#bussinessordersum").html(txt);

		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})	
	
})
/*
 * 查询所有的订单
 */
$(".alllist").on("click",function(){
	$.ajax({
		type:"get",
		url:"/business/bussinessorderlist",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderList;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				txt += `<tr> 
					<td>${bussinessOrderList[i].memberName}</td>
					<td>${format(bussinessOrderList[i].createTime)}</td>
					<td>${bussinessOrderList[i].businessNo}</td>
					<td>¥${bussinessOrderList[i].orderSum}</td>
                    <td>${bussinessOrderList[i].payType}</td>										
					<td>${bussinessOrderList[i].orderInfo}*${bussinessOrderList[i].orderNum}</td>		                  
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#bussinessorderlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	$.ajax({
		type:"get",
		url:"/business/bussinessordersum",
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderSum = data.bussinessOrderSum;
			$("#bussinessordersum").html("");
			var txt = "";
			txt = `
			交易金额 
			<span class="font-red">${bussinessOrderSum}
			</span>`
				console.log(txt);
			
			$("#bussinessordersum").html(txt);

		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})


$(".user-arrow-down").on("click", function () {
    if ($(".dropdown").is(":hidden")) {
        $(".dropdown").show();
    } else {
        $(".dropdown").hide();
    }
})
$(".business-order").on("click", function () {
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("支付中心");
})
$(".service-order").on("click", function () {
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("结算中心");
})
$(".search li").eq(0).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".search li").eq(1).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".search li").eq(2).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".search li").eq(3).on("click", function () {
    $(".search li").removeClass("font-red");
    $(this).addClass("font-red");
})