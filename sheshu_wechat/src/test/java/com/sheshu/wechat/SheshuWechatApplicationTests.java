package com.sheshu.wechat;

import com.sheshu.utils.WeChatUtils;
import com.sheshu.wechat.bean.base.AccessToken;
import com.sheshu.wechat.bean.base.Ips;
import com.sheshu.wechat.bean.user.UserListInfo;
import com.sheshu.wechat.service.MenuService;
import com.sheshu.wechat.service.UserService;
import com.sheshu.wechat.service.WeChatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SheshuWechatApplicationTests {

	@Autowired
	private WeChatService weChatService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@Test
	public void getAccessToken() throws IOException {
		AccessToken accessToken = weChatService.getAccessToken();
		System.out.print(accessToken.getAccess_token());
	}

	@Test
	public void createMenu() throws IOException {
		Integer errcode = menuService.createMenu();
		if(errcode==0){
			System.out.println("菜单创建成功");
		}else{
			System.out.println("菜单创建失败");
		}
	}

	@Test
	public void queryMenu() throws IOException {
		String result = menuService.queryMenu();
		System.out.println(result);
	}

	@Test
	public void deleteMenu() throws IOException {
		Integer errcode = this.menuService.deleteMenu();
		System.out.println(errcode);
	}

	@Test
	public void getIpList() throws IOException {
		Ips ipList = this.weChatService.getIpList();
		System.out.println(ipList);
	}

	@Test
	public void getUserListInfo() throws IOException {
		UserListInfo userListInfo = this.userService.getUserListInfo();
		System.out.println(userListInfo);
	}

	/*@Test
	public void getUserInfo() throws IOException {
		String openid = "o1kccwiJ7gXSled_5C0ChExp1J_0";
		UserInfo userListInfo = this.userService.getUserInfo(openid);
		System.out.println(userListInfo);
	}*/

	@Test
	public void testStr(){
		String entry = WeChatUtils.getNoncestr();
		System.out.println(entry);

	}
}
