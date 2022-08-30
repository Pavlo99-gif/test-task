package org.example.service;

import java.util.List;
import org.example.model.Comment;

public interface Report {
    String makeReport(List<Comment> list);
}
