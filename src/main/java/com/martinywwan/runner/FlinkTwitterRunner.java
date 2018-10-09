package com.martinywwan.runner;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FlinkTwitterRunner implements ApplicationRunner {

    @Autowired
    private StreamExecutionEnvironment flinkExecutionEnvironment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        flinkExecutionEnvironment.execute("FlinkTwitterExecution");
    }
}
