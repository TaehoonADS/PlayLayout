package com.ninestairs.playlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        Button btn  = (Button) findViewById(R.id.button_position_third);
        View view = (View) findViewById(R.id.percentRelativeLayout);

        int x = view.getLeft();
        int y = view.getTop();

        int mw = view.getMeasuredWidth();
        int mh = view.getMeasuredHeight();

        int w = view.getWidth();
        int h = view.getHeight();

        String msg = "x좌표는 " + String.valueOf(x)
                    +"y좌표는 " + String.valueOf(y)
                    +"MeasuredWidth는 " + String.valueOf(mw)
                    +"MeasuredHeight는 " + String.valueOf(mh)
                    +"Width는 " + String.valueOf(w)
                    +"Height는 " + String.valueOf(h);

        btn.setText(msg);



    }
}
