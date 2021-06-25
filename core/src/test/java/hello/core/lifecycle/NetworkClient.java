package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient /*implements InitializingBean, DisposableBean*/ {
    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, URL = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("Connect = " + url);
    }

    public void call(String msg){
        System.out.println("call : " + url + " and msg = " + msg);
    }

    public void disconnect(){
        System.out.println("close = " + url);
    }

    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
    /*
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
    */
}
