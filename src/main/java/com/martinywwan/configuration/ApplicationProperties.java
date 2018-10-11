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

    private final Twitter twitter = new Twitter();

    @Getter
    @Setter
    public class Flink {
        private Integer parallelism;
    }

    @Getter
    @Setter
    public class Twitter {
        private String consumerKey;

        private String consumerSecret;

        private String token;

        private String tokenSecret;
    }
}
