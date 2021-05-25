package com.tea.modules.algorithm;

import com.tea.modules.model.po.Page;

public class LimitPage {
    static int totalCount = 60;
    static int playLiveCount = 10;
    static int noticeLiveCount = 20;
    static int endLiveCount = 30;

    public static Page getPage(Page vuePage){
        Page resultPage = new Page();
        int page = vuePage.getPage();
        int pageSize = vuePage.getPageSize();
        int startIndex = (page-1)*pageSize;
        int endIndex = startIndex+pageSize;
        if(endIndex>totalCount){
            System.out.println("别逗了，没有这么多页");
            return null;
        }
        if(playLiveCount>startIndex){
            System.out.println("进入第一区间");
            if(playLiveCount>endIndex){
                System.out.println("终止在第一区间");
                resultPage.setStartRow(startIndex);
                resultPage.setEndRow(endIndex);
                return resultPage;
            }else if(playLiveCount<endIndex && endIndex<(playLiveCount+noticeLiveCount)){
                System.out.println("进入第二区间");
                startIndex = startIndex-playLiveCount;
                if(startIndex<=0){
                    startIndex = 0;
                }
                resultPage.setStartRow(startIndex);
                resultPage.setEndRow(endIndex);
                System.out.println("终止在第二区间");
                return resultPage;
            }else{
                System.out.println("进入第三区间");
                startIndex = startIndex-playLiveCount-noticeLiveCount;
                if(startIndex<=0){
                    startIndex = 0;
                }
                resultPage.setStartRow(startIndex);
                resultPage.setEndRow(endIndex);
                System.out.println("终止在第三区间");
                return resultPage;
            }
        }else if((playLiveCount+noticeLiveCount)>startIndex){
            System.out.println("进入第二区间");
            startIndex = startIndex-playLiveCount;
            if(startIndex<=0){
                startIndex = 0;
            }
            resultPage.setStartRow(startIndex);
            resultPage.setEndRow(endIndex);
            System.out.println("终止在第二区间");
            return resultPage;
        }
        return resultPage;
    }

}
