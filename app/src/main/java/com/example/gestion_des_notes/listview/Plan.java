package com.example.gestion_des_notes.listview;

public class Plan {
    private String id;
    private String fil;
    private String niv;

    public Plan(String id, String fil, String niv) {
        this.id = id;
        this.fil = fil;
        this.niv = niv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFil() {
        return fil;
    }

    public void setFil(String fil) {
        this.fil = fil;
    }

    public String getNiv() {
        return niv;
    }

    public void setNiv(String niv) {
        this.niv = niv;
    }
}
