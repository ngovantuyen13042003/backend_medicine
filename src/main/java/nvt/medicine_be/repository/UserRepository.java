package nvt.medicine_be.repository;

import nvt.medicine_be.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User findOneByEmailAndPassword(String email, String password);
}
