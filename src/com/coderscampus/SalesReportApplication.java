package com.coderscampus;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalesReportApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("Model 3 Yearly Sales Report \n--------------");

		MapService mapService = new MapService();
		SaleReportService saleReportService = new SaleReportService();
		Map<String, Integer> model3SalesByYear = new LinkedHashMap<String, Integer>(
				saleReportService.salesReportByYear("model3.csv"));
		Map<LocalDate, Integer> model3SalesByMonth = new LinkedHashMap<LocalDate, Integer>(
				saleReportService.salesReportByMonth("model3.csv"));
		printSalesReport(mapService, model3SalesByYear, model3SalesByMonth);

		Map<String, Integer> modelSSalesByYear = new LinkedHashMap<String, Integer>(
				saleReportService.salesReportByYear("modelS.csv"));
		Map<LocalDate, Integer> modelSSalesByMonth = new LinkedHashMap<LocalDate, Integer>(
				saleReportService.salesReportByMonth("modelS.csv"));
		System.out.println("Model S Yearly Sales Report \n--------------");
		printSalesReport(mapService, modelSSalesByYear, modelSSalesByMonth);

		Map<String, Integer> modelXSalesByYear = new LinkedHashMap<String, Integer>(
				saleReportService.salesReportByYear("modelX.csv"));
		Map<LocalDate, Integer> modelXSalesByMonth = new LinkedHashMap<LocalDate, Integer>(
				saleReportService.salesReportByMonth("modelX.csv"));
		System.out.println("Model X Yearly Sales Report \n--------------");
		printSalesReport(mapService, modelXSalesByYear, modelXSalesByMonth);

	}

	private static void printSalesReport(MapService mapService, Map<String, Integer> model3SalesByYear,
			Map<LocalDate, Integer> model3SalesByMonth) {
		Integer model3HighestMonthSales = mapService.getLargestValueInMap(model3SalesByMonth);
		Integer model3LowestMonthSales = mapService.getSmallestValueInMap(model3SalesByMonth);
		Entry<LocalDate, Integer> model3HighestMonthEntry = mapService.findEntryByValue(model3SalesByMonth,
				model3HighestMonthSales);
		Entry<LocalDate, Integer> model3LowestMonthEntry = mapService.findEntryByValue(model3SalesByMonth,
				model3LowestMonthSales);

		printMapToConsole(model3SalesByYear);

		System.out.println("The best month for Model 3 was: "
				+ model3HighestMonthEntry.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM")));
		System.out.println("The worst month for Model 3 was: "
				+ model3LowestMonthEntry.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM")) + "\n");
	}

	private static void printMapToConsole(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

}
