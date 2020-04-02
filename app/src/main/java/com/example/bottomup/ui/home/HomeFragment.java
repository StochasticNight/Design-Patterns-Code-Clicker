package com.example.bottomup.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomup.MainActivity;
import com.example.bottomup.R;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    int i = 1;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //Button mybutton = (Button) root.findViewById(R.id.button);
        ImageView keyboard = root.findViewById(R.id.keyboard);
        //final TextView tscore = root.findViewById(R.id.textView);
        //textView = root.findViewById(R.id.text_home);
        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).addLoC(MainActivity.clickAmount);
            }
        });

        return root;
    }

}