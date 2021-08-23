package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql20UserDao implements UserDao {
    private final Sql2o sql2o;
    public Sql20UserDao(Sql2o sql2o) {
        this.sql2o=sql2o;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (name, bio, position, role, departmentid) VALUES (:name, :bio, :position, :role, :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    @Override
    public User findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void update(int id, String name, String bio,String position,String role,int departmentId) {
        String sql = "UPDATE users SET (name, bio, position, role, departmentid) = (:name, :bio, :position, :role, :departmentId) WHERE id=:id"; //CHECK!!!
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("bio", bio)
                    .addParameter("position", position)
                    .addParameter("role", role)
                    .addParameter("departmentId", departmentId)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id = :id";
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
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
