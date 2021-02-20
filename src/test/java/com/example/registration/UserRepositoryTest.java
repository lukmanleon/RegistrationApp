package com.example.registration;

import com.example.registration.entities.User;
import com.example.registration.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("leon@test.com");
        user.setPassword("password");
        user.setFirstName("Leon");
        user.setLastName("Lukman");

        User savedUser = userRepo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assert(existUser.getEmail().equals(user.getEmail()));
    }

    @Test
    public void findUserByEmail(){

        String email = "leon@test.com";
        User user = userRepo.findByEmail(email);

        assert (user != null);
    }
}
