package com.example.cobagame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int angkarandom;
    public void  angkarandomGenerator() {
        Random rand = new Random();
        angkarandom = rand.nextInt(10) + 1;
    }
    public void onGuess(View view) {
        String pesan = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
            if (guessedNumber < 1 || guessedNumber > 10)
                pesan = "tebakannya harus antara angka 1 sampai 10!!";
            else if (guessedNumber <  angkarandom)
                pesan = "Sayang sekali terlalu tinggi  !!";
            else if (guessedNumber >  angkarandom)
                pesan = "Sayang sekali terlalu rendah !!";
            else {
                pesan = "Tebakan Tepat !!";
                angkarandomGenerator();
            }
        } catch (Exception e) {
            pesan = "tempat tidak boleh kosong";
        } finally {
            Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        angkarandom = rand.nextInt(10) + 1;
    }
}
