package cn.e3mall.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class FastDfsTest {
	@Test
	public void testUpload() throws Exception{
		//创建一个配置文件，文件名任意，内容就是tracher服务器的地址
		//使用全局对象加载配置文件
		ClientGlobal.init("E:/javaproject/e3project/e3-manager-web/src/main/resources/conf/client.conf");
		//创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//通过TrackClient获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建一个StorageServer的引用，可以是null
		StorageServer storageServer = null;
		//创建一个StorageClient，参数需要TrackerServer和StrorageServer
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//使用StrorageClient上传文件
		String[] strings = storageClient.upload_file("E:/upload/f9a10fc551c14d9a87806aa155838701.jpg","jpg",null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("E:/javaproject/e3project/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile("E:/upload/Img304163380.jpg");
		System.out.println(string);
	}
}
