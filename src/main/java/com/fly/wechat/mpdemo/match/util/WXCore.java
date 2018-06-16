package com.fly.wechat.mpdemo.match.util;

import java.util.Random;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;


/**
 * 封装对外访问方法
 * @author liuyazhuang
 *
 */
public class WXCore {
	
	private static final String WATERMARK = "watermark";
	private static final String APPID = "appid";
	/**
	 * 解密数据
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String appId, String encryptedData, String sessionKey, String iv){
		String result = "";
		try {
			AES aes = new AES();  
		    byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));  
		    if(null != resultByte && resultByte.length > 0){  
		        result = new String(WxPKCS7Encoder.decode(resultByte));  
		    	JSONObject jsonObject = JSONObject.parseObject(result);
		    	String decryptAppid = jsonObject.getJSONObject(WATERMARK).getString(APPID);
		    	if(!appId.equals(decryptAppid)){
		    		result = "";
		    	}
	        }  
		} catch (Exception e) {
			result = "";
			e.printStackTrace();
		}
	    return result;
	}
	public static String getRandomString(int length){
	    //定义一个字符串（A-Z，a-z，0-9）即62位；
	    String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
	    //由Random生成随机数
	        Random random=new Random();  
	        StringBuffer sb=new StringBuffer();
	        //长度为几就循环几次
	        for(int i=0; i<length; ++i){
	          //产生0-61的数字
	          int number=random.nextInt(62);
	          //将产生的数字通过length次承载到sb中
	          sb.append(str.charAt(number));
	        }
	        //将承载的字符转换成字符串
	        return sb.toString();
	  }
	
	public static String buildToken(){
		return getRandomString(6)+System.currentTimeMillis()%100;
	}
	
	
	public static void main(String[] args) throws Exception{
//	   String appId = "wxc20a02533ffcc185";
//	   String encryptedData = "jvotar/sVIgG3FYS/XwZy3Q9/dm6OddOtiz3guEWt2RElDslQ0gVlFMHuZhha6OVpe0yYtmTDP4rq4uhi6iUKH685a2hqDQIfJ2s/wXtQXTbPGqa6pd/2meqDrJsZnLr0qxIgZCZ3ESf9Q5196vpaF0srqwBDwm2GRETC4iC1rRo19d3RhqVfS2P2z7jkeZIyDImJvzlHHBJSSvMnJOm5jnpteQXoe8+z5+frt6bpDSJ+3wgTLmCfC5PE9fsBPDsbSB6VjYwMz/kYyLWvPhUx2j/n0lU5+PynCEsnhNBLqmz50p7KK7Xx0cFW+wRYNsVCQa1EhccbG9TqYnMY/zYZn8AENBtI1qreDIknDogsV8WQK/T/rXBQVIONN/uCTqWxLDXPKB8U/qVqp5MkwxQTNopsVM+NnBqjkLlNDHyyd/VfpkgOio0KztKe31Mn1lfL7ERGTW8U16CcaHUcxzWGeV18bfPwvEstE9KdxVUCiY=";
//	   String sessionKey = "52pm\\/89aeGdSOGQQSWzWVQ==";
//	   String iv = "/2G8s6TErf9oIU7h2oODcA==";
//       System.out.println(decrypt(appId, encryptedData, sessionKey, iv));
		System.out.println(buildToken());
    }
}
