package com.i2silly.common.constant;

/**
 * @author hanhan
 */

public enum ModeEnum {
    /**
     * 模式
     */
    TRIM_LEFT(-1),
    TRIM_RIGHT(1),
    TRIM_ALL(0);

    private int mode;

    ModeEnum(int mode){
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}
