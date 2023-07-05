package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteReport {
	private String videoTitle;
	private Long favoriteCount;
	private Date newestDate;
	private Date oldestDate;
}
