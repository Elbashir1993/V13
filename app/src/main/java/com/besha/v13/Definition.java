package com.besha.v13;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Definition extends Fragment {
    RecyclerView vitRyc;
    DefAdapter defAdapter;
    VideoView video;
    MediaController mediaController;
    public static VitaminViewModel model;
    ArrayList<Vitamin> vitamins;
    public Definition() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        requireActivity().setTitle("Definition");
        model = ViewModelProviders.of(requireActivity(), new VitaminViewModel.VitaminModelProvider(getContext())).get(VitaminViewModel.class);
        vitamins = model.getVitaminsList().getValue();
        model.getVitaminsList().observe(getViewLifecycleOwner(), list->{
            vitamins = list;
        });
        return inflater.inflate(R.layout.fragment_definition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        video = (VideoView) view.findViewById(R.id.videoView);
        mediaController = new MediaController(getContext());
        String path = "android.resource://"+getActivity().getPackageName()+"/"+R.raw.vv;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
        video.start();

        defAdapter = new DefAdapter(vitamins);
        vitRyc = view.findViewById(R.id.vit_rcy);
        vitRyc.setLayoutManager(new GridLayoutManager(getContext(),3));
        vitRyc.setAdapter(defAdapter);

       /* view.findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "android.resource://"+getActivity().getPackageName()+"/"+R.raw.vitamins;
                Uri uri = Uri.parse(path);
                video.setVideoURI(uri);
                video.setMediaController(mediaController);
                mediaController.setAnchorView(video);
                video.start();
            }
        });*/
    }
}
