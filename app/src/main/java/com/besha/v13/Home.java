package com.besha.v13;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    NavController navController;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        requireActivity().setTitle("Home");
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.definition).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.definition2, null));
        view.findViewById(R.id.dos).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_home2_to_dosage, null));
        view.findViewById(R.id.vitamin_asses).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_home2_to_vitaminAssesment, null));
    }
}
