package com.example.dialogfragment.FragmentActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dialogfragment.R;


/*
Dialog Fragment nou3 mn anwa3 l application le mnest3mel feha fragment:
Dialog Fragment:howe 3ebara 3an moraba3 7ewar byeje b nous shshe w shshe l 5alfeye btkoun mbyne bas btkoun mano l focus 3lyha w btkoun l dialog 2a3la mena w l focus 3lyha l 3onsour dialog efteradeyen bekoun elo tasmem 3 zrar cancel ,no,delete,icon confirmation msg:
bekoun feha icon w title lal dialog ,meaasge la resle le bada tbayen lal user w 3 button 2 button 3ala yamen 7ed ba3d w button 3al sheml la7ala 3ala l shmel
haw l button eloun asme2 efteradeye:
positive button w negative button bekouno 7ed ba3d 3al yamen l postive 3al yamen l negative w l neagative 3al sheml l postive w nuetral bekoun la7alo 3al shmel tansmeyet l button fene 8ayer text ta3eloun metl ma bade tasmem by deffult byeje ma3 dialog bheda shakl l title bold w l text kola lawna aswad w l alwen l 5asa bel button bel color taba3 l coloraccent le mawjoud bel project
positive button:
negative button
neutral button:
Title:
Message:
icon:

hay lm ma3lomet l efteradeye ta3et dialog w fe ma3lomet edafeye feek ba3den defa feek badel title t7ot lista t7ot majmo3a mn checkboxes t7ot majmo3a mn radio buttons lista bte5tar mena aktar mn 3osnour ya3ne l 5eyar mafto7 edemak laken hayde dialog le btkoun by deffult
fena kamen na3mel tasmem 5as fena b dialog  w 7ana3mlo ma3 ba3d
3ashen na3mel heda dialog bel android fena na3mlo btare2ten:
1-tare2a l 2ola eno defo bshakl mobesher bel activity ta3ete bshakl eno lama ed8at 3ala button ye3redle dialog
2-tare2a tenye defa bede5el fragment

hala2 bade 2a3ml activity bde5ela button esmo show_dialog lama bade ed8at 3ala button bade ezher dialog

keef momken 2a3ml ezhar lal dialog mn 5elel da8te 3ala zer:

beje ba3mel listner 3ala l button

tae2a l 2ola eno bade ezhera b activity w heye tare2a l baseta

beje best3ml object mn class esmo AlertDialog:esm l class l 5as b dioalog AlertDialog dialog=AlertDialog dot class l Builder le mn 5elelo ana bade 2a3mel build aw bene2 lal dialog wl me7tawa le 5as fe
 AlertDialog dialog=new AlertDialog.Builder() :bye5od l context le howe l mainactivity le ana feha dot this l2no bado esm l activity le ana feha 3ashen ye3red dialog 3lyha ba3den dot w byetl3le l 5asa2es metl settitle() w 8ayro l 5asa2es le bade 7ota lal dialog settitle,seticon,...etc

AlertDialog dialog=new AlertDialog.Builder().setTitle("Confirmation").setMessage("hi iam dialog").seticon(R.drawble.icon)
fek kamen .setitem():iza badak t3abe lista ,setcostumetitle(),w feee kteer sha8let w e5er she bas t5les bt2olo
.create() fa berou7 bya3mel creation 2aw bene2 lal dialog w be7fez instance b2alb variable l dialog

bas 3ashen tezhro 3ala shshe  dialog.show() fa byezhar ma3ak dialog

law badak deef l buttons:
.setPostivebutton
.setnuetralbutton
.setnegativebutton

bhay tare2a:
 AlertDialog dialog=new AlertDialog.Builder(MainActivity.this).setTitle("Dialog Title").setMessage("this is message dialog").setIcon(R.drawable.baseline_wifi_calling_3_24).setNegativeButton("negative", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "negative", Toast.LENGTH_SHORT).show();
                }
            }).setPositiveButton("positive", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "positive", Toast.LENGTH_SHORT).show();


                }
            }).setNeutralButton("nuetral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(MainActivity.this, "nuetral", Toast.LENGTH_SHORT).show();

                }
            }).create();
            dialog.show();


bas hay tare2a ma be7abzo este5dema lesh?
l2no hay tare2a enta fe3lyan btektob code dialog mobasharatan bel activity b ma3na eno ma fe ruesability bel code ta3elak enon law enta badak test5dem heda l code be matra7 tene ma fek
fa alak l 2artab men heek w l ajmal eno tet3mela ma3 dialog fragment

sho btefre2 dialog fragemnt 3an dialog l activity:
dialog fragemnt:Fragemnt b2lba dialog  badal ma kont et3emal dialog bshakl mobeshar bede5l l activity alak la2 btseer tet3emal ma3a ka fragement tyeb sho l momayazet l jdede le ana be7sal 3lyha lama est3mel dialog fragemnt  badal tare2a l 3adeye kteer momyezet:
-yseer 3andak reuesability lal code btseer feek tensa5 l code metl ma badak w test5dmo w t3adel 3lee metl ma badak ma bt2sser 3ala she tene
-she l aham eno btseer tet3mela ma3 dialog ka fragment keef ya3ne ya3ne btseer ween ma badak enta defo b2aye matar7 ya3ne b 2aye maken bt7ob deef fe fragment feek deef fe dialog ka fragment ya3ne feek deef l dialog heda 3ala l viewpager lesh l2no howe fragemnt bel neheye l dialog b2emkenak defo 3ala aye she btet3emal ma3 l fragment b2emkenak ye3rdo bel  back stack lama ta3mel back yo3rdelak yeh bel back stack 3ashen ma yel8e bel mara laken b 7alte hay  laken b7alete hay l diaog bel activity iza da8t 3al button 7a ybyen l dialog w 3mlt kabset l ok masln w 3mlt back 7a yetla3 mn l app lesh l2no fe3lyan ma dafo 3ala l back stack laken b 2emkene mn 5elel l fragemnt eno defo 3ala l backstack ya3ne lama a3mel back yerja3 ybyen l dialog 8ayer e5teyare mn ok la no masln 2aw cancel hay momyezet fene est5dema

//tyeb keef bade est5dmo b fragemnt nasf l code le katbto bel activity bas b fragemnt

//ba3mel 2awl she fragemnt














 */






public class MainActivity extends AppCompatActivity {

    Button showDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog=findViewById(R.id.show_dialog);


        showDialog.setOnClickListener(v->{
            AlertDialog dialog=new AlertDialog.Builder(MainActivity.this).setTitle("Dialog Title").setMessage("this is message dialog").setIcon(R.drawable.baseline_wifi_calling_3_24).setNegativeButton("negative", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "negative", Toast.LENGTH_SHORT).show();
                }
            }).setPositiveButton("positive", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "positive", Toast.LENGTH_SHORT).show();


                }
            }).setNeutralButton("nuetral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(MainActivity.this, "nuetral", Toast.LENGTH_SHORT).show();

                }
            }).create();
            dialog.show();

        });


    }
}