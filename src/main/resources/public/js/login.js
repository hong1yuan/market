function login(){
        var username = $("#username").val(); 
        var password = $("#password").val();
        alert(username);
        alert(password);
        var param = {
            "loginName": username,
            "loginPassword": password
        };
        var url = "http://127.0.0.1:2000/loginUser";

        marketRequestBase.doAjaxDX(param,url,function(data){
            if(data.code == "0"){
                alert(data.data.userName);
                alert("成功");
                location.href="index.html?txt=11";//发送txt里面的内容
            }
        });
    
    }