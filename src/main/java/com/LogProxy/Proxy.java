package com.LogProxy;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.logging.Logger;

@Component
public class Proxy implements Runnable{
    private Thread thread;
    Socket socket;
    InputStream in;
    PrintWriter out;
    Logger logger = Logger.getLogger("Proxy");
    private final String URL = "127.0.0.1";
    private final int PORT = 8081;

    public Proxy() {
        try {
            socket = new Socket(URL, PORT);
            in = socket.getInputStream();
            out = new PrintWriter(socket.getOutputStream(), true);
            thread = new Thread(this);
            thread.run();
        } catch (IOException io) {
            logger.warning("Connect error:" + io);
        } catch (Exception e) {
            logger.warning("General error:" + e);
        }
        if(Objects.nonNull(socket) && socket.isConnected()) {
            logger.info("Connect!!");
        }
    }

    @Override
    public void run() {

    }

    public void registryLog(String readLine) {
        out.println(readLine);
    }
}
