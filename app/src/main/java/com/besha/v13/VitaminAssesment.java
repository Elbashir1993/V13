package com.besha.v13;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class VitaminAssesment extends Fragment implements View.OnClickListener {


    public VitaminAssesment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_vitamin_assesment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String url = "https://www.consumerlab.com/RDAs/";
        view.findViewById(R.id.assesone).setOnClickListener(this);
        view.findViewById(R.id.assestwo).setOnClickListener(this);
        view.findViewById(R.id.assesthree).setOnClickListener(this);
        view.findViewById(R.id.assesfour).setOnClickListener(this);

        // brands
        view.findViewById(R.id.pure).setOnClickListener(this);
        view.findViewById(R.id.thorne).setOnClickListener(this);
        view.findViewById(R.id.lifextension).setOnClickListener(this);
        view.findViewById(R.id.jarrow).setOnClickListener(this);
        view.findViewById(R.id.morebrands).setOnClickListener(this);
    }

    private void openWebPage(String url){

    }

    @Override
    public void onClick(View view) {

        String url = "";
        switch (view.getId()){
            case R.id.assesone: url = "https://www.webmd.com/vitamins-and-supplements/supplements-assessment/default.htm"; break;
            case R.id.assestwo: url = "https://freevitamindeficiencytest.com/"; break;
            case R.id.assesthree: url = "https://takecareof.com/p/start-the-quiz?utm_medium=article&utm_content=takequiz"; break;
            case R.id.assesfour: url = "https://www.personanutrition.com/start-the-assessment/"; break;

            //brands
            case R.id.pure: url = "https://www.pureformulas.com/"; break;
            case R.id.thorne: url = "https://www.thorne.com/"; break;
            case R.id.lifextension: url = "https://www.lifeextension.com/"; break;
            case R.id.jarrow: url = "https://www.jarrow.com/"; break;
            case R.id.morebrands: url = "https://www.isotrope.com/best-vitamin-and-supplement-brands/"; break;

            default: url = ""; break;
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        customTabsIntent.launchUrl(getContext(), Uri.parse(url));
    }
}
