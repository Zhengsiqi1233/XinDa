$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})
$(".order3").on("click", function(){
    $(".main-top li").eq(3).text("未通过用户");
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})

$(function(){
	var providerid = sessionStorage.getItem("providerid");
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

			$.ajax({
				type:"get",
				url:"/business/businessorderlistbyid", 
				data:{
					providerid:providerid,
				},
				dataType:"json",
				
				success:function(data){
					console.log("成功返回的数据",data);
					
					var businessOrderList = data.businessOrderList;
					$("#businessorderlist").html("");
					var txt = "";
					for(var i = 0; i < businessOrderList.length; i ++){
						txt += `<tr>
							<td>${businessOrderList[i].businessNo}</td>
							<td>${businessOrderList[i].orderInfo}</td>
							<td>${businessOrderList[i].memberName}</td>
							<td>${businessOrderList[i].memberCellphone}</td>
							<td>${businessOrderList[i].orderNum}</td>
							<td>${businessOrderList[i].orderSum}</td>
							<td>${format(businessOrderList[i].createTime)}</td>
							<td>
                            	<span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                           </td>
						</tr>`
						}
					console.log(txt);
					
					$("#businessorderlist").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
			})
			
		})
		