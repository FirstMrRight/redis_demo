package com.tea.modules.design.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liutx
 * @date 2021/1/6 21:47
 * @Description eg:
 * 一个论坛，需要过滤不良言论，所以说需要针对不同的不良言论类型进行处理
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:), <script>,欢迎访问 49.232.21.180,大家都是996");

        //条件筛选,链式编程
        //链式编程可以使得代码可读性高，链式编程的原理就是返回一个this对象，就是返回本身，达到链式效果
        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new UrlFilter());

        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);
    }

}

class Msg {
    String name;
    String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

/**
 * 封装变化，需要根据不同的类型做不同的处理
 */
interface Filter {
    /**
     * 过滤接口
     *
     * @param m
     */
    void doFilter(Msg m);
}

class HTMLFilter implements Filter {
    @Override
    public void doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        m.setMsg(r);
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replaceAll("996", "955");
        m.setMsg(r);
    }

}

//=========================一下类作为链条2=========================

class FaceFilter implements Filter{

    @Override
    public void doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace(":)" ,"(::)");
        m.setMsg(r);
    }
}


class UrlFilter implements Filter{

    @Override
    public void doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("49.232.21.180","http://49.232.21.180.com");
        m.setMsg(r);
    }
}


/**
 * 消息处理交给链条,使处理逻辑从头走到尾
 */
class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(Msg m) {
        for (Filter f : filters) {
            f.doFilter(m);
        }
    }
}
