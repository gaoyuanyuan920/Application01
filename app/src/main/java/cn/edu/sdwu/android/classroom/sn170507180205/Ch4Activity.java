package cn.edu.sdwu.android.classroom.sn170507180205;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch4Activity extends AppCompatActivity implements View.OnFocusChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面
        setContentView(R.layout.layout_ch4_1);
        //1)获取普通界面组件
        Button button = (Button) findViewById(R.id.button1);
        //点击长按图片成为
        ImageView imageView = (ImageView) findViewById(R.id.ch4_iv);
        //3)调用事件源
        button.setOnClickListener(new MyClickListener());

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {

                WallpaperManager wallpaperManager = (WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try {

                    wallpaperManager.setResource(R.raw.img);
                } catch (Exception e) {

                    Log.e(Ch4Activity.class.toString(), e.toString());
                }
                return true;
            }
        });


        EditText email = (EditText) findViewById(R.id.ch4_1_email);
        email.setOnFocusChangeListener(this);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ch4_1_11);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                TextView textview = (TextView) findViewById(R.id.ch4_1_tv);
                textview.setText("x:" + x + ",y:" + y);
                ;
                return false;
            }
        });
    }
    public void onFocusChange(View view, boolean b) {
        //判断邮箱地址的合法性
        EditText editText = (EditText) view;
        if (!b) {
            String content = editText.getText().toString();//得到editText的内容
            //判断邮箱地址的正则表达式
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(regEx1);
            //content email
            Matcher matcher = pattern.matcher(content);
            TextView textView = (TextView) findViewById(R.id.ch4_1_tv);
            if (matcher.matches()) {
                textView.setText("");
            } else {
                textView.setText("email invalidate");
            }
        }
    }
    //2)实现监听类
    // button.setOnClickListener(new MyClickListener());
    class MyClickListener implements View.OnClickListener {
        public void onClick(View view) {
            Log.i(Ch4Activity.class.toString(), "button click");


        }
    }
    public void  startMain(View view){
        //界面跳转
        Intent intent=new Intent(this, MainActivity01.class);
        startActivity(intent);
    }


}