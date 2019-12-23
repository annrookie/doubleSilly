package com.i2silly.common.constant;

/**
 * @author hanhan
 * @version 1.0
 */

public enum WeekEnum {
    /**
     * 星期
     */
    Mon("Monday", 1),
    Tue("Tuesday", 2),
    Wed("Wednesday", 3),
    Tur("Thursday", 4),
    Fri("Friday", 5),
    Sat("Saturday", 6),
    Sun("Sunday", 7);

    private String name;
    private int index;

    WeekEnum(String name, int index) {
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
