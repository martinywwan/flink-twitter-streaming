package com.martinywwan.runner;

import com.martinywwan.operator.map.TweetMapper;
import com.martinywwan.operator.sink.TweetSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FlinkTwitterLauncher implements ApplicationRunner {

    private final StreamExecutionEnvironment flinkExecutionEnvironment;

    private final RichSourceFunction<String> twitterSource;

    @Autowired
    public FlinkTwitterLauncher(StreamExecutionEnvironment flinkExecutionEnvironment,
                                RichSourceFunction<String> twitterSource) {
        this.flinkExecutionEnvironment = flinkExecutionEnvironment;
        this.twitterSource = twitterSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DataStreamSource<String> flinkDataStreamSource = flinkExecutionEnvironment.addSource(twitterSource);
        flinkDataStreamSource.map(new TweetMapper()).filter(Objects::nonNull).addSink(new TweetSink());
        flinkExecutionEnvironment.execute("FlinkTwitterExecution");
    }
}
