package com.tea.modules.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * com.xjm.model
 *
 * @author xiejiemin
 * @create 2020/11/10
 */
public class Test {
    public static class VO {
        public int id;

        @JSONField(unwrapped = true)
        public Localtion localtion;
    }
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static  class PageVO<T> implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 当前页
         */
        @JSONField(name = "p")
        private Integer page;

        /**
         * 每页数量
         */
        @JSONField(name = "page_size")
        private Integer pageSize;

        /**
         * 请求参数对象
         */
        @JSONField(unwrapped = true)
        private T params;
    }
    public static class Localtion {
        public int longitude;
        public int latitude;

        public Localtion() {}

        public Localtion(int longitude, int latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }


    public static void main(String[] args) {
        VO vo = new VO();
        vo.id = 123;
        vo.localtion = new Localtion(127, 37);

        String text = JSON.toJSONString(vo);
        System.out.println(Objects.equals("{\"id\":123,\"latitude\":37,\"longitude\":127}", text));

        VO vo2 = JSON.parseObject(text, VO.class);
        System.out.println(Objects.equals(vo.localtion.latitude, vo2.localtion.latitude));
        System.out.println(Objects.equals(vo.localtion.longitude, vo2.localtion.longitude));

        PageVO<Object> build = PageVO.builder().page(1).pageSize(10).build();
        String s = JSON.toJSONString(build);
        System.out.println(s);
        PageVO pageVO = JSONObject.parseObject(s, PageVO.class);
        System.out.println(pageVO.toString());
    }
}
