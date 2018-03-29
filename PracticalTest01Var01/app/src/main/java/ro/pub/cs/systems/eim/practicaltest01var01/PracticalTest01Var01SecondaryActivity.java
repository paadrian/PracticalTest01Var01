package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static ro.pub.cs.systems.eim.practicaltest01var01.R.id.button;
import static ro.pub.cs.systems.eim.practicaltest01var01.R.id.textView2;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    private static String result = "";
    private Listener button = new Listener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        Button button1 = findViewById(R.id.button6);
        Button button2 = findViewById(R.id.button7);

        button1.setOnClickListener(button);
        button2.setOnClickListener(button);

        TextView view = findViewById(R.id.textView2);

        view.setText(getIntent().getExtras().getString("text"));



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView view = findViewById(R.id.textView2);

        view.setText(data.getExtras().getString("text"));
    }

    private class Listener implements Button.OnClickListener
    {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button6:{
                    PracticalTest01Var01SecondaryActivity.result = "cancel";
                    Intent i = new Intent();
                    i.putExtra("result", PracticalTest01Var01SecondaryActivity.result);
                    setResult(RESULT_OK, i);
                    finish();
                    break;
                }
                case R.id.button7 : {
                    PracticalTest01Var01SecondaryActivity.result = "register";
                    Intent i = new Intent();
                    i.putExtra("result", PracticalTest01Var01SecondaryActivity.result);
                    setResult(RESULT_OK, i);
                    finish();
                    break;
                }
            }
        }
    }
}
