$(".user-arrow-down").on("click",function(){
    if($(".dropdown").is(":hidden")){
        $(".dropdown").show();
 }else{
       $(".dropdown").hide();
 }
})
$(function(){
		$("#username").html("");
		var txt="";
		txt += sessionStorage.getItem("providername")
		$("#username").append(txt);
})
<<<<<<< Updated upstream
$(function(){
	var providerid = sessionStorage.getItem("providerid");
	$("#store-info1").html("");
	var txt = "";
	txt += `<form action="/provider/saveUserImg" method="post" enctype ="multipart/form-data">
    <label for="file" class="btn btn-primary" style="float: left;height: 30px;width: 180px;margin-right: 20px">选择照片</label>
    <input  id="file" name="file" type="file" style="float: left;display:none"/>
    <input  name="providerid" type="hidden" value="${providerid}"/>
    <input  class="btn btn-primary" type="submit" value="提交" style="float: left">
</form>
            
           <img th:src="@{/provider/headImg?id=${providerid}}" onerror="defaultImg(this)"/>`
		
		console.log(txt);
	
	$("#store-info1").html(txt);
})
function defaultImg(img){
		img.src="/images/user-lg.png";
	}

$(function(){
	var providerid = sessionStorage.getItem("providerid");
	$.ajax({
		type:"get",
		url:"/provider/providerstore",
		data:{
			providerid:providerid,
		},
		dataType:"json",
		success:function(data){
			console.log("成功返回的数据",data);	
			var providerStore =  data.providerStore;
			$("#store-info").html("");
			var txt = "";
			txt += ` <li>
                    <span>公司介绍</span>
                    <textarea >${providerStore[0].providerInfoUser}</textarea>
                </li>
                <li>
                    <span>工作时间</span>
                    <select>
                        <option value="">周一到周五</option>
                        <option value="">周一到周四</option>
                    </select>
                </li>
                <li>
                    <span>QQ</span>
                    <input placeholder="请输入QQ"  value = "${providerStore[0].qq}"/ >
                </li>
                <li>
                    <span>联系电话</span>
                    <input placeholder="请输入联系电话" value = "${providerStore[0].tel}" /> <i> (固定电话的填写格式：01012345678)</i>
                </li>`
	console.log(txt);
			
			$("#store-info").html(txt);
		}
	})
		
})
=======
>>>>>>> Stashed changes
