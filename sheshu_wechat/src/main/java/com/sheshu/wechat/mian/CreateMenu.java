package com.sheshu.wechat.mian;

import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.wechat.menu.Button;
import com.sheshu.wechat.menu.ClickButton;
import com.sheshu.wechat.menu.Menu;
import com.sheshu.wechat.menu.ViewButton;
import com.sheshu.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 董帮辉 2017-3-11.
 */
public class CreateMenu {

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private WeChatService weChatService;


}
