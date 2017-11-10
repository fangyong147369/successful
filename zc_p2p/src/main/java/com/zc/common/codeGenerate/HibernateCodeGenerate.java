package com.zc.common.codeGenerate;

import java.io.File;

import com.zc.common.codeGenerate.template.CodeTemplate;
import com.zc.common.util.date.DateUtil;
import com.zc.common.util.validate.StringUtil;

public class HibernateCodeGenerate {
	private static String basePath = null;
	private String fileCharset = "utf-8";
	private String sourcePath = "src/main/java/";
	
	String packageName = "demos";
	String entityName = "DemoUpload";
	String tableName = "tbl_upload";
	boolean generateDao = false;
	private String moduleName = "";
	private String author = "zp";
	private String version = "2.0.0.0";
	private String since = DateUtil.dateStr6(DateUtil.getNow());
	private String dbModel = "S";
	
	public void generate(){
		if(StringUtil.isBlank(packageName)){
			packageName = entityName.toLowerCase();
		}
		CodeTemplate ct = new CodeTemplate(packageName, entityName, tableName);
		ct.setModuleName(moduleName);
		
		if (basePath == null || basePath.trim().length() == 0) {
            basePath = System.getProperty("user.dir");
        }
        if (basePath == null || basePath.trim().length() == 0) {
            System.err.println("[ERROR] 请配置basePath。");
            return;
        }
        if (!basePath.endsWith(File.separator)) {
            basePath = basePath + File.separator;
        }
        
        System.out.println(basePath);
        sourcePath = basePath + sourcePath;
        System.out.println(sourcePath);
        
        //生成实体
        String entityPath = sourcePath + ct.getEntityPackage().replace(".", File.separator) + File.separator
        	+ ct.getEntityName() + ".java";
        GenerateUtil.writeText(new File(entityPath), ct.entity(), fileCharset);
       
        //生成model
        String modelPath = sourcePath + ct.getModelPackage().replace(".", File.separator) + File.separator
        	+ ct.getModelName() + ".java";
        GenerateUtil.writeText(new File(modelPath), ct.model(), fileCharset);
        
        //生成Dao
        String daoPath = sourcePath + ct.getDaoPackage().replace(".", File.separator) + File.separator
        		+ ct.getDaoName() + ".java";
        GenerateUtil.writeText(new File(daoPath), ct.dao(), fileCharset);
        
        //生成DaoImpl
        String daoImplPath = sourcePath + ct.getDaoImplPackage().replace(".", File.separator) + File.separator
        		+ ct.getDaoImplName() + ".java";
        GenerateUtil.writeText(new File(daoImplPath), ct.daoImpl(), fileCharset);
        
        //生成Service
        String servicePath = sourcePath + ct.getServicePackage().replace(".", File.separator) + File.separator
        		+ ct.getServiceName() + ".java";
        GenerateUtil.writeText(new File(servicePath), ct.service(), fileCharset);
        
        //生成ServiceImpl
        String serviceImplPath = sourcePath + ct.getServiceImplPackage().replace(".", File.separator) + File.separator
        		+ ct.getServiceImplName() + ".java";
        GenerateUtil.writeText(new File(serviceImplPath), ct.serviceImpl(), fileCharset);
        //生成Controller
        String controllerPath = sourcePath + ct.getControllerPackage().replace(".", File.separator) + File.separator
        	+ ct.getControllerName() + ".java";
        GenerateUtil.writeText(new File(controllerPath), ct.controller(), fileCharset);
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isGenerateDao() {
		return generateDao;
	}

	public void setGenerateDao(boolean generateDao) {
		this.generateDao = generateDao;
	}

	/** 获取【sourcePath】 **/
	public String getSourcePath() {
		return sourcePath;
	}

	/** 设置【sourcePath】 **/
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	/** 获取【moduleName】 **/
	public String getModuleName() {
		return moduleName;
	}

	/** 设置【moduleName】 **/
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/** 获取【author】 **/
	public String getAuthor() {
		return author;
	}

	/** 设置【author】 **/
	public void setAuthor(String author) {
		this.author = author;
	}

	/** 获取【version】 **/
	public String getVersion() {
		return version;
	}

	/** 设置【version】 **/
	public void setVersion(String version) {
		this.version = version;
	}

	/** 获取【since】 **/
	public String getSince() {
		return since;
	}

	/** 设置【since】 **/
	public void setSince(String since) {
		this.since = since;
	}

	/** 获取【dbModel】 **/
	public String getDbModel() {
		return dbModel;
	}

	/** 设置【dbModel】 **/
	public void setDbModel(String dbModel) {
		this.dbModel = dbModel;
	}
	
}
