package com.peek.camera.model.impl;
import com.google.gson.Gson;
import com.peek.camera.model.UpdateInfo;
import com.peek.camera.model.model.UpdateMode;
import com.peek.camera.p032a.C1100e;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateInfoImpl implements UpdateMode {
    public void getData(final C1100e eVar) {
//        BmobQuery bmobQuery = new BmobQuery("UpdateInfo");
//        bmobQuery.order("-createdAt");
//        bmobQuery.findObjectsByTable(new QueryListener<JSONArray>() {
//            public void done(JSONArray jSONArray, BmobException bmobException) {
//                if (bmobException != null) {
//                    BaseApplication.m4926a(BaseApplication.m4925a().getString(C1054R.string.updateError));
//                    C1140n.m5271b("update 2", bmobException.toString());
//                    if (eVar != null) {
//                        eVar.mo4560a();
//                    }
//                } else if (jSONArray == null || jSONArray.length() <= 0) {
//                    eVar.mo4562b();
//                } else {
//                    int i = 0;
//                    boolean z = false;
//                    while (true) {
//                        if (i >= jSONArray.length()) {
//                            break;
//                        }
//                        try {
//                            JSONObject jSONObject = jSONArray.getJSONObject(i);
//                            if (jSONObject != null) {
//                                UpdateInfo updateInfo = (UpdateInfo) new Gson().fromJson(jSONObject.toString(), UpdateInfo.class);
//                                C1140n.m5266a("Version = " + updateInfo.getVersion());
//                                if (updateInfo.getApkName().equals("Peek2S")) {
//                                    z = true;
//                                    eVar.mo4561a(updateInfo);
//                                    break;
//                                }
//                            } else {
//                                continue;
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            C1140n.m5271b("update 1", e.toString());
//                        }
//                        i++;
//                    }
//                    if (!z) {
//                        eVar.mo4562b();
//                    }
//                }
//            }
//        });
    }

    public void getUpdateInfo(C1100e eVar) {
        getData(eVar);
    }
}
