package com.ym.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class helloController extends Controller {
    @ActionKey("/aa")
    public void index1(){
        String aa=getPara(0);
        System.out.println(aa+"  ");
        renderText("hahaha");
    }
}
