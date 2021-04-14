package com.tea.modules.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * com.xjm.spring.util
 *
 * @author xiejiemin
 * @create 2020/12/21
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class PageUtils<T> implements Serializable {
    /**
     * 分页参数非法
     */
    private final static String NUMBER_ILLEGAL_EXCEPTION = "please input legal parameter for page operation.";
    /**
     * 分页参数不存在
     */
    private final static String PARAM_NULL_EXCEPTION = "paging parameter does not exist.";
    /**
     * 分页参数过大
     */
    private final static String PAGE_LIMIT_ILLEGAL_EXCEPTION = "The requested paging parameter is too large.";
    /**
     * 分页偏移量大小限制
     */
    private final static String PAGE_LIMIT_ILLEGAL = "web.pagination.limit";
    /**
     * 分页页数大小限制
     */
    private final static String PAGE_ILLEGAL = "web.pagination.page";

    private List<T> records;

    private long total;

    private long size;

    private long current;

    public PageUtils(Page<T> page) {
        this.total = page.getTotal();
        this.current = page.getCurrent();
        this.size = page.getSize();
    }

    public PageUtils(Page<T> page, List<T> list) {
        this.records = list;
        this.total = page.getTotal();
        this.current = page.getCurrent();
        this.size = page.getSize();
    }

    public static void checkPageParamLegal(Long page, Long pageSize) {
        if (Objects.isNull(page) || Objects.isNull(pageSize)) {
            throw new RuntimeException(PARAM_NULL_EXCEPTION);
        }
        if (page < 0 || pageSize < 0) {
            throw new RuntimeException(NUMBER_ILLEGAL_EXCEPTION);
        }
        Long pageIllegal = SpringUtil.getApplicationContext().getEnvironment().getProperty(PAGE_ILLEGAL, Long.class, 1000L);
        if (page > pageIllegal) {
            throw new RuntimeException((PAGE_LIMIT_ILLEGAL_EXCEPTION));
        }
        Long pageLimitIllegal = SpringUtil.getApplicationContext().getEnvironment().getProperty(PAGE_LIMIT_ILLEGAL, Long.class, 100L);
        if (pageSize > pageLimitIllegal) {
            throw new RuntimeException((PAGE_LIMIT_ILLEGAL_EXCEPTION));
        }
    }
}
