package com.zc;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zc.common.queue.pojo.QueueModel;
import com.zc.common.queue.service.QueueService;
import com.zc.common.util.BeanUtil;
import com.zc.test.TestModel;
import com.zc.test.TestService;

@Controller
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableScheduling
@ImportResource("classpath:applicationConfig.xml")
public class Application extends SpringBootServletInitializer {
	
	@Resource
	private TestService testService;
	@Resource
	private QueueService queueService;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
//		TestModel t = testService.find(1);
//		queueService.send(new QueueModel("测试ActiveMQ队列。。。。"));
        return "测试";
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        BeanUtil.getBean(TestService.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[]{Application.class});
    }
}
