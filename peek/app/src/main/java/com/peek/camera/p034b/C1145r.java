package com.peek.camera.p034b;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;

/* renamed from: com.bmw.peek2.b.r */
public class C1145r {

    /* renamed from: a */
    private OkHttpClient f3107a;

    /* renamed from: com.bmw.peek2.b.r$a */
    private static class C1147a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C1145r f3108a = new C1145r();
    }

    private C1145r() {
        this.f3107a = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).build();
    }

    /* renamed from: a */
    public static C1145r m5287a() {
        return C1147a.f3108a;
    }

    /* renamed from: b */
    private Request.Builder m5288b() {
        return new Request.Builder().addHeader(HTTP.CONN_DIRECTIVE, "keep-alive");
    }

    /* renamed from: a */
    public String mo4670a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            int i = 0;
            for (String next : map.keySet()) {
                if (i > 0) {
                    sb.append("&");
                }
                try {
                    sb.append(String.format("%s=%s", new Object[]{next, URLEncoder.encode(map.get(next).toString(), "utf-8")}));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        Call newCall = this.f3107a.newCall(m5288b().url(String.format("%s?%s", new Object[]{str, sb.toString()})).build());
        Response execute = null;
        try {
            execute = newCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (execute.isSuccessful()) {
            newCall.cancel();
            try {
                return execute.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        newCall.cancel();
       return  "";
    }
}
