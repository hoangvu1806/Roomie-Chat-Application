
package com.hoangvu.event;

import com.hoangvu.model.ModelUser;

public interface EventMain {

    public void showLoading(boolean show);

    public void initChat();

    public void selectUser(ModelUser toUser);
    public void updataUser(ModelUser toUser);

}
