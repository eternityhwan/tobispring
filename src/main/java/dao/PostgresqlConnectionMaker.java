package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnectionMaker implements ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver"); // 클래스를 forname으로 찾으라는 명령이다, 괄호에는 Driver url을 넣어주면 됨.
        java.sql.Connection c = DriverManager.getConnection( // :는 프로토콜 다음에 써줌
                "jdbc:mysql://localhost/carlkim", "root", "3642");
        // ------------ 여기까지하면 연결은 끝나는 거임 ----------------------------
        return c;
    }
}
