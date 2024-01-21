package is2.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class JFreeChartHistogramWindow extends JPanel implements HistogramWindow {

    @Override
    public void show(Histogram hist) {
        JFreeChart res = ChartFactory.createBarChart("", "Número de cursos matriculados",
                "Frecuencia", dataset(hist), PlotOrientation.VERTICAL, false, false, false);
        add(new ChartPanel(res));
    }

    private CategoryDataset dataset(Histogram hist){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int i = 3;
        for(double value : hist.values()){
            dataset.addValue(value, "", i+ " cursos");
            i++;
        }
        return dataset;
    }
}
