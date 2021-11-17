package dao;


import domain.User;

import java.sql.*;

// 템플릿 메소드 패턴임
// 이 템플릿 메소드를 추상 메소드로 만들어서 독립 시킬 것이야.

public abstract class UserDao {

    // 중복코드 추출 실시한다.
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
    //{
//        Class.forName("com.mysql.cj.jdbc.Driver"); // 클래스를 forname으로 찾으라는 명령이다, 괄호에는 Driver url을 넣어주면 됨.
//        Connection c = DriverManager.getConnection( // :는 프로토콜 다음에 써줌
//                "jdbc:mysql://localhost/carlkim", "root", "3642");
        // url 쓰는 방법 - jdbc(자바에서데이터연결커넥하니까)프로토콜:mysql(데이터베이스서버프로그램이름)://호스트명/데이터베이스이름
        // --- class 변수로 넣어주면 메소드 작성 할 때마다 연결 메소드 안넣어줘도 됨. ---
        // ------------ 여기까지하면 연결은 끝나는 거임 ----------------------------
//        return c;
//    }


    public void add(User user) throws ClassNotFoundException, SQLException {
        // 1. 데이터 베이스와 연결하기 위해 커넥션을 가져온다.
        // 2. 하지만 커넥션은 드라이버가 있어야해 (드라이버를 먼저 잡고 그다음 connection을 해주면된다 간단함)

        // ------------ 여기서부터는 인서트 영역 ----------
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into Users(Userid, name, password) values(?,?,?)");

        //각각의 ps 스트링으로 들어감
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
    }
        //------------ 여기까지가 인서트 메소드임 -------------------

        //------------ get 메소드 뽑는 메소드 만들것, id에 해당하는 유저를 뽑는 기능임. -----

        public User get(String id) throws ClassNotFoundException, SQLException {
            // id 스트링을 받아올 것이다. 선언 get(String id)
            // get 은 리턴값을 산출해야하기 때문에 void를 쓰면 안되고 user를 넣어준다.
            // void는 함수 값을 실행하고 끝남.

            // 1. 데이터 베이스와 연결하기 위해 커넥션을 가져온다.
            // 2. 하지만 커넥션은 드라이버가 있어야해 (드라이버를 먼저 잡고 그다음 connection을 해주면된다 간단함)

            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement
                    ("select * from users where userid = ?"); // <- userid 컬럼 순서를 변수로 삼겠다는거임 ? 정해지지 않음.

            // 오직 PrepareStatement만이 sql 문에 ?를 넣을 수 있어. 즉 값만 바꿔서 설정가능하다는 것임.
            // 즉 객체를 캐시에 담아 재사용한다는 것임

            ps.setString(1, id); //  < - PrepareStatement 에서 준비된 ? 를 1 변수로 받는다는 뜻임
            ResultSet rs = ps.executeQuery(); // <- 워크벤치에서 번개버튼 누르는거.
            rs.next();


           User user = new User();
           user.setId(rs.getString("userid"));
           user.setName(rs.getString("name"));
           user.setPassword(rs.getString("password"));

            return user;
        }
    }

