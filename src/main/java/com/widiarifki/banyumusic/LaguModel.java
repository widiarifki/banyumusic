package com.widiarifki.banyumusic;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class LaguModel extends AbstractTableModel {
    
    private List<Lagu> dataLagu;

    public LaguModel(List<Lagu> l){
        dataLagu = l;
    }

    public int getRowCount(){
        return dataLagu.size();
    }

    public int getColumnCount(){
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column){
        Lagu l = dataLagu.get(row);

        switch(column){
            case 0: return l.getPicture();
            case 1: return l.getTitle();
            case 2: return l.getArtist();
            case 3: return l.getGenre();
            default: return null;
        }
    }

    public String getColumnName(int column){
        
        switch(column){
            case 0: return "Gambar";
            case 1: return "Judul";
            case 2: return "Artis";
            case 3: return "Genre";
            default: return null;
        }
    }

    public Lagu getRowAt(int row) {
        Lagu l = dataLagu.get(row);

        return l;
    }
}