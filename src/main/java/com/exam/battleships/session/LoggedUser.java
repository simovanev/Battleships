package com.exam.battleships.session;

import com.exam.battleships.models.entities.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {
    private long id;
    private String username;

    public void login(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
    public  void logout(){
        this.id = 0;
        this.username = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
