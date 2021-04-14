package com.tea.modules.design.template;

/**
 * @author jaymin
 * 2020/12/6 1:49
 */
public abstract class ArticleEventTemplate implements ArticleEvent {

    @Override
    public final void pushArticle() {
        joinMembership();
        createArticle();
        write();
        push();
    }

    /**
     * 钩子方法，默认当前用户为普通用户
     */
    protected void joinMembership() {
        System.out.println("************普通用户****************");
    }

    /**
     * 平台默认实现，所有用户复用这个逻辑，不可以重写
     */
    private void createArticle() {
        System.out.println("新建文章");
    }

    /**
     * 抽象方法，子类必须实现
     */
    protected abstract void write();

    /**
     * 平台默认实现，所有用户复用这个逻辑，不可以重写
     */
    private void push() {
        System.out.println("发布 \n");
    }
}
