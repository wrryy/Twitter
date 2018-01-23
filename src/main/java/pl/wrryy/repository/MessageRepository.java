package pl.wrryy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wrryy.entity.Message;
import pl.wrryy.entity.User;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{
        public List<Message> findAllByAddressee_UsernameOrderByCreatedDesc(String username);
}
