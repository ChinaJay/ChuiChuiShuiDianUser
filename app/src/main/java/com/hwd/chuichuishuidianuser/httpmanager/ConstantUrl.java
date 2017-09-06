package com.hwd.chuichuishuidianuser.httpmanager;

/**
 * Created by Administrator on 2017-07-03.
 */

public class ConstantUrl {
//    public static String HOST = "http://xc.hwangda.com/MoCar/appInterface/";

    // 测试地址
    public static String HOST = "http://192.168.0.123:8080/fluentDrive/interface/";

  public static String WXPAY_URL ="";

    // 获取用户详情
    public static String GETUSERINFO = "user/getCxUserDetails?";
    // 修改用户信息
    public static String CHANGEUSERINFO = "user/updateCxUser?";
    // 修改手机号获取验证码
    public static String GETVERYCODEFORPHONECHANGE = "user/updateSendverificationCode?";
    // 修改手机号
    public static String CHANGEPHONE = "user/updatePhone?";
  // 获取验证码
  public static String GETVERSONCODE = "login/loginSendverificationCode";
  // 登录
  public static String LOGIN = "login";
  // 获取站点车辆列表
  public static String CARLIST = "site/queryCarListBySiteId";
  // 获取车辆详情
  public static String CARINFO = "site/queryCarInfoById";
  //申请投放
  public static String DELIVERY ="site/applyDelivery";
  //通过编号获取车辆信息
  public static String CARINFOBYNOW ="site/getCarInfoByNumber";
  //确认租车生成订单接口
  public static String MAKEORDER ="order/makeOrder";
  //用户开锁接口
  public static String UNLOCKCAR ="order/unLockCar";
  // 获取用户钱包接口
  public static String GETUSERWALLET = "user/getCxUserAccount?";
  //用户锁车接口
  public static String LOCKCAR ="order/lockCar";
  // 获取充值规则
  public static String GETCHARGETYPE = "user/getRechargeRuleList";
  // 获取消息列表
  public static String GETMESSAGELIST = "user/getCxUserMessageList";
  // 获取用户消费记录
  public static String GETCONSUMPTION = "user/getCxUserConsumeRecord";
  // 获取行程记录
  public static String GETTRIPLIST = "user/getCxUserOrderRecord";
  // 车费预算接口
  public static String ESTIMATEDCOST = "order/estimatedCost";
  // 还车接口
  public static String RETURNCARANDCALC = "order/ReturnCarAndCalc";
  // 充值明细列表
  public static String GETCHARGELIST = "user/getCxUserRechargeInfo";
  // 提现申请
  public static String WIDTHDRAW = "user/userTakeMoney";
  // 提现记录列表
  public static String WITHDRAWLIST = "";
  // 支付接口
  public static String GETALIPAYINFO = "alipay/alipay";
  // 根据坐标获取站点
  public static String GETCXSITELIST = "site/getCxSiteListByCoordinate";
  // 根据坐标获取站点
  public static String ISUNSETTLEDORDER = "order/isUnsettledOrder";
  // 获取站点信息和站点车辆
  public static String GETSITEANDCAR = "site/getSiteAndCarBeanById";
  // 还车资费预算接口
  public static String CONFIRMRETURN = "order/confirmReturnCar";
}
