package com.peek.camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_COMPRESSIONCFG_V30;
import com.hikvision.netsdk.NET_DVR_VIDEOEFFECT;
import com.peek.camera.model.All_id_Info;

public class TXSetFragment extends Fragment {
    SeekBar sb1;
    SeekBar sb2;
    SeekBar sb3;
    SeekBar sb4;
    TextView save_tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fra_txset, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sb1 = (SeekBar) view.findViewById(R.id.sb1);
        sb2= (SeekBar) view.findViewById(R.id.sb2);
        sb3 = (SeekBar) view.findViewById(R.id.sb3);
        sb4 = (SeekBar) view.findViewById(R.id.sb4);
        save_tv = (TextView) view.findViewById(R.id.save_tv);
       sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               iBrightValue = (byte) progress;
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iContrastValue = (byte) progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iSaturationValue = (byte)progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iHueValue = (byte) progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        save_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setConfig();
                Toast.makeText(getContext(),"配置保存成功！",Toast.LENGTH_SHORT).show();
            }
        });
        getConfig();


    }
    public  void getConfig(){
        int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();


        NET_DVR_VIDEOEFFECT VideoEffect = new NET_DVR_VIDEOEFFECT();
        if (!HCNetSDK.getInstance().NET_DVR_ClientGetVideoEffect(m_iLogID2, VideoEffect))
        {
            System.out.println("NET_DVR_ClientGetVideoEffect failed:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }
        else
        {
            //System.out.println("NET_DVR_ClientGetVideoEffect succ"+ VideoEffect.iBrightValue +
            ///VideoEffect.iContrastValue+VideoEffect.iSaturationValue+VideoEffect.iHueValue);
            iBrightValue = (byte) (VideoEffect.byBrightnessLevel);
            iContrastValue = (byte) (VideoEffect.byContrastLevel);
            iSaturationValue = (byte) (VideoEffect.bySaturationLevel);
            iHueValue = (byte) (VideoEffect.bySharpnessLevel );
            System.out.println("NET_DVR_ClientGetVideoEffect succ"+ VideoEffect.byBrightnessLevel +
                    VideoEffect.byContrastLevel+VideoEffect.bySaturationLevel+VideoEffect.byHueLevel);
            sb1.setProgress((int)iBrightValue );
            sb2.setProgress((int)iContrastValue );
            sb3.setProgress((int)iSaturationValue );
            sb4.setProgress((int)iHueValue);
        }
    }
   byte  iBrightValue ;
    byte  iContrastValue;
   byte  iSaturationValue;
   byte  iHueValue;
    public  void setConfig(){

        int m_iLogID2 = All_id_Info.getInstance().getM_iLogID();


        NET_DVR_VIDEOEFFECT VideoEffect = new NET_DVR_VIDEOEFFECT();
        //iBrightValue 亮度，取值范围： [1,10]
        //iContrastValue 对比度，取值范围： [1,10]
        //iSaturationValue 饱和度，取值范围： [1,10]
        //iHueValue 色度，取值范围： [1,10]

        VideoEffect.byBrightnessLevel = iBrightValue;
        VideoEffect.byContrastLevel = iContrastValue;
        VideoEffect.bySaturationLevel = iSaturationValue;
        VideoEffect.bySharpnessLevel = iHueValue;
        if(!HCNetSDK.getInstance().NET_DVR_ClientSetVideoEffect(m_iLogID2, VideoEffect))
        {
            System.out.println("NET_DVR_ClientSetVideoEffect failed:" +  + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }
        else
        {
            Toast.makeText(getContext(),"配置修改成功",Toast.LENGTH_SHORT).show();
            System.out.println("NET_DVR_ClientSetVideoEffect succ");
        }
    }
}
