package com.example.viewmodel_livedata;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment implements View.OnClickListener
{

    public BottomFragment() {
        // Required empty public constructor
    }

    MyViewModel myViewModel;
    View view;
    Button button_send;
    EditText edit_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_bottom, container, false);
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        button_send=view.findViewById(R.id.button_send);
        edit_text=view.findViewById(R.id.edit_text);
        button_send.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_send:
               // myViewModel.modelData.setText(edit_text.toString());
                myViewModel.getCurrentName().setValue(edit_text.getText().toString());
                break;
        }
    }
}
