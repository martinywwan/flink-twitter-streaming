package com.martinywwan.model;

import lombok.*;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

import static java.sql.Timestamp.from;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
@Table(name = "T_TWEET")
public class Tweet implements Serializable{

    @Id
    @SequenceGenerator(sequenceName = "SEQ_TWEET", name = "SEQ_TWEET_GEN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TWEET_GEN")
    @JsonIgnore
    private long id;

    @JsonIgnore
    private Timestamp createdTs;

    @Column(name = "TWEET_TS")
    @JsonProperty("created_at")
    private String tweetTs;

    @Column(name = "TWEET_ID")
    @JsonProperty("id")
    private long tweetId;

    @Column(name = "TWEET_MESSAGE")
    private String text;

    @PrePersist
    public void setPrePersist(){
        createdTs = from(Instant.now());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tweet{");
        sb.append("id=").append(id);
        sb.append(", createdTs=").append(createdTs);
        sb.append(", tweetTs='").append(tweetTs).append('\'');
        sb.append(", tweetId=").append(tweetId);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
