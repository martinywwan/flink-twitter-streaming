package com.martinywwan.configuration;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlinkConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public StreamExecutionEnvironment flinkExecutionEnvironment(){
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.createLocalEnvironment();
        streamExecutionEnvironment.setParallelism(applicationProperties.getFlink().getParallelism());
        return streamExecutionEnvironment;
    }
}
