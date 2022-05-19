package in.ashokit.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchResponse {

	private Long caseNum;
	private String planName;
	private String planStatus;
	private Double benefitAmt;
	private LocalDate startDate;
	private LocalDate endDate;
	private String denailReason;
	private String holderName;
	private Long holderSsn;
}
