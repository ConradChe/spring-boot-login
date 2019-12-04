package com.test.springbootlogin.util;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ProgressUtil
 * @Description
 * @Author SunJie
 * @Date 2019/10/28 0028 14:20
 **/
public class  ProgressUtil {
     public static Map<String,Integer> progressMap = new HashMap<>();
     public static boolean flag = false;

    /*/*
     * 。
     *
      * @param key 同步的用户
     * @param value 同步的数目
     * @return void
     * @exception
     * @author Sunjie
     * @date 2019/10/28 0028 14:23
     */
    public static void setTotalProgressMap(String key,Integer value){
        progressMap.put(key+"_total",value);
    }

    public static void setNumProgressMap(String key,Integer value){
        progressMap.put(key+"_num",value);
    }



    public static Integer getTotalValue(String key){
        return progressMap.get(key+"_total");
    }

    public static Integer getNumValue(String key){
        Integer value = progressMap.get(key + "_num");
        if (null == value){
            setNumProgressMap(key,0);
        }
        return  progressMap.get(key+"_num");
    }



    public static void deleteValue(String key){
        String total = key +"_total";
        String num = key + "_num";
        Set<Map.Entry<String, Integer>> entries = progressMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if (next.getKey().equals(total) || next.getKey().equals(num)){
                iterator.remove();
            }
        }
    }

}
