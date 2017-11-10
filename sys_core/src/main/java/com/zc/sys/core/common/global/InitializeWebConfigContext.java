package com.zc.sys.core.common.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zc.sys.common.cache.RedisCacheUtil;
import com.zc.sys.common.util.log.LogUtil;
import com.zc.sys.core.sys.dao.ConfigDao;
import com.zc.sys.core.sys.dao.TemplateDao;
import com.zc.sys.core.sys.entity.Template;
import com.zc.sys.core.sys.model.ConfigModel;

/**
 * 初始化系统参数
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月6日
 */
@Component
public class InitializeWebConfigContext {

	private static RedisCacheUtil cache;
	private static TemplateDao templateDao;
	private static ConfigDao configDao;
	static{
		cache = (RedisCacheUtil) BeanUtil.getBean(RedisCacheUtil.class);
		templateDao = (TemplateDao) BeanUtil.getBean(TemplateDao.class);
		configDao = (ConfigDao) BeanUtil.getBean(ConfigDao.class);
	}

	/**
	 * 初始化调用
	 */
	@PostConstruct
	public void contextInitialized() {
		// 初始化系统模版
		initSysTempalte();
		// 初始化系统参数
		initSysConfig();
		LogUtil.info("初始化系统参数SUCCESS====================================================");
	}
	
	/**
	 * 初始化系统模版
	 */
	public static Map<String, Object> initSysTempalte(){
		List<Template> list = templateDao.findByProperty("status", 1);
		Map<String, Object> sysTemplateMap = new HashMap<String, Object>();
		for (Template template : list) {
			sysTemplateMap.put(template.getNid() + "_" + template.getType() + "_" + template.getTypeSub(), template);
		}
		cache.setCode("SYSTEMPLATE", sysTemplateMap);
		return sysTemplateMap;
	}
	
	/**
	 * 初始化系统配置
	 * @return
	 */
	public static ConfigModel initSysConfig(){
		ConfigModel config = configDao.getConfig();
		cache.setCode("SYSCONFIG", config);
		return config;
	}

}
