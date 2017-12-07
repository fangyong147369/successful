package com.zc.sys.core.common.global;

import java.util.HashMap;
import java.util.Map;

import com.zc.sys.common.cache.RedisCacheUtil;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.entity.Template;
import com.zc.sys.core.sys.model.ConfigModel;

/**
 * 全局信息
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年11月6日
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Global {
	
	public static final ThreadLocal transferThreadLocal = new ThreadLocal();
	
	/**
	 * 获取模版信息
	 * @param nid
	 * @param type
	 * @param typeSub
	 * @return
	 */
	public static Template getTemplate(String nid,int type,int typeSub){
		RedisCacheUtil cache = (RedisCacheUtil)BeanUtil.getBean(RedisCacheUtil.class);
		Map<String, Object> sysTemplateMap = cache.getCache("SYSTEMPLATE", Map.class);
		if(sysTemplateMap.size() <= 0){
			sysTemplateMap = InitializeWebConfigContext.initSysTempalte();
		}
		return (Template)sysTemplateMap.get(nid + "_" + type + "_" + typeSub);
	}
	
	public static Map<String, Object> getTransfer() {
		Map<String, Object> map = (Map<String, Object>) transferThreadLocal.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			transferThreadLocal.set(map);
		}
		return map;
	}

	public static void setTransfer(String key, Object value) {
		Map<String, Object> map = getTransfer();
		map.put(key, value);
		transferThreadLocal.set(map);
	}
	
	public static String getValue(String key) {
		RedisCacheUtil cache = (RedisCacheUtil)BeanUtil.getBean(RedisCacheUtil.class);
		ConfigModel sysConfig = cache.getCache("SYSCONFIG", ConfigModel.class);
		if (sysConfig == null) {
			sysConfig = InitializeWebConfigContext.initSysConfig();
		}
		Object value = sysConfig.getValue(key);
		return StringUtil.isNull(value);
	}
	
	public static int getInt(String key) {
		return StringUtil.toInt(getValue(key));
	}
	
	public static double getdouble(String key) {
		return Double.parseDouble(getValue(key));
	}
	
	//系统状态dev-测试环境;prod-生产环境
	public static boolean sysState(){
		if(StringUtil.isNull(Global.getValue("sys_state")).equals("prod")){
			return true;
		}
		return false;
	}
	
}
