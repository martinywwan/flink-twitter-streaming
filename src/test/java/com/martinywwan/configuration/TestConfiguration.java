package com.martinywwan.configuration;

import org.apache.commons.io.FileUtils;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Serializable;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {

    @Component("twitterSource")
    @Primary
    public class TestSource extends RichSourceFunction<String> implements Serializable {
        @Override
        public void run(SourceContext<String> ctx) throws Exception {
            System.out.println("************* TUNNNINGNGNGN");
            String inputTestData = FileUtils.readFileToString(new File("src/test/resources/exampleTweet.json"));
            ctx.collect(inputTestData);
        }

        @Override
        public void cancel() {}
    }
}

