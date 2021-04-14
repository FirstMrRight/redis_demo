package com.tea.modules.design.template;

/**
 * @author jaymin
 * 2020/12/6 15:14
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        ArticleEvent normalUserArticleEvent = new NormalUserArticleEvent();
        ArticleEvent marketingUserArticleEvent = new MarketingUserArticleEvent();
        ArticleEvent authorUserArticleEvent = new AuthorUserArticleEvent();
        normalUserArticleEvent.pushArticle();
        marketingUserArticleEvent.pushArticle();
        authorUserArticleEvent.pushArticle();
    }
}
