$(function(){
	$.ajax({
		type:"get",
		url:"/providerProdut/providerprodutlist",
		dataType:"json",
		data:{
			pagenum:20,
			pagesize:1,
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var providerProdutList = data.providerProdutList;
			$("#providerprodutlist").html("");
			var txt = "";
			for(var i = 0; i < providerProdutList.length; i ++){
				txt += `<tr>
					<td>${providerProdutList[i].serviceName}</td>
					<td>${providerProdutList[i].serviceContent}</td>
					<td>${providerProdutList[i].salesNum}</td>
					<td>${providerProdutList[i].providerName}</td>
					<td>¥${providerProdutList[i].price}</td>
					<td><input class="checkbox" type="checkbox" /></td>
                    <td><input class="checkbox" type="checkbox" /></td>
				</tr>`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#providerprodutlist").html(txt);
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
$(".sort li").eq(0).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".sort li").eq(1).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})
$(".sort li").eq(2).on("click", function () {
    $(".sort li").removeClass("font-red");
    $(this).addClass("font-red");
})