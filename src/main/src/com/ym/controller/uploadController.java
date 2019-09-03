package com.ym.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class uploadController extends Controller {
 public void index(){
     UploadFile file=getFile("file");
     render("/WEB-INF/jsp/success.jsp");
 }
}
