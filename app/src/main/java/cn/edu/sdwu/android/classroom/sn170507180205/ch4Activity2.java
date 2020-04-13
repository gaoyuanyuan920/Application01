package cn.edu.sdwu.android.classroom.sn170507180205;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ch4Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面
        setContentView(R.layout.layout_ch4_2);
        //获取 RadioGroup 进行操作
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.ch4_2_rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                //第二个参数为   RadioButton的id
                RadioButton radioButton=(RadioButton)findViewById(i);
                Object object=radioButton.getTag();//Tag类型为object
                //获取 TextView ，进行操作
                TextView textView=(TextView)findViewById(R.id.ch4_2_tv);
                if(object!=null&&object.toString().equals("1")){
                    textView.setText("right");
                }else{
                    textView.setText("error");
                }

            }


        });
    }
}