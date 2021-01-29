package iniciacioaspring.sBootInitialDemoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iniciacioaspring.sBootInitialDemoN2.domain.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Long> {

}