package com.zc.sys.quartz;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zc.sys.common.util.date.DateUtil;
import com.zc.sys.common.util.http.UtilHttp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationConfig-test.xml"})
public class TestService{

	public void getSMSCode(){
		String model = "mobile=15555555555&handleSmsType=1";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/common/getMobileCode", model);
		System.err.println(dd);
	}
	
	public void getToken(){
		String model = "";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/common/getToken", model);
		System.err.println(dd);
	}
	
	public void reg(){
		getToken();
		String model = "mobile=15555555555&mobileCode=123456&pwd=123456&confirmPwd=123456&token=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/user/reg", model);
		System.err.println(dd);
	}
	
	public void login(){
		getToken();
		String model = "loginName=15555555555&pwd=123456&token=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/user/login", model);
		System.err.println(dd);
	}
	
	public void realName(){
		getToken();
		String model = "user.id=1&realName=毕若晗&cardType=1&cardNo=361001198711133789&token=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/useridentify/realName", model);
		System.err.println(dd);
	}
	
	public void bindbank(){
		getToken();
		String model = "user.id=1&bankCardNo=11111111111111&mobile=15555555555&bankCode=100&token=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/acc/bankcard/bindBC", model);
		System.err.println(dd);
	}
	
	public void menu(){
		String model = "";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/s/menu/add", model);
		System.err.println(dd);
	}
	
	public void cashloan(){
		getToken();
		String model = "user.id=1&total=10000&cashLoanConfig.id=1&payPwd=1234567&token=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/cl/cashloan/cashLoan", model);
		System.err.println(dd);
	}
	
	public void operatorList(){
		String model = "";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/m/operator/list", model);
		System.err.println(dd);
	}
	
	public void roleById(){
		String model = "id=1";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/m/role/getById", model);
		System.err.println(dd);
	}
	
	public void roleMenuList(){
		String model = "role.id=1";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/m/rolemenu/list", model);
		System.err.println(dd);
	}
	
	public void roleUpdate(){
		String model = "id=1&name=管理员&state=1&remark=测试&menuIdStr=4,1";//4,1,3,8,5,6,7,10
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/m/role/update", model);
		System.err.println(dd);
	}
	
	public void calculator(){
		String model = "periodUnit=1&period=30&amount=10000&rate=0.05&repaymentType=1";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/common/calculator", model);
		System.err.println(dd);
	}
	
	public void cashLoanRepayment(){
		String model = "id=1&period=1&repaymentWay=1&repaymentAccount=11111111111111";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/cl/cashloanrepayment/repayment", model);
		System.err.println(dd);
	}
	
	public void updatePwd(){
		String model = "id=1&oldPwd=123456&pwd=1234567&confirmPwd=1234567&updatePwdWay=2&mobileCode=";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/user/updatePwd", model);
		System.err.println(dd);
	}
	
	public void updatePayPwd(){
		getToken();
		String model = "id=1&oldPwd=123456&payPwd=1234567&confirmPwd=1234567&updatePwdWay=1&mobileCode=123456&token=123456";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/u/user/updatePayPwd", model);
		System.err.println(dd);
	}
	
	public void promotionAdd(){
		String model = "name=测试活动标题&way=1&content=测试活动内容&state=1&startTime="+DateUtil.getNow()+"&endTime="+DateUtil.rollDay(new Date(), 100);
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/pt/promotion/add", model);
		System.err.println(dd);
	}
	
	public void promotionprizeconfigAdd(){
		String model = "promotion.id=1&prizeNo=11&type=1&state=1";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/pt/promotionprizeconfig/add", model);
		System.err.println(dd);
	}
	
	public void interestfreenoteAdd(){
		String model = "name=免息券测试&state=1&day=5&validityType=1&validityValue=10&quota=10&minAmount=1000";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/pt/interestfreenote/add", model);
		System.err.println(dd);
	}
	
	public void menuAdd(){
		String model = "parentId=4&name=参数配置&href=/s/config/list&sort=5&state=0";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080/s/menu/add", model);
		System.err.println(dd);
	}
	
	@Test
	public void testMain(){
//		menuAdd();
//		interestfreenoteAdd();
//		promotionAdd();
//		promotionprizeconfigAdd();
//		updatePwd();
//		getSMSCode();
//		updatePayPwd();
//		reg();
//		login();
//		realName();
//		bindbank();
//		cashloan();
//		cashLoanRepayment();
//		menu();
//		operatorList();
//		roleById();
//		roleUpdate();
//		roleMenuList();
//		calculator();
	}
	
	public static void main(String[] args) {
//		String param = "id=11111111111";
//		String dd = UtilHttp.sendPost("http://127.0.0.1:8080", param);
//		System.err.println(dd);
		
//		System.err.println(StringUtil.isPhone(null));
//		Date now = DateUtil.getNow();
//		System.err.println(DateUtil.msBetween(DateUtil.rollMinute(now, 10), now));
	}
}
