
package com.hoangvu.event;

import com.hoangvu.model.ModelUser;

public interface EventMain {

    public void showLoading(boolean show);

    public void initChat();

    public void selectUser(ModelUser user);
    public void updataUser(ModelUser user);

}
