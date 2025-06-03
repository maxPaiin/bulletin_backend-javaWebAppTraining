package org.example.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.common.Result;
import org.example.common.ResultCodeEnum;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.example.util.JwtHelper;
import org.example.util.MD5Util;
import org.example.util.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//MVC :from frontend data -> controller -> service -> DAO -> search database -> return message(result and status code) -> show to view

@WebServlet("/user/*")
public class UserController extends BaseController{
     private final UserService  userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user = WebUtil.readJson(req,User.class);
       Result result = null;
       User loginUser = userService.findByUserloginId(user.getLogin_id());

       if(null != loginUser){
           if(loginUser.getPassword().equals(MD5Util.encrypt(user.getPassword()))){
               Map<String,Object> data = new HashMap<>();
               String token = JwtHelper.createToken(loginUser.getUser_id().longValue());
               data.put("token",token);
               result = Result.ok(data);
           }else{
              result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
           }
       }else{
           result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
       }
       WebUtil.writeJson(resp,result);
    }

    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result<Object> result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        if(token != null && !token.isBlank()){
            if(!JwtHelper.isExpiration(token)){
                Integer user_id = JwtHelper.getUserId(token).intValue();
                User user = userService.findByUserId(user_id);
                if(user != null){
                    Map<String,Object> data = new HashMap<>();
                    user.setPassword(" ");
                    data.put("loginUser",user);
                    result = Result.ok(data);
                }
            }
        }
        WebUtil.writeJson(resp,result);
    }
}
