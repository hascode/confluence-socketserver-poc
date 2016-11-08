package com.trehn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;

public class SocketServerExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket server = new ServerSocket(6666);
		System.out.println("socket server listening on port 6666");
		Socket clientSocket = server.accept();
		System.out.println("socket client connected");
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out.println("welcome torsten");
		while (true) {
			out.println(String.format("hello torsten, now it's %s", ZonedDateTime.now().toString()));
			Thread.sleep(5000);
		}
		// server.close();

	}

}
