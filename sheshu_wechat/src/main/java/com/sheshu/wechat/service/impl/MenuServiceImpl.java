package com.sheshu.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.utils.UrlRequestUtils;
import com.sheshu.wechat.menu.Button;
import com.sheshu.wechat.menu.ClickButton;
import com.sheshu.wechat.menu.Menu;
import com.sheshu.wechat.menu.ViewButton;
import com.sheshu.wechat.service.MenuService;
import com.sheshu.wechat.service.WeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 董帮辉 2017-3-11.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private WeChatService weChatService;

    @Override
    public Menu getMenu(){
        /*Menu menu = new Menu();
        ClickButton but11 = new ClickButton();
        but11.setName("click菜单");
        but11.setType("click");
        but11.setKey("11");

        ViewButton but21 = new ViewButton();
        but21.setName("view菜单");
        but21.setType("view");
        but21.setUrl("http://www.baidu.com");

        ClickButton but31 = new ClickButton();
        but31.setName("扫码事件");
        but31.setType("scancode_push");
        but31.setKey("31");

        ClickButton but32 = new ClickButton();
        but32.setName("地理位置");
        but32.setType("location_select");
        but32.setKey("32");

        Button button = new Button();
        button.setName("菜单");
        button.setSub_button(new Button[]{but31, but32});

        menu.setButton(new Button[]{but11, but21, button});*/

        //获取服务器地址
        String serverUrl = weChatConfigProperties.getServerUrl();
        
        //获取微信视图地址
        String clickToUrl = weChatConfigProperties.getClickToUrl();

        //点击按钮(二级菜单)
        ClickButton but11 = new ClickButton();
        but11.setName("企业介绍😎");
        but11.setType("click");
        but11.setKey("11");
        ClickButton but12 = new ClickButton();
        but12.setName("资费介绍");
        but12.setType("click");
        but12.setKey("12");
        ClickButton but13 = new ClickButton();
        but13.setName("网点查询");
        but13.setType("click");
        but13.setKey("13");
        ClickButton but14 = new ClickButton();
        but14.setName("联系电话");
        but14.setType("click");
        but14.setKey("14");

        ViewButton but21 = new ViewButton();
        but21.setName("用户缴费");
        but21.setType("view");
        but21.setUrl(clickToUrl.replace("APPID",weChatConfigProperties.getAppId()).replace("REDIRECT_URI",serverUrl+"/weChatView/helloHtml"));

        //父菜单(一级菜单)
        Button button1 = new Button();
        button1.setName("企业信息");
        button1.setSub_button(new Button[]{but11, but12,but13,but14});

        Button button2 = new Button();
        button2.setName("缴费");
        button2.setSub_button(new Button[]{but21});

        Menu menu = new Menu();
        menu.setButton(new Button[]{button1,button2});
        return menu;


    }

    @Override
    public Integer createMenu() throws IOException {
        logger.info("创建菜单");
        Integer errcode = 0;
        String createMenuUrl = weChatConfigProperties.getCreateMenuUrl();
        createMenuUrl = createMenuUrl.replace("ACCESS_TOKEN",this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtils.sendPost(createMenuUrl, MAPPER.writeValueAsString(getMenu()));
        if(!StringUtils.isEmpty(result)){
            Map map = MAPPER.readValue(result, Map.class);
            errcode = (Integer) map.get("errcode");
        }
        return errcode;
    }

    @Override
    public String queryMenu() throws IOException {
        String queryMenuUrl = weChatConfigProperties.getQueryMenuUrl();
        queryMenuUrl = queryMenuUrl.replace("ACCESS_TOKEN", this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtils.sendGet(queryMenuUrl);
        return result;
    }

    @Override
    public Integer deleteMenu() throws IOException {
        logger.info("删除菜单");
        Integer errcode = 0;
        String deleteMenuUrl = weChatConfigProperties.getDeleteMenuUrl();
        deleteMenuUrl = deleteMenuUrl.replace("ACCESS_TOKEN", this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtils.sendGet(deleteMenuUrl);
        if(!StringUtils.isEmpty(result)){
            Map map = MAPPER.readValue(result, Map.class);
            errcode = (Integer) map.get("errcode");
        }
        return errcode;
    }
}
