package com.ym.Routes;

import com.jfinal.config.Routes;
import com.ym.controller.IndexController;
import com.ym.controller.helloController;
import com.ym.controller.uploadController;

public class FrontRoutes extends Routes {
    @Override
    public void config() {
        add("/", IndexController.class);
        add("/bb", helloController.class);
        add("/upload", uploadController.class);
    }
}
