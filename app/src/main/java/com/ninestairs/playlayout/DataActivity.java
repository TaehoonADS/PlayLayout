package com.ninestairs.playlayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DataActivity extends AppCompatActivity {

    /**
     * 3가지 데이터 저장 방식을 이용하여 정보를 표시함
     *
     * 1. key-value
     * 2. file system
     * 3. SQLite
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);



        //key-value
        Context context = this;
        SharedPreferences sharedPref = this.getSharedPreferences(
                "com.ninestairs.playlayout.keyValueStore",
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("age", 28);
        editor.commit();

        int mAge = sharedPref.getInt("age",100);
        Log.d("Debug", String.valueOf(mAge));

        int uAge = sharedPref.getInt("uAge",00);
        Log.d("Debug", String.valueOf(uAge));

        editor.putInt("uAge", 23);
        editor.commit();
        uAge = sharedPref.getInt("uAge",00);
        Log.d("Debug", String.valueOf(uAge));

        SharedPreferences sharedPrefBig = this.getSharedPreferences(
                "com.ninestairs.playlayout.keyValueStoreBig",
                Context.MODE_PRIVATE);

        int bAge  = sharedPrefBig.getInt("age", 50);
        Log.d("Debug", String.valueOf(bAge));




    }
}
