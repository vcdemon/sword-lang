package org.sword.lang.http;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public class HttpsUtils {
	
	private static Logger logger = Logger.getLogger(HttpsUtils.class);
	
	/**
	 * 
	 * @param url
	 * @param data
	 * @return
	 */
	public static String post(String url,String data){
		try {
			HttpClient client = new HttpsClient();
			HttpPost post = new HttpPost(url);
			if(data != null && !data.equals("")){
				HttpEntity reqEntity = new StringEntity(data);
				post.setEntity(reqEntity);
			}
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "utf-8");
			return result;
		} catch (Exception e) {
			logger.error("https post error," + e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String get(String url){
		try {
			HttpClient client = new HttpsClient();
			HttpGet get = new HttpGet(url);
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "utf-8");
			return result;
		} catch (Exception e) {
			logger.error("https get error," + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
