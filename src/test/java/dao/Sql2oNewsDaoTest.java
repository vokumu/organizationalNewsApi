package dao;

import models.News;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private Sql20UserDao userDao;
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_test";
        Sql2o sql2o = new Sql2o(connectionString, "emile067", "mushimiyimana");
        userDao = new Sql20UserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        userDao.clearAll();
        departmentDao.clearAll();
        newsDao.clearAll();
        conn.close();
    }

    @Test
    public void newsIsSavedCorrectly(){
        News newPost = setupNews();
        newsDao.add(newPost);
        assertEquals(newsDao.getAll().get(0),newPost);
    }

    @Test
    public void addingNewsSetsId() throws Exception {
        News testNews = setupNews();
        int originalPostId = testNews.getId();
        newsDao.add(testNews);
        assertNotEquals(originalPostId,testNews.getId());
    }

    @Test
    public void addedNewsAreReturnedFromGetAll() throws Exception {
        News testNews = setupNews();
        newsDao.add(testNews);
        assertEquals(1,newsDao.getAll().size());
    }

    @Test
    public void noNewsReturnsEmptyList() throws Exception {
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectUser() throws Exception {
        News testNews = setupNews();
        newsDao.add(testNews);
        newsDao.deleteById(testNews.getId());
        assertEquals(0, newsDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        News testNews = setupNews();
        News altNews = setupAltNews();
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }

    //Helpers
    public News setupNews (){
        return new News("emile","student learning java",36);
    }

    public News setupAltNews (){
        return new News("emile","student learning java");
    }
}