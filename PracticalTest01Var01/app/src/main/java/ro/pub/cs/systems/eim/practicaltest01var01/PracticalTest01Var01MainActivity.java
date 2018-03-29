package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.os.PersistableBundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practical_test01_var01_main);

        Button bN = findViewById(R.id.button);
        Button bW = findViewById(R.id.button2);
        Button bE = findViewById(R.id.button3);
        Button bS = findViewById(R.id.button4);
        Button second = findViewById(R.id.button5);

        bN.setOnClickListener(_buttonListener);
        bW.setOnClickListener(_buttonListener);
        bE.setOnClickListener(_buttonListener);
        bS.setOnClickListener(_buttonListener);
        second.setOnClickListener(_buttonListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result = data.getExtras().getString("result");
        Log.d("result", result);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.getString("COUNT") != null);
            _count = Integer.parseInt(savedInstanceState.getString("COUNT"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("COUNT", _count.toString());
    }

    private Integer _count = 0;
    private ButtonOnClickListener _buttonListener = new ButtonOnClickListener();

    private class ButtonOnClickListener implements Button.OnClickListener{

        @Override
        public void onClick(View view) {
            TextView out = findViewById(R.id.textView);
            switch (view.getId())
            {
                case  R.id.button: {
                    String old = out.getText().toString();
                    out.setText(old + "N, ");
                    _count++;
                    break;
                }
                case  R.id.button2: {
                    String old = out.getText().toString();
                    out.setText(old + "W, ");
                    _count++;
                    break;
                }
                case  R.id.button3: {
                    String old = out.getText().toString();
                    out.setText(old + "E, ");
                    _count++;
                    break;
                }
                case  R.id.button4: {
                    String old = out.getText().toString();
                    out.setText(old + "S, ");
                    _count++;
                    break;
                }
                case R.id.button5: {
                    Intent second;
                    second = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    second.putExtra("text", out.getText().toString());
                    startActivityForResult(second, 1);
                    break;
                }
            }
            Log.d("CountButtons", _count.toString());

        }
    }
}
