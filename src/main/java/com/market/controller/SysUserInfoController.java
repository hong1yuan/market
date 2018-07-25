package com.market.controller;

import com.market.model.Result;
import com.market.model.SysUserInfo;
import com.market.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RestController
public class SysUserInfoController {
    @Autowired
    SysUserInfoService sysUserInfoService;

    @RequestMapping(value = "/loginUser")
    //public Map<String, Object> loginUser(String loginName, String loginPassword,HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Origin", "*");
    public Result loginUser(String loginName, String loginPassword, HttpServletRequest request){
        HashMap<String, Object> param = new HashMap<>();
        param.put("loginName",loginName);
        param.put("loginPassword",loginPassword);
        SysUserInfo sysUserInfo = sysUserInfoService.selectByPrimaryKey(param);
        Result result = new Result(Result.success,sysUserInfo);
        //创建session
        HttpSession session = request.getSession();
        //存session
        request.getSession().setAttribute("sysUserInfo", sysUserInfo);
        //return sysUserInfo;
        //Map<String, Object> callback = new HashMap<>();
        //callback.put("success","true");
        return result;
    }

    @RequestMapping(value = "/indexl")
    public Result index(HttpServletRequest request){
        //创建session
        HttpSession session = request.getSession();
        //获取session中的user
        SysUserInfo sysUserInfo = (SysUserInfo)session.getAttribute("sysUserInfo");
        Result result = new Result(Result.success,sysUserInfo);
        return result;

    }
}
