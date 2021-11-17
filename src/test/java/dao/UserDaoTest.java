package dao;

import domain.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {
    // alt + insert  - generate 테스트 메소드 넣어주면됨.
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        UserDao userDao = new NUserDao();
        User user = new User();

        user.setId(2);
        user.setName("nomu");
        user.setPassword("523");

        userDao.add(user);

        User result = userDao.get("1");
        System.out.println(result.getId());
        System.out.println(result.getName());
        assertEquals(1, result.getId());

        UserDao userDao2 = new PostgreUserDao();
        User user1 = new User();

        user.setId(2);
        user.setName("nomu");
        user.setPassword("523");

        userDao2.add(user);

        User result2 = userDao2.get("1");
        System.out.println(result.getId());
        System.out.println(result.getName());
        assertEquals(1, result.getId());


    }
}