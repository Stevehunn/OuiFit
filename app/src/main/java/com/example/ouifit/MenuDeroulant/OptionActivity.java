package com.example.ouifit.MenuDeroulant;

import android.app.Activity;
import android.os.Bundle;

import com.example.ouifit.R;

public class OptionActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

    }

    /*------------------------Cycle de vie de l'activité-----------------------*/
    protected void onPause() {
        super.onPause();
        finish();
    }

}
