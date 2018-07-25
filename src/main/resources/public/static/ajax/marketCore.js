var marketRequest = {
    requestRootPath: "http://127.0.0.1:8080/market",
    // requestAPI: "api",
    // requestVersion: "v1",
    createUrl: function (method) {
        return this.requestRootPath + "/"  + method;
    },
    getProject: function (param, callback) {
        var url = this.createUrl("test/getProject");
        marketRequestBase.doAjax(param, url, callback);
    },
    getCadition : function(param,callback){
    	var url = this.createUrl("test/getCondition");
    	marketRequestBase.doAjaxDX(param,url,callback);
    }
}

var marketRequestBase = {
    doAjax: function (param, url, callback) {
        $.ajax({
            type: 'POST',
            url: url,
            data: param,
            success: function (data) {
            		marketCommon.vailUser(data);
                if (typeof callback == "function")
                    callback(data);
            },
            error: function (exception, status, errorText) {
                console.log('数据获取异常，请稍后再试！' + errorText);
            }
        });
    },
    doAjaxDX: function (param, url, callback) {
        $.ajax({
            type: 'POST',
            url: url,
            data: param,
            async : false,
            //dataType:"jsonp",    //跨域json请求一定是jsonp
            //jsonp: "jsonpCallback",    //跨域请求的参数名，默认是callback
            //jsonpCallback:"success_jsonpCallback",
            crossDomain:true,
            xhrFields: {  withCredentials: true  },
            success: function (data) {
                //alert(JSON.stringify( data));
                marketCommon.vailUser(data);
                if (typeof callback == "function")
                    callback(data);
            },
            error: function (exception, status, errorText) {
                console.log('数据获取异常，请稍后再试！' + errorText);
            }
        });
    },
    doGetAjax: function (param,url,callback) {
    		$.ajax({
    			type:"GET",
    			url:url,
    			async:true,
    			success: function (data) {
    				marketCommon.vailUser(data);
    				if (typeof callback == "function")
    					callback(data);
    			},
    			error: function (exception, status, errorText) {
    				console.log('数据获取异常，请稍后再试！' + errorText);
    			}
    		});
    }

};
var marketCommon = {
    getUrlParam: function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    },
    delQueStr: function (url, ref) //删除参数值
    {
        if (url.indexOf('#') != -1) {
            url = url.substr(0, url.indexOf('#'));
        }
        var str = "";

        if (url.indexOf('?') != -1)
            str = url.substr(url.indexOf('?') + 1);
        else
            return url;
        var arr = "";
        var returnurl = "";
        var setparam = "";
        if (str.indexOf('&') != -1) {
            arr = str.split('&');
            for (i in arr) {
                if (arr[i].split('=')[0] != ref) {
                    returnurl = returnurl + arr[i].split('=')[0] + "=" + arr[i].split('=')[1] + "&";
                }
            }
            return url.substr(0, url.indexOf('?')) + "?" + returnurl.substr(0, returnurl.length - 1);
        }
        else {
            arr = str.split('=');
            if (arr[0] == ref)
                return url.substr(0, url.indexOf('?'));
            else
                return url;
        }
    },
    vailUser: function(data) {
    		if (data != null && data != '') {
    			if (data.isVailUser != null && data.isVailUser) {
    				window.location.href = '';
    			} 
    		}
    }
}

function getUrlParam(name) {
    return marketCommon.getUrlParam(name);
}
function delQueStr(url, ref) //删除参数值
{
    return marketCommon.delQueStr(url, ref);
}