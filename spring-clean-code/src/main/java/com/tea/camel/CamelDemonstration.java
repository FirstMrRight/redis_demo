package com.tea.camel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tea.modules.model.HttpResponse;

/**
 * com.tea.camel
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class CamelDemonstration {

    public static void main(String[] args) {
        String responseJson = "{\n" +
                "    \"U_id\": 1,\n" +
                "    \"user_name\": \"jaymin\",\n" +
                "    \"book_price\": 20\n" +
                "}";
        HttpResponse httpResponse = JSONObject.parseObject(responseJson, HttpResponse.class);
        System.out.println(httpResponse.toString());
    }
}
