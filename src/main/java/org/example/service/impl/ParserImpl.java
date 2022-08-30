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
            Comment comment = new Comment();
            comment.setId(jsonObject.getLong("id"));
            comment.setPostId(jsonObject.getLong("postId"));
            comment.setBody(jsonObject.getString("body"));
            User user = new User();
            JSONObject userJson = (JSONObject) jsonObject.get("user");
            user.setId(userJson.getLong("id"));
            user.setUsername(userJson.getString("username"));
            comment.setUser(user);
            list.add(comment);
        }
        return list;
    }
}
