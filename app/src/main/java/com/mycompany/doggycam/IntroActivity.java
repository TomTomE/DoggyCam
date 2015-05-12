package com.mycompany.doggycam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Created by Administrator on 2015-05-12.
 */
public class IntroActivity extends Activity {

    Handler h;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);
        h = new Handler();
        h.postDelayed(introrun, 3500);
    }

    Runnable introrun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    };

    //인트로 화면 중간에 뒤로가기 버튼을 눌러서 꺼졌을 경우 4초 후 메인페이지가 뜨는 것을 방지
    @Override
    public  void onBackPressed() {
        super.onBackPressed();
        h.removeCallbacks(introrun);
    }
}