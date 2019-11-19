package com.besha.v13;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Vi extends Fragment {
    //TextView desc;
    TextView descText;
    //TextView benf;
    TextView benfText;
    //TextView sources;
    TextView srcText;
    //TextView risk;
    TextView riskText;
    //TextView ref;
    TextView refText;

    // reference url
    String url;
    public VitaminViewModel model;
    public Vi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_vi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // define fields
//        desc = (TextView) view.findViewById(R.id.vitamin_desc);
        descText = (TextView) view.findViewById(R.id.vitamin_desc_text);
//        benf = (TextView) view.findViewById(R.id.vitamin_benefits);
        benfText = (TextView) view.findViewById(R.id.vitamin_benefits_text);
//        sources = (TextView) view.findViewById(R.id.vitamin_sources);
        srcText = (TextView) view.findViewById(R.id.vitamin_sources_text);
//        risk = (TextView) view.findViewById(R.id.vitamin_risk);
        riskText = (TextView) view.findViewById(R.id.vitamin_risk_text);
//        ref = (TextView) view.findViewById(R.id.vitamin_ref);
        refText = (TextView) view.findViewById(R.id.vitamin_ref_text);
        model = ViewModelProviders.of(requireActivity(), new VitaminViewModel.VitaminModelProvider(getContext())).get(VitaminViewModel.class);
        model.pageId.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                VitaminsList vitaminsList = new VitaminsList();
                Vitamin vitamin = vitaminsList.getVitamin(integer);
                if (vitamin != null){
                    requireActivity().setTitle("Vitamin "+vitamin.getName());
                    descText.setText("\u3000\u3000"+vitamin.getDescription());
                    benfText.setText("\u3000\u3000"+vitamin.getBenefits());
                    srcText.setText("\u3000\u3000"+vitamin.getSources());
                    riskText.setText("\u3000\u3000"+vitamin.getRisk());
                    refText.setText("\u3000\u3000"+vitamin.getRefrences());
                    url = vitamin.getRefrences();

                }else {
                    descText.setText(getResources().getString(R.string.wrong));
                }

            }
        });
        refText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
                customTabsIntent.launchUrl(getContext(), Uri.parse(url));
            }
        });
    }


}
