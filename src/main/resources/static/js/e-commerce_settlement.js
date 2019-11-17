$(function(){
	var business_no = sessionStorage.getItem("business_no");
	$.ajax({
		type:"get",
		url:"/business/bussinessorderpay",
		dataType:"json",
		data:{
			business_no:business_no,
			/*pagenum:20,
			pagesize:1,*/
		},
		success:function(data){
			console.log("成功返回的数据",data);
			var bussinessOrderPay = data.bussinessOrderPay;
			$("#bussinessorderpay").html("");
			var txt = "";
				txt += `<div class="content width1200">
        <p class="product_num font-aqua">订单详情</p>
        <hr color="#ededed" size="1">
        <ul class="merchandise">
            <li>
                订单编号：<span class="font-aqua">sessionStorage.getItem("business_no")</span>
            </li>
            <li>创建时间：${format(bussinessOrderPay.createTime)}</li>
            <li>订单总额：¥${bussinessOrderPay.orderSum}</li>
        </ul>
        <p class="product_num font-aqua">支付方式</p>
        <hr color="#ededed" size="1">
        <p class="font-size14">非网银支付</p>
        <img src="./images/yinlian.png" alt="">
        <input class="radio radio1" type="radio" name="pay">
        <p class="font-size14">平台支付</p>
        <img src="./images/weixin.png" alt="">
        <input class="radio radio2" type="radio" name="pay">
        <img src="./images/zhifubao.png" alt="">
        <input class="radio radio3" type="radio" name="pay">
        <ul class="payment">
            <li>金额总计：<span>¥${bussinessOrderList[i].orderSum}</span></li>
            <li>支付</li>
        </ul>
    </div>`
			
				
			console.log(txt);
			// var tbody = $("<tbody></tbody>").html(txt);
			$("#bussinessorderpay").html(txt);
		},
		error:function(data){
			console.log("失败后返回的数据",data);
		}
	})
	
})

$(".payment li").eq(1).on("click", function(){
    location.href="redirect?page=e-commerce_order";
})
