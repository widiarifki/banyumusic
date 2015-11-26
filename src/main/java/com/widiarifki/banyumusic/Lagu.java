package com.widiarifki.banyumusic;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Lagu {

    private Integer id;
    private String title;
    private String artist;
    private ImageIcon picture;
    //private String picture;
    private String id_genre;
    private String genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ImageIcon getPicture() {
    //public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        //this.picture = picture;

        Image image = null;
        try {
            URL url = new URL("http://www.widiarifki.com/banyumusic/img/"+picture);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.picture = new ImageIcon(image);
    }

    public String getId_genre() {
        return id_genre;
    }

    public void setId_genre(String id_genre) {
        this.id_genre = id_genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}