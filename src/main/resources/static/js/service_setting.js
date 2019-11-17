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
$(".change-info").on("click", function(event){
    $(".masking").show();
})
$(".save").on("click", function(event){
    $(".masking").hide();
    console.log("保存");
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})

$(function(){
	var providerid = sessionStorage.getItem("providerid");
	$.ajax({
		type:"get",
		url:"/provider/providermessage",
		data:{
			providerid:providerid,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			var providerList =  data.providerList;
			var providerProvince = data.providerProvince;
			var providerCity = data.providerCity;
			var providerArea = data.providerArea;
			$("#main-content").html("");
			var txt = "";
		
			txt += `
			<div class="avatars">
                    <img th:src="@{/providerProdut/headImg?id=${providerid}}" onerror="defaultImg(this)"/><li>
                    <p>更换头像</p>
                </div>
                  <ul class="store-info" id= "store-info">
            <span>服务商名称</span>
            <span>${providerList[0].name}</span>
        </li>
        <li>
            <span>地区</span>
            <span>${providerProvince[0].name}-${providerCity[0].name}-${providerArea[0].name}</span>
        </li>
        <li>
            <span>手机号</span>
            <span>${providerList[0].cellphone}</span>
        </li>
        <li>
            <span>微信</span>
            <span>${providerList[0].wechat}</span>
        </li>
        <li>
            <span>QQ</span>
            <span>${providerList[0].qq}</span>
        </li>
        <li>
            <span>邮箱</span>
            <span>${providerList[0].email}</span>
        </li>
        <li>
            <button class="change-info">修改</button>
        </li>
        </ul>`
				console.log(txt);
			
			$("#main-content").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
		
	})
})
$(function(){
	$.ajax({
		type: "post",
		url: "/region/register",
		dataType: "json",
		success: function(data){
			var province = data.province;
			console.log("成功后返回的数据",province);
			$("#province").html("");
			txt="";
			txt +=`<option value="">省</option>`
			for(var i = 0;i<province.length;i++){
				txt +=`
                        <option onclick="provinceId('${province[i].id}')"  value="${province[i].id}">${province[i].name}</option>`
			}
			$("#province").append(txt);
			$("#city").html("");
			txt="";
			txt +=`<option value="">市</option>`
			$("#city").append(txt);
			$("#area").html("");
			txt="";
			txt +=`<option value="">区</option>`
			$("#area").append(txt);
			
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
})

function changeprovince(){
	var provinceId = $("#province").val();
	console.log("省",provinceId);
	$.ajax({
		type: "post",
		url: "/region/city",
		data:{
			provinceId:provinceId,
		},
		dataType: "json",
		success: function(data){
			var city = data.city;
			$("#city").html("");
			txt="";
			txt +=`<option value="">市</option>`
			for(var i = 0;i<city.length;i++){
				txt +=`
                        <option class="cityId" value="${city[i].id}">${city[i].name}</option>`
			}
			$("#city").append(txt);
			$("#area").html("");
			txt="";
			txt +=`<option value="">区</option>`
			$("#area").append(txt);
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
}


function changecity(){
	var cityId = $("#city").val();
	console.log("市id",cityId);
	$.ajax({
		type: "post",
		url: "/region/area",
		data:{
			cityId:cityId,
		},
		dataType: "json",
		success: function(data){
			var area = data.area;
			$("#area").html("");
			txt="";
			txt +=`<option value="">区</option>`
			for(var i = 0;i<area.length;i++){
				txt +=`
                        <option class="areaId" value="${area[i].id}">${area[i].name}</option>`
			}
			$("#area").append(txt);
			
		},
		error: function(data){
			console.log("失败后返回的数据",data);
		}
	})
}








