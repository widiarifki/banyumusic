package com.widiarifki.banyumusic;

public class Playlist {

    private Integer id_lagu;
    private Integer id_user;
    private Lagu data_lagu;

    public Integer getId_lagu() {
        return id_lagu;
    }

    public void setId_lagu(Integer id_lagu) {
        this.id_lagu = id_lagu;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Lagu getData_lagu() {
        return data_lagu;
    }

    public void setData_lagu(Lagu l) {
        this.data_lagu = l;
    }
}