package dao;

import domain.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {
    // alt + insert  - generate 테스트 메소드 넣어주면됨.
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User();

        user.setId("2");
        user.setName("nomu");
        user.setPassword("523");

        userDao.add(user);

        User result = userDao.get("1");
        System.out.println(result.getId());
        System.out.println(result.getName());
        assertEquals("1", result.getId()); //

    }
}