package com.martinywwan.repo;

import com.martinywwan.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TweetRepo extends JpaRepository<Tweet, Long> , Serializable {
}
