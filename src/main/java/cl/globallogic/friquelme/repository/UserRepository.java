package cl.globallogic.friquelme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.globallogic.friquelme.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User getUserByEmail(String email);
}
