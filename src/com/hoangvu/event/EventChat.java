
package com.hoangvu.event;

import com.hoangvu.model.ModelReceiveMessage;
import com.hoangvu.model.ModelSendMessage;

import java.io.IOException;

public interface EventChat {
    public void sendMessage(ModelSendMessage data);
    public void receiveMessage(ModelReceiveMessage data);
    public void receiveImage(ModelReceiveMessage data) throws IOException;
    public void sendImage(ModelSendMessage data) throws IOException;
}
