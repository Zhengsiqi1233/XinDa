/*
 * 通过价格排序的所有产品
 */
$(".byprice").on("click",function(){
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

			$.ajax({
				type:"get",
				url:"/providerProdut/providerprodutlistbyprice", 
				data:{
					pagenum:20,
					pagesize:1,
				},
				dataType:"json",
				
				success:function(data){
					console.log("成功返回的数据",data);
					
					var providerProdutList = data.providerProdutListByPrice;
					$("#aaa").html("");
					var txt = "";
					for(var i = 0; i < providerProdutList.length; i ++){
						txt += `<div class="article">
				            <img src="" alt="图片" />
				            <ul class="article-info">
				                <li>${providerProdutList[i].serviceName}</li>
				                <li>${providerProdutList[i].serviceInfo}</li>
				                <li>${providerProdutList[i].provider.name}</li>
				            </ul>
				            <ul class="article-price">
				                <li>${providerProdutList[i].price}</li>
				                <li>
				                    <a href="redirect?page=e-commerce_settlement">立即购买</a>
				                    <span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
				                </li>
				            </ul>
				        </div>
				        <hr color="#ededed" size="1">`
						}
					console.log(txt);
					
					$("#aaa").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
		})
})
/*
 * 综合排序
 */
$(".byall").on("click",function(){
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}

			$.ajax({
				type:"get",
				url:"/providerProdut/providerprodutlist", 
				data:{
					pagenum:20,
					pagesize:1,
				},
				dataType:"json",
				
				success:function(data){
					console.log("成功返回的数据",data);
					
					var providerProdutList = data.providerProdutList;
					$("#aaa").html("");
					var txt = "";
					for(var i = 0; i < providerProdutList.length; i ++){
						txt += `<div class="article">
				            <img src="" alt="图片" />
				            <ul class="article-info">
				                <li>${providerProdutList[i].serviceName}</li>
				                <li>${providerProdutList[i].serviceInfo}</li>
				                <li>${providerProdutList[i].provider.name}</li>
				            </ul>
				            <ul class="article-price">
				                <li>${providerProdutList[i].price}</li>
				                <li>
				                    <a href="redirect?page=e-commerce_settlement">立即购买</a>
				                    <span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
				                </li>
				            </ul>
				        </div>
				        <hr color="#ededed" size="1">`
						}
					console.log(txt);
					
					$("#aaa").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
		})
})
/*
 * 通过产品的名称查询
 */
$(".product").on("click",function(){
$(".search-btn").on("click",function(){
            	var value=$(".searchlist").val();
            	/*var providerid = sessionStorage.getItem("providerid");
            	function format(time){
            		var date = new Date(time);
            		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
            	}*/

            			$.ajax({
            				type:"get",
            				url:"/providerProdut/providerprodutpage", 
            				data:{
            					//providerid:providerid,
            					service_name:value,
            					pagenum:20,
            					pagesize:1,
            				},
            				dataType:"json",
            				
            				success:function(data){
            					console.log("成功返回的数据",data);
            					
            					var providerProdutList = data.providerProdutPage;
            					$("#aaa").html("");
            					var txt = "";
            					for(var i = 0; i < providerProdutList.length; i ++){
            						txt += `<div class="article">
            				            <img src="" alt="图片" />
            				            <ul class="article-info">
            				                <li>${providerProdutList[i].serviceName}</li>
            				                <li>${providerProdutList[i].serviceInfo}</li>
            				                <li>${providerProdutList[i].provider.name}</li>
            				            </ul>
            				            <ul class="article-price">
            				                <li>${providerProdutList[i].price}</li>
            				                <li>
            				                    <a href="redirect?page=e-commerce_settlement">立即购买</a>
            				                    <span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
            				                </li>
            				            </ul>
            				        </div>
            				        <hr color="#ededed" size="1">`
            						}
            					console.log(txt);
            					
            					$("#aaa").html(txt);
            				},
            				error:function(data){
            					console.log("失败后返回的数据",data);
            				}
            		})
            })
})
/*
 * 根据服务商查询
 */
$(".provider").on("click",function(){
$(".search-btn").on("click",function(){
            	var value=$(".searchlist").val();
            			$.ajax({
            				type:"get",
            				url:"/providerProdut/providerprodutlikebyprovidername", 
            				data:{
            					provider_name:value,
            					pagenum:20,
            					pagesize:1,
            				},
            				dataType:"json",
            				
            				success:function(data){
            					console.log("成功返回的数据",data);
            					
            					var providerProdutList = data.ProviderProdutBy;
            					$("#aaa").html("");
            					var txt = "";
            					for(var i = 0; i < providerProdutList.length; i ++){
            						txt += `<div class="article">
            				            <img src="" alt="图片" />
            				            <ul class="article-info">
            				                <li>${providerProdutList[i].provider.name}</li>
            				                <li>${providerProdutList[i].provider.providerInfoMember}</li>
            				                <li>客服电话：${providerProdutList[i].provider.tel}</li>
            				            </ul>
            				            <ul class="article-price">
            				                <li>      </li>
            				                <li>
                                        <span onclick="showproduct(${providerProdutList[i].id})">立即进入店铺</span>            				 
            				                </li>
            				            </ul>
            				        </div>
            				        <hr color="#ededed" size="1">`
            						}
            					console.log(txt);
            					
            					$("#aaa").html(txt);
            				},
            				error:function(data){
            					console.log("失败后返回的数据",data);
            				}
            		})
            })
})
function showproduct(providerId)
{
	console.log("点击进入",providerId);
	$.ajax({
		type:"get",
		url:"/providerProdut/providerprodutbyclick", 
		data:{
			providerId:providerId,
		},
		dataType:"json",
		
		success:function(data){
			console.log("成功返回的数据",data);
			
			var providerProdutList = data.ProviderProdutByClick;
			$("#aaa").html("");
			var txt = "";
			for(var i = 0; i < providerProdutList.length; i ++){
				txt += `<div class="article">
		            <img src="" alt="图片" />
		            <ul class="article-info">
		                <li>${providerProdutList[i].serviceName}</li>
		                <li>${providerProdutList[i].serviceInfo}</li>
		                <li>${providerProdutList[i].providerName}</li>
		            </ul>
		            <ul class="article-price">
		                <li>${providerProdutList[i].price}</li>
		                <li>
		                    <a href="redirect?page=e-commerce_settlement">立即购买</a>
		                    <span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
		                </li>
		            </ul>
		        </div>
		        <hr color="#ededed" size="1">`
				}
			console.log(txt);
			
			$("#aaa").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
})
	
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

$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("membername")
		$("#username").append(txt);
})
function cartadd(id){
	var memberid = sessionStorage.getItem("memberid");
	console.log("添加商品 ：",id);
	$.ajax({
		type:"get",
					url:"/cart/cartadd",
					data:{
						id:id,
						memberid:memberid,
					}, 
					dataType:"json",
					success:function(data){
						
					}
	})
}
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
			$("#aaa").html("");
			var txt = "";
			for(var i = 0; i < providerProdutList.length; i ++){
				txt += `<div class="article">
            <img src="" alt="图片" />
            <ul class="article-info">
                <li>${providerProdutList[i].serviceName}</li>
                <li>${providerProdutList[i].serviceInfo}</li>
                <li>${providerProdutList[i].provider.name}</li>
            </ul>
            <ul class="article-price">
                <li>${providerProdutList[i].price}</li>
                <li>
                    <a href="redirect?page=e-commerce_settlement">立即购买</a>
                    <span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
                </li>
            </ul>
        </div>
        <hr color="#ededed" size="1">`
				}
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#aaa").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
})
