package com.coderscampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class SaleReportService {

	Map<String, Integer> salesReportByYear(String fileName) throws IOException {
		Map<String, Integer> salesReportByYear = new LinkedHashMap<>();
		FileService fileService = new FileService();
		BufferedReader reader = fileService.reader(fileName);
		String line = "";

		while ((line = reader.readLine()) != null) {
			String[] dateSalesInfo = fileService.parseText(line);
			if (FileService.isNumeric(dateSalesInfo[1])) {
				LocalDate saleYearDate = LocalDate.parse(dateSalesInfo[0] + "-01",
						DateTimeFormatter.ofPattern("MMM-yy-dd"));
				String saleYear = saleYearDate.format(DateTimeFormatter.ofPattern("yyyy"));
				int parsedInt = Integer.parseInt(dateSalesInfo[1]);
				if (salesReportByYear.containsKey(saleYear)) {
					Integer newSalesCount = salesReportByYear.get(saleYear) + parsedInt;
					salesReportByYear.replace(saleYear, salesReportByYear.get(saleYear), newSalesCount);
				} else {
					salesReportByYear.put(saleYear, parsedInt);
				}
			}

		}
		return salesReportByYear;

	}

	Map<LocalDate, Integer> salesReportByMonth(String fileName) throws IOException {
		Map<LocalDate, Integer> salesReportByMonth = new LinkedHashMap<>();
		FileService fileService = new FileService();
		BufferedReader reader = fileService.reader(fileName);
		String line = "";

		while ((line = reader.readLine()) != null) {
			String[] dateSalesInfo = fileService.parseText(line);
			if (FileService.isNumeric(dateSalesInfo[1])) {
				LocalDate saleYearDate = LocalDate.parse(dateSalesInfo[0] + "-01",
						DateTimeFormatter.ofPattern("MMM-yy-dd"));
				int parsedInt = Integer.parseInt(dateSalesInfo[1]);
				if (salesReportByMonth.containsKey(saleYearDate)) {
					Integer newSalesCount = salesReportByMonth.get(saleYearDate) + parsedInt;
					salesReportByMonth.replace(saleYearDate, salesReportByMonth.get(saleYearDate), newSalesCount);
				} else {
					salesReportByMonth.put(saleYearDate, parsedInt);
				}
			}

		}
		return salesReportByMonth;

	}
}
