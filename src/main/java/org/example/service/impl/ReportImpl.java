package org.example.service.impl;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.example.model.Comment;
import org.example.service.Report;

public class ReportImpl implements Report {
    private static final DateTimeFormatter DATE_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    @Override
    public String makeReport(List<Comment> list) {
        String report = list.stream()
                .map(this::getReportString)
                .collect(Collectors.joining(System.lineSeparator()));
        return "id | body | postId | username | updatedAt \n" + report;
    }

    private StringBuilder getReportString(Comment comment) {
        StringBuilder builder = new StringBuilder();
        builder.append(comment.getId())
                .append(" | ")
                .append(comment.getBody())
                .append(" | ")
                .append(comment.getPostId())
                .append(" | ")
                .append(comment.getUser().getUsername())
                .append(" | ")
                .append(comment.getUpdatedAt().format(DATE_TIME_FORMATTER));
        return builder;
    }
}
