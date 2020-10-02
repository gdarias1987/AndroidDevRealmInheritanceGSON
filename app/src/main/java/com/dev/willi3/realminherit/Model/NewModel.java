package com.dev.willi3.realminherit.Model;

import com.dev.willi3.realminherit.Interface.INewModel;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NewModel extends RealmObject implements INewModel {

    public BaseModel baseModel;

    @SerializedName("num")
    int num;

    private RealmList<HerramientaModel> listado;

    @PrimaryKey
    int ID;

    public NewModel(){
        baseModel = new BaseModel(ID);
        this.listado = new RealmList<>();
//        ID = baseModel.getID();
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public RealmList<HerramientaModel> getListado() {
        return listado;
    }

    @Override
    public void addHerramienta(HerramientaModel herramienta) {
        listado.add(herramienta);
    }

    @Override
    public int getID() {
        return baseModel.getID();
    }

    @Override
    public void setID(int ID) {
        baseModel.setID(ID);
    }

    @Override
    public String getName() {
        return baseModel.getName();
    }

    @Override
    public void setName(String name) {
        baseModel.setName(name);
    }

    @Override
    public String getExtra() {
        return baseModel.getExtra();
    }

    @Override
    public void setExtra(String name) {
        baseModel.setExtra(name);
    }
}
