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
		// ����������׽���

		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * �������ݰ�
		 */
		// �����ַ�����������

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				// �����ֽ�����
				byte[] bs = line.getBytes();
				// ָ��Ҫ���͵�����Ip��ַ
				InetAddress address = InetAddress.getLocalHost();
				DatagramPacket dp = new DatagramPacket(bs, bs.length, address, port);

				// �������ݰ�

				ds.send(dp);
				System.out.println("�ѷ�������");
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
		System.out.println("ֹͣ����");
	}
}
