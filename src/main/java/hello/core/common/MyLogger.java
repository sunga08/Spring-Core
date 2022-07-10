package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // 이 빈은 http 요청 당 하나씩 생성되고, http 요청이 끝나는 시점에 소멸된다.
public class MyLogger {

    private String uuid; //빈이 생성되는 시점에 초기화 메서드를 통해 uuid를 생성해서 저장해둔다.
    private String requestURL; //이 빈이 생성되는 시점에는 알 수 없으므로 외부에서 setter로 받는다.

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean crate: " + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
