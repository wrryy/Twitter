package pl.wrryy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.wrryy.entity.Comment;
import pl.wrryy.entity.User;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(nativeQuery = true, value = "Select * from comment where user_id=:id order by created desc")
    public List<Comment> findCommentsByUserId(@Param("id") int id);

    @Query(nativeQuery = true, value = "Select * from comment where tweet_id=:id order by created desc")
    public List<Comment> findCommentsByTweetId(@Param("id") int id);

    @Query(value = "Select * from comment order by created desc", nativeQuery = true)
    public List<Comment> sortByCreated();
}