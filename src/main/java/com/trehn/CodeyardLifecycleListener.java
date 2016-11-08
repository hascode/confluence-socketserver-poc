package com.trehn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.config.lifecycle.LifecycleContext;
import com.atlassian.config.lifecycle.LifecycleItem;

public class CodeyardLifecycleListener implements LifecycleItem {
	private static final Logger log = LoggerFactory.getLogger(CodeyardLifecycleListener.class);

	@Override
	public void startup(LifecycleContext context) throws InterruptedException {
		log.info("lifecycle listener context started");
		new Thread(() -> {
			try {
				log.info("socket server starting");
				ServerSocket server = new ServerSocket(6666);
				log.info("socket server listening on port 6666");
				Socket clientSocket = server.accept();
				log.info("socket client connected");
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out.println("welcome torsten");
				while (true) {
					out.println(String.format("hello torsten, now it's %s", ZonedDateTime.now().toString()));
					try {
						Thread.sleep(10 * 1000);
					} catch (Exception e) {
						log.error("i've got threading wrong");
					}
				}
				// server.close();
		        // log.info("socket server closed");
			} catch (IOException e) {
				log.error("io exception thrown trying to create socket server", e);
			}
		}).start();
	}

	@Override
	public void shutdown(LifecycleContext context) throws Exception {
		log.info("lifecycle lister context stopped");
		// tear down your application here and hope confluence shuts down gracefully
	}

}
