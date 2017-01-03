package example.com.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);


        // 在这里，我们构建了一个Intent，这个Intent仅仅是用于传递数据而已，它没有指定任何的“意图”。
        // 紧接着把这个要传递的数据存放在Intent中，然后调用了setReuslt()方法，这个方法非常重要，是专门用于向上一个活动返回数据的。
        // setResult()方法接收两个参数，第一个参数用于向上一个活动返回处理结果，一般只使用RESULT_OK或RESULT_CANCENED这两个值，
        //  第二个参数则把带有数据的Intent传递回去。
        Button button2 = (Button) findViewById(R.id.button_2) ;
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent() ;
                intent.putExtra("data_return", "Hello FirstActivity") ;
                setResult(RESULT_OK, intent) ;
                finish() ;
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent() ;
        intent.putExtra("data_return", "Hello FirstActivity Back") ;
        setResult(RESULT_OK, intent) ;
        finish() ;
    }

}
