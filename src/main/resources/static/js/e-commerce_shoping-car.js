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
    $(".content-nav a").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
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
/*
 * 删除
 */
function delcart(produtId){
	console.log("删除： " + produtId);
	var memberid = sessionStorage.getItem("memberid");
	$.ajax({
		type:"get",
		url:"/cart/delcart",
		data:{
			produtId:produtId,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);
			if(data.code == 1){
				$.ajax({
					type:"get",
					url:"/cart/membercart",
					data:{
						memberid:memberid,
					},
					dataType:"json",
					success:function(data){
						console.log("成功返回的数据",data);	
						var memberCart = data.car;
						$("#memberCart").html("");
						var txt = "";
						for(var i = 0; i < memberCart.length; i ++){
						txt += `
						<p class="shop">店铺：${memberCart[i].name}</p>`
						for(var j = 0; j < memberCart[i].productlist.length ; j++){
							txt += `
			        <ul class="merchandise">
			            <li>
			                <img src="/providerProdut/headImg?id=${memberCart[i].productlist[j].produtId}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
			            </li>
			            <li>${memberCart[i].productlist[j].produtName}</li>
			            <li>${memberCart[i].productlist[j].price}</li>
			            <li>
			                <span onclick = "reducenum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">-</span>
			                <input class="order1" value="${memberCart[i].productlist[j].buyNum}" name="order1" id="order1" onblur="changenum('${memberCart[i].productlist[j].produtId}')"/>
			                <span  onclick = "addnum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">+</span>
			            </li>
			            <li>
			                ${memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum}
			            </li>
			            <li>
			                <span  onclick = "delcart('${memberCart[i].productlist[j].produtId}')">删除</span>
			            </li>
			        </ul>
			        `
					}
						}
						txt += `<ul class="price">
			            <li>金额合计<span>3242</span></li>
			            <li>
			                <a href="redirect?page=e-commerce_product">继续购物</a>
			                <a href="redirect?page=e-commerce_settlement">去结算</a>
			            </li>
			        </ul>`
			//console.log(txt);
						
						$("#memberCart").html(txt);
					},
					error:function(data){
						console.log("失败后返回的数据",data);
					}
				})
			}
		}
		
		})
}
/*
 * 减少
 */
function reducenum(produtId, name){
	console.log(produtId);
	var memberid = sessionStorage.getItem("memberid");
	var e = window.event;
	if($(e.target).next().val() <= 1){
		alert("数量不能小于1");
	}else{
		$(e.target).next().val($(e.target).next().val()-1);	
	}
	var orderNum = $(e.target).next().val();
	console.log(orderNum);
	
	
	$.ajax({
		type:"get",
		url:"/cart/reducenum",
		data:{
			produtId:produtId,
			orderNum:orderNum,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			$.ajax({
				type:"get",
				url:"/cart/membercart",
				data:{
					memberid:memberid,
				},
				dataType:"json",
				success:function(data){
					console.log("成功返回的数据",data);	
					var memberCart = data.car;
					$("#memberCart").html("");
					var txt = "";
					for(var i = 0; i < memberCart.length; i ++){
					txt += `
					<p class="shop">店铺：${memberCart[i].name}</p>`
					for(var j = 0; j < memberCart[i].productlist.length ; j++){
						txt += `
		        <ul class="merchandise">
		            <li>
		                <img src="/providerProdut/headImg?id=${memberCart[i].productlist[j].produtId}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
		            </li>
		            <li>${memberCart[i].productlist[j].produtName}</li>
		            <li>${memberCart[i].productlist[j].price}</li>
		            <li>
		                <span onclick = "reducenum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">-</span>
		                <input class="order1" value="${memberCart[i].productlist[j].buyNum}" name="order1" id="order1" onblur="changenum('${memberCart[i].productlist[j].produtId}')"/>
		                <span  onclick = "addnum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">+</span>
		            </li>
		            <li>
		                ${memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum}
		            </li>
		            <li>
		                <span  onclick = "delcart('${memberCart[i].productlist[j].produtId}')">删除</span>
		            </li>
		        </ul>
		        `
				}
					}
					txt += `<ul class="price">
		            <li>金额合计<span>3242</span></li>
		            <li>
		                <a href="redirect?page=e-commerce_product">继续购物</a>
		                <a href="redirect?page=e-commerce_settlement">去结算</a>
		            </li>
		        </ul>`
		//console.log(txt);
					
					$("#memberCart").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
			})

		}
	})
	
}
/*
 * 增加
 */
function addnum(produtId, name){
	console.log(produtId);
	var memberid = sessionStorage.getItem("memberid");
	var e = window.event;
	var sum = 0;
	
	$(e.target).prev().val(+$(e.target).prev().val()+1);	
	var orderNum = $(e.target).prev().val();
	console.log(orderNum);
	
	$.ajax({
		type:"get",
		url:"/cart/reducenum",
		data:{
			produtId:produtId,
			orderNum:orderNum,
			
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			$.ajax({
				type:"get",
				url:"/cart/membercart",
				data:{
					memberid:memberid,
				},
				dataType:"json",
				success:function(data){
					console.log("成功返回的数据",data);	
					var memberCart = data.car;
					$("#memberCart").html("");
					var txt = "";
					for(var i = 0; i < memberCart.length; i ++){
					txt += `
					<p class="shop">店铺：${memberCart[i].name}</p>`
					for(var j = 0; j < memberCart[i].productlist.length ; j++){
						var sum1 = memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum;
						sum += memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum;
						txt += `
		        <ul class="merchandise">
		            <li>
		                <img src="/providerProdut/headImg?id=${memberCart[i].productlist[j].produtId}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
		            </li>
		            <li>${memberCart[i].productlist[j].produtName}</li>
		            <li>${memberCart[i].productlist[j].price}</li>
		            <li>
		                <span onclick = "reducenum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">-</span>
		                <input class="order1" value="${memberCart[i].productlist[j].buyNum}" name="order1" id="order1" onblur="changenum('${memberCart[i].productlist[j].produtId}')"/>
		                <span  onclick = "addnum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">+</span>
		            </li>
		            <li>
		                ${memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum}
		            </li>
		            <li>
		                <span  onclick = "delcart('${memberCart[i].productlist[j].produtId}')">删除</span>
		            </li>
		        </ul>
		        `
				}
					}
					txt += `<ul class="price">
		            <li>金额合计<span>￥${sum}</span></li>
		            <li>
		                <a href="redirect?page=e-commerce_product">继续购物</a>
		                <a href="redirect?page=e-commerce_settlement">去结算</a>
		            </li>
		        </ul>`
		//console.log(txt);
					
					$("#memberCart").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
			})
		}
	})
	
}

/*
 * 手动输入数量
 */
function changenum(produtId){
	console.log(produtId);
	var memberid = sessionStorage.getItem("memberid");
	var e = window.event;
	console.log($(e.target).val());
	var orderNum = $(e.target).val();
	console.log(orderNum);
	
	$.ajax({
		type:"get",
		url:"/cart/reducenum",
		data:{
			produtId:produtId,
			orderNum:orderNum,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			$.ajax({
				type:"get",
				url:"/cart/membercart",
				data:{
					memberid:memberid,
				},
				dataType:"json",
				success:function(data){
					console.log("成功返回的数据",data);	
					var memberCart = data.car;
					$("#memberCart").html("");
					var txt = "";
					for(var i = 0; i < memberCart.length; i ++){
					txt += `
					<p class="shop">店铺：${memberCart[i].name}</p>`
					for(var j = 0; j < memberCart[i].productlist.length ; j++){
						txt += `
		        <ul class="merchandise">
		            <li>
		                <img src="/providerProdut/headImg?id=${memberCart[i].productlist[j].produtId}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
		            </li>
		            <li>${memberCart[i].productlist[j].produtName}</li>
		            <li>${memberCart[i].productlist[j].price}</li>
		            <li>
		                <span onclick = "reducenum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">-</span>
		                <input class="order1" value="${memberCart[i].productlist[j].buyNum}" name="order1" id="order1" onblur="changenum('${memberCart[i].productlist[j].produtId}')"/>
		                <span  onclick = "addnum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">+</span>
		            </li>
		            <li>
		                ${memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum}
		            </li>
		            <li>
		                <span  onclick = "delcart('${memberCart[i].productlist[j].produtId}')">删除</span>
		            </li>
		        </ul>
		        `
				}
					}
					txt += `<ul class="price">
		            <li>金额合计<span>3242</span></li>
		            <li>
		                <a href="redirect?page=e-commerce_product">继续购物</a>
		                <a href="redirect?page=e-commerce_settlement">去结算</a>
		            </li>
		        </ul>`
		//console.log(txt);
					
					$("#memberCart").html(txt);
				},
				error:function(data){
					console.log("失败后返回的数据",data);
				}
			})
		}
	})
}
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	var produtId;
	var num ;
	var sum = 0;
	$.ajax({
		type:"get",
		url:"/cart/membercart",
		data:{
			memberid:memberid,
			produtId:produtId,
			num:num,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			var memberCart = data.car;
			$("#memberCart").html("");
			var txt = "";
			for(var i = 0; i < memberCart.length; i ++){
			txt += `
			<p class="shop">店铺：${memberCart[i].name}</p>`
			for(var j = 0; j < memberCart[i].productlist.length ; j++){
				var sum1 = memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum;
				sum += memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum;
				 sessionStorage.setItem("sum",sum);
				 produtId = memberCart[i].productlist[j].produtId;
				 sessionStorage.setItem("produtId",produtId);
				 console.log(produtId);
				 num = memberCart[i].productlist[j].buyNum;
				 console.log(num);
				txt += `
        <ul class="merchandise">
            <li>
                <img src="/providerProdut/headImg?id=${memberCart[i].productlist[j].produtId}" onerror="defaultImg(this)"/>
<script>
	function defaultImg(img){
		img.src="/images/user-lg.png";
	}
</script>
            </li>
            <li>${memberCart[i].productlist[j].produtName}</li>
            <li>${memberCart[i].productlist[j].price}</li>
            <li>
                <span onclick = "reducenum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">-</span>
                <input class="order1" value="${memberCart[i].productlist[j].buyNum}" name="order1" id="order1" onblur="changenum('${memberCart[i].productlist[j].produtId}')"/>
                <span  onclick = "addnum('${memberCart[i].productlist[j].produtId}', '${memberCart[i].productlist[j].buyNum}')">+</span>
            </li>
            <li>
                ${memberCart[i].productlist[j].price*memberCart[i].productlist[j].buyNum}
            </li>
            <li>
                <span  onclick = "delcart('${memberCart[i].productlist[j].produtId}')">删除</span>
            </li>
        </ul>
       
        
        `
		}	
			}
			txt += `<ul class="price">
            <li>金额合计<span>${sum}</span></li>
            <li>
                <a href="redirect?page=e-commerce_product">继续购物</a>
                <a href="redirect?page=e-commerce_settlement">去结算</a>
            </li>
        </ul>`

			
			$("#memberCart").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
})