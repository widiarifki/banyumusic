package com.widiarifki.banyumusic;

import java.util.Map;
import java.util.HashMap;
import org.springframework.web.client.RestTemplate;

public class User {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private String gender;
    //private boolean loginStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    /*
    public boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }*/
    
    public void postUser(String name, String email, String password){
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);

        RestTemplate client = new RestTemplate();
        String urlSimpan = "http://widiarifki.com/banyumusic/user_post.php";
        Map<String, Integer> hasil = client.postForObject(urlSimpan, u, HashMap.class);
    }
}