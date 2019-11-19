package com.besha.v13;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DefAdapter extends RecyclerView.Adapter<DefViewHolder> {
    private static ArrayList<Vitamin> vitamins;
    public DefAdapter(ArrayList<Vitamin> v) {
        vitamins = v;
    }


    @NonNull
    @Override
    public DefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.def_view_holder_xml, parent, false);
        return new DefViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefViewHolder holder, int position) {
        Log.d("myList", "getItemCount1: "+vitamins.size());
        Vitamin vitamin = vitamins.get(position);
        Log.d("id", "vitaminId: "+vitamin.getVid()+"and position "+position);
        holder.bindTo(vitamin);
    }

    @Override
    public int getItemCount() {
        Log.d("myList", "getItemCount: "+vitamins.size());
        return vitamins.size();
    }
}
class DefViewHolder extends RecyclerView.ViewHolder{
    ImageView vit;
    Bundle bundle = new Bundle();
    public DefViewHolder(@NonNull View itemView) {
        super(itemView);
        vit = itemView.findViewById(R.id.def_img);

    }

    public void bindTo(Vitamin vitamin){

        switch (vitamin.getVid()){
            case 1: vit.setImageResource(R.drawable.a); navToView(1);break;
            case 2: vit.setImageResource(R.drawable.c); navToView(10);break;
            case 3: vit.setImageResource(R.drawable.d); navToView(11);break;
            case 4: vit.setImageResource(R.drawable.e); navToView(12);break;
            case 5: vit.setImageResource(R.drawable.b); navToView(2);break;
            case 6: vit.setImageResource(R.drawable.b2); navToView(3);break;
            case 7: vit.setImageResource(R.drawable.b3); navToView(4);break;
            case 8: vit.setImageResource(R.drawable.b5); navToView(5);break;
            case 9: vit.setImageResource(R.drawable.b6); navToView(6);break;
            case 10: vit.setImageResource(R.drawable.b7);navToView(7); break;
            case 11: vit.setImageResource(R.drawable.b9); navToView(8);break;
            case 12: vit.setImageResource(R.drawable.b12); navToView(9);break;
            case 13: vit.setImageResource(R.drawable.k); navToView(13); break;
        }
    }

    public void navToView(int id){
        VitaminViewModel model = Definition.model;
        vit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.pageId.setValue(id);
                Navigation.findNavController(itemView).navigate(R.id.action_definition2_to_vi);
            }
        });
    }

}
