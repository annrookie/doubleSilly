package com.rookie.common.constant;

/**
 * @author hanhan
 */

public enum Mode {
    /**
     * 模式
     */
    TRIM_LEFT(-1),
    TRIM_RIGHT(1),
    TRIM_ALL(0);

    private int mode;

    Mode(int mode){
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}
