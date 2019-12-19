package com.zero.my_generator.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class HttpClientUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	public static String doGet(String url) {
		CloseableHttpResponse response = null;
		String result = "";
		// 通过址默认配置创建一个httpClient实例
		try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
			// 创建httpGet远程连接实例
			HttpGet httpGet = new HttpGet(url);
			// 设置请求头信息，鉴权
			// httpGet.setHeader("Authorization", "Bearer
			// da3efcbf-0845-4fe3-8aba-ee040be542c0");
			// 设置配置请求参数
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
					.setConnectionRequestTimeout(35000)// 请求超时时间
					.setSocketTimeout(60000)// 数据读取超时时间
					.build();
			// 为httpGet实例设置配置
			httpGet.setConfig(requestConfig);
			// 执行get请求得到返回对象
			response = httpClient.execute(httpGet);
			// 通过返回对象获取返回数据
			HttpEntity entity = response.getEntity();
			// 通过EntityUtils中的toString方法将结果转换为字符串
			result = EntityUtils.toString(entity);
		} catch (IOException e) {
			logger.error("http请求异常", e);
		} finally {
			// 关闭资源
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error("关闭资源异常", e);
				}
			}
		}
		return result;
	}

	public static String doPost(String url, String authorization, String json) {

		CloseableHttpResponse response = null;
		String result = "";
		// 通过址默认配置创建一个httpClient实例
		try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
			// 创建HttpPost远程连接实例
			HttpPost httpPost = new HttpPost(url);
			// 设置请求头信息，鉴权
			httpPost.setHeader("Authorization", authorization);
			httpPost.setHeader("Content-type", "application/json; charset=utf-8");
			httpPost.setHeader("Connection", "Close");

			// 构建消息实体
			StringEntity reqEntity = new StringEntity(json, Charset.forName("UTF-8"));
			reqEntity.setContentEncoding("UTF-8");
			// 发送Json格式的数据请求
			reqEntity.setContentType("application/json");
			httpPost.setEntity(reqEntity);

			// 设置配置请求参数
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
					.setConnectionRequestTimeout(35000)// 请求超时时间
					.setSocketTimeout(60000)// 数据读取超时时间
					.build();
			// 为httpGet实例设置配置
			httpPost.setConfig(requestConfig);
			// 执行get请求得到返回对象
			response = httpClient.execute(httpPost);
			// 通过返回对象获取返回数据
			HttpEntity entity = response.getEntity();
			// 通过EntityUtils中的toString方法将结果转换为字符串
			result = EntityUtils.toString(entity);
		} catch (IOException e) {
			logger.error("http请求异常", e);
		} finally {
			// 关闭资源
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					logger.error("关闭资源异常", e);
				}
			}
		}
		return result;

	}

	private static Random random = new Random();

	public static void main(String[] args) {
		String url = "http://localhost:9997/hoper/jjsSubscription/order";
		List<String> jsons = new ArrayList<>();
		List<String> list = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();
		map.put("phoneNo", "13647007202");
		map.put("productId", 34);
		map.put("custName", "写明");
		map.put("certNo", "360302199012260013");
		map.put("preOrderAmt", 50000);
		map.put("bankInfo", "中国银行");
		map.put("bankCode", "65465464268468");
		map.put("introducer", "13647007202");
		map.put("userType", 0);
		jsons.add(JSON.toJSONString(map));

		map = new HashMap<>();
		map.put("phoneNo", "13407993051");
		map.put("productId", 34);
		map.put("custName", "黄金连");
		map.put("certNo", "360311197307053545");
		map.put("preOrderAmt", 50000);
		map.put("bankInfo", "中国银行");
		map.put("bankCode", "654654646842268");
		map.put("introducer", "13407993051");
		map.put("userType", 0);
		jsons.add(JSON.toJSONString(map));

		map = new HashMap<>();
		map.put("phoneNo", "17779910999");
		map.put("productId", 34);
		map.put("custName", "张艳");
		map.put("certNo", "431222198608094524");
		map.put("preOrderAmt", 50000);
		map.put("bankInfo", "中国银行");
		map.put("bankCode", "65465464684618");
		map.put("introducer", "13407993051");
		map.put("userType", 0);
		jsons.add(JSON.toJSONString(map));

		list.add(
				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMzQwNzk5MzA1MSIsInVzZXJJZCI6MTIzMCwiZXhwIjoxNTQ4OTA4MzY0LCJpYXQiOjE1NDg5MDExNjR9."
						+ "BR0PSU2xH-GyPdrTmoxznFIWm1Cj16X2eZvQ9EMUn8E");
		list.add(
				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxNzc3OTkxMDk5OSIsInVzZXJJZCI6MTIzMSwiZXhwIjoxNTQ4OTA4NDEyLCJpYXQiOjE1NDg5MDEyMTJ9."
						+ "N4cHa-oQ-15Y8IPV379TUv7qhs1oWYfy7bFo70Btyj8");
		list.add(
				"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMzYwNzkwMDQ4MSIsInVzZXJJZCI6MTIyOSwiZXhwIjoxNTQ4OTA4NDcyLCJpYXQiOjE1NDg5MDEyNzJ9."
						+ "zR2y9047EV9qd4QUNEaXAKcU9UvOrqkL1Z-5h_H_gYE");

		// String doPost = doPost(url, list.get(random.nextInt(list.size())),
		// jsons.get(random.nextInt(jsons.size())));
		// System.out.println(doPost);
		ExecutorService pool = Executors.newCachedThreadPool();
		int i = 0;
		while (i++ < 10) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					String doPost = doPost(url, list.get(random.nextInt(list.size())),
							jsons.get(random.nextInt(jsons.size())));
					System.out.println(doPost);
				}
			});
		}
	}
}
