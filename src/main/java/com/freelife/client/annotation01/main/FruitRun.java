package com.freelife.client.annotation01.main;

import com.freelife.client.annotation01.domain.Apple;
import com.freelife.client.annotation01.util.FruitInfoUtil;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class FruitRun {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
        // @Component, @Service, @Controller bean 등록 참고 코드
        // ClassPathBeanDefinitionScanner.class
    }
}
