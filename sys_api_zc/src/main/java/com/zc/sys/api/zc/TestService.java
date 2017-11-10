package com.zc.sys.api.zc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zc.sys.common.util.http.UtilHttp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"file:src/main/resources/applicationConfig.xml"})
public class TestService{

	@Test
	public void testMain(){
		String param = "id=11111111111";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080", param);
	}
	
	public static void main(String[] args) {
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < 64; i++) {
//			sb.append(1);
//		}
//		System.err.println(sb);
		String param = "id=11111111111";
		String dd = UtilHttp.sendPost("http://127.0.0.1:8080", param);
		System.err.println(dd);
	}
}
