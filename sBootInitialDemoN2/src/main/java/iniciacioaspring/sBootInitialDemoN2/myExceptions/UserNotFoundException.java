package iniciacioaspring.sBootInitialDemoN2.myExceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long id) {
	    super("Could not find user " + id);
	}
}