package com.husen.test;

import java.io.*;
import java.net.*;
import java.util.*;

public class test implements Runnable {


	@Override
	public void run() {
		try (
				// ����ServerSocket����
				ServerSocket ssocket = new ServerSocket(8060);
				// �����˿�8080
				Socket socket = ssocket.accept();
				// ���ڽ��ܿͻ��˵�����
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// ���ڷ��͸��ͻ�������
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				// �������뷢�͵�����
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));) {
			// ʹ��ѭ����һֱ����
			while (true) {
				// ��������
				String str = in.readUTF();
				System.out.println(str);
				// ��������
				String line = read.readLine();
				if (line.equalsIgnoreCase("bye")) {
					break;
				}
				out.writeUTF(line);
				// ǿ��ˢ�»�����
				out.flush();
			}
			System.out.println("�����ѷ���");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		Thread th = new Thread(new test2());
		Thread th1 = new Thread(new test());
		th.start();
		th1.start();
	}
}