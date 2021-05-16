package com.tea.magic;

/**
 * com.tea.magic <br>
 * 1,2,3,4，这些魔法值到底是什么意思???
 *
 * @author jaymin
 * @since 2021/5/13
 */
public class MagicValueDemonstration {
    /**
     * 季节枚举类
     */
    private enum SeasonEnum {
        /**
         * 春天
         */
        SPRING(1, "Spring"),
        /**
         * 夏天
         */
        SUMMER(2, "Summer"),
        /**
         * 秋天
         */
        AUTUMN(3, "Autumn"),
        /**
         * 冬天
         */
        WINTER(4, "Winter");
        /**
         * 季节值
         */
        private Integer season;
        /**
         * 季节名称
         */
        private String name;

        SeasonEnum(int season, String name) {
            this.season = season;
            this.name = name;
        }

        /**
         * 转换季节名称
         *
         * @param season 季节值
         * @return seasonName
         */
        public static String convertSeasonName(Integer season) {
            for (SeasonEnum seasonEnum : SeasonEnum.values()) {
                if (seasonEnum.season.equals(season)) {
                    return seasonEnum.name;
                }
            }
            return null;
        }
    }

    /**
     * 获取当前季节对应的英文名称
     *
     * @param season 季节值
     * @return
     */
    public String convertSeasonName(Integer season) {
        if (season.equals(1)) {
            return "Spring";
        } else if (season.equals(2)) {
            return "Summer";
        } else if (season.equals(3)) {
            return "Autumn";
        } else if (season.equals(4)) {
            return "Winter";
        }
        return null;
    }
}
