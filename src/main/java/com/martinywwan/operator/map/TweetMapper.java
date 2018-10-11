package com.martinywwan.operator.map;

import com.martinywwan.model.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Slf4j
public class TweetMapper implements MapFunction<String, Tweet> {

    @Override
    public Tweet map(String inputTweet) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputTweet, Tweet.class);
        } catch (IOException e) {
            log.error("Failed to map input tweet to POJO", e);
        }
        return null;
    }
}
