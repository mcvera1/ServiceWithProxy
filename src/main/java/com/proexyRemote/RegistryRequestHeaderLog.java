package com.proexyRemote;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class RegistryRequestHeaderLog implements Runnable {
    private Thread thread;
    ServerSocket serverSocket;
    Socket socket;
    Logger logger = Logger.getLogger("RegistryLog");

    public RegistryRequestHeaderLog() {
        try {
            serverSocket = new ServerSocket(8081);
            socket = serverSocket.accept();
            thread = new Thread(this);
            thread.start();
        } catch(Exception e) {
            logger.info("Error in registry log:"+ e);
        }
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            registryLog(br.readLine());
        } catch (Exception e) {
            logger.warning("Error in thread:" + e);
        }
    }

    public void registryLog(String readLine) {
        System.out.println(readLine);
        logger.info(readLine);
    }

    public static void main(String arg[]) {
        RegistryRequestHeaderLog rl = new RegistryRequestHeaderLog();
    }
}
