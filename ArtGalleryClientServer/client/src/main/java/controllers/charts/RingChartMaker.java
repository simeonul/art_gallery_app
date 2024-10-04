package controllers.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class RingChartMaker implements ChartMaker{
    @Override
    public JFreeChart createChart(HashMap<String, Integer> input, String title) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Map.Entry<String, Integer> entry : input.entrySet()){
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        JFreeChart chart = ChartFactory.createRingChart(title, dataset, true, true, false);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((RingPlot)chart.getPlot()).setLabelGenerator(labelGenerator);
        return chart;
    }
}
