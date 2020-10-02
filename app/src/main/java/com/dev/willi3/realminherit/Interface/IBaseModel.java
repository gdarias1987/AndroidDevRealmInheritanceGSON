package com.dev.willi3.realminherit.Interface;

import io.realm.RealmModel;

public interface  IBaseModel {
    int getID();
    void setID(int ID);
    String getName();
    void setName(String name);
    String getExtra();
    void setExtra(String name);
}

