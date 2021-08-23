package models;

import org.graalvm.compiler.lir.LIRInstruction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void userInstantiatesCorrectly_true(){
        User newUser = setupUser();
        User altUser = setupAltUser();
        assertTrue(newUser instanceof User);
        assertTrue(altUser instanceof User);
    }

    @Test
    public void getNameReturnsCorrectly(){
        User newUser = setupUser();
        assertEquals("emile",newUser.getName());
    }

    @Test
    public void getBioReturnsCorrectly(){
        User newUser = setupUser();
        assertEquals("student learning java",newUser.getBio());
    }

    @Test
    public void getPositionReturnsCorrectly(){
        User newUser = setupUser();
        assertEquals("student",newUser.getPosition());
    }

    @Test
    public void getRoleReturnsCorrectly(){
        User newUser = setupUser();
        assertEquals("enjoy",newUser.getRole());
    }

    @Test
    public void getDepartmentIdReturnsCorrectly(){
        User newUser = setupUser();
        Integer expected = 36;
        assertEquals(expected,newUser.getDepartmentId());
    }
    @Test
    public void setNameReturnsCorrectly(){
        User newUser = setupUser();
        String initial=newUser.getName();
        newUser.setName("Kam");
        assertNotEquals(initial,newUser.getName());
    }

    @Test
    public void setBioReturnsCorrectly(){
        User newUser = setupUser();
        String initial=newUser.getBio();
        newUser.setBio("Kam");
        assertNotEquals(initial,newUser.getBio());
    }

    @Test
    public void setPositionReturnsCorrectly(){
        User newUser = setupUser();
        String initial=newUser.getPosition();
        newUser.setPosition("Kam");
        assertNotEquals(initial,newUser.getPosition());
    }

    @Test
    public void setRoleReturnsCorrectly(){
        User newUser = setupUser();
        String initial=newUser.getRole();
        newUser.setRole("Kam");
        assertNotEquals(initial,newUser.getRole());
    }

    @Test
    public void setDepartmentIdReturnsCorrectly(){
        User newUser = setupUser();
        Integer initial=newUser.getDepartmentId();
        newUser.setDepartmentId(37);
        assertNotEquals(initial,newUser.getDepartmentId());
    }

    //helpers
    public User setupUser (){
        return new User("emile","student learning java","student","enjoy",36);
    }

    public User setupAltUser (){
        return new User("emile","student learning java","student","enjoy");
    }
}