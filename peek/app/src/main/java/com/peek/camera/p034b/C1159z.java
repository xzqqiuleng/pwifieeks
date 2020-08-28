package com.peek.camera.p034b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.util.List;

/* renamed from: com.bmw.peek2.b.z */
public class C1159z {

    /* renamed from: a */
    private WifiManager f3130a;

    /* renamed from: b */
    private WifiInfo f3131b;

    /* renamed from: c */
    private List<ScanResult> f3132c;

    public C1159z(Context context) {
        this.f3130a = (WifiManager) context.getSystemService("wifi");
        mo4681a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private WifiConfiguration m5341b(String r6) {
        /*
            r5 = this;
            android.net.wifi.WifiManager r0 = r5.f3130a
            java.util.List r0 = r0.getConfiguredNetworks()
            if (r0 == 0) goto L_0x0042
            java.util.Iterator r1 = r0.iterator()
        L_0x000c:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0042
            java.lang.Object r0 = r1.next()
            android.net.wifi.WifiConfiguration r0 = (android.net.wifi.WifiConfiguration) r0
            java.lang.String r2 = r0.SSID
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0041
            java.lang.String r2 = r0.SSID
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x000c
        L_0x0041:
            return r0
        L_0x0042:
            r0 = 0
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bmw.peek2.p034b.C1159z.m5341b(java.lang.String):android.net.wifi.WifiConfiguration");
    }

    /* renamed from: a */
    public WifiConfiguration mo4680a(String str, String str2, int i) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = "\"" + str + "\"";
        WifiConfiguration b = wifiConfiguration;
        if (b != null) {
            C1140n.m5266a("wifiConfiguration !=null " + b.SSID);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f3130a.enableNetwork(b.networkId, true);
                this.f3130a.removeNetwork(b.networkId);
            } else {
                this.f3130a.removeNetwork(b.networkId);
            }
        }
        if (i == 1) {
            wifiConfiguration.wepKeys[0] = "";
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (i == 2) {
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.wepKeys[0] = "\"" + str2 + "\"";
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (i == 3) {
            wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        }
        return wifiConfiguration;
    }

    /* renamed from: a */
    public void mo4681a() {
        this.f3131b = this.f3130a.getConnectionInfo();
    }

    /* renamed from: a */
    public void mo4682a(int i) {
        this.f3130a.disconnect();
    }

    /* renamed from: a */
    public void mo4683a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration != null) {
            C1140n.m5266a("正在添加wifi网络！" + wifiConfiguration.SSID);
            boolean enableNetwork = this.f3130a.enableNetwork(this.f3130a.addNetwork(wifiConfiguration), true);
            this.f3130a.saveConfiguration();
            this.f3130a.reconnect();
            C1140n.m5266a("添加wifi网络 结果：" + enableNetwork);
        }
    }

    /* renamed from: a */
    public void mo4684a(String str) {
        WifiConfiguration b = m5341b(str);
        if (b != null) {
            this.f3130a.removeNetwork(b.networkId);
        }
    }

    /* renamed from: b */
    public void mo4685b() {
        if (!this.f3130a.isWifiEnabled()) {
            C1140n.m5266a("wifi已经开启");
            this.f3130a.setWifiEnabled(true);
        }
    }

    /* renamed from: c */
    public void mo4686c() {
        C1140n.m5266a("扫描wifi列表");
        this.f3130a.startScan();
        this.f3132c = this.f3130a.getScanResults();
    }

    /* renamed from: d */
    public List<ScanResult> mo4687d() {
        return this.f3132c;
    }

    /* renamed from: e */
    public int mo4688e() {
        mo4681a();
        if (this.f3131b == null) {
            return 0;
        }
        return this.f3131b.getIpAddress();
    }

    /* renamed from: f */
    public int mo4689f() {
        mo4681a();
        if (this.f3131b == null) {
            return 0;
        }
        return this.f3131b.getNetworkId();
    }

    /* renamed from: g */
    public String mo4690g() {
        mo4681a();
        return this.f3131b.getSSID();
    }

    /* renamed from: h */
    public int mo4691h() {
        mo4681a();
        return this.f3131b.getLinkSpeed();
    }

    /* renamed from: i */
    public int mo4692i() {
        mo4681a();
        return this.f3131b.getRssi();
    }
}
