package is2.ulpgc.kata3;

import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {
    private HistogramWindow histogramWindow;

    public MainJFrame() throws HeadlessException {
        this.setTitle("Frecuencia por número de cursos matriculados.");
        this.setSize(1150, 900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createHistogramWindow());
    }

    private Component createHistogramWindow() {
        JFreeChartHistogramWindow window = new JFreeChartHistogramWindow();
        this.histogramWindow = window;
        return window;
    }

    public HistogramWindow histogramWindow(){
        return this.histogramWindow;
    }
}
