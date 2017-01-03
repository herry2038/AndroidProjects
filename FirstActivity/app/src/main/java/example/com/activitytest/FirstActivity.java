package example.com.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button) ;
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 1. Toast 使用方法
                //Toast.makeText(FirstActivity.this, "You clicked Button 1",
                //       Toast.LENGTH_SHORT).show() ;

                // 2. 显示Intent
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class) ;
                //startActivity(intent) ;

                // 3. 隐式Intent
                Intent intent = new Intent("com.example.activitytest.ACTION_START") ;
                intent.addCategory("com.example.activitytest.MY_CATEGORY") ;
                //startActivity(intent) ;
                startActivityForResult(intent, 1) ;  //  用于从intent指向的Activity中返回结果。

                // 2.3.3 更多隐式Intent的用法
//                Intent intent = new Intent(Intent.ACTION_VIEW) ;
//                intent.setData(Uri.parse("http://www.baidu.com")) ;
//                startActivity(intent) ;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.close_item:
                finish() ;
                break ;
            default:
        }
        return true ;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch ( requestCode ) {
            case 1:
                if ( resultCode == RESULT_OK ) {
                    String returnedData = data.getStringExtra("data_return") ;
                    Log.d("FirstActivity", returnedData) ;
                }
                break ;
            default:

        }
    }
}
