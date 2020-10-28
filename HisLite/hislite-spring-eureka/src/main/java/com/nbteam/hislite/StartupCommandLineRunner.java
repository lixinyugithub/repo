package com.nbteam.hislite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: StartupCommandLineRunner
 * @Description: TODO（一句话）
 * @author chenxin
 * @date 2017/10/30 14:00
 */
@Component
@Order(value=0)
public class StartupCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");
    }

}
