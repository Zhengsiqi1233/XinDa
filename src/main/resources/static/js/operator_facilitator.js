$(function(){
	$.ajax({
		type:"get",
		url:"/provider/providerlist",
		dataType:"json",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var providerList = data.providerList;
			$("#providerlist").html("");
			var txt = "";
			for(var i = 0; i < providerList.length; i ++){
				txt += `<tr>
				    <td>${providerList[i].name}</td>
					<td>${providerList[i].region}</td>
					<td>${providerList[i].cellphone}</td>
					<td>${providerList[i].providerInfoUser}</td>
					<td>
				
                        <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                        <span class="handle-btn"><i class="fa fa-circle-o fa-fw"></i>停用</span>
                    
					</td>
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#providerlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
/*
 * 正常的用户展示
 */
$(".providercommon").on("click",function(){
	$.ajax({
		type:"get",
		url:"/provider/providerlist",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var providerList = data.providerList;
			$("#providerlist").html("");
			var txt = "";
			for(var i = 0; i < providerList.length; i ++){
				txt += `<tr>
				    <td>${providerList[i].name}</td>
					<td>${providerList[i].region}</td>
					<td>${providerList[i].cellphone}</td>
					<td>${providerList[i].providerInfoUser}</td>
					<td>
				
                        <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                        <span class="handle-btn"><i class="fa fa-circle-o fa-fw"></i>启用</span>
                    
					</td>
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#providerlist").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
$(".providerstop").on("click",function(){
	$.ajax({
		type:"get",
		url:"/provider/providerstop",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var providerList = data.providerStop;
			$("#providerlist").html("");
			var txt = "";
			for(var i = 0; i < providerList.length; i ++){
				txt += `<tr>
				    <td>${providerList[i].name}</td>
					<td>${providerList[i].region}</td>
					<td>${providerList[i].cellphone}</td>
					<td>${providerList[i].providerInfoUser}</td>
					<td>
				
                        <span class="handle-btn"><i class="fa fa-edit fa-fw"></i>详情</span>
                        <span class="handle-btn"><i class="fa fa-circle-o fa-fw"></i>启用</span>
                    
					</td>
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#providerlist").html(txt);
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
$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(".order1").on("click", function(){
    $(".order1").addClass("border-red");
    $(".order2").removeClass("border-red");
    $(".main-top li").eq(3).text("正常用户");
})
$(".order2").on("click", function(){
    $(".order2").addClass("border-red");
    $(".order1").removeClass("border-red");
    $(".main-top li").eq(3).text("停用用户");
})