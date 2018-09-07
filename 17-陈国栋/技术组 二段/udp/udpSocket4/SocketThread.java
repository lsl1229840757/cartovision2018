package udpSocket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SocketThread implements Runnable {

	int port;
	
	public SocketThread(int port) {
		super();
		this.port = port;
	}

	@Override
	public void run() {
		// 创建服务端套接字

		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 创建数据包
		 */
		// 创建字符输入流对象

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				// 创建字节数组
				byte[] bs = line.getBytes();
				// 指定要发送的主机Ip地址
				InetAddress address = InetAddress.getLocalHost();
				DatagramPacket dp = new DatagramPacket(bs, bs.length, address, port);

				// 发送数据包

				ds.send(dp);
				System.out.println("已发送数据");
				if ("exit".equals(line)) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ds!=null)
		ds.close();
		System.out.println("停止运行");
	}
}
