package org.example.service;

import java.util.List;
import org.example.model.Comment;

public interface UsernameMod {
    List<Comment> upFirstCharacter(List<Comment> list);
}
