package com.example.chaizexu.tinnews.common;

import android.os.Bundle;

/**
 * Created by chai on 9/17/18.
 */

public interface TinFragmentManager {
    void doFragmentTransaction(TinBasicFragment basicFragment);
    void startActivityWithBundle(Class<?> clazz, boolean isFinished, Bundle bundle);

    void showSnackBar(String message);
}
