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
/*
 * 用户名
 */
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("membername")
		$("#username").append(txt);
})
/*
 * 购物车数量
 */
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
/*
 * 加入购物车
 */
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
						console.log("成功返回的数据",data);
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
            <img src="/providerProdut/headImg?id=${providerProdutList[i].id}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
            <ul class="article-info">
                <li>${providerProdutList[i].serviceName}</li>
                <li>${providerProdutList[i].serviceInfo}</li>
                <li>${providerProdutList[i].providerName}</li>
            </ul>
            <ul class="article-price">
                <li>${providerProdutList[i].price}</li>
                <li>

                	    <a href="redirect?page=e-commerce_settlement1">立即购买</a>`
              sessionStorage.setItem("produtids", providerProdutList[i].id);
                   txt += `<span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
                </li>
            </ul>
        </div>
        <hr color="#ededed" size="1">`
									}
								
								$("#aaa").html(txt);
							},
							error:function(data){
								console.log("失败后返回的数据",data);
							}
						})
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
            <img src="/providerProdut/headImg?id=${providerProdutList[i].id}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
            <ul class="article-info">
                <li>${providerProdutList[i].serviceName}</li>
                <li>${providerProdutList[i].serviceInfo}</li>
                <li>${providerProdutList[i].providerName}</li>
            </ul>
            <ul class="article-price">
                <li>${providerProdutList[i].price}</li>
                <li>

                	    <a href="redirect?page=e-commerce_settlement1">立即购买</a>`
              sessionStorage.setItem("produtids", providerProdutList[i].id);
                   txt += `<span onclick="cartadd(${providerProdutList[i].id})">加入购物车</span>
                </li>
            </ul>
        </div>
        <hr color="#ededed" size="1">`
				}
			//console.log(txt);
			
//          <a href="redirect?page=e-commerce_settlement1">立即购买</a>
//		    <span onclick="buynow(${providerProdutList[i].id})">立即购买</span>
			
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#aaa").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
})
function buynow(produtid){
	var memberid = sessionStorage.getItem("memberid");
	var membername = sessionStorage.getItem("membername");
	$.ajax({
		type:"get",
		url:"/business/buynow",
		data:{
			produtid:produtid,
			memberid:memberid,
			membername:membername,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据：", data);
			console.log(produtid);
			location.href="redirect?page=e-commerce_settlement1";
		}
	})
}
