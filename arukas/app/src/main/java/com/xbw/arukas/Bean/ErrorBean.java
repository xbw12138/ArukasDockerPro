package com.xbw.arukas.Bean;

import java.util.List;

public class ErrorBean {

    /**
     * statuscode : 422
     * data : {"errors":[{"status":"422","code":"sessions.login-failure","title":"Failed to login"}]}
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
        private List<ErrorsBean> errors;

        public List<ErrorsBean> getErrors() {
            return errors;
        }

        public void setErrors(List<ErrorsBean> errors) {
            this.errors = errors;
        }

        public static class ErrorsBean {
            /**
             * status : 422
             * code : sessions.login-failure
             * title : Failed to login
             */

            private String status;
            private String code;
            private String title;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
