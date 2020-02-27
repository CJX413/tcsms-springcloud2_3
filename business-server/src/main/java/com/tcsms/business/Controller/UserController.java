package com.tcsms.business.Controller;

import com.google.gson.JsonObject;
import com.tcsms.business.Entity.UserInfo;
import com.tcsms.business.Service.ReceiveServiceImp.UserInfoServiceImp;
import com.tcsms.business.Utils.JwtTokenUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
public class UserController {

    @Autowired
    UserInfoServiceImp userInfoServiceImp;

    @RequestMapping("userInfo")
    public String getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("authorization");
        String username = JwtTokenUtils.getUsername(token);
        UserInfo userInfo = userInfoServiceImp.findByUserName(username);
        return userInfo.toString();
    }

}
