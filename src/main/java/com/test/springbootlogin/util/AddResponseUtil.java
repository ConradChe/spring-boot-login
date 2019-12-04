package com.test.springbootlogin.util;

import com.kiegame.business.bean.ApiResponse;

import java.util.ArrayList;
import java.util.List;

public class AddResponseUtil {

    public static ApiResponse addResult(Integer result,String id){
        if (result > 0) {
            List<String> resultList = new ArrayList<>();
            resultList.add(id);
            return new ApiResponse(ApiConst.Code.CODE_SUCCESS.code(), "添加成功",resultList,resultList.size());
        } else {
            return new ApiResponse(ApiConst.Code.CODE_COMMON_ERROR.code(), "添加失败，请重新添加");
        }
    }
}
