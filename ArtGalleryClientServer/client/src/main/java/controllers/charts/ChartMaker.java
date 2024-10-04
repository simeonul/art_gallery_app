package controllers.charts;

import org.jfree.chart.JFreeChart;

import java.util.HashMap;

public interface ChartMaker {
    JFreeChart createChart(HashMap<String, Integer> input, String title);
}
