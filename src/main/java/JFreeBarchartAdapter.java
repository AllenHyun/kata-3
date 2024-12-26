import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart){
        return ChartFactory.createBarChart(
                barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetOf(barchart)
        );
    }

    public static CategoryDataset datasetOf(Barchart barchart){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String category: barchart.keySet()){
            dataset.addValue(barchart.get(category), "", category);
        }
        return dataset;
    }
}
