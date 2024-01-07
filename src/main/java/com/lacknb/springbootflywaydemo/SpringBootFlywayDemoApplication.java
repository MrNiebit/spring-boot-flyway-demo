package com.lacknb.springbootflywaydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 因为如果直接指定db包   service也会被扫描到  所以通过markerInterface 进行限定
@MapperScan(basePackages = "com.lacknb.springbootflywaydemo.*.db", markerInterface = com.baomidou.mybatisplus.core.mapper.BaseMapper.class)
public class SpringBootFlywayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFlywayDemoApplication.class, args);
    }

}
