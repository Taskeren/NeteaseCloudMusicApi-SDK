package cn.taskeren.music.test;

import api.UserApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import util.NeteaseMusicUtils;

import static cn.taskeren.music.test.SensitiveInfo.*;

@Disabled
public class TestLogin {

	@BeforeAll
	static void setupTestApi() {
		NeteaseMusicUtils.setApiDomain(API_URL);
	}

	/**
	 * Not tested yet, for I don't have account to log in with phone.
	 */
	@Test
	public void testLoginByPhoneNumber() {
		UserApi api = UserApi.loginByPhone("15824508506", "Task1024", false);

		System.out.println("Cookie = "+api.getCookie());
		System.out.println(api);
	}

	@Test
	public void testLoginByEmail() {
		UserApi api = UserApi.loginByEmail(EMAIL, PASSWORD, false);

		System.out.println("Cookie = "+api.getCookie());
		System.out.println(api);
	}

}
