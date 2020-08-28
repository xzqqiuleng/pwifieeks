package com.peek.camera.p034b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import okhttp3.OkHttpClient;
import org.apache.http.client.methods.HttpGet;

/* renamed from: com.bmw.peek2.b.p */
public class C1143p {
    /* renamed from: a */
    public static int m5285a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 1;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null && allNetworkInfo.length > 0) {
            int i = 0;
            while (i < allNetworkInfo.length) {
                if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                    System.out.println(i + "网络===状态===" + allNetworkInfo[i].getState());
                    System.out.println(i + "网络===类型===" + allNetworkInfo[i].getTypeName());
                    if (allNetworkInfo[i].getTypeName().equals("WIFI")) {
                        new OkHttpClient();
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.baidu.com/").openConnection();
                            httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
                            if (httpURLConnection.getResponseCode() == 200) {
                                System.out.println(i + "网络===wifi验证联网成功===");
                                return 0;
                            }
                            System.out.println(i + "网络===wifi验证联网失败===");
                            return 2;
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                            System.out.println(i + "网络===wifi验证联网失败异常1===" + e);
                            return 2;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            System.out.println(i + "网络===wifi验证联网失败异常2===" + e2);
                            return 2;
                        }
                    } else {
                        System.out.println(i + "网络===验证联网成功===");
                        return 0;
                    }
                } else {
                    i++;
                }
            }
        }
        System.out.println("===false===");
        return 1;
    }
}
