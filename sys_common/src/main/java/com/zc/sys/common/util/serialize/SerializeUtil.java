package com.zc.sys.common.util.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.zc.sys.common.util.log.LogUtil;

/**
 * 序列化
 * 
 * @author zp
 * @version 0.0.1
 * @since 2017年8月10日
 */
public class SerializeUtil {
	
	/**
	 * 对象序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			LogUtil.error("对象序列化失败" + e.getMessage());
		}
		return null;
	}

	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			LogUtil.error("对象反序列化失败" + e.getMessage());
		}
		return null;
	}
}
