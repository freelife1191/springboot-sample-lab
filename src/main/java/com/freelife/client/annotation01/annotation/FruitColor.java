package com.freelife.client.annotation01.annotation;

import java.lang.annotation.*;

/**
 * Spring Annotation의 원리와 Custom Annotation 만들어보기
 * https://donghyeon.dev/spring/2020/08/18/Spring-Annotation%EC%9D%98-%EC%9B%90%EB%A6%AC%EC%99%80-Custom-Annotation-%EB%A7%8C%EB%93%A4%EC%96%B4%EB%B3%B4%EA%B8%B0/
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    enum Color {BLUE, RED, GREEN}
    Color fruitColor() default Color.GREEN;
}