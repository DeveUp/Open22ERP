package erpsystem.view.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.sun.glass.ui.Size;

import erpsystem.controller.StatisticsController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class StadistFXMLController implements Initializable {

	///////////////////////////////////////////////////////
	// Interval
	///////////////////////////////////////////////////////
	@FXML
	private StackedBarChart<String, Number> stadistChartDay;

	@FXML
	private CategoryAxis stadistChartDayX;

	@FXML
	private NumberAxis stadistChartDayY;

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if (stadistChartDay != null) {
			stadistChartDay.getData().removeAll(stadistChartDay.getData());
			/**
			 * Date Interval
			 */
			Calendar finalCalendar = Calendar.getInstance();
			long time = System.currentTimeMillis();
			finalCalendar.setTimeInMillis(time);
			Calendar initialCalendar = Calendar.getInstance();
			initialCalendar.setTimeInMillis(time);
			initialCalendar.add(Calendar.DAY_OF_MONTH, -8);
			int interval = 1;
			/***
			 * Date
			 */
			finalCalendar = getCurrentCalendar();
			Calendar finalValue = copyCalendar(initialCalendar);
			Calendar initialValue = copyCalendar(initialCalendar);
			int i = 0;
			while (finalCalendar.after(finalValue)) {

				System.out.println(finalCalendar.after(finalValue));
				initialValue = copyCalendar(finalValue);
				finalValue.add(Calendar.DAY_OF_MONTH, interval);
				String s1 = toString(initialValue);
				String s2 = toString(finalValue);
				long value1 = initialValue.getTimeInMillis();
				long value2 = finalValue.getTimeInMillis();
				/***
				 * Series
				 */
				System.out.println(s1 + " - " + s2);
				System.out.println("Size: " + stadistChartDay.getData().size());
				final XYChart.Series<String, Number> series = new XYChart.Series<>();
				series.setName(s1 + " \n" + s2);
				StatisticsController statisticsController = new StatisticsController();
				series.getData().add(new XYChart.Data<String, Number>("Venta",
						statisticsController.getValorVendaEm(value1, value2)));
				series.getData().add(new XYChart.Data<String, Number>("Compra",
						statisticsController.getValorCompraEm(value1, value2)));
				series.getData().add(new XYChart.Data<String, Number>("Lucro",
						statisticsController.getValorLucroEm(value1, value2)));
				stadistChartDay.getData().add(series);
				i++;
				System.out.println(stadistChartDay.getData());
			}
		}
	}

	private Calendar getCurrentCalendar() {
		Calendar calendar = Calendar.getInstance();
		long ct = System.currentTimeMillis();
		calendar.setTimeInMillis(ct);
		return calendar;
	}

	private Calendar copyCalendar(Calendar calendar) {
		Calendar result = Calendar.getInstance();
		result.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
		return result;
	}

	private String toString(Calendar calendar){
        String result = "";
        int y  = calendar.get(Calendar.YEAR);
        int m  = calendar.get(Calendar.MONTH) + 1;
        int d  = calendar.get(Calendar.DAY_OF_MONTH);
        int h  = calendar.get(Calendar.HOUR_OF_DAY);
        int mm = calendar.get(Calendar.MINUTE);
        int s  = calendar.get(Calendar.SECOND);
        result += ((d < 9) ? "0" : "") + d + "/" + 
        		  ((m < 9) ? "0" : "") + m + "/" + 
        		   y + 
        		   " " + 
        		   ((h < 9) ? "0" : "") + h + ":" + 
        		   ((mm < 9) ? "0" : "") + mm + ":"+
        		   ((s < 9) ? "0" : "") + s; 
        return result;        
    }

	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public StackedBarChart getStadistChartDay() {
		return stadistChartDay;
	}

	public void setStadistChartDay(StackedBarChart stadistChartDay) {
		this.stadistChartDay = stadistChartDay;
	}

	public CategoryAxis getStadistChartDayX() {
		return stadistChartDayX;
	}

	public void setStadistChartDayX(CategoryAxis stadistChartDayX) {
		this.stadistChartDayX = stadistChartDayX;
	}

	public NumberAxis getStadistChartDayY() {
		return stadistChartDayY;
	}

	public void setStadistChartDayY(NumberAxis stadistChartDayY) {
		this.stadistChartDayY = stadistChartDayY;
	}
}
