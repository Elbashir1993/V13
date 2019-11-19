package com.besha.v13;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

public class VitaminViewModel extends ViewModel {
    Context ctx;
    VDataBase vDataBase;
    Boolean dbexistFlag;
    public static MutableLiveData<ArrayList<Vitamin>>  vitaminsList = new MutableLiveData<>();

    public MutableLiveData<Integer> pageId = new MutableLiveData<>();

    public VitaminViewModel(Context context) {
        this.ctx = context;
        if(vitaminsList.getValue() == null) {
            vitaminsList.setValue(new VitaminsList().getVitaminArrayList());
        }
       /* vDataBase = new VRepository(context).getvDataBase();*/
        /*Dbexist dbexist = new Dbexist();
        dbexist.execute();*/
    }

    public MutableLiveData<ArrayList<Vitamin>> getVitaminsList() {
        return vitaminsList;
    }

    public static class VitaminModelProvider extends ViewModelProvider.NewInstanceFactory {
        Context context;

        public VitaminModelProvider(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new VitaminViewModel(context);
        }
    }

    // additional code to save vitamin list in room database, optional use
    /*private class Dbexist extends AsyncTask<Object, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Object... objects) {
            ArrayList<Vitamin> vitaminList = vDataBase.vDao().isNotNull();
            if(vitaminList.size() == 0){
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean){

            }else {
                // insert one time database info
                OneTimeInsert oneTimeInsert = new OneTimeInsert();
                oneTimeInsert.execute(vitaminsList);

            }
        }

        private class OneTimeInsert extends AsyncTask<ArrayList<Vitamin>, Void, Boolean> {
            @Override
            protected Boolean doInBackground(ArrayList<Vitamin>... lists) {
               for(ArrayList<Vitamin> vl: lists){
                   if(vl != null){
                       for (Vitamin v: vl) {
                           vDataBase.vDao().insertVitamin(v);
                           return true;
                       }
                   }
               }
               return false;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                if(aBoolean){
                    Log.d("insertedForOneTime", "inserted: true");
                }else {
                    Log.d("insertedForOneTime", "inserted: false");
                }
            }
        }
    }*/
}
