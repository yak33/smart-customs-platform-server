package io.github.yak33.system.controller.system;

import cn.hutool.crypto.digest.BCrypt;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class SysUserControllerTest {

    @Test
    void resetPwd() {
        String rawPassword = "chao1987";

        // 无需自己生成 salt，BCrypt.hashpw 会自动生成
        String hashedPassword = BCrypt.hashpw(rawPassword);

        System.out.println("原始密码: " + rawPassword);
        System.out.println("BCrypt 哈希后的密码 (存入数据库): " + hashedPassword);
        System.out.println("哈希后的密码长度: " + hashedPassword.length());

        // 每次生成的哈希都不同，因为 salt 是随机的
        String hashedPassword2 = BCrypt.hashpw(rawPassword);
        System.out.println("再次哈希 (结果不同): " + hashedPassword2);

        // 从数据库中取出之前存储的 hashedPassword
        String storedHash = "$2a$10$Jkocm9net1vrXZfC.8ezxeibzet40zHhBQI2MLlMVhoC3c.RIEnbe"; // 模拟从数据库读取

        // 使用 BCrypt.checkpw 进行校验，它会自动从 storedHash 中提取 salt 进行计算和比较
        boolean isPasswordMatch = BCrypt.checkpw(rawPassword, storedHash);
        System.out.println("密码 '" + rawPassword + "' 是否正确: " + isPasswordMatch);
    }
}
