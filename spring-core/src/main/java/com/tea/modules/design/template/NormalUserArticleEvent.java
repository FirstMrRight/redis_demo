package com.tea.modules.design.template;

/**
 * @author jaymin
 * 继承模板类，当前角色为普通用户br>
 * 2020/12/6 15:07
 */
public class NormalUserArticleEvent extends ArticleEventTemplate {

    @Override
    public void write() {
        System.out.println("随便写写:---------");
    }
}
