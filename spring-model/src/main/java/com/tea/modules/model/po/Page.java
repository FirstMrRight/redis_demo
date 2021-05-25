package com.tea.modules.model.po;

import lombok.Data;

@Data
public class Page {
    private int page;
    private int pageSize;
    private int startRow;
    private int endRow;
}
