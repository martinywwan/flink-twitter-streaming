package com.martinywwan.operator.sink;

import com.martinywwan.model.Tweet;
import com.martinywwan.repo.TweetRepo;
import com.martinywwan.util.SpringBeansUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.springframework.data.jpa.repository.JpaRepository;

import static java.time.LocalDate.now;

@Slf4j
public class TweetSink extends RichSinkFunction<Tweet> {

    private JpaRepository<Tweet, Long> tweetRepo;

    @Override
    public void open(Configuration parameters) {
        tweetRepo = SpringBeansUtil.getBean(TweetRepo.class);
    }

    @Override
    public void invoke(Tweet tweet, Context context) {
        log.info(String.format("Persisting Tweet [timestamp=%s] [Tweet=%s]", now(), tweet.toString()));
        tweetRepo.save(tweet);
    }
}
