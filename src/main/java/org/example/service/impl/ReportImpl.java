package org.example.service.impl;

import java.util.List;
import org.example.model.Comment;
import org.example.service.Report;

public class ReportImpl implements Report {
    @Override
    public String makeReport(List<Comment> list) {
        StringBuilder builder = new StringBuilder("id | body | postId | username | updatedAt");
        for (Comment comment : list) {
            builder.append(System.lineSeparator())
                            .append(comment.getReportString());
        }
        return builder.toString();
    }
}
