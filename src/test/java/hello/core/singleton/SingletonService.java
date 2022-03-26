package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    //조회 => instance 참조를 꺼낼수 있는것은 이 메소드뿐
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){} //외부에서 객체 생성이 되지 않도록

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
