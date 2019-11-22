$(".search-product").on("click", function () {
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function () {
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function (event) {
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".user-action a").on("click", function (event) {
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function (event) {
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(".content-banner li").eq(0).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").hide();
    $(".account-info").show();
})
$(".content-banner li").eq(1).on("click", function (event) {
    $(".content-banner li").removeClass("border-b1");
    $(event.target).addClass("border-b1");
    $(".change-password").show();
    $(".account-info").hide();
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("membername")
		$("#username").append(txt);
})
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	var membername = sessionStorage.getItem("membername");
	$("#userinfo").html("");
	var txt="";
	txt += `<img src="/member/headImg?id=${memberid}" onerror="defaultImg(this)" style="height:90px; width:100px;"/>
				<p>${membername}</p>`
	$("#userinfo").append(txt);
})
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	var membername = sessionStorage.getItem("membername");
	$("#account-info").html("");
	var txt = "";
	txt +=`<form action="/member/changemember" method="post" enctype ="multipart/form-data">
 <li>
                    <span>当前头像：</span>
                    <img src="/member/headImg?id=${memberid}" onerror="defaultImg(this)" style="height:90px; width:100px;"/>
                    <label for="file" class="btn btn-primary" style="height: 30px;width: 180px;margin-right: 20px;margin-left:30px">选择照片</label>
					<input  id="file" name="file" type="file" style="float: left;display:none"/>
					<input  name="id" type="hidden" value="${memberid}"/>
                </li>
                <li>
                    <span>性别：</span>
                    <input class="radio" type="radio" name="sex" checked="checked"  value=1 /> 男 
                    <input class="radio" type="radio" name="sex" checked="checked"  value=2 /> 女
                </li>
                <li>
                    <span>姓名：</span>
                    <input type="text" name= "name"/>
                </li>
                <li>
                    <span >邮箱：</span>
                    <input type="text" name="email"/>
                </li>
                <li>
                    <input type="submit" class="save" value="保存"></input>
                </li>
               
                </form>`
	$("#account-info").append(txt);
})
$(function(){
	var memberid = sessionStorage.getItem("memberid");
	var membername = sessionStorage.getItem("membername");
	$("#chang-password").html("");
	var txt = "";
	txt += ` <li>
                    <span>旧密码：</span>
                    <input type="text" name =" oldPassword" class="oldPassword" />
                </li>
                <li>
                    <span>新密码：</span>
                    <input type="text" name = "newPassword" class="newPassword"/>
                </li>
                <li>
                    <span>再次输入新密码：</span>
                    <input type="text" name="querenPassword" class="querenPassword"/>
                </li>
                <li>
                    <p class="save" onclick="save(${memberid})">保存</p>
                </li>`
	$("#chang-password").append(txt);
})
function save(memberid){
	var memberid = sessionStorage.getItem("memberid");
	var oldPassword = $(".oldPassword").val();
	var newPassword = $(".newPassword").val();
	var querenPassword = $(".querenPassword").val();
	
	console.log("旧密码:", oldPassword, "新密码：", newPassword, "确认密码：", querenPassword);
	
	 $.ajax({
		 type:"get",
	 	 url:"/member/changemima",
	 	 data:{
	 		memberid:memberid,
	 		oldPassword:oldPassword,
	 		newPassword:newPassword,
	 		querenPassword:querenPassword,
	 		
	 	 },
	 	dataType:"json",
    	success:function(data){
    		console.log("返回成功的数据：", data);
    		alert(data.mem);
    		$("#chang-password").html("");
    		var txt = "";
    		txt += ` <li>
    	                    <span>旧密码：</span>
    	                    <input type="text" name =" oldPassword" class="oldPassword" />
    	                </li>
    	                <li>
    	                    <span>新密码：</span>
    	                    <input type="text" name = "newPassword" class="newPassword"/>
    	                </li>
    	                <li>
    	                    <span>再次输入新密码：</span>
    	                    <input type="text" name="querenPassword" class="querenPassword"/>
    	                </li>
    	                <li>
    	                    <p class="save" onclick="save(${memberid})">保存</p>
    	                </li>`
    		$("#chang-password").append(txt);
    	}
	 })
}