package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {
	@Id
	@Column(name = "UserId")
	private String userId;

	@Column(name = "Email")
	private String email;

	@Column(name = "Fullname")
	private String fullname;

	@Column(name = "Password")
	private String password;

	@Column(name = "Admin")
	private boolean admin = false;
}