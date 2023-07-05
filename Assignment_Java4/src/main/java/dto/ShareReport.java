package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareReport {
	private String userId;
	private String senderEmail;
	private String receiveEmail;
	private Date sendDate;
}
