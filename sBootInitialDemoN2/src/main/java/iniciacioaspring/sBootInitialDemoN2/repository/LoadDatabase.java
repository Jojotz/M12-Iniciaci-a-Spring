package iniciacioaspring.sBootInitialDemoN2.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import iniciacioaspring.sBootInitialDemoN2.domain.MyUser;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new MyUser("Joan Coll", "3 Octubre")));
      log.info("Preloading " + repository.save(new MyUser("Frodo Baggins", "28 Gener")));
    };
  }
}