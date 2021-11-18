package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker{
    // 인터페이스를 구현화하는 것이야.(상속아니다)
    // 컨넥션메이커 인터페이스를 구현하는 것임.

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 클래스를 forname으로 찾으라는 명령이다, 괄호에는 Driver url을 넣어주면 됨.
        Connection c = DriverManager.getConnection( // :는 프로토콜 다음에 써줌
                "jdbc:mysql://localhost/carlkim", "root", "3642");
        // ------------ 여기까지하면 연결은 끝나는 거임 ----------------------------
        return c;
    }
}
