package com.xbw.arukas.Bean;

import java.util.List;

public class ExtensionBean {


    /**
     * statuscode : 200
     * data : [{"appname":"东灵山","packagename":"com.xbw.mvp","icon":"http://pic.ecfun.cc/15319632485b4fe770a11a4468221","functioncode":101,"functionname":"VPN，镜像请使用xbw12138/auto-shadowsocks:latest 端口：8989 tcp","activity":"com.xbw.mvp.ui.MainActivity","flag":"datajson","appstore":"https://fir.im/r95s","type":"app"},{"appname":"东灵山","packagename":"com.xbw.mvp","icon":"http://pic.ecfun.cc/15319632485b4fe770a11a4468221","functioncode":102,"functionname":"分享SS，镜像请使用xbw12138/auto-shadowsocks:latest 端口：8989 tcp","activity":"com.xbw.mvp.ui.MainActivity","flag":"datajson","appstore":"https://fir.im/r95s","type":"app"},{"appname":"SS加密链接获取","packagename":"","icon":"http://pic.ecfun.cc/15319632485b4fe770a11a4468221","functioncode":103,"functionname":"SS加密链接获取","activity":"","flag":"datajson","appstore":"http//ecfun.cc/vpn/encode.php?url=","type":"web"}]
     */

    private int statuscode;
    private List<DataBean> data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appname : 东灵山
         * packagename : com.xbw.mvp
         * icon : http://pic.ecfun.cc/15319632485b4fe770a11a4468221
         * functioncode : 101
         * functionname : VPN，镜像请使用xbw12138/auto-shadowsocks:latest 端口：8989 tcp
         * activity : com.xbw.mvp.ui.MainActivity
         * flag : datajson
         * appstore : https://fir.im/r95s
         * type : app
         */

        private String appname;
        private String packagename;
        private String icon;
        private int functioncode;
        private String functionname;
        private String activity;
        private String flag;
        private String appstore;
        private String type;

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getPackagename() {
            return packagename;
        }

        public void setPackagename(String packagename) {
            this.packagename = packagename;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getFunctioncode() {
            return functioncode;
        }

        public void setFunctioncode(int functioncode) {
            this.functioncode = functioncode;
        }

        public String getFunctionname() {
            return functionname;
        }

        public void setFunctionname(String functionname) {
            this.functionname = functionname;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getAppstore() {
            return appstore;
        }

        public void setAppstore(String appstore) {
            this.appstore = appstore;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
