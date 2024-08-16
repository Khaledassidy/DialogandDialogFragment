package com.example.dialogfragment.FragmentDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

//2awl she bade faker dialog heda le bade 2a3mlo sho data le bade ersela elo
//momken t2ole bade erselo l title,l msg,icon sa7
//lakn bader ersel data lal fragemnt mesh dialog b2alab fragemnt so sa7
//la 2e3red haw l eshay b dialog bade ersel haw l eshya mn l activity 3ala l fragment
//fa bade tabe2 le 3mlto abl ersel data mn activity 3ala l fragemnt

//houn bheeed l class ana 3emel extend mn fragemnt fa bshela w b5aleha ta3mel extends mn DialogFragemnt lesh?
//sho btefer2 dialogFragemnt vs Fragemnt
//dialog fragemnt feha ba3d l methods mawjoude bl lifecycle jehze eno tet3emal ma3 dialog metl sho:
//-OnCreateDialog():method btenshe2lak l dialog btare2a deffult le 3mlneha abl le 3mlneha bel activity
//OnCreateView():law badak tenshe2 layout 5asa bel dialog 7a na3mel tare2a l 3adeye ba3den na3mel tare2a l costume

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE = "title";
    private static final String ARG_MSG = "msg";
    private static final String ARG_ICON = "icon";

    // TODO: Rename and change types of parameters
    private String mTitle;
    private String mMsg;
    private int mIcon;
    private OnPositiveClickListner onPositiveClickListner;
    private OnNegativeClickListner onNegativeClickListner;
    private OnNuetralClickListner onNuetralClickListner;

    public DialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnPositiveClickListner){
            onPositiveClickListner=(OnPositiveClickListner) context;

        }else{
            throw new RuntimeException("Please Immplement litnser Positive");
        }

        if(context instanceof OnNegativeClickListner){
            onNegativeClickListner=(OnNegativeClickListner) context;

        }else{
            throw new RuntimeException("Please Immplement litnser Negative");
        }

        if(context instanceof OnNuetralClickListner){
            onNuetralClickListner=(OnNuetralClickListner) context;

        }else{
            throw new RuntimeException("Please Immplement litnser Nuetral");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPositiveClickListner=null;
        onNegativeClickListner=null;
        onNuetralClickListner=null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mTitle Parameter 1.
     * @param mMsg Parameter 2.
     * @param mIcon Parameter 3.
     * @return A new instance of fragment DialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogFragment newInstance(String mTitle, String mMsg,int mIcon) {
        DialogFragment fragment = new DialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, mTitle);
        args.putString(ARG_MSG, mMsg);
        args.putInt(ARG_ICON, mIcon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mMsg = getArguments().getString(ARG_MSG);
            mIcon = getArguments().getInt(ARG_ICON);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //hay l method btrje3 dialog nafs l code le 3mlto bel activity bade 2a3mlo houn
        //alertdialog heda class 5aso bel dialog b2albo class esmo builder heda l class mn 5elelo ba3mel build lal dialog 2aw bebne l ma3lomet l asaseye l mawjoude bel dialog  3ashen jaheza ba3d heek benshe2 dialog l mara wa7de
        AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
        dialog.setTitle(mTitle);
        dialog.setMessage(mMsg);
        dialog.setIcon(mIcon);
        //ba3d ma t5ales bta3mel return dialog.create() l method le esma create bt2om btraje3lak AlertDialog btenshe2 AlertDialog btrj3lk dialog  lal class le stad3a l fragemnt hay
        //fa fe3lyan l alertdialog howe 3ebara 3an dialog tab3na  fe class esmo builder howe le byebne l ma3lomet hay l settitle,seticon..etc w berou7 berj3le yeha b fucntion l oncreate dialog 3ashen y2azherle yeha 3ala shshe
        //ahal2 law bade deef l button le bade yeha 3ande 3 zrar:
        //-setpostivebutton():bte5od 2awl she esmo l button text mn resource 2aw sebet
        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(), "yes clicked", Toast.LENGTH_SHORT).show();
                onPositiveClickListner.OnPositiveButtonClicked();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(), "No clicked", Toast.LENGTH_SHORT).show();
                onNegativeClickListner.OnNegativeButtonClicked();

            }
        });

        dialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onNuetralClickListner.OnNuetralButtonClicked();
            }
        });
        return dialog.create();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //ba3mel interface esma onpositiveclicklistner w method b2alaba esma onpositiveButtonClicked
    //w ba3mel nafs she wa7de la negative wa7de lal nuetral

    public interface OnPositiveClickListner{
        void OnPositiveButtonClicked();
    }

    public interface OnNegativeClickListner{
        void OnNegativeButtonClicked();
    }

    public interface OnNuetralClickListner{
        void OnNuetralButtonClicked();
    }

}