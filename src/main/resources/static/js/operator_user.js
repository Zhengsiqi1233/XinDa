function format(time){
	var date = new Date(time);
	return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
}
$(function(){
	$.ajax({
		type:"get",
		url:"/membercomtroller/memberlist",
		dataType:"json",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var memberList = data.memberList;
			$("#memberlist").html("");
			var txt = "";
			for(var i = 0; i < memberList.length; i ++){
				txt += `<tr>
					<td>${memberList[i].id}</td>
					<td>${memberList[i].name}</td>
					<td>${memberList[i].cellphone}</td>
					<td>${memberList[i].region}</td>
					<td>${format(memberList[i].createTime)}</td>
					<td>${memberList[i].orderNum}</td>
					<td>${memberList[i].orderSum}</td>
					<td>
                       <span class="handle-btn">查看</span>
                    </td>
					
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#memberlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".business-order").on("click", function(){
    $(".main-content").show();
    $("table").show();
    $(".main-pagination").show();
    $(".main-sercive").hide();
    $(".business-order").addClass("border-red");
    $(".service-order").removeClass("border-red");
    $(".main-top li").eq(3).text("注册用户");
})
$(".service-order").on("click", function(){
    $(".main-content").hide();
    $("table").hide();
    $(".main-pagination").hide();
    $(".main-sercive").show();
    $(".service-order").addClass("border-red");
    $(".business-order").removeClass("border-red");
    $(".main-top li").eq(3).text("服务商用户");
})
