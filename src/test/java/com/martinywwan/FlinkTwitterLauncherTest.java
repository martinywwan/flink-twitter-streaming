package com.martinywwan;

import com.martinywwan.configuration.TestConfiguration;
import com.martinywwan.model.Tweet;
import com.martinywwan.runner.FlinkTwitterLauncher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class, TestConfiguration.class})
@ActiveProfiles("test")
public class FlinkTwitterLauncherTest {

    @Autowired
    private FlinkTwitterLauncher flinkTwitterLauncher;

    @Autowired
    private JpaRepository<Tweet, Long> tweetRepo;

    @Description("Dummy test source writes JSON test file into the Flink stream. " +
                 "The JSON is mapped to a POJO and persisted to H2 database")
    @Test
    public void endToEndDataIngestion() throws Exception {
        Thread.sleep(200);
        List<Tweet> tweets = tweetRepo.findAll();
        assertThat(tweets.size()).isEqualTo(1);
        Tweet tweet = tweets.get(0);
        assertThat(tweet.getTweetId()).isEqualTo(850006245121695744L);
        assertThat(tweet.getText()).isEqualTo("Example Tweet :) .. www.github.com/martinywwan");
    }
}
