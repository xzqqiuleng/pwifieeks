package com.peek.camera;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_COMPRESSIONCFG_V30;
import com.hikvision.netsdk.NET_DVR_VIDEOEFFECT;
import com.peek.camera.model.All_id_Info;

public class MovieSetFragment extends Fragment {
    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    TextView save_tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fra_cs_set, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sp1 = (Spinner) view.findViewById(R.id.sp1);
        sp2= (Spinner) view.findViewById(R.id.sps2);
        sp3 = (Spinner) view.findViewById(R.id.sp3);
        save_tv = (TextView) view.findViewById(R.id.save_tv);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case  0:
                        reSolution = 19;
                        break;
                    case  1:
                        reSolution = 20;
                        break;
                    case  2:
                        reSolution = 27;
                        break;
                    case  3:
                        reSolution = 30;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case  0:
                        frameRate = 13;
                        break;
                    case  1:
                        frameRate = 16;
                        break;
                    case  2:
                        frameRate = 17;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case  0:
                        encType = 1;
                        break;
                    case  1:
                        encType = 10;
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        save_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setConfig();
            }
        });
        getConfig();


    }
    public  void getConfig(){
        int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();
        NET_DVR_COMPRESSIONCFG_V30 CompressionCfg = new NET_DVR_COMPRESSIONCFG_V30();
        if (!HCNetSDK.getInstance().NET_DVR_GetDVRConfig(m_iLogID2, HCNetSDK.NET_DVR_GET_COMPRESSCFG_V30, All_id_Info.getInstance().getM_iChanNum(), CompressionCfg))
        {
            System.out.println("get CompressionCfg failed!" + "err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }else
        {

           reSolution =   CompressionCfg.struNormHighRecordPara.byResolution;
          frameRate  = CompressionCfg.struNormHighRecordPara.dwVideoFrameRate;
          encType =   CompressionCfg.struNormHighRecordPara.byVideoEncType;
            System.out.println("get CompressionCfg succ! ");
            //分辨率 16-VGA(640*480)， 19，1280*720   20，1280*960    27，1920*1080       30，2048*1536
            System.out.println("分辨率: " + CompressionCfg.struNormHighRecordPara.byResolution);
            //视频帧率0-全部， 1-1/16，2-1/8，3-1/4，4-1/2，5-1，6-2，7-4，8-6，9-8，10 -10 ，11 -12 ，12 -16 ，13 -20 ， 14 -15 ，15 -18 ，
            //
            //13 -20  16 －22 ，17 -25
            System.out.println("视频帧数: " + CompressionCfg.struNormHighRecordPara.dwVideoFrameRate);
            //视频编码类型： 1-标准 h264，10 -标准 h265
            System.out.println("视频编码类型: " + CompressionCfg.struNormHighRecordPara.byVideoEncType);
        }
            switch (reSolution){
            case 19:
                sp1.setSelection(0);
                break;
            case 20:
                sp1.setSelection(1);
                break;
            case 27:
                sp1.setSelection(2);
                break;
            case 30:
                sp1.setSelection(3);
                break;
            default:

                break;
        }

        switch (frameRate){
            case 13:
                sp2.setSelection(0);
                break;
            case 16:
                sp2.setSelection(1);
                break;
            case 17:
                sp2.setSelection(2);
                break;


            default:

                break;
        }

        switch (encType){
            case 1:
                sp3.setSelection(0);
                break;
            case 10:
                sp3.setSelection(1);
                break;

            default:

                break;
        }
    }
   byte  reSolution;
   int  frameRate;
   byte  encType;
    public  void setConfig(){
        NET_DVR_COMPRESSIONCFG_V30 CompressionCfg = new NET_DVR_COMPRESSIONCFG_V30();

        CompressionCfg.struNormHighRecordPara.byVideoEncType = encType;
        CompressionCfg.struNormHighRecordPara.dwVideoFrameRate = frameRate;
        CompressionCfg.struNormHighRecordPara.byResolution = reSolution;
        int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();
        if (!HCNetSDK.getInstance().NET_DVR_SetDVRConfig(m_iLogID2, HCNetSDK.NET_DVR_SET_COMPRESSCFG_V30, All_id_Info.getInstance().getM_iChanNum(), CompressionCfg))
        {
            System.out.println("Set CompressionCfg failed!" + "err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }else
        {  Toast.makeText(getContext(),"配置修改成功",Toast.LENGTH_SHORT).show();
            System.out.println("Set CompressionCfg succ!" );
        }

    }
}
