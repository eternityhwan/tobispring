package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 데이터베이스에 접속하는 연결 매소드만 따로 빼놓은 것이 아래의 코드이다

public class PostgreUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver"); // 클래스를 forname으로 찾으라는 명령이다, 괄호에는 Driver url을 넣어주면 됨.
        Connection c = DriverManager.getConnection( // :는 프로토콜 다음에 써줌
                "jdbc:postgresql://localhost:3307/bmwgs?searchpath=public", "postgres", "3642");
        // url 쓰는 방법 - jdbc(자바에서데이터연결커넥하니까)프로토콜:mysql(데이터베이스서버프로그램이름)://호스트명/데이터베이스이름
        // --- class 변수로 넣어주면 메소드 작성 할 때마다 연결 메소드 안넣어줘도 됨. ---
        // ------------ 여기까지하면 연결은 Z끝나는 거임 ----------------------------
        return c;

    }
}
