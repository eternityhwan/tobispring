package dao;

import domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void addAndGet() throws Exception {
        // 위에 UserDao 디비랑 붙는지 테스트해봐야해.
        UserDao userDao = new UserDao();
        User user = new User();
        userDao.add(user);
    }
}