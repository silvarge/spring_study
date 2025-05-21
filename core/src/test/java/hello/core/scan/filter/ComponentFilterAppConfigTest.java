package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class ComponentFilterAppConfigTest {

  @Test
  @DisplayName("컴포넌트 필터 테스트")
  void filterScan() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        ComponentFilterAppConfig.class);
    BeanA beanA = ac.getBean("beanA", BeanA.class);
    assertThat(beanA).isInstanceOf(BeanA.class);

    assertThatThrownBy(() -> ac.getBean("beanB", BeanB.class)).isInstanceOf(
        NoSuchBeanDefinitionException.class);

  }

  @Configuration
  @ComponentScan(
      includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
      excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
  )
  static class ComponentFilterAppConfig {

  }

}
