package udpSocket4;

public class ChatRoom {
	public static void main(String[] args) {
		ServeThread st = new ServeThread(10000);
		
		SocketThread ct = new SocketThread(12000);
		
		Thread th = new Thread(ct);
		
		Thread th1 = new Thread(st);
		
		th.start();
		
		th1.start();
		
	}
}
