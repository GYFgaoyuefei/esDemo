package com.run.gao;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * 协议文件增删改查的应用程序
 * @author Administrator
 *
 */
public class EmployeeCRUDApp {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) throws Exception {
		// 先构建client
		Settings settings = Settings.builder()
				.put("cluster.name", "elasticsearch")
				.build();
		
		TransportClient client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
		
		createProtocol(client);
		getProtocol(client);
//		updateProtocol(client);
//		deleteProtocol(client);
		
		client.close();
	}
	
	/**
	 * 创建大协议信息（创建一个document）
	 * @param client
	 */
	private static void createProtocol(TransportClient client) throws Exception {
		IndexResponse response = client.prepareIndex("protocol", "bigProtocol", "1")
				.setSource(XContentFactory.jsonBuilder()
						.startObject()
							.field("name", "WA_SOURCE_0001")
						.endObject())
				.get();
		IndexResponse response1 = client.prepareIndex("protocol", "sProtocol", "1")
				.setSource(XContentFactory.jsonBuilder()
						.startObject()
						.field("name", "1389979")
						.field("bigProtocol","1")
						.field("应用简介","asfsda")
						.endObject())
				.get();

		response.getResult();
		System.out.println(response.getResult());
	}
	
	/**
	 * 获取大协议信息
	 * @param client
	 * @throws Exception
	 */
	private static void getProtocol(TransportClient client) throws Exception {
		GetResponse response = client.prepareGet("protocol", "bigProtocol", "1").get();
		System.out.println(response.getSourceAsString());
	}
	
	/**
	 * 修改大协议信息
	 * @param client
	 * @throws Exception
	 */
	private static void updateProtocol(TransportClient client) throws Exception {
		UpdateResponse response = client.prepareUpdate("protocol", "bigProtocol", "1")
				.setDoc(XContentFactory.jsonBuilder()
							.startObject()
								.field("name", "WA_SOURCE_0001")
							.endObject())
				.get();
		System.out.println(response.getResult());
 	}
	
	/**
	 * 删除大协议信息
	 * @param client
	 * @throws Exception
	 */
	private static void deleteProtocol(TransportClient client) throws Exception {
		DeleteResponse response = client.prepareDelete("protocol", "bigProtocol", "1").get();
		System.out.println(response.getResult());  
	}
	
}


//GET /protocol/bigProtocol/_search
//		{
//		"query": {
//		"bool": {
//		"should": [
//		{"match": {
//		"bigProtocol": "aaa"
//		}},
//		{"match": {
//		"应用简介": "aaa"
//		}},
//		{"match": {
//		"name":"aaa"
//		}}
//		]
//		}
//		}
//		}