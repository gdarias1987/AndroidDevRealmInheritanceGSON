package com.dev.willi3.realminherit.Interface;

import com.dev.willi3.realminherit.Interface.IBaseModel;
import com.dev.willi3.realminherit.Model.HerramientaModel;

import io.realm.RealmList;

public interface INewModel extends IBaseModel {
    int getNum();
    void setNum(int num);
    RealmList<HerramientaModel> getListado();
    void addHerramienta(HerramientaModel herramienta);
}
