package dao;


import domain.User;

import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
       this.connectionMaker = connectionMaker;
    }
    // 나중에 문제 생기면 일일이 수정을 다 해줘야함
    // 그러니까 인터페이스를 쓰라고 그게 이 책의 결론
    // 커넥션이라는 인터페이스를 만들어서 본문 수정 없이 하겠다는 것이 스프링의 본 목적

    public void add(User user) throws ClassNotFoundException, SQLException {
        // 1. 데이터 베이스와 연결하기 위해 커넥션을 가져온다.
        // 2. 하지만 커넥션은 드라이버가 있어야해 (드라이버를 먼저 잡고 그다음 connection을 해주면된다 간단함)
        // ------------ 여기서부터는 인서트 영역 ----------
        Connection c = connectionMaker.makeConnection();;
        PreparedStatement ps = c.prepareStatement(
                "insert into Users(Userid, name, password) values(?,?,?)");
        //각각의 ps 스트링으로 들어감
        ps.setInt(1, user.getId());
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

            Connection c = connectionMaker.makeConnection();
            PreparedStatement ps = c.prepareStatement
                    ("select * from users where userid = ?"); // <- userid 컬럼 순서를 변수로 삼겠다는거임 ? 정해지지 않음.

            // 오직 PrepareStatement만이 sql 문에 ?를 넣을 수 있어. 즉 값만 바꿔서 설정가능하다는 것임.
            // 즉 객체를 캐시에 담아 재사용한다는 것임

            ps.setString(1, id); //  < - PrepareStatement 에서 준비된 ? 를 1 변수로 받는다는 뜻임
            ResultSet rs = ps.executeQuery(); // <- 워크벤치에서 번개버튼 누르는거.
            rs.next();


           User user = new User();
           user.setId(rs.getInt("userid"));
           user.setName(rs.getString("name"));
           user.setPassword(rs.getString("password"));

            return user;
        }
    }

