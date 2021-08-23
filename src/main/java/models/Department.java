package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String bio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                name.equals(that.name) &&
                bio.equals(that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bio);
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Department(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }
}
