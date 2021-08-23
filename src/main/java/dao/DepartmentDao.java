package dao;

import models.Department;
import models.News;
import models.User;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);

    //read
    List<Department> getAll();
    List<User> getDepartmentUsers(Department department);
    List<News> getDepartmentNews(Department department);

    // find by ID
    Department findById(int id);

    //update
    void update(int id, String name, String bio);

    //delete
    void deleteById(int id);
    void clearAll();
}
