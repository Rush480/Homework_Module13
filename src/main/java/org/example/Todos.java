package org.example;

public class Todos {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    @Override
    public String toString() {
        return "Todos{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public Todos(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }
}
