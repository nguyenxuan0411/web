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
@Table(name = "Videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video {
	@Id
	@Column(name = "VideoId")
	private String videoId;

	@Column(name = "Active")
	private boolean active = true;

	@Column(name = "Description")
	private String description;

	@Column(name = "Poster")
	private String poster;

	@Column(name = "Title")
	private String title;

	@Column(name = "Views")
	private int views;

	@OneToMany(mappedBy = "video")
	private List<Favorite> favorites;

	@OneToMany(mappedBy = "video")
	private List<Share> shares;
}