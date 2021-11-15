package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        // throws 뒤에는 에러나니까 추가해준거임 alt+enter 로
        // mysql 연결하는 커넥터가 깔려야 작동함
        // 메이븐, 그레들 없던 시절이라 파일을 직접 집어넣었었음.
        Class.forName("com.mysql.cj.jdbc.Driver");
        // cj 새버전이라는 뜻
        // 클래스를 forName으로 찾는거임.
        // 메이븐에 디펜던시 다 깔고 위처럼 코딩하면
        // Driver라는 클래스를 쓸 수가 있어.

        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/carlkim", "root", "3642" // url,user/password
        );
    }
}
