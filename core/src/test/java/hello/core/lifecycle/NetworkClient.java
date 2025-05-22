package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;

public class NetworkClient  {
  public String url;

  public NetworkClient() {
    System.out.println("생성자 호출, url = " + url);
  }

  public void setUrl(String url) {
    this.url = url;
  }

  // 서비스 시작 시 호출
  public void connect() {
    System.out.println("connect: " + url);
  }

  // 연결이 된 상대에서 호출
  public void call(String message) {
    System.out.println("call = " + url + ", message = " + message);
  }

  // 서비스 종료 시 호출
  public void disconnect(){
    System.out.println("close: " + url);
  }

  @PostConstruct
  public void init() {
    System.out.println("NetworkClient.init");
    connect();
    call("초기화 연결 메시지");
  }

  @PreDestroy
  public void close(){
    System.out.println("NetworkClient.close");
    disconnect();
  }

  // implements InitializingBean, DisposableBean 을 할 때
//  @Override
//  public void afterPropertiesSet() throws Exception {
//    // 의존관계 주입이 끝나면 호출하겠다는 소리
//    System.out.println("NetworkClient.afterPropertiesSet");
//    connect();
//    call("초기화 연결 메시지");
//  }
//
//  @Override
//  public void destroy() throws Exception {
//    // 빈이 종료될 때 호출
//    System.out.println("NetworkClient.destroy");
//    disconnect();
//  }
}
