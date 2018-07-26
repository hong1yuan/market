$(function(){
    //func(xxx)//执行函数
    alert(111);
    var param = {};
    var url = "http://127.0.0.1:2000/indexl";
    marketRequestBase.doAjaxDX(param,url,function(data){
        if(data.code == "0"){
            alert(data.data.userName);
            alert("成功");
            $('#loginName').html(data.data.userName);

            // location.href="index.html?txt=11";//发送txt里面的内容

        }
    });
});