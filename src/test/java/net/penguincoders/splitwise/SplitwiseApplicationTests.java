package net.penguincoders.splitwise;

import net.penguincoders.splitwise.dataaccess.model.UsersEntity;
import net.penguincoders.splitwise.dataaccess.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
class SplitwiseApplicationTests  extends AbstractTestNGSpringContextTests{

    @Autowired
    public UsersRepository usersRepository;

	@Test
	public void test(){
		List<UsersEntity> getUserEntity = usersRepository.getAllUsers();
        System.out.println(getUserEntity);
	}

}
