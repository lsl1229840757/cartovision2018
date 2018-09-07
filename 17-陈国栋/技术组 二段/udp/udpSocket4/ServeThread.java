package udpSocket4;

/**
 * �������
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

		// ����socket����˶���

		System.out.println("������1��ʼ����");
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * ʹ��whileѭ��ʵ��һֱ����������
		 */

		while (true) {
			// �����ֽ�����
			byte[] bs = new byte[1024];
			// ���ݱ�������ʵ�������Ӱ�Ͷ�ݷ���

			DatagramPacket dp = new DatagramPacket(bs, bs.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ��������
			InetAddress ia = dp.getAddress();
			String ip = ia.getHostAddress();
			// ������ݵĳ���
			int len = dp.getLength();
			byte[] bs1 = dp.getData();
			String result = new String(bs1, 0, len);
			System.out.println(ip + result);
			if ("exit".equals(result)) {
				System.out.println("ֹͣ����1");
				break;
			}
		}
		if (ds != null) {
			ds.close();
		}

	}
}
