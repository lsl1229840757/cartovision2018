package udpSocket4;
//�̣߳�Thread����������
public class ChatRoom1 {
	public static void main(String[] args) {
		ServeThread st = new ServeThread(12000);
		
		SocketThread ct = new SocketThread(10000);
		
		Thread th = new Thread(ct);
		
		Thread th1 = new Thread(st);
		
		th.start();
		
		th1.start();
		
	}
}
