package dao;

public class DaoFactory {
    public UserDao userDaoMysql() {

        UserDao userDao = new UserDao(new NConnectionMaker()); // <- ()괄호안에 어떤 커넥션을 사용할 것인지 선택하게함.
        //                              괄호안에 커넥션을 뭘 넣느냐에 따라 작동하는 것이 다름
        //                              이게 객체 지향이다.
        return userDao;
    }
    public UserDao userDaoPostgre() {

        UserDao userDao = new UserDao(new PostgresqlConnectionMaker()); // <- ()괄호안에 어떤 커넥션을 사용할 것인지 선택하게함.
        return userDao;
    }
}
