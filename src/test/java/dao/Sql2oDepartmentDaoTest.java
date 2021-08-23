package dao;

import models.Department;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private Sql20UserDao userDao;
    private Sql2oDepartmentDao DepartmentDao;
    private Sql2oDepartmentDao departmentDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/organisational_test";
        Sql2o sql2o = new Sql2o(connectionString, "emile067", "mushimiyimana");
        userDao = new Sql20UserDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        userDao.clearAll();
        departmentDao.clearAll();
        conn.close();
    }

    @Test
    public void DepartmentIsSavedCorrectly() {
        Department testDepartment = setupDepartment();
        departmentDao.add(testDepartment);
        assertEquals(departmentDao.getAll().get(0), testDepartment);
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department testDepartment = setupDepartment();
        int originalPostId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalPostId, testDepartment.getId());
    }

    @Test
    public void addedDepartmentAreReturnedFromGetAll() throws Exception {
        Department testDepartment = setupDepartment();
        departmentDao.add(testDepartment);
        assertEquals(1, departmentDao.getAll().size());
    }

    @Test
    public void noDepartmentReturnsEmptyList() throws Exception {
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectUser() throws Exception {
        Department testDepartment = setupDepartment();
        departmentDao.add(testDepartment);
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupDepartment();
        Department altDepartment = setupAltDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }

    //Helpers
    public Department setupDepartment() {
        return new Department("emile", "student learning java");
    }

    public Department setupAltDepartment() {
        return new Department("Kamana", "student learning java");
    }
}