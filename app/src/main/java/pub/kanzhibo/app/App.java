package pub.kanzhibo.app;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;

import com.tencent.bugly.crashreport.CrashReport;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import pub.kanzhibo.app.util.SharedPreferencesUtils;

import static pub.kanzhibo.app.global.Constants.Key.ISLOGIN;

public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        CrashReport.initCrashReport(getApplicationContext(), "900057711", false);
        AVOSCloud.initialize(this, "CIVyV1zRVPbkMQC88fyO9cuW-gzGzoHsz", "Tqbvbhznm5vc1BYdzMTXHeVd");
//        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder(this).schemaVersion(1).build();
        Realm.setDefaultConfiguration(config);
    }

    public static Context getContext() {
        return context;
    }

    public static boolean isLogIn() {
        return SharedPreferencesUtils.getBoolean(context, ISLOGIN, false);
    }

    public static void logIn() {
        SharedPreferencesUtils.saveBoolean(context, ISLOGIN, true);
    }

    public static void logOut() {
        SharedPreferencesUtils.saveBoolean(context, ISLOGIN, false);
    }
}
