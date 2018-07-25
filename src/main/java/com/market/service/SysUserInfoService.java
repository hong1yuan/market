package com.market.service;

import com.market.model.SysUserInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface SysUserInfoService {
    SysUserInfo selectByPrimaryKey(Map<String,Object> param);
}
