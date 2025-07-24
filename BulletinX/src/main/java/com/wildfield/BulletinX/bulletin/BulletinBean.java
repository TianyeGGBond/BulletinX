package com.wildfield.BulletinX.bulletin;

public class BulletinBean {
    //private修饰，getter setter提取
  private String message;

    // Constructor 构造方法，要和类名同名，new时候创建
    public BulletinBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //重写String的toString接口，返回的不是内存值 是message
    @Override
    public String toString() {
        return "BulletinBean [message=" + message + "]";
    }

}
