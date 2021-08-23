package dao;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql20UserDaoTest {
    private Sql20UserDao userDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_test";
        Sql2o sql2o = new Sql2o(connectionString, "emile067", "mushimiyimana");
        userDao = new Sql20UserDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        userDao.clearAll();
        conn.close();
    }

    @Test
    public void userIsSavedCorrectly(){
        User newUser = new User("emile","student learning java","student","enjoy",36);
        userDao.add(newUser);
        assertEquals(userDao.getAll().get(0),newUser);
    }

    @Test
    public void addingUserSetsId() throws Exception {
        User testUser = setupUser();
        int originalUserId = testUser.getId();
        userDao.add(testUser);
        assertNotEquals(originalUserId,testUser.getId());
    }

    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        User newUser = new User("emile","student learning java","student","enjoy",36);
        userDao.add(newUser);
        assertEquals(1,userDao.getAll().size());
    }

    @Test
    public void noUsersReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectUser() throws Exception {
        User testUser = setupUser();
        userDao.add(testUser);
        userDao.deleteById(testUser.getId());
        assertEquals(0, userDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        User testUser = setupUser();
        User otherUser = setupAltUser();
        userDao.clearAll();
        assertEquals(0, userDao.getAll().size());
    }

    //Helpers
    public User setupUser (){
        return new User("emile","student learning java","student","enjoy",36);
    }

    public User setupAltUser (){
        return new User("emile","student learning java","student","enjoy");
    }
}