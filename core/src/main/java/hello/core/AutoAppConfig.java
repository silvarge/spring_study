package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//    basePackages = "hello.core.member",  // 베이스 패키지 지정
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

  @Bean(name = "memoryMemberRepository")
  MemberRepository MemoryMemberRepository() {
    return new MemoryMemberRepository();
  }

}
