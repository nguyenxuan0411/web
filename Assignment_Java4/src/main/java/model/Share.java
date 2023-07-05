package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Shares")
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share {
	@Id
	@Column(name="ShareId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shareId;

	@Column(name="Emails")
	private String emails;

	@Column(name="ShareDate")
	private Date shareDate;

	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	@ManyToOne
	@JoinColumn(name="VideoId")
	private Video video;
}