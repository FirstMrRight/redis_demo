package com.tea.modules.design.template;

/**
 * @author jaymin<br>
 * 继承模板类，当前角色为专业的作家<br>
 * 2020/12/6 15:11
 */
public class AuthorUserArticleEvent extends ArticleEventTemplate {

    @Override
    public void write() {
        System.out.println("论中华五千年的文化传承:--------");
    }

    @Override
    public void joinMembership() {
        System.out.println("************会员用户***********");
    }
}
