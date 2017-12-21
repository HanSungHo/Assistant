package kr.inha.inti.assistant;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private long lastTimeBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button simsimButton = (Button) findViewById(R.id.simsim);

        Button trashButton = (Button) findViewById(R.id.trash);
        trashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder trashDialog = new AlertDialog.Builder(MainActivity.this);
                trashDialog.setTitle("쓰레기통 현황").create().show();

            }
        });

        ToggleButton lightButton = (ToggleButton) findViewById(R.id.light);
        lightButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

            }
        });
    } // onCreate 끝

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();

    }

}
