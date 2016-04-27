package com.ninestairs.playlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    /*

        --Basic--
        1. root/src/main/res/layout 아래에 layout 을 정의한 xml 파일들이 있음
        2. layout 종류(LinearLayout, RelativeLayout, etc ... ) 에 따라 다른 속성을 가짐
        3. layout_width & layout_height 속성은 반드시 정의해야 함 (단 외부 라이브러리 사용시 예외 있음)

    */
    Context mContext;
    /**
     *
     * 랜덤한 키를 생성해서 키 정보에 따라 다른 레이아웃을 불러옴
     * Generate random key and fetch different layout.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         mContext = getApplicationContext();

        //랜덤한 키를 생성해서 키 정보에 따라 다른 레이아웃을 불러옴
        //Generate random key and fetch different layout on Create event
        Random generator = new Random();
        int key =  generator.nextInt(3);

        if(key == 1){
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_linear);
        }

        //touch area 에 터치 이벤트 처리
        View ta = findViewById(R.id.touch_area);
        ta.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = MotionEventCompat.getActionMasked(event);

                switch(action){
                    case (MotionEvent.ACTION_DOWN) :
                        Log.d("DEBUG","touch area 클릭다운");
                        return true;

                    case (MotionEvent.ACTION_UP) :
                        Log.d("DEBUG","touch area 클릭업");
                        Intent intent = new Intent(mContext,com.ninestairs.playlayout.RelativeActivity.class);
                        startActivity(intent);
                        return true;

                    default :
                        Log.d("DEBUG","다른 이벤트");
                        return true;
                }

            }
        });


        //TODO: 화면을 스와이프 하면 RelativeActivity 를 화면에 표시함 (테스트 후 추가)



    }

    //@test 화면클릭시 로그출력
    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Log.d("DEBUG", "Action was DOWN");
                return true;

            case (MotionEvent.ACTION_MOVE) :
                Log.d("DEBUG", "Action was MOVE");
                return true;

            case (MotionEvent.ACTION_UP) :
                Log.d("DEBUG","Action was UP");
                Intent intent = new Intent(mContext,com.ninestairs.playlayout.ListViewActivity.class);
                startActivity(intent);
                return true;

            case (MotionEvent.ACTION_CANCEL) :
                Log.d("DEBUG","Action was CANCEL");
                return true;

            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d("DEBUGGGG", "Movement occurred outside bounds of current screen element");
                return true;

            default :
                return super.onTouchEvent(event);
        }
    }


}
