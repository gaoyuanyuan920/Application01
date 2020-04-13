package cn.edu.sdwu.android.classroom.sn170507180205;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Ch7Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch7_1);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.ch7_1_tb);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(Ch7Activity1.this, "on", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Ch7Activity1.this, "off", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.ch7_1_spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] strArr = getResources().getStringArray(R.array.strArr);
                String content = strArr[i];
                Toast.makeText(Ch7Activity1.this, content, Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}