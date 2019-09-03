package com.ym.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.render.ViewType;
import com.ym.Routes.AdminRoutes;
import com.ym.Routes.FrontRoutes;
import com.ym.vo.Users;


public class myConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        //开发者模式,在控制台打印调用信息
        constants.setDevMode(true);
        //设置返回的视图类型
        constants.setViewType(ViewType.JSP);
        //设置上传后保存文件的路径
        constants.setBaseUploadPath("up");
    }

    @Override
    public void configRoute(Routes routes) {
        //分离路由,前端与管理员路由分开管理
        routes.add(new FrontRoutes());
        routes.add(new AdminRoutes());
    }

    @Override
    public void configPlugin(Plugins plugins) {
        PropKit.use("db.properties");
        DruidPlugin druid=new DruidPlugin(PropKit.get("jdbcUrl"),PropKit.get("username"),PropKit.get("password"));
        druid.addFilter(new StatFilter());
        WallFilter wallFilter=new WallFilter();
        wallFilter.setDbType("mysql");
        druid.addFilter(wallFilter);
        druid.setTestOnBorrow(true);
        druid.setTestOnReturn(true);
        plugins.add(druid);

        ActiveRecordPlugin arp=new ActiveRecordPlugin(druid);
        arp.setShowSql(true);
        arp.addMapping("users", Users.class);
        plugins.add(arp);

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {
        DruidStatViewHandler druidHandler=new DruidStatViewHandler("/druid");
        handlers.add(druidHandler);
    }
}
