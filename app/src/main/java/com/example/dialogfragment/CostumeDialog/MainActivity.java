package com.example.dialogfragment.CostumeDialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dialogfragment.R;

public class MainActivity extends AppCompatActivity implements DialogFragment.OnPositiveClickListner {

    Button costume_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        costume_dialog=findViewById(R.id.costume_dialog);

        costume_dialog.setOnClickListener(v->{
            DialogFragment dialogFragment= DialogFragment.newInstance("hello","what do you want",R.drawable.baseline_wifi_calling_3_24);
            dialogFragment.show(getSupportFragmentManager(),null);
        });

    }

    @Override
    public void OnPositiveButtonClicked(String Edittextmsg) {
        Toast.makeText(this, ""+Edittextmsg, Toast.LENGTH_SHORT).show();

    }
}