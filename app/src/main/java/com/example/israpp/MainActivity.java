package com.example.israpp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    Button notifyBtn, btn_add, btn_show;
    EditText et_word, et_reading, et_meaning, et_category;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_show = findViewById(R.id.btn_show);
        et_word = findViewById(R.id.et_word);
        et_reading = findViewById(R.id.et_reading);
        et_meaning = findViewById(R.id.et_meaning);
        et_category = findViewById(R.id.et_category);


        //Ingresar datos:
        btn_add.setOnClickListener((v) -> {
            WordModel wordModel;

            try{
                wordModel = new WordModel(-1,
                        et_word.getText().toString(),
                        et_reading.getText().toString(),
                        et_meaning.getText().toString(),
                        et_category.getText().toString(),
                        0);
                Toast.makeText(MainActivity.this, wordModel.toString(), Toast.LENGTH_SHORT).show();
            }catch(Exception e){
                Toast.makeText(MainActivity.this, "Error uploading a word.", Toast.LENGTH_SHORT).show();
                wordModel = new WordModel(-1, "error", "error", "error", "error", 1);
            }

            DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

            boolean success = dataBaseHelper.addW(wordModel);

            Toast.makeText(MainActivity.this, "Succes! " + success, Toast.LENGTH_SHORT).show();


        });



        //Toma mango
        notifyBtn = findViewById(R.id.notify_btn);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("La notificacion", "La notificacion", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "La notificacion")
                        .setContentTitle("La nuea palabra del dia")
                        .setContentText("El kanji más pulento: ")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_launcher_background);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build());
            }
        });


    }


}
