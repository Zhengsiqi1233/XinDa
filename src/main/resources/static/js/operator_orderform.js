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
					<td>${bussinessOrderList[i].businessNo}</td>
					<td>${bussinessOrderList[i].memberName}</td>					
					<td>${bussinessOrderList[i].orderInfo}*${bussinessOrderList[i].orderNum}</td>
					<td>¥${bussinessOrderList[i].orderSum}</td>
					<td>${format(bussinessOrderList[i].createTime)}</td>
                    <td>${bussinessOrderList[i].status}</td>
                    <td>
                        <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                    </td>
					
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
	
})

function format(time){
	var date = new Date(time);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(function(){
	$("#username").html("");
	var txt="";
	txt += sessionStorage.getItem("username")
	$("#username").append(txt);
})
$(".business-order").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("业务订单");
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务订单");
})