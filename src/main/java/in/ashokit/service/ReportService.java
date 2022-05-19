package in.ashokit.service;

import java.util.List;

import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<SearchResponse> searchPlans(SearchRequest request);

	
}
