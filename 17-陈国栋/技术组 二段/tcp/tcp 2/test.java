package com.husen.test;

import java.io.*;
import java.net.*;
import java.util.*;

public class test implements Runnable {


	@Override
	public void run() {
		try (
				// 创建ServerSocket对象
				ServerSocket ssocket = new ServerSocket(8060);
				// 监听端口8080
				Socket socket = ssocket.accept();
				// 用于接受客户端的数据
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// 用于发送给客户端数据
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				// 用于输入发送的数据
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));) {
			// 使用循环，一直监听
			while (true) {
				// 接收数据
				String str = in.readUTF();
				System.out.println(str);
				// 发送数据
				String line = read.readLine();
				if (line.equalsIgnoreCase("bye")) {
					break;
				}
				out.writeUTF(line);
				// 强制刷新缓冲区
				out.flush();
			}
			System.out.println("数据已发送");

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