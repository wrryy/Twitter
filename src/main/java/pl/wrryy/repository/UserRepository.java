package pl.wrryy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wrryy.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "Select * from user order by username asc", nativeQuery = true)
    public List<User> findAllByFullName();
    public User findOneByUsernameAndPassword(String username, String password);
}
