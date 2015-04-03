package com.simplefactory.chart;

public class Main {
	
	private static final String KEY_HISTOGRAM = "Histogram";
	private static final String KEY_LINE = "Line";
	private static final String KEY_PIE = "Pie";
	

	public static void main(String[] args) {
		// Reflect
		displayChart(ChartFactory.getChart("com.simplefactory.chart.HistogramChart"));
		displayChart(ChartFactory.getChart("com.simplefactory.chart.LineChart"));
		displayChart(ChartFactory.getChart("com.simplefactory.chart.PieChart"));
		
		// Read type.properties
		displayChart(ChartFactory.getChartByKey(KEY_HISTOGRAM));
		displayChart(ChartFactory.getChartByKey("Line"));
		displayChart(ChartFactory.getChartByKey(KEY_PIE));
	}
	
	private static void displayChart(IChart chart){
		chart.display();
	}

}
