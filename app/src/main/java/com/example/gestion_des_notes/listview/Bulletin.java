package com.example.gestion_des_notes.listview;

public class Bulletin {
    private String module;
    private String note;

    public Bulletin(String module, String note) {
        this.module = module;
        this.note = note;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
