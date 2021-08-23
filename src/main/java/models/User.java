package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String bio;
    private String position;
    private String role;
    private Integer departmentId;

    public User(String name, String bio, String position, String role) {
        this.name = name;
        this.bio = bio;
        this.position = position;
        this.role = role;
        this.departmentId = null;
    }

    public User(String name, String bio, String position, String role, int departmentId) {
        this.name = name;
        this.bio = bio;
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                departmentId == user.departmentId &&
                name.equals(user.name) &&
                bio.equals(user.bio) &&
                position.equals(user.position) &&
                role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bio, position, role, departmentId);
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
