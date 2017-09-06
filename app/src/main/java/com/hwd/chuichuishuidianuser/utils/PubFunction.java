package com.hwd.chuichuishuidianuser.utils;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: quanwen
 * Date: 2017-08-07
 * Time: 16:46
 * Description:
 */

public class PubFunction {
    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 时间格式转化
     */
    public static String getNowDate(String format, String time) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            Date currentTime = formatter.parse(time);
            String dateString = formatter.format(currentTime);
            return dateString;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String saveImageToGallery(Context context, Bitmap bmp, String path, String name) {
        // 首先保存图片
        File appDir = new File(path);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        //        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, name);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            return file.getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //        // 其次把文件插入到系统图库
        //        try {
        //            MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), name, null);
        //        }
        //        catch (FileNotFoundException e) {
        //            e.printStackTrace();
        //        }
        //        // 最后通知图库更新
        //        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
        return null;
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "0秒";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = minute + "分" + second+"秒";
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99小时59分59秒";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = hour + "小时" + minute + "分" + second +"秒";
            }
        }
        return timeStr;
    }

//    public static String unitFormat(int i) {
//        String retStr = null;
//        if (i >= 0 && i < 10)
//            retStr = "0" + Integer.toString(i);
//        else
//            retStr = "" + i;
//        return retStr;
//    }
}
