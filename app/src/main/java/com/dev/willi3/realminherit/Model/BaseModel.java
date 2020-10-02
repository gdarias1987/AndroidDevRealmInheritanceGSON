package com.dev.willi3.realminherit.Model;

import com.dev.willi3.realminherit.Interface.IBaseModel;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BaseModel extends RealmObject implements IBaseModel {

    public BaseModel(){
        ID = 2;
//        name = "DEV XA";
    }

    public BaseModel(int idNew){
        ID = idNew;
    }

    @PrimaryKey
    @SerializedName("id")
    private int ID;

    @SerializedName("name")
    private String name;

    @SerializedName("extra")
    private String extra;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
