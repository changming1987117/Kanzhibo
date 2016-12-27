package pub.kanzhibo.app.login;

import com.avos.avoscloud.AVUser;
import com.hannesdorfmann.mosby.mvp.MvpView;

import pub.kanzhibo.app.model.UserInfo;

/**
 * Created by turbo on 2016/11/2.
 */

public interface LoginView extends MvpView {

    public void showError(String errMessage);

    public void showLoading();

    void loginSuccessful(AVUser user);

    void loginSuccessful(UserInfo userInfo);
}
