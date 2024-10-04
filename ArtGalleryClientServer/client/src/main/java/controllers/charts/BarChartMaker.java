package controllers.charts;

import controllers.charts.ChartMaker;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.HashMap;
import java.util.Map;

public class BarChartMaker implements ChartMaker {

    @Override
    public JFreeChart createChart(HashMap<String, Integer> input, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Map.Entry<String, Integer> entry : input.entrySet()){
            dataset.addValue(entry.getValue(), entry.getKey(), "");
        }
        JFreeChart chart = ChartFactory.createBarChart(title, "", "Number of Art Pieces",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;
    }
}
