package com.peek.camera.p034b;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import com.peek.camera.BaseApplication;
import com.peek.camera.model.FileInfo;
import com.peek.camera.model.Login_info;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bmw.peek2.b.g */
public class C1129g {

    /* renamed from: a */
    public static final DecimalFormat f3093a = new DecimalFormat("####.##");

    /* renamed from: b */
    public static final DecimalFormat f3094b = new DecimalFormat("####.#");

    /* renamed from: a */
    public static String m5220a() {
        List<String> a = m5224a((Context) BaseApplication.m4925a());
        if (!Login_info.getInstance().isSaveToExSdcard()) {
            return a.get(0);
        }
        if (a.size() > 1) {
            return a.get(a.size() - 1);
        }
        Login_info.getInstance().setSaveToExSdcard(false);
        return a.get(0);
    }

    /* renamed from: a */
    public static String m5221a(long j) {
        if (j < 0) {
            return "0B";
        }
        if (j / 1024 < 1) {
            return j + "B";
        }
        if (j / 1048576 < 1) {
            return f3093a.format((double) (((float) j) / 1024.0f)) + "KB";
        } else if (j / 1073741824 < 1) {
            return f3093a.format((double) (((float) ((j * 100) / 1048576)) / 100.0f)) + "MB";
        } else {
            return f3093a.format((double) (((float) ((j * 100) / 1073741824)) / 100.0f)) + "GB";
        }
    }

    /* renamed from: a */
    public static String m5222a(Context context, String str) {
        String str2 = "";
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            Method method3 = cls.getMethod("getUserLabel", new Class[0]);
            int i = 0;
            while (i < length) {
                Object obj = Array.get(invoke, i);
                String str3 = (String) method3.invoke(obj, new Object[0]);
                String str4 = (String) method2.invoke(obj, new Object[0]);
                C1140n.m5266a(" userLabel = " + str3);
                if (str3 == null || !str3.contains(str)) {
                    str4 = str2;
                }
                i++;
                str2 = str4;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        return str2;
    }

    /* renamed from: a */
    private static String m5223a(String str, File[] fileArr) {
        for (File file : fileArr) {
            if (file != null && file.toString().contains(str) && m5240e(file.toString())) {
                return file.toString();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static List<String> m5224a(Context context) {
        String a;
        ArrayList arrayList = new ArrayList();
        String[] b = m5233b(context);
        String d = m5237d();
        arrayList.add(d);
        if (!(b.length == 0 || b.length == 1)) {
            for (String str : b) {
                if (!str.contains(d)) {
                    if (m5240e(str)) {
                        arrayList.add(str);
                    } else {
                        File[] c = m5236c(context);
                        if (c.length > 1 && (a = m5223a(str, c)) != null) {
                            arrayList.add(a);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<FileInfo> m5225a(Context context, List<FileInfo> list, int i) {
        if (list != null && list.size() > 0) {
            for (FileInfo next : list) {
                if (next != null) {
                    next.setName(m5238d(next.getFilePath()));
                    next.setSizeDesc(m5221a(next.getSize()));
                    next.setFileType(i);
                }
            }
        }
        return list;
    }

    /* renamed from: a */
    public static List<FileInfo> m5226a(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Uri contentUri = MediaStore.Files.getContentUri("external");
        String[] strArr2 = {"_data", "title"};
        String str = "";
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                str = str + " OR ";
            }
            str = str + "_data" + " LIKE '%" + strArr[i] + "'";
        }
        Cursor query = context.getContentResolver().query(contentUri, strArr2, str, (String[]) null, "date_modified DESC");
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    String string = query.getString(0);
                    if (C1155v.m5329a(string, '/') <= 7) {
                        FileInfo fileInfo = new FileInfo();
                        fileInfo.setFilePath(string);
                        try {
                            fileInfo.setSize(new File(string).length());
                        } catch (Exception e) {
                        }
                        arrayList.add(fileInfo);
                    }
                } catch (Exception e2) {
                    Log.i("FileUtils", "------>>>" + e2.getMessage());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m5227a(String str) {
        C1140n.m5266a("updateSystemLibFile path = " + str);
        MediaScannerConnection.scanFile(BaseApplication.m4925a(), new String[]{str}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
    }

    /* renamed from: a */
    public static void m5228a(String str, String str2, String str3) {
        if (!str2.equals(str3)) {
            File file = new File(str + str2);
            File file2 = new File(str + str3);
            if (file.exists()) {
                if (file2.exists()) {
                    for (int i = 1; new File(str + str3 + "_" + i).exists(); i++) {
                    }
                    return;
                }
                file.renameTo(file2);
            }
        }
    }

    /* renamed from: a */
    public static boolean m5229a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        for (File name : file.listFiles()) {
            if (name.getName().equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static int m5230b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.listFiles().length;
        }
        return 0;
    }

    /* renamed from: b */
    public static String m5231b(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (!str.contains(".")) {
            return str;
        }
        return str.substring(0, str.lastIndexOf(".")) + str2;
    }

    /* renamed from: b */
    public static void m5232b() {
        File file = new File(m5220a() + Login_info.local_video_path);
        if (!file.exists()) {
            file.mkdirs();
            BaseApplication.m4928b().edit().putInt("KEY_VIDEO_FILE_COUNT", 1).commit();
        } else if (file.listFiles() != null && file.listFiles().length == 0) {
            BaseApplication.m4928b().edit().putInt("KEY_VIDEO_FILE_COUNT", 1).commit();
        }
        File file2 = new File(m5220a() + Login_info.local_kanban_path);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    /* renamed from: b */
    private static String[] m5233b(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumePaths", new Class[0]);
            method.setAccessible(true);
            return (String[]) method.invoke(storageManager, new Object[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    /* renamed from: c */
    public static String m5234c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 1;
        while (m5229a(str, "00" + i)) {
            i++;
        }
        return "00" + i;
    }

    /* renamed from: c */
    public static void m5235c() {
        File file = new File(m5220a() + Login_info.local_picture_path);
        if (!file.exists()) {
            file.mkdirs();
            BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", 1).commit();
        } else if (file.listFiles() != null && file.listFiles().length == 0) {
            BaseApplication.m4928b().edit().putInt("KEY_PICTURE_FILE_COUNT", 1).commit();
        }
    }

    /* renamed from: c */
    private static File[] m5236c(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs((String) null) : new File[0];
    }

    /* renamed from: d */
    public static String m5237d() {
        return Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory().toString() : Environment.getDownloadCacheDirectory().toString();
    }

    /* renamed from: d */
    public static String m5238d(String str) {
        return (str == null || str.equals("")) ? "" : str.substring(str.lastIndexOf("/") + 1);
    }

    /* renamed from: e */
    public static List<Float> m5239e() {
        String a = m5220a();
        if (!new File(a).exists()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StatFs statFs = new StatFs(a);
        long blockSize = (long) statFs.getBlockSize();
        long blockCount = (long) statFs.getBlockCount();
        float f = ((float) (blockCount * blockSize)) / 1.07374182E9f;
        float availableBlocks = ((float) (((long) statFs.getAvailableBlocks()) * blockSize)) / 1.07374182E9f;
        arrayList.add(Float.valueOf(((float) Math.round(f * 100.0f)) / 100.0f));
        arrayList.add(Float.valueOf(((float) Math.round(availableBlocks * 100.0f)) / 100.0f));
        arrayList.add(Float.valueOf(((float) Math.round((f - availableBlocks) * 100.0f)) / 100.0f));
        return arrayList;
    }

    /* renamed from: e */
    private static boolean m5240e(String str) {
        File file = new File(str + "/a.txt");
        try {
            file.createNewFile();
            file.delete();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
