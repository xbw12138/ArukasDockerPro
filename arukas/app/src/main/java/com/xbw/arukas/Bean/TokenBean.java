package com.xbw.arukas.Bean;

import java.util.List;

public class TokenBean{

    /**
     * statuscode : 200
     * data : {"token":"eyJhbGciOiJSUzI1NiJ9.eyJ1c2VyX3V1aWQiOiI0NTJjOGZlYS0wOTFiLTRiYzEtYmQwZi1lMjliODBjZjgwYTciLCJleHAiOjE1MzI3NDY0MzEsIm5iZiI6IjE1MzE1MzYyMzEiLCJpc3MiOiJiOTc3NTJlZC1lMGI1LTQ4MGQtOGExZi1iNDA0MGQ3ODg5MjYifQ.J7WWGU6BGTK1jOOaRyts0KXO9z4m4bzl_cTQ-TuasIiRW6ZQ-dt7XqWJViSz6VIw7b8uRwXmTPRTfWXzuSja_RAsG7vIiXfYPlCON0aAiveU1unR2A6D-t6i3dSDpb2hfesBQAClFgI8FpFIdpYyPpVfoyFU0d9aGSaWWj1H7v2XFCmcsecVzBOshQRJGC9rkzHIA9pKNjVTdup4TZRYje0y7xWaEYwGjHkVtta5D0e6zb4k-PYV4Rf2-y2PdJ-0DitBnh-bzMsDh8AqojJpWKr-bXWqT57bS5vXgXxrGrpNCEhcRYaDUzpYxPtmIlqnapRbzcdaEKKTGfl5kkGSjw"}
     */

    private int statuscode;
    private DataBean data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : eyJhbGciOiJSUzI1NiJ9.eyJ1c2VyX3V1aWQiOiI0NTJjOGZlYS0wOTFiLTRiYzEtYmQwZi1lMjliODBjZjgwYTciLCJleHAiOjE1MzI3NDY0MzEsIm5iZiI6IjE1MzE1MzYyMzEiLCJpc3MiOiJiOTc3NTJlZC1lMGI1LTQ4MGQtOGExZi1iNDA0MGQ3ODg5MjYifQ.J7WWGU6BGTK1jOOaRyts0KXO9z4m4bzl_cTQ-TuasIiRW6ZQ-dt7XqWJViSz6VIw7b8uRwXmTPRTfWXzuSja_RAsG7vIiXfYPlCON0aAiveU1unR2A6D-t6i3dSDpb2hfesBQAClFgI8FpFIdpYyPpVfoyFU0d9aGSaWWj1H7v2XFCmcsecVzBOshQRJGC9rkzHIA9pKNjVTdup4TZRYje0y7xWaEYwGjHkVtta5D0e6zb4k-PYV4Rf2-y2PdJ-0DitBnh-bzMsDh8AqojJpWKr-bXWqT57bS5vXgXxrGrpNCEhcRYaDUzpYxPtmIlqnapRbzcdaEKKTGfl5kkGSjw
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String error) {
            this.token = token;
        }

    }

}
