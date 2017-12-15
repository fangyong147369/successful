package com.zc.sys.core.sys.model;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import com.zc.sys.common.exception.BusinessException;
import com.zc.sys.common.model.jpa.Page;
import com.zc.sys.common.util.validate.StringUtil;
import com.zc.sys.core.sys.entity.Config;
/**
 * 系统参数
 * 
 * @author zp
 * @version 2.0.0.0
 * @since 2017年7月27日
 */
public class ConfigModel extends Config{

	/** 序列号 **/
	private static final long serialVersionUID = 1L;
	
	/** 当前页码 */
	private int pageNo;
	/** 每页数据条数 */
	private int pageSize = Page.ROWS;
	/** 条件查询 */
	private String searchName;
	/** 系统配置表nid数组 */
	private String[] configNid;
	/** 参数配置map **/
	private Map<String, Config> map;
	
	public ConfigModel() {
		super();
	}

	public ConfigModel(int size) {
		map = Collections.synchronizedMap(new HashMap<String, Config>());
		configNid = new String[size];
	}
	
	public void addConfig(Config sys) {
		map.put(sys.getNid().replace("con_", ""), sys);
	}
	
	public void setConfigNid(int length, String nid){
		configNid[length] = nid.replace("con_", "");
	}
	
	private Config getConfig(String key) {
		Config sys = (Config) map.get(key);
		return sys;
	}
	
	public String getValue(String key) {
		Config c = getConfig(key);
		if (c == null)
			return null;
		return c.getValue();
	}
	
	/**
	 * 实体转换model
	 * 
	 * @param user
	 *            实体
	 * @return model
	 */
	public static ConfigModel instance(Config config) {
		ConfigModel configModel = new ConfigModel();
		BeanUtils.copyProperties(config, configModel);
		return configModel;
	}

	/**
	 * model转换实体
	 * 
	 * @return 实体
	 */
	public Config prototype() {
		Config config = new Config();
		BeanUtils.copyProperties(this, config);
		return config;
	}
	
	/**
	 * 参数校验
	 */
	public void validParam() {
		if (StringUtil.isBlank(this.getNid())) {
			throw new BusinessException("标识不能为空！");
		}
		if (StringUtil.isBlank(this.getName())) {
			throw new BusinessException("名称不能为空！");
		}
		if (StringUtil.isBlank(this.getValue())) {
			throw new BusinessException("参数值不能为空！");
		}
		if (this.getType() <= 0) {
			throw new BusinessException("类型错误！");
		}
	}
	
	/**
	 * 设置修改参数
	 * @param systemConfig
	 */
	public void setUpdateParam(Config systemConfig) {
		systemConfig.setName(this.getName());
		systemConfig.setNid(this.getNid());
		systemConfig.setRemark(this.getRemark());
		systemConfig.setState(this.getState());
		systemConfig.setType(this.getType());
		systemConfig.setValue(this.getValue());
	}
	

	/** 获取【当前页码】 **/
	public int getPageNo() {
		return pageNo;
	}

	/** 设置【当前页码】 **/
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/** 获取【每页数据条数】 **/
	public int getPageSize() {
		return pageSize;
	}

	/** 设置【每页数据条数】 **/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/** 获取【条件查询】 **/
	public String getSearchName() {
		return searchName;
	}

	/** 设置【条件查询】 **/
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	/** 获取【系统配置表nid数组】 **/
	public String[] getConfigNid() {
		return configNid;
	}

	/** 设置【系统配置表nid数组】 **/
	public void setConfigNid(String[] configNid) {
		this.configNid = configNid;
	}

	/** 获取【参数配置map】 **/
	public Map<String, Config> getMap() {
		return map;
	}

	/** 设置【参数配置map】 **/
	public void setMap(Map<String, Config> map) {
		this.map = map;
	}

}
