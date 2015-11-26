package com.widiarifki.banyumusic;

import java.util.*;
import javax.swing.table.*;

public class UserModel extends AbstractTableModel {
    
    private List<User> dataUser;

    public UserModel(List<User> u){
        dataUser = u;
    }

    public int getRowCount(){
        return dataUser.size();
    }

    public int getColumnCount(){
        return 3;
    }

    public Object getValueAt(int row, int column){
        User m = dataUser.get(row);

        switch(column){
            case 0: return m.getId();
            case 1: return m.getName();
            case 2: return m.getEmail();
            default: return null;
        }
    }

    public String getColumnName(int column){
        
        switch(column){
            case 0: return "ID";
            case 1: return "Nama";
            case 2: return "Email";
            default: return null;
        }
    }
}