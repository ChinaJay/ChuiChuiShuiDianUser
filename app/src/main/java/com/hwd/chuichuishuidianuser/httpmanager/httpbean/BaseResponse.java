package com.hwd.chuichuishuidianuser.httpmanager.httpbean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-07-03.
 */

public class BaseResponse implements Serializable {
    private boolean success;
    private String msg;
    private int count;
    private int pageNo;
    private int pageSize;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
