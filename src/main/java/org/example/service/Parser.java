package org.example.service;

import java.util.List;
import org.example.model.Comment;
import org.json.JSONArray;

public interface Parser {
    List<Comment> parse(JSONArray jsonArray);
}
