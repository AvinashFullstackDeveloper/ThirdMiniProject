package in.ashokit.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.reports.ExcelGenerator;
import in.ashokit.reports.PdfGenerator;
import in.ashokit.request.SearchRequest;
import in.ashokit.response.SearchResponse;
import in.ashokit.service.ReportService;

@RestController
public class ReportRestController {

	@Autowired
	private ReportService service;

	@GetMapping("/plan-names")
	public List<String> getPlanNames() {
		return service.getPlanNames();
	}

	@GetMapping("/plan-statues")
	public List<String> getPlanStatuses() {
		return service.getPlanStatuses();
	}

	@PostMapping("/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request) {
		return service.searchPlans(request);
	}

	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.searchPlans(null);
		ExcelGenerator excel = new ExcelGenerator();
		excel.generateExcel(records, response);
	}

	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse httpResponse) throws Exception {

		httpResponse.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.searchPlans(null);
		PdfGenerator pdfGen = new PdfGenerator();
		pdfGen.generatePdf(records, httpResponse);
	}

}
