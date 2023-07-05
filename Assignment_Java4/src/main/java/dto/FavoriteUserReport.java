package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteUserReport {
	private String userId;
	private String fullname;
	private String email;
	private Date likeDate;
}
