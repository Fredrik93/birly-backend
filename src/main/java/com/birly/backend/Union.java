package com.birly.backend;

import java.util.Locale;

public enum Union {
    BANDLANDET, SKOGSMARDEN, LINDSDAL;

    public String displayName(){
        return name().toLowerCase(Locale.ROOT);
    }
}
