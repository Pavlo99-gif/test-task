package org.example.model;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Long postId;
    private String body;
    private User user;
    private LocalDateTime updatedAt;

    public Comment() {
    }

    public Comment(Long id, Long postId, String body, User user) {
        this.id = id;
        this.postId = postId;
        this.body = body;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Comment{"
                + "id=" + id
                + ", postId=" + postId
                + ", body='" + body + '\''
                + ", user=" + user
                + ", updatedAt=" + updatedAt
                + '}';
    }
}
