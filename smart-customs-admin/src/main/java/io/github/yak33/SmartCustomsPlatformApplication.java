package io.github.yak33;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动程序
 *
 * @author ZHANGCHAO
 */

@Slf4j
@SpringBootApplication
public class SmartCustomsPlatformApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SmartCustomsPlatformApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        ConfigurableApplicationContext context = application.run(args);

        printStartupInfo(context);
    }

    /**
     * 打印启动成功信息
     *
     * @param context Spring应用上下文
     */
    private static void printStartupInfo(ConfigurableApplicationContext context) {
        try {
            Environment env = context.getEnvironment();
            String protocol = "http";
            if (env.getProperty("server.ssl.key-store") != null) {
                protocol = "https";
            }

            String port = env.getProperty("server.port", "8080");
            String path = env.getProperty("server.servlet.context-path", "");
            String ip = InetAddress.getLocalHost().getHostAddress();
            String profile = env.getActiveProfiles().length > 0 ? String.join(", ", env.getActiveProfiles()) : "default";

            log.info("\n----------------------------------------------------------\n\t" +
                    "🚀 智慧关务平台后端服务启动成功！\n\t" +
                    "访问地址 (Local): \t" + protocol + "://localhost:" + port + path + "\n\t" +
                    "访问地址 (Network): \t" + protocol + "://" + ip + ":" + port + path + "\n\t" +
                    "应用环境 (Profile): \t" + profile + "\n" +
                    "----------------------------------------------------------");
        } catch (UnknownHostException e) {
            log.info("\n🎉 智慧关务平台后端服务启动成功！");
        }
    }

}
