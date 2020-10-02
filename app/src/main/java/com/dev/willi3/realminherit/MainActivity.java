package com.dev.willi3.realminherit;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;

import android.os.Bundle;
import android.widget.TextView;

import com.dev.willi3.realminherit.App.MyApp;
import com.dev.willi3.realminherit.Model.HerramientaModel;
import com.dev.willi3.realminherit.Model.NewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    MyApp myApp;
    TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        myApp = (MyApp) getApplication();

        realm = Realm.getDefaultInstance();

//        realm.executeTransaction(bgRealm->{
//            bgRealm.deleteAll();
//        });

        realm.executeTransaction(bgRealm->{
            Number lastModelID = bgRealm.where(NewModel.class).max("ID");
            int newId = lastModelID == null ? 1 : lastModelID.intValue()+1;
            NewModel newModel = bgRealm.createObject(NewModel.class, newId);
            newModel.setName("DEV " + newId);
            newModel.setExtra("EXTRA DATA" + newId);
            newModel.addHerramienta(new HerramientaModel("PRUEBA" + newId));
            bgRealm.insertOrUpdate(newModel);
        });

        List<NewModel> listado = realm.where(NewModel.class).findAll();
        List<NewModel> auxList = realm.copyFromRealm(listado);
        String aux = "";

        try {
            aux = new Gson().toJson(auxList);

        }
        catch (Exception ex){
            aux = ex.getLocalizedMessage();
        }

        txtTitulo.setText(aux);

        Type typeList = new TypeToken<ArrayList<NewModel>>(){}.getType();
        List<NewModel> nuevo = new Gson().fromJson(aux,typeList);
    }
}