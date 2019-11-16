package com.tj.y.web.utils;


import com.tj.y.web.consts.PortalUserConstants;

import java.util.Map;

public class PortalUserContextHelper {
    private static ThreadLocal<Map<String, Object>> ownerThreadLocal = new ThreadLocal<>();

    public static void putUser(Map<String, Object> map){
        ownerThreadLocal.set(map);
    }

    public static Integer getUserId(){
        Map<String, Object> ownerMap = ownerThreadLocal.get();

        return Integer.parseInt(ownerMap.get(PortalUserConstants.USER_ID).toString());
    }

    public static String getNickname(){
        Map<String, Object> ownerMap = ownerThreadLocal.get();

        return ownerMap.get(PortalUserConstants.NICKNIME).toString();
    }

}
