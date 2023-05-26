package com.surya.springboot.MyFirstWebApp.Todo;

import java.time.LocalDate;

public class Todo {
    private long id;
    private String username;
    private String description;
    private LocalDate targetDate;

    private boolean progress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public Todo(long id, String username, String description, LocalDate targetDate, boolean progress) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", progress=" + progress +
                '}';
    }
}
