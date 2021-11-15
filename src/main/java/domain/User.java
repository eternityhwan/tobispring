package domain;

// 인서트 목적으로 만든 클래스임

public class User {
    private String id;
    private String name;
    private String passowrd;

    // private 접근자는 초기화 안하면 외부에서 접근이 됨.

    // 게터 앤 세터 -- 맴버변수에 직접 접근하지 않기 위해 사용.


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
