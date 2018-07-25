package com.market.service.impl;

import com.market.mapper.SysUserInfoMapper;
import com.market.model.SysUserInfo;
import com.market.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {
    @Autowired
    SysUserInfoMapper sysUserInfoMapper;
    @Override
    public SysUserInfo selectByPrimaryKey(Map<String,Object> param) {
        return sysUserInfoMapper.selectByPrimaryKey(param);
    }
}
