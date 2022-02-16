package com.example.gestion_des_notes.listview;

public class PlanModule {
    private String id;
    private String module;

    public PlanModule(String id, String module) {
        this.id = id;
        this.module = module;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
