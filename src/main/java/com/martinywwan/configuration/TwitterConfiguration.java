package com.martinywwan.configuration;

import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class TwitterConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public RichSourceFunction<String> twitterSource(){
        Properties props = new Properties();
        props.setProperty(TwitterSource.CONSUMER_KEY, applicationProperties.getTwitter().getConsumerSecret());
        props.setProperty(TwitterSource.CONSUMER_SECRET, applicationProperties.getTwitter().getConsumerSecret());
        props.setProperty(TwitterSource.TOKEN, applicationProperties.getTwitter().getToken());
        props.setProperty(TwitterSource.TOKEN_SECRET, applicationProperties.getTwitter().getTokenSecret());
        return new TwitterSource(props);
    }
}
