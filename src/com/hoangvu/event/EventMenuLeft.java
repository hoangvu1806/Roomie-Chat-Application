
package com.hoangvu.event;

import com.hoangvu.model.ModelUser;
import java.util.List;

public interface EventMenuLeft {

    public void newUser(List<ModelUser> users);

    public void userConnect(int userID);

    public void userDisconnect(int userID);
}
