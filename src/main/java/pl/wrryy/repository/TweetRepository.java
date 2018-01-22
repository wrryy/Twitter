package pl.wrryy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wrryy.entity.Tweet;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    public List<Tweet> findTweetsByUserIdOrderByCreatedDesc(int id);
    public List<Tweet> findTweetsByTweetTextContainsOrderByCreatedDesc(String start);
    public List<Tweet> findTweetsByUserId(int id);

    @Query(value = "Select * from tweet order by created desc", nativeQuery = true)
    public List<Tweet> sortByCreated();


}
