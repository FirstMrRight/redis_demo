package com.tea.modules.design.template;

/**
 * @author jaymin<br>
 * 继承模板类，当前角色为营销号<br>
 * 2020/12/6 15:09
 */
public class MarketingUserArticleEvent extends ArticleEventTemplate {

    @Override
    public void write() {
        System.out.println("震惊！当代年轻人竟然平均996:---------");
    }

    @Override
    public void joinMembership() {
        System.out.println("***********会员用户************");
    }
}
