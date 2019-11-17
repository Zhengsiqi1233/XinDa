$(".payment li").eq(1).on("click", function(){
    location.href="redirect?page=e-commerce_order";
})
$(".radio1").on("click", function(){
	paytype = 1;
})
$(".radio2").on("click", function(){
	paytype = 2;
})
$(".radio3").on("click", function(){
	paytype = 3;
})

/*$(function(){
	var businessOrder = sessionStorage.getItem("businessOrder");
	$.ajax({
		type:"get",
		url:"/business/businesscartid",
		data:{
			businessOrder:businessOrder,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			
		}
	
	})
})*/
$(function (){
	function format(time){
		var date = new Date(time);
		return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}
	var memberid = sessionStorage.getItem("memberid");
	var membername = sessionStorage.getItem("membername");
	var sum = sessionStorage.getItem("sum");
	 var produtId = sessionStorage.getItem("produtId");
	$.ajax({
		type:"get",
		url:"/business/businesscart",
		data:{
			memberid:memberid,
			membername:membername,
			sum:sum,
			produtId:produtId,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			console.log("id" + produtId);
			var cart = data.cart;
			var list = data.list;
			var businessOrder = data.businessOrder;
			$("#main").html("");
			var txt = "";
			txt+=` 
			<ul class="merchandise"  id="merchandise"> <li>
                订单编号：<span class="font-aqua">${businessOrder[0].businessNo}</span>
            </li>
            <li>创建时间：${format(businessOrder[0].createTime)}</li>
				
				 <li>订单明细：`
				var aa = "";
				 for(var i = 0; i <cart.length; i ++){
					aa+=  cart[i].produtName + "*" + cart[i].buyNum + ",";
					 
				 }
				 aa = aa.substring(0, aa.lastIndexOf(","));
				 
				
				txt+=`${aa}</li>
            <li>订单总额：￥${sum}</li>
            </ul>
            <p class="product_num font-aqua">支付方式</p>
        <hr color="#ededed" size="1">
        <p class="font-size14">非网银支付</p>
        <img src="./images/yinlian.png" alt="">
        <input class="radio radio1" type="radio" name="pay" checked="checked"  value = 1>
        <p class="font-size14">平台支付</p>
        <img src="./images/weixin.png" alt="">
        <input class="radio radio2" type="radio" name="pay"  checked="checked"  value = 2>
        <img src="./images/zhifubao.png" alt="">
        <input class="radio radio3" type="radio" name="pay" checked="checked"  value =3>
        <ul class="payment" id = "payment">
<li>金额总计：<span>¥${sum}</span></li>
            <a href="redirect?page=e-commerce_order"><li onclick = "btn(${businessOrder[0].businessNo})" >支付</li></a>
            </ul>`
				console.log(txt);
				$("#main").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
})

/*$(function (){
	var sum = sessionStorage.getItem("sum");
	$("#payment").html("");
	var txt = "";
	txt+= `
	<ul class="payment" id = "payment">
<li>金额总计：<span>¥${sum}</span></li>
            <li onclick = "btn()" ><a href="redirect?page=e-commerce_product"/>支付</li>
            </ul>`
	console.log(txt);
	$("#payment").html(txt);
})
*/
function btn(businessNo){
	var val = $('input:radio:checked').val();
	console.log(val);
	$.ajax({
		type:"get",
		url:"/business/businesspay",
		data:{
			businessNo:businessNo,
			val:val,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			
		}
	})
}