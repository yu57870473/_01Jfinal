package com.ym.Routes;

import com.jfinal.config.Routes;
import com.ym.controller.AdminController;

public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/admin", AdminController.class);
    }
}
