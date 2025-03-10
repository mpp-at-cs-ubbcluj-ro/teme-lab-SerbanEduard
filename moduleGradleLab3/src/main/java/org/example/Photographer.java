package org.example;

public class Photographer {
    private int id;
    private String name;
    private String email;
    private boolean isPhotographer;

    public Photographer(int id, String name, String email, boolean isPhotographer) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isPhotographer = isPhotographer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPhotographer() {
        return isPhotographer;
    }

    public void setPhotographer(boolean photographer) {
        isPhotographer = photographer;
    }

    @Override
    public String toString() {
        return "Photographer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isPhotographer=" + isPhotographer +
                '}';
    }
}
