package com.nupt.dzs.juheapi.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class JuHePageResponse<T> {
    /**
     * 结果码 200 为成功
     */
    private String resultcode;
    /**
     * 错误码
     */
    private String error_code;
    /**
     * 原因
     */
    private String reason;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public JuHePageResult getResult() {
        return result;
    }

    public void setResult(JuHePageResult result) {
        this.result = result;
    }

    /**
     * 数据结果集
     */
    private JuHePageResult<T> result;
    public class JuHePageResult<M>{
        private String totalCount;/*总条数*/
        private String page; /*当前页*/
        private String num; /*显示条数*/
        private List<M> data;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<M> getData() {
            return data;
        }

        public void setData(List<M> data) {
            this.data = data;
        }
    }
}
