package com.example.ypc.demo1;

public class Bean {
    boolean isChecked = false;

    public Bean(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isChecked() {

        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
