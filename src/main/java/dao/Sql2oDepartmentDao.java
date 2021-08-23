package dao;

import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql20) {
        this.sql2o = sql20;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name, bio) VALUES (:name, :bio)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        String sql = "SELECT * FROM departments";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Department.class);
        }
    }

    @Override
    public List<User> getDepartmentUsers(Department department) {
        String sql = "SELECT * FROM users WHERE departmentid=:id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",department.getId())
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<News> getDepartmentNews(Department department) {
        String sql = "SELECT * FROM news WHERE departmentid=:id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",department.getId())
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public Department findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }    }

    @Override
    public void update(int id, String name, String bio) {
        String sql = "UPDATE users SET (name, bio) = (:name, :bio) WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("bio", bio)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
