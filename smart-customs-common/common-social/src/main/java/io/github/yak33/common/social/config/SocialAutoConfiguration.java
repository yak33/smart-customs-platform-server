package io.github.yak33.common.social.config;

import me.zhyd.oauth.cache.AuthStateCache;
import io.github.yak33.common.social.config.properties.SocialProperties;
import io.github.yak33.common.social.utils.AuthRedisStateCache;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Social 配置属性
 * @author thiszhc
 */
@AutoConfiguration
@EnableConfigurationProperties(SocialProperties.class)
public class SocialAutoConfiguration {

    @Bean
    public AuthStateCache authStateCache() {
        return new AuthRedisStateCache();
    }

}
