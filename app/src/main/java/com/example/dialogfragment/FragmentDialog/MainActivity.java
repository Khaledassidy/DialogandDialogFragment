package com.example.dialogfragment.FragmentDialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dialogfragment.R;

public class MainActivity extends AppCompatActivity implements DialogFragment.OnPositiveClickListner, DialogFragment.OnNegativeClickListner, DialogFragment.OnNuetralClickListner {

    Button dialog_frag_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dialog_frag_btn=findViewById(R.id.Dialog_Fragmnet_btn);

        dialog_frag_btn.setOnClickListener(v->{
            //hala2 bade estd3e l fragment:
            //bestd3e l fragemnt le esmo DialogFragment
            //w b3abe data bel newinstance

            //ba3den 3ashen 2a3ml l fragment show fe method bel fragemnt esma show hay l method bas mawjoude bel dialogfragemnt
            //bye5od l fragmentmanage,w string le howe tag momken t5ale null howe nous momken ykoun mortabet fe 3ashen law badak teb7as 3an l fragemnt bel nous taba3a  2aw tetb3a sha8le mo3yane law 5alyta null  ma btefre2

            //law badak by code te5fe lal fragemnt fe method esma dismiss fragment.dismiss();
            DialogFragment fragment=new DialogFragment();
            fragment.show(getSupportFragmentManager(),null);

            //bas toast heda taba3 l click negative w postive lezm ma 2a3mlo bel fragment lezm 2a3mlo bel activity
            //fa l mafroud lama l user yed8at 3ala zer l yes yersel l data mn l fragemnt le heye dialog 3ala l activity bara
            //feek kouna nersel data mn fragemnt la activity 3an tare2 listner ba3mel listner wa7de 2aw la kelo wa7de listner fa mnfadel na3mel listner la kel wa7de

        });

    }

    @Override
    public void OnNegativeButtonClicked() {
        Toast.makeText(this, "no clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnNuetralButtonClicked() {
        Toast.makeText(this, "cancel clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnPositiveButtonClicked() {
        Toast.makeText(this, "yes clicked", Toast.LENGTH_SHORT).show();

    }
}