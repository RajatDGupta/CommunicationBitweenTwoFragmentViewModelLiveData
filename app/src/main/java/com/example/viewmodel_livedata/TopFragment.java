package com.example.viewmodel_livedata;



import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {


    public TopFragment() {
        // Required empty public constructor
    }

    View view;
    MyViewModel myViewModel;
    TextView text_view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_top, container, false);
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        text_view=view.findViewById(R.id.text_view);


        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                text_view.setText(newName);
            }
        };

        myViewModel.getCurrentName().observe(getActivity(),nameObserver);

        return view;
    }

}
