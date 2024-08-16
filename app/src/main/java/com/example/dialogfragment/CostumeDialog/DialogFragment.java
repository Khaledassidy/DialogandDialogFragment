package com.example.dialogfragment.CostumeDialog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dialogfragment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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


    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPositiveClickListner=null;

    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mTitle Parameter 1.
     *@param mMsg Parameter 2.
     *@param mIcon Parameter 3.
     *
     * @return A new instance of fragment DialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DialogFragment newInstance(String mTitle, String mMsg, int mIcon) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView title=view.findViewById(R.id.dialog_Title);
        TextView msg=view.findViewById(R.id.dialog_msg);
        EditText editText=view.findViewById(R.id.dialog_edittext);
        Button button=view.findViewById(R.id.btn_dialog);
        title.setText(mTitle);
        msg.setText(mMsg);
        button.setBackgroundResource(mIcon);

        button.setOnClickListener(v->{
            onPositiveClickListner.OnPositiveButtonClicked(editText.getText().toString());
            dismiss();
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public interface OnPositiveClickListner{
        void OnPositiveButtonClicked(String Edittextmsg);
    }


}