package np.com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.login.model.SecUser;
import np.com.login.repository.SecUserRepository;

@Service
public class SecUserService {
	
	@Autowired
    private SecUserRepository secUserRepository;
	
	public SecUser findByUsername(String username) {
        return secUserRepository.findByUsername(username);
    }
	
	public SecUser save(SecUser secUser) {
        return secUserRepository.save(secUser);
    }

}
