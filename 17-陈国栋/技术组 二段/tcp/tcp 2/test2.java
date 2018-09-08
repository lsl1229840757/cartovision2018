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
				// 用于接受服务器的数据
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// 用于发送给服务器数据
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				// 用于输入发送的数据
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));) {
			// 使用循环，一直监听
			while (true) {
				// 发送数据
				String line = read.readLine();
				if (line.equalsIgnoreCase("bye")) {
					break;
				}
				out.writeUTF(line);
				System.out.println("数据已发送");
				// 强制刷新缓冲区
				out.flush();
				// 接收数据
				String str = in.readUTF();
				System.out.println(str);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}
}