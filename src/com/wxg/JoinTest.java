package com.wxg;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxg-a on 2017/7/5.
 */
public class JoinTest {

    public static void main(String[] args) {
        Map<String, Object> params = ImmutableMap.<String, Object>of("type", "departmentMembers",
                "departmentId", "hello", "recursive", "true");

        String departmentId = (String)params.get("departmentId");
        Boolean b = Boolean.parseBoolean((String)params.get("recursive"));
        System.out.println();
    }


}
