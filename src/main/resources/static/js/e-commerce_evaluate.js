$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("membername")
		$("#username").append(txt);
})
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	$.ajax({
		type:"get",
		url:"/cart/cartall",
		data:{
			memberid:memberid,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			var all = data.all;
			$("#all").html("");
			var txt="";
			txt += all
			$("#all").append(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})
$(function(){
	//var providerid = sessionStorage.getItem("memberid");
	$.ajax({
		type:"get",
		url:"/business/bussinessorderlist",
		dataType:"json",
		
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderList = data.bussinessOrderList;
			$("#bussinessorderlist").html("");
			var txt = "";
			for(var i = 0; i < bussinessOrderList.length; i ++){
				if(bussinessOrderList[i].evaluate == null){
				txt += `<div class="article">
               <img src="" alt="图片" />
                <ul class="article-info">
					
                    <li>${bussinessOrderList[i].produt.serviceName}*${bussinessOrderList[i].orderNum}</li>
                    <li>${bussinessOrderList[i].produt.serviceInfo}</li>
                    <li>${bussinessOrderList[i].produt.providerName}</li>
                </ul>
                <p>购买时间：${format(bussinessOrderList[i].createTime)}</p>
                <p class="evaluate_btn" onclick="evaluate1('${bussinessOrderList[i].businessNo}')">去评价</p>
            </div>`
					
					
				}
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


$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
function evaluate1(business_no){
	console.log("评价",business_no);
	
    $(".masking").show();
    sessionStorage.setItem("business_no",business_no);
}
$(".save").on("click", function(event){
	var business_no = sessionStorage.getItem("business_no");
	console.log("开始评价",business_no);
	//var memberid = sessionStorage.getItem("memberid");
    var evaluate = $(".evaluate").val();
    $.ajax({
    	type:"post",
    	url:"/business/evaluateInsert",
    	data:{
    		evaluate:evaluate,
    		business_no:business_no,
    	},
    	dataType:"json",
    	success:function(data){
			console.log("成功返回的数据",data);	
			if(data.code == 1){
				$.ajax({
					type:"get",
					url:"/business/bussinessorderlist",
					dataType:"json",
					
					success:function(data){
						console.log("成功返回的数据",data);
						var bussinessOrderList = data.bussinessOrderList;
						$("#bussinessorderlist").html("");
						var txt = "";
						for(var i = 0; i < bussinessOrderList.length; i ++){
							if(bussinessOrderList[i].evaluate == null){
							txt += `<div class="article">
			               <img src="" alt="图片" />
			                <ul class="article-info">
								
			                    <li>${bussinessOrderList[i].produt.serviceName}*${bussinessOrderList[i].orderNum}</li>
			                    <li>${bussinessOrderList[i].produt.serviceInfo}</li>
			                    <li>${bussinessOrderList[i].produt.providerName}</li>
			                </ul>
			                <p>购买时间：${format(bussinessOrderList[i].createTime)}</p>
			                <p class="evaluate_btn" onclick="evaluate1('${bussinessOrderList[i].businessNo}')">去评价</p>
			            </div>`
								
								
							}
						}
						console.log(txt);
						// var tbody = $("<tbody></tbody>").html(txt);
						$("#bussinessorderlist").html(txt);
					},
					error:function(data){
						console.log("失败后返回的数据",data);
					}
				})
				
				 
			}else{
				alert("哈哈哈");
			}	
		}
    })
    $(".masking").hide();
    console.log("保存");
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})