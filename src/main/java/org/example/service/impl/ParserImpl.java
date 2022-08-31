package org.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Comment;
import org.example.model.User;
import org.example.service.Parser;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParserImpl implements Parser {
    @Override
    public List<Comment> parse(JSONArray jsonArray) {
        List<Comment> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            JSONObject userJson = (JSONObject) jsonObject.get("user");
            User user = new User(userJson.getLong("id"),
                    userJson.getString("username"));
            Comment comment = new Comment(jsonObject.getLong("id"),
                    jsonObject.getLong("postId"),
                    jsonObject.getString("body"),
                    user);
            list.add(comment);
        }
        return list;
    }
}
