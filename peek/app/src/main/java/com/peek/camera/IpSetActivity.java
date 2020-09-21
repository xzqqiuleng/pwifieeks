package com.peek.camera;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.peek.camera.model.Login_info;

public class IpSetActivity extends Activity {
    EditText et1,et2,et3,et4,et5,et6,et7;
    TextView con_br;
    ImageView back_set;
    TabLayout tabs;
    int posiTion = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_set);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        con_br = (TextView) findViewById(R.id.con_br);
        back_set = (ImageView) findViewById(R.id.back_set);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("中继网络设置"));
        tabs.addTab(tabs.newTab().setText("主机网络设置"));


        et1.setText( BaseApplication.m4928b().getString("VIDEO_IP2",""));
        et2.setText(BaseApplication.m4928b().getString("VIDEO_ACCOUNT2",""));
        et3.setText( BaseApplication.m4928b().getString("VIDEO_PASSWORD2",""));
        et4.setText( BaseApplication.m4928b().getString("baseMainFrameWifiSSID2",""));
        et5.setText( BaseApplication.m4928b().getString("TCP_IP1",""));
        et7.setText( BaseApplication.m4928b().getString("WIFIPD1",""));
        if (BaseApplication.m4928b().getInt("TCP_PORT1",-1) == -1){
            et6.setText( "");
        }else {
            et6.setText( BaseApplication.m4928b().getInt("TCP_PORT",-1)+"");
        }

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                posiTion = tab.getPosition();

                if(posiTion == 0){

                    et1.setText( BaseApplication.m4928b().getString("VIDEO_IP1",""));
                    et2.setText(BaseApplication.m4928b().getString("VIDEO_ACCOUNT1",""));
                    et3.setText( BaseApplication.m4928b().getString("VIDEO_PASSWORD1",""));
                    et4.setText( BaseApplication.m4928b().getString("baseMainFrameWifiSSID1",""));
                    et5.setText( BaseApplication.m4928b().getString("TCP_IP1",""));
                    et7.setText( BaseApplication.m4928b().getString("WIFIPD1",""));
                    if (BaseApplication.m4928b().getInt("TCP_PORT1",-1) == -1){
                        et6.setText( "");
                    }else {
                        et6.setText( BaseApplication.m4928b().getInt("TCP_PORT1",-1)+"");
                    }

                }else {
                    et1.setText( BaseApplication.m4928b().getString("VIDEO_IP2",""));
                    et2.setText(BaseApplication.m4928b().getString("VIDEO_ACCOUNT2",""));
                    et3.setText( BaseApplication.m4928b().getString("VIDEO_PASSWORD2",""));
                    et4.setText( BaseApplication.m4928b().getString("baseMainFrameWifiSSID2",""));
                    et5.setText( BaseApplication.m4928b().getString("TCP_IP2",""));
                    et7.setText( BaseApplication.m4928b().getString("WIFIPD2",""));
                    if (BaseApplication.m4928b().getInt("TCP_PORT2",-1) == -1){
                        et6.setText( "");
                    }else {
                        et6.setText( BaseApplication.m4928b().getInt("TCP_PORT2",-1)+"");
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        back_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        con_br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(posiTion == 0){
                    int port=0;
                    try {
                        port = Integer.parseInt(et6.getText().toString());
                        if (et1.getText().toString().trim().length() < 3 ||et2.getText().toString().trim().length() < 3||et3.getText().toString().trim().length() < 3 ||et4.getText().toString().trim().length() < 3 || et5.getText().toString().trim().length()<3||et7.getText().toString().trim().length()<1){
                            Toast.makeText(IpSetActivity.this,"配置失败，请检查填写的数据！",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        BaseApplication.m4928b().edit().putString(Login_info.VIDEO_IP,et1.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.VIDEO_ACCOUNT,et2.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.VIDEO_PASSWORD,et3.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.baseMainFrameWifiSSID,et4.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.baseRepeaterWifiSSID,et4.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("TCP_IP",et5.getText().toString()).commit();

                        BaseApplication.m4928b().edit().putInt("TCP_PORT",port).commit();
                        BaseApplication.m4928b().edit().putString("WIFIPD1",et7.getText().toString()).commit();




                        BaseApplication.m4928b().edit().putString("VIDEO_IP1",et1.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("VIDEO_ACCOUNT1",et2.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("VIDEO_PASSWORD1",et3.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("baseMainFrameWifiSSID1",et4.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("TCP_IP1",et5.getText().toString()).commit();

                        BaseApplication.m4928b().edit().putInt("TCP_PORT1",port).commit();
                        BaseApplication.m4928b().edit().putString("WIFIPD1",et7.getText().toString()).commit();
                        Toast.makeText(IpSetActivity.this,"配置保存成功！",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(IpSetActivity.this,"请输入正确端口号",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    int port=0;
                    try {
                        port = Integer.parseInt(et6.getText().toString());
                        if (et1.getText().toString().trim().length() < 3 ||et2.getText().toString().trim().length() < 3||et3.getText().toString().trim().length() < 3 ||et4.getText().toString().trim().length() < 3 || et5.getText().toString().trim().length()<3||et7.getText().toString().trim().length()<1){
                            Toast.makeText(IpSetActivity.this,"配置失败，请检查填写的数据！",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        BaseApplication.m4928b().edit().putString(Login_info.VIDEO_IP,et1.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.VIDEO_ACCOUNT,et2.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.VIDEO_PASSWORD,et3.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.baseMainFrameWifiSSID,et4.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString(Login_info.baseRepeaterWifiSSID,et4.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("TCP_IP",et5.getText().toString()).commit();

                        BaseApplication.m4928b().edit().putInt("TCP_PORT",port).commit();





                        BaseApplication.m4928b().edit().putString("VIDEO_IP2",et1.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("VIDEO_ACCOUNT2",et2.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("VIDEO_PASSWORD2",et3.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("baseMainFrameWifiSSID2",et4.getText().toString()).commit();
                        BaseApplication.m4928b().edit().putString("TCP_IP2",et5.getText().toString()).commit();

                        BaseApplication.m4928b().edit().putInt("TCP_PORT2",port).commit();
                        BaseApplication.m4928b().edit().putString("WIFIPD2",et7.getText().toString()).commit();
                        Toast.makeText(IpSetActivity.this,"配置保存成功！",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(IpSetActivity.this,"请输入正确端口号",Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });
    }
}
