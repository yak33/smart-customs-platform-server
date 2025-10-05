package io.github.yak33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 启动程序
 *
 * @author ZHANGCHAO
 */

@SpringBootApplication
public class SmartCustomsPlatformApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SmartCustomsPlatformApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println("(♥◠‿◠)ﾉﾞ  smart-customs-platform-server启动成功   ლ(´ڡ`ლ)ﾞ");
    }

}
