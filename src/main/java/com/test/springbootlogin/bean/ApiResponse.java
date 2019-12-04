package com.test.springbootlogin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.springbootlogin.util.ApiConst;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一的执行完毕后的返回对象
 *
 * @author pandong
 * @date 2019年11月19日 下午14:48:09
 * @copyright(c) kiegame.com
 */
public class ApiResponse {
    private static final long serialVersionUID = -1;
    private long code;
    private String message;
    private List data;
    private long total;

    public ApiResponse() {

    }

    public ApiResponse(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(long code, String message, List data, long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getData() {
        return data != null ? data : new ArrayList();
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getLength() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 判断是否成功
     * @return
     */
    @JsonIgnore
    public Boolean isSuccess(){
        return ApiConst.Code.CODE_SUCCESS.code() == this.code;
    }

    /**
     * 构建成功提示返回对象
     * @param message
     * @return
     */
    public static ApiResponse buildSuccessMessage(String message){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_SUCCESS.code());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    /**
     * 构建错误提示返回对象
     * @param message
     * @return
     */
    public static ApiResponse buildErrorMessage(String message){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_COMMON_ERROR.code());
        apiResponse.setMessage(message);
        return apiResponse;
    }

    /**
     * 构建成功返回数据对象
     * @param obj
     * @return
     */
    public static ApiResponse buildSuccessResponse(Object obj){
        List respList;
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ApiConst.Code.CODE_SUCCESS.code());
        apiResponse.setMessage("success");
        if(obj instanceof List){
            respList = (List) obj;

        }else {
            respList = new ArrayList();
            respList.add(obj);
        }
        apiResponse.setData(respList);
        return apiResponse;
    }

    /**
     * 将当前对象转换为json
     *
     * @return
     */
    public String asJSON() {
        return "";
    }

    @Override
    public String toString() {
        String resultMsg = "CODE:[" + code + "],MESSAGE:[" + message + "]";
        if (data != null) {
            resultMsg += ",DATA:[LIST TOTAL=" + total + " LEN=" + getLength() + "]";
        }
        return resultMsg;
    }


}
