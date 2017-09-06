package com.hwd.chuichuishuidianuser.httpmanager;

/**
 * Created by Administrator on 2017-04-04.
 */

public interface OnCallBack<T> {
    /**
     * 请求失败的时候调用
     * @param e    异常信息
     *        code 响应码
     */
    public void onFailed(Exception e, int code);

    /**
     * 请求成功的时候调用
     * @param t 所要生成的Bean类
     */
    public  void onSuccess(T t) ;
}
