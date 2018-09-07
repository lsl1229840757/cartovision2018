package udpSocket4;

/**
 * 改造代码
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServeThread implements Runnable {

	int port;

	public ServeThread(int port) {
		super();
		this.port = port;
	}
	@Override
	public void run() {

		// 创建socket服务端对象

		System.out.println("服务器1开始运行");
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 使用while循环实现一直监听的作用
		 */

		while (true) {
			// 创建字节数组
			byte[] bs = new byte[1024];
			// 数据报包用来实现无连接包投递服务

			DatagramPacket dp = new DatagramPacket(bs, bs.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 解析数据
			InetAddress ia = dp.getAddress();
			String ip = ia.getHostAddress();
			// 获得数据的长度
			int len = dp.getLength();
			byte[] bs1 = dp.getData();
			String result = new String(bs1, 0, len);
			System.out.println(ip + result);
			if ("exit".equals(result)) {
				System.out.println("停止运行1");
				break;
			}
		}
		if (ds != null) {
			ds.close();
		}

	}
}
