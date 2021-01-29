package iniciacioaspring.sBootInitiaDemoN3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iniciacioaspring.sBootInitiaDemoN3.domain.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Long> {

}