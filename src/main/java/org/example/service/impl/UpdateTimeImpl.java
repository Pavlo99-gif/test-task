package org.example.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.example.model.Comment;
import org.example.service.UpdateTime;

public class UpdateTimeImpl implements UpdateTime {
    @Override
    public void addTime(List<Comment> list) {
        list.stream()
                .forEach(c -> c.setUpdatedAt(LocalDateTime.now()));
    }
}
