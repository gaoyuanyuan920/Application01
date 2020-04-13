package cn.edu.sdwu.android.classroom.sn170507180205;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class Ch6Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch6_1);
        String content = getString(R.string.hello);
        Log.i(Ch6Activity1.this.toString(), content);
        String sms = getString(R.string.sms);
        sms = String.format(sms, 100, "张三");
        Log.i(Ch6Activity1.this.toString(), sms);
        // i获收数组资源
        Resources resources = getResources();
        //(整型数组
        int[] intArr = resources.getIntArray(R.array.intArr);
        for (int i = 0; i < intArr.length; i++) {
            Log.i(Ch6Activity1.this.toString(), intArr[i] + "");
        }
        //字符串数组
        String[] strArr = resources.getStringArray(R.array.strArr);
        for (int i = 0; i < strArr.length; i++) {
            Log.i(Ch6Activity1.this.toString(), strArr[i]);
        }
        // 普通类型数组
        TypedArray typedArray = resources.obtainTypedArray(R.array.commanArr);
        ImageView imageView = (ImageView) findViewById(R.id.ch6_i_iv);
        int resId = typedArray.getResourceId(0, 0);
        imageView.setImageResource(resId);
        String str = typedArray.getString(1);
        Log.i(Ch6Activity1.this.toString(), str);
    }

    private Resources resources;
    XmlPullParser xmlPullParser= resources.getXml (R.xml.words);
    {
        try {
            while (xmlPullParser.getEventType()!= XmlPullParser.END_DOCUMENT) {

                if (xmlPullParser.getEventType() == XmlPullParser.START_TAG) {

                    ///判断一下是否是word元於(rords直接路过)

                    if (xmlPullParser.getName().equals("word")) {

                        String word = xmlPullParser.getAttributeValue(0);

                        Class e = null;
                        Log.e(Ch6Activity1.class.toString(),e.toString());
                    }
                }
            }
        }  catch(Exception e){

            Log.e(Ch6Activity1.class.toString(), e.toString());
        }
    }

    public boolean on0ptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mymenu1_item1:
                Toast.makeText(this, "item1 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu1_item2:
                Toast.makeText(this, "item2 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu1_item3 :
                Toast.makeText(this, "item3 ", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }

}