package org.example.service.impl;

import java.util.List;
import org.example.model.Comment;
import org.example.service.UsernameMod;

public class UsernameModImpl implements UsernameMod {

    @Override
    public void upFirstCharacter(List<Comment> list) {
        list.stream()
                .forEach(c -> c.getUser().setUsername(
                        Character.toUpperCase(c.getUser().getUsername().charAt(0)) +
                        c.getUser().getUsername().substring(1)));
    }
}
