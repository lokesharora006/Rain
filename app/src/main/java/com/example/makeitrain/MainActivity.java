package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    private Button makeItRain;
    private Button ShowInfo;
    private TextView moneyValue;
    private int moneyCounter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeItRain = findViewById(R.id.Buttonmakeitrain);
        ShowInfo = findViewById(R.id.showinfo);

        //makeItRain.setOnClickListener(v -> Log.d("MainActivity", "onClick: Make it rain"));
    }

    public void ShowMoney(View view) {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));

        switch (moneyCounter) {
            case 20000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,
                        R.color.purple_700));
                Toast.makeText(this, "hey you getting richer", Toast.LENGTH_SHORT).show();
                break;
            case 30000:
                moneyValue.setTextColor(Color.MAGENTA);
                break;


            case 40000:
                moneyValue.setTextColor(Color.RED);
                break;
            default:
                moneyValue.setTextColor(Color.WHITE);
        }
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT)
//                .show();

        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", view1 -> {
                    Log.d("Snack", "showInfo: Snackbar More");
                })
                .show();
    }


}
