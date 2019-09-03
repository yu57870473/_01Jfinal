package com.ym.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.ym.vo.Users;

import java.util.List;

public class IndexController extends Controller {
    public void list1(){
        //使用Db+ Record模式,这样不用写实体类,虽然简便,但是前端返回的视图字段必须与数据库一致,
        // 当需要自定义视图的时候(如树形),则需要自己重新封装数据
        List<Record> list= Db.find("select * from users");
        System.out.println(list);
        setAttr("list",list);
        setSessionAttr("msg","success!!");
        render("/WEB-INF/jsp/success.jsp");
    }
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
        String birthday=getPara("birthday");
        Boolean flag=new Users().set("username",username).set("password",password).set("salt","ym").set("birthday",birthday).save();
        if(flag){
            setSessionAttr("msg","success!!");
            render("/WEB-INF/jsp/success.jsp");
        }
    }

}
