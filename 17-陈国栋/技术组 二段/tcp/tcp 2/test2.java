import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class test2 implements Runnable {
	public void run() {
		try (

				Socket socket = new Socket("127.0.0.1", 8060);
				// ���ڽ��ܷ�����������
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// ���ڷ��͸�����������
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				// �������뷢�͵�����
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));) {
			// ʹ��ѭ����һֱ����
			while (true) {
				// ��������
				String line = read.readLine();
				if (line.equalsIgnoreCase("bye")) {
					break;
				}
				out.writeUTF(line);
				System.out.println("�����ѷ���");
				// ǿ��ˢ�»�����
				out.flush();
				// ��������
				String str = in.readUTF();
				System.out.println(str);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}
}