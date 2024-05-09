package com.hoangvu.connection;

import com.hoangvu.event.PublicEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

public class ServerConnection {
    private static ServerConnection instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP_ADDRESS = "localhost";

    private ServerConnection() {
        try {
            client = IO.socket("http://" + IP_ADDRESS + ":" + PORT_NUMBER);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ServerConnection getInstance() {
        if (instance == null) {
            instance = new ServerConnection();
        }
        return instance;
    }

    public Socket getClient() {
        return client;
    }

    public void connect() {
        client.on("user-status", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                int userID = (Integer) objects[0];
                boolean status = (Boolean) objects[1];
                if (status) {
                    //  connect
                    PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                } else {
                    //  disconnect
                    PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                }
            }
        });
        client.open();
    }

    public void disconnect() {
        client.disconnect();
    }
}
