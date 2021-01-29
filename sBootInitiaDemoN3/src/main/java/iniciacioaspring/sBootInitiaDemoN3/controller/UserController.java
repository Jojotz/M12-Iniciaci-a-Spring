package iniciacioaspring.sBootInitiaDemoN3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iniciacioaspring.sBootInitiaDemoN3.domain.MyUser;
import iniciacioaspring.sBootInitiaDemoN3.myExceptions.UserNotFoundException;
import iniciacioaspring.sBootInitiaDemoN3.repository.UserRepository;

@RestController
//@RequestMapping("/v1")
class UserController {

  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/v1")
  public String helloUser(@RequestParam(value = "name", defaultValue = "World") String name) {
  	return String.format("Hello %s!", name); 
  	//Petició GET a Postman: localhost:8080/v1/?name=Joan
  }
  
  @GetMapping("/users")
  List<MyUser> all() {
    return repository.findAll();
  }

  @PostMapping("/users")
  MyUser newUser(@RequestBody MyUser newUser) {
    return repository.save(newUser);
  }

  // Single item

  @GetMapping("/users/{id}")
  MyUser one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/users/{id}")
  MyUser replaceUser(@RequestBody MyUser newUser, @PathVariable Long id) {

    return repository.findById(id)
      .map(user -> {
    	  user.setName(newUser.getName());
    	  user.setDateOfBirth(newUser.getDateOfBirth());
        return repository.save(user);
      })
      .orElseGet(() -> {
    	  newUser.setId(id);
        return repository.save(newUser);
      });
  }

  @DeleteMapping("/users/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}