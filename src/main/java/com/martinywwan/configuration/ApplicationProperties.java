package com.martinywwan.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
@Setter
public class ApplicationProperties {

    private final Flink flink = new Flink();

    @Getter
    @Setter
    public class Flink {
        private Integer parallelism;
    }
}
