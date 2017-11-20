package com.zc.sys.api.zc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zc.sys.common.util.http.UtilHttp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:com/zc/sys/api/zc/codegen/applicationConfig-test.xml"})
public class TestService{

	public void getSMSCode(){
		String model = "mobile=15555555555";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/common/getMobileCode", model);
		System.err.println(dd);
	}
	
	public void reg(){
		String model = "mobile=15555555555&mobileCode=123456&pwd=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/user/reg", model);
		System.err.println(dd);
	}
	
	public void login(){
		String model = "loginName=15555555555&pwd=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/user/login", model);
		System.err.println(dd);
	}
	
	public void realName(){
		String model = "user.id=1&realName=毕若晗&cardType=1&cardNo=361001198711133789";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/useridentify/realName", model);
		System.err.println(dd);
	}
	
	public void bindbank(){
		String model = "user.id=1&bankCardNo=11111111111111&mobile=15555555555&bankCode=100";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/acc/bankcard/bindBC", model);
		System.err.println(dd);
	}
	
	public void menu(){
		String model = "";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/s/menu/add", model);
		System.err.println(dd);
	}
	
	public void cashloan(){
		String model = "user.id=1&total=1000";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/cl/cashloan/cashLoan", model);
		System.err.println(dd);
	}
	
	public void operatorList(){
		String model = "";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/m/operator/list", model);
		System.err.println(dd);
	}
	
	@Test
	public void testMain(){
//		getSMSCode();
//		reg();
//		login();
//		realName();
//		bindbank();
		cashloan();
//		menu();
//		operatorList();
	}
	
	public static void main(String[] args) {
//		String param = "id=11111111111";
//		String dd = UtilHttp.sendPost("http://127.0.0.1:8080", param);
//		System.err.println(dd);
		
//		System.err.println(StringUtil.isPhone(null));
	}
}
