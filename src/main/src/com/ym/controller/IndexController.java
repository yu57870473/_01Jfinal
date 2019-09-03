package com.ym.controller;

import com.jfinal.core.Controller;
import com.ym.vo.Users;

import java.util.List;

public class IndexController extends Controller {
    public void list(){
        List<Users> list=Users.dao.find("select * from users");
        System.out.println(list);
        setAttr("list",list);
        setSessionAttr("msg","success!!");
        render("/WEB-INF/jsp/success.jsp");
    }
    public void save(){
        String username=getPara("username");
        String password=getPara("password");
        Boolean flag=new Users().set("username",username).set("password",password).set("salt","ym").save();
        if(flag){
            setSessionAttr("msg","success!!");
            render("/WEB-INF/jsp/success.jsp");
        }
    }

}
