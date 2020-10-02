package com.dev.willi3.realminherit.Model;

import io.realm.RealmObject;

public class HerramientaModel extends RealmObject {
    private String herramienta;

    public HerramientaModel(){
    }

    public HerramientaModel(String herramienta){
        this.herramienta = herramienta;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }
}
