package com.peek.camera.view.p038b;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.peek.camera.R;
import com.peek.camera.model.Login_info;
import com.peek.camera.view.view.SwitchButton;

/* renamed from: com.bmw.peek2.view.b.h */
public class C1229h implements View.OnClickListener {

    /* renamed from: a */
    private AlertDialog f3343a;

    /* renamed from: b */
    private Login_info f3344b = Login_info.getInstance();

    /* renamed from: c */
    private EditText f3345c;

    /* renamed from: d */
    private EditText f3346d;

    /* renamed from: e */
    private EditText f3347e;

    /* renamed from: f */
    private EditText f3348f;

    /* renamed from: g */
    private EditText f3349g;

    /* renamed from: h */
    private EditText f3350h;

    /* renamed from: i */
    private EditText f3351i;

    /* renamed from: j */
    private EditText f3352j;

    /* renamed from: k */
    private TextView f3353k;

    /* renamed from: l */
    private TextView f3354l;

    /* renamed from: m */
    private TextView f3355m;

    /* renamed from: n */
    private SwitchButton f3356n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f3357o;

    /* renamed from: p */
    private SwitchButton f3358p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f3359q;

    /* renamed from: r */
    private Context f3360r;

    /* renamed from: s */
    private SwitchButton f3361s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f3362t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C1234a f3363u;

    /* renamed from: com.bmw.peek2.view.b.h$a */
    public interface C1234a {
        /* renamed from: a */
        void mo5099a(boolean z);
    }

    public C1229h(Context context) {
        this.f3360r = context;
        this.f3343a = new AlertDialog.Builder(context).create();
        this.f3343a.setCanceledOnTouchOutside(false);
        Window window = this.f3343a.getWindow();
        window.setWindowAnimations(R.style.dialog_anim);
        this.f3343a.setView(new EditText(context));
        this.f3343a.show();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        window.setAttributes(this.f3343a.getWindow().getAttributes());
        window.setGravity(17);
        window.setContentView(R.layout.dialog_setting);
        this.f3345c = (EditText) window.findViewById(R.id.haikang_ip);
        this.f3346d = (EditText) window.findViewById(R.id.haikang_port);
        this.f3348f = (EditText) window.findViewById(R.id.haikang_password);
        this.f3347e = (EditText) window.findViewById(R.id.haikang_account);
        this.f3349g = (EditText) window.findViewById(R.id.socket_ip);
        this.f3350h = (EditText) window.findViewById(R.id.socket_port);
        this.f3351i = (EditText) window.findViewById(R.id.wifi_ssid);
        this.f3352j = (EditText) window.findViewById(R.id.wifi_password);
        this.f3353k = (TextView) window.findViewById(R.id.set_sure);
        this.f3354l = (TextView) window.findViewById(R.id.set_cancel);
        this.f3355m = (TextView) window.findViewById(R.id.set_reset);
        this.f3356n = (SwitchButton) window.findViewById(R.id.wifi_isConnect_auto);
        this.f3358p = (SwitchButton) window.findViewById(R.id.haikang_zimaliu);
        this.f3361s = (SwitchButton) window.findViewById(R.id.permission2just);
        this.f3345c.setText(this.f3344b.getVideo_ip());
        this.f3346d.setText(this.f3344b.getVideo_port() + "");
        this.f3347e.setText(this.f3344b.getVideo_account());
        this.f3348f.setText(this.f3344b.getVideo_password());
        this.f3349g.setText(this.f3344b.getSocket_ip());
        this.f3350h.setText(this.f3344b.getSocket_port() + "");
        this.f3351i.setText(this.f3344b.getWifi_SSID());
        this.f3352j.setText(this.f3344b.getWifi_Password());
        this.f3357o = this.f3344b.isWifi_auto();
        this.f3359q = this.f3344b.isVideo_zimaliu();
        this.f3362t = this.f3344b.isPermisionLog();
        this.f3356n.setChecked(this.f3357o);
        this.f3358p.setChecked(this.f3359q);
        this.f3361s.setChecked(this.f3362t);
        this.f3356n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = C1229h.this.f3357o = z;
            }
        });
        this.f3358p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = C1229h.this.f3359q = z;
            }
        });
        this.f3361s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = C1229h.this.f3362t = z;
            }
        });
        this.f3353k.setOnClickListener(this);
        this.f3354l.setOnClickListener(this);
        this.f3355m.setOnClickListener(this);
        this.f3343a.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getRepeatCount() == 0) {
                    C1229h.this.f3363u.mo5099a(false);
                }
                return false;
            }
        });
    }

    /* renamed from: b */
    private boolean m5599b() {
        return !this.f3345c.getText().toString().equals("") && !this.f3346d.getText().toString().equals("") && !this.f3347e.getText().toString().equals("") && !this.f3348f.getText().toString().equals("") && !this.f3349g.getText().toString().equals("") && !this.f3350h.getText().toString().equals("") && !this.f3351i.getText().toString().equals("") && !this.f3352j.getText().toString().equals("") && this.f3349g.getText().toString().split("\\.").length == 4 && this.f3345c.getText().toString().split("\\.").length == 4;
    }

    /* renamed from: a */
    public void mo5092a() {
        this.f3363u.mo5099a(false);
        this.f3343a.dismiss();
    }

    /* renamed from: a */
    public void mo5093a(C1234a aVar) {
        this.f3363u = aVar;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.set_cancel:
                mo5092a();
                return;
            case R.id.set_reset:
                this.f3345c.setText(Login_info.base_video_ip);
                this.f3346d.setText("8000");
                this.f3347e.setText(Login_info.base_video_account);
                this.f3348f.setText(Login_info.base_video_password);
                this.f3349g.setText(Login_info.base_socket_ip);
                this.f3350h.setText("50001");
                this.f3351i.setText(Login_info.baseMainFrameWifiSSID);
                this.f3352j.setText("bmwpeek2shost");
                this.f3356n.setChecked(true);
                this.f3358p.setChecked(false);
                return;
            case R.id.set_sure:
                if (m5599b()) {
                    this.f3344b.setData(this.f3345c.getText().toString(), this.f3346d.getText().toString(), this.f3347e.getText().toString(), this.f3348f.getText().toString(), this.f3349g.getText().toString(), Integer.valueOf(this.f3350h.getText().toString()).intValue(), this.f3351i.getText().toString(), this.f3352j.getText().toString(), this.f3357o, this.f3359q);
                    this.f3344b.setPermisionLog(this.f3362t);
                    if (this.f3363u != null) {
                        this.f3363u.mo5099a(true);
                    }
                    mo5092a();
                    return;
                }
                Toast.makeText(this.f3360r, "输入格式有误，请重新输入！", 0).show();
                return;
            default:
                return;
        }
    }
}
