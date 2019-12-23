package com.i2silly.common.constant;

/**
 * @author hanhan
 */
public enum MonthEnum {
    /**
     * 月份
     */
    Jan("January", 1),
    Feb("February", 2),
    Mar("March", 3),
    Apr("April", 4),
    May("May", 5),
    Jun("June", 6),
    Jul("July", 7),
    Aug("August", 8),
    Sep("September", 9),
    Oct("October", 10),
    Nov("November", 11),
    Dec("December", 12);

    private String name;
    private int index;

    private MonthEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
