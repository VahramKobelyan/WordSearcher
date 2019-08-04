

package com.koko.utils;


public abstract class Assert {


    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }


}
