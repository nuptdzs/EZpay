package com.nupt.dzs.juheapi.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 * showapi响应体结构
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class ShowApiResponse {
    private String showapi_res_code;
    private String showapi_res_error;
    private Body showapi_res_body;

    public String getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(String showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public Body getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(Body showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public class Body{
        private PageBean pagebean;

        public PageBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PageBean pagebean) {
            this.pagebean = pagebean;
        }
    }

    public class PageBean{
        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        private int allNum;
        private int allPages;
        private List<FinNewsModel> contentlist;

        public List<FinNewsModel> getContentlist() {
            return contentlist;
        }
    }
}
