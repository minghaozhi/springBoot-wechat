package com.sheshu.wechat.service;

import com.sheshu.wechat.menu.Menu;

import java.io.IOException;

/**
 * 董帮辉 2017-3-11.
 */
public interface MenuService {

    /**
     * 获取菜单
     * @return
     */
    Menu getMenu();

    /**
     * 创建菜单
     * @return
     * @throws IOException
     */
    Integer createMenu() throws IOException;

    /**
     * 查询菜单的json串
     * @return
     * @throws IOException
     */
    String queryMenu() throws IOException;

    /**
     * 删除菜单
     * @return
     * @throws IOException
     */
    Integer deleteMenu() throws IOException;
}
