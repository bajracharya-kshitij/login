package np.com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import np.com.login.model.SecUser;

public interface SecUserRepository extends JpaRepository<SecUser, Long> {
	
	SecUser findByUsername(String username);
	
}
