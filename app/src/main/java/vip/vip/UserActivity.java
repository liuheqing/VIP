package vip.vip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import util.ExitApplication;

public class UserActivity extends AppCompatActivity {
 private ImageView iv_back;
    private TextView textView_zhuce;
    private TextView textView_denglu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_center);
        init();
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitApplication.getInstance().clearActivity(UserActivity.this);
            }
        });

        textView_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,RegisterActivity.class );
                startActivity(intent);
            }
        });
        textView_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,LoginActivity.class );
                startActivity(intent);
            }
        });
    }



    private void init() {

        iv_back = (ImageView) findViewById(R.id.my_center_top_bar_back);
        textView_zhuce = (TextView) findViewById(R.id.textView10);
        textView_denglu = (TextView) findViewById(R.id.textView11);
        ExitApplication.getInstance().addActivity(this);
    }
}
