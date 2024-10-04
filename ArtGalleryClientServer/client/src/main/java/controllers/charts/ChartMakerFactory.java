package controllers.charts;
public class ChartMakerFactory {

    public ChartMakerFactory() {
    }

    public ChartMaker getChartMaker(int selectedStructure) {
        ChartMaker chartMaker = null;

        switch (selectedStructure){
            case 0:
                chartMaker = new PieChartMaker();
                break;
            case 1:
                chartMaker = new BarChartMaker();
                break;
            case 2:
                chartMaker = new RingChartMaker();
                break;
        }
        return chartMaker;
    }
}
