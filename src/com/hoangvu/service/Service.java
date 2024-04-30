package com.hoangvu.service;



import io.socket.client.IO;
import io.socket.client.Socket;

public class Service {

    private static Service instance;

    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP_ADDRESS = "127.0.0.1";

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }
    private Service() {

    }
    public Socket getClient() {
        return client;
    }

    public void startServer() {
        try{
            client = IO.socket("http://"+IP_ADDRESS+":"+PORT_NUMBER);
            client.open();
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
