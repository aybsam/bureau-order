package com.lismart.smartregie.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories("com.lismart.smartregie.repository")
@EnableCaching
@EnableScheduling
public class SystemConfiguration {

}
