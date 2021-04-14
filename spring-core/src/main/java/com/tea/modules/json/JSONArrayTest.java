package com.tea.modules.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * com.xjm.test
 *
 * @author xiejiemin
 * @create 2020/11/12
 */
public class JSONArrayTest {
    public static void main(String[] args) {
        String json = "[\n" +
                "  {\n" +
                "    \"EvilLabel\": \"Polity\",\n" +
                "    \"EvilType\": 20001,\n" +
                "    \"Keywords\": [\n" +
                "      \"国民党\"\n" +
                "    ],\n" +
                "    \"Score\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"EvilLabel\": \"Illegal\",\n" +
                "    \"EvilType\": 20006,\n" +
                "    \"Keywords\": [\n" +
                "      \"毒品\"\n" +
                "    ],\n" +
                "    \"Score\": 0\n" +
                "  }\n" +
                "]";
        List<JSONObject> jsonObjects = JSON.parseArray(json, JSONObject.class);
        String keywords = jsonObjects.stream().map(jsonObject -> jsonObject.getString("Keywords")).collect(Collectors.joining(","));
        String replace = keywords.replace("[", "").replace("]", "");
        System.out.println(replace);
    }
}
