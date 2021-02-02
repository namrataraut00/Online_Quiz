package quiz.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import quiz.entity.User;

public interface UserDao {

	public User validateLogin(String email,String password);

	public boolean register(User newUser);

	public User getUserByid(int id);

	public boolean updateMail(int id,String email);
	public boolean updatePassword(int id,String password) throws GeneralSecurityException, IOException;
}
