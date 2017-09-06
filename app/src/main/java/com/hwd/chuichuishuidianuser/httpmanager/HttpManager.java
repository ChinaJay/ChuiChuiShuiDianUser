package com.hwd.chuichuishuidianuser.httpmanager;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017-04-04.
 */

public class HttpManager {


    private static final int ON_SUCCESS = 0;
    private static final int ON_ERROE = 1;
    private static final int ON_FAILURE = 2;
    private static final int ON_JSON_ERROR = 3;
    private static final HttpManager manager = new HttpManager();
    private final OkHttpClient client;
    String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=utf-8";
    OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();
    private Request request;
    private Context ctx;
    private Handler handler = new Handler(Looper.getMainLooper());

    private HttpManager() {
        client = mBuilder.connectTimeout(10, TimeUnit.SECONDS).build();
    }

    public static HttpManager getInstance() {
        return manager;
    }

    /**
     * 联网获取数据的封装
     * @param url     联网的url
     * @param context 上下文
     * @param params  请求参数Map集合，可以传多个参数
     * @param clazz   所要获取的bean类
     * @param onCallBack  返回数据的回调
     */
    public <T> void getBeanFromNet(String url, final Context context, Map<String, ?> params, final Class<T> clazz, final OnCallBack<T> onCallBack) {
        FormBody.Builder builder = new FormBody.Builder();
        FormBody.Builder bd = new FormBody.Builder();
        String body = "";
        try {
            if (params != null && params.size() != 0) {
                for (String key : params.keySet()) {
                    bd.add(key, params.get(key).toString());
                }
                body = new Gson().toJson(params);
            } else {
                body = new Gson().toJson(new HashMap<String, String>());
            }
            ConnectivityManager con = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
            boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
            boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
            if (!wifi && !internet) {
                Toast.makeText(context, "亲，没网络,请检查网络连接", Toast.LENGTH_SHORT).show();
                return;
            }
            body = URLEncoder.encode(body, "utf-8");//参数信息，通过URLEncoder编码
            FormBody formBody = bd.build();
            request = new Request.Builder().url(ConstantUrl.HOST + url).post(formBody).addHeader("Content-Type", CONTENT_TYPE).build();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        client.newCall(request).enqueue(new Callback() {
            //请求失败的回调
            @Override
            public void onFailure(final Call call, final IOException e) {
                if (context == null) {
                    return;
                }
                Log.i("test", "faliure");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onCallBack.onFailed(e, 110);
                    }
                });
            }

            //请求成功的回调
            @Override
            public void onResponse(Call call, Response response) {
                if (context == null) {
                    return;
                }
                try {
                    String json = response.body().string();
                    final int code = response.code();
                    if (code >= 200 && code < 300) {
                        Log.i("test", "success");
                        final T t = new Gson().fromJson(json.trim(), clazz);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                onCallBack.onSuccess(t);
                            }
                        });
                    } else {
                        Log.i("test", "" + code);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                onCallBack.onFailed(null, code);
                            }
                        });
                    }
                }
                catch (final IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onCallBack.onFailed(e, 111);
                        }
                    });
                }
                catch (final JsonParseException je) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onCallBack.onFailed(je, 112);
                        }
                    });
                }
            }
        });
    }
}
