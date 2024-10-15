package Observer;


import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graphic extends JFrame implements Observer {

    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public Graphic() {

        JFreeChart chart = ChartFactory.createBarChart(
                "Algoritmo genético", 
                "Iteração",         
                "Fitness",            
                dataset);   
                
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);

        
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            }
        }, 0, 4000);
    }


    @Override
    public void atualizar(Float fitness, int iteration) {
        dataset.addValue(fitness, "Fitness", Integer.toString(iteration));
    }


}
