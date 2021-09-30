package erpsystem.view.controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import erpsystem.controller.StatisticsController;
import erpsystem.util.Variable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class StatisticsFXMLController implements Initializable {

	///////////////////////////////////////////////////////
	// Day
	///////////////////////////////////////////////////////
	@FXML
	private StackedBarChart<String, Number> stadistChartDay;

	@FXML
	private CategoryAxis stadistChartDayX;

	@FXML
	private NumberAxis stadistChartDayY;
	
	///////////////////////////////////////////////////////
	// Interval
	///////////////////////////////////////////////////////
	@FXML
	private BarChart<String, Number> statisticIntervalChart;

	@FXML
	private CategoryAxis statisticIntervalChartCategory;

	@FXML
	private NumberAxis statisticIntervalChartNumber;
	
	///////////////////////////////////////////////////////
	// Interval - Date Start
	///////////////////////////////////////////////////////
	@FXML
	private ComboBox<String> statisticIntervalDateStartDay;
	@FXML
	private ComboBox<String> statisticIntervalDateStartMonth;
	@FXML
	private ComboBox<String> statisticIntervalDateStartYear;
	
	///////////////////////////////////////////////////////
	// Interval - Date End
	///////////////////////////////////////////////////////
	@FXML
	private ComboBox<String> statisticIntervalDateEndDay;
	@FXML
	private ComboBox<String> statisticIntervalDateEndMonth;
	@FXML
	private ComboBox<String> statisticIntervalDateEndYear;
	@FXML
	private Button statisticIntervalButtonFind;
	

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		/**
		 * Interval
		 */
		if (statisticIntervalChart != null) {
			/**
			 * Date Start
			 */
			statisticIntervalDateStartDay.setItems(Variable.days());
			statisticIntervalDateStartDay.getSelectionModel().selectFirst();
			statisticIntervalDateStartMonth.setItems(Variable.month());
			statisticIntervalDateStartMonth.getSelectionModel().selectFirst();
			statisticIntervalDateStartYear.setItems(Variable.years());
			statisticIntervalDateStartYear.getSelectionModel().selectFirst();
			/**
			 * Date End
			 */
			statisticIntervalDateEndDay.setItems(Variable.days());
			statisticIntervalDateEndDay.getSelectionModel().selectFirst();
			statisticIntervalDateEndMonth.setItems(Variable.month());
			statisticIntervalDateEndMonth.getSelectionModel().selectFirst();
			statisticIntervalDateEndYear.setItems(Variable.years());
			statisticIntervalDateEndYear.getSelectionModel().selectFirst();
		}
		/**
		 * Day
		 */
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
			while (finalCalendar.after(finalValue)) {
				initialValue = copyCalendar(finalValue);
				finalValue.add(Calendar.DAY_OF_MONTH, interval);
				String s1 = toString(initialValue);
				String s2 = toString(finalValue);
				long value1 = initialValue.getTimeInMillis();
				long value2 = finalValue.getTimeInMillis();
				/***
				 * Series
				 */
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
			}
		}
	}
	
	///////////////////////////////////////////////////////
	// Method - On
	///////////////////////////////////////////////////////
	@FXML
	public void onButtonFindRangeDate(ActionEvent event) {
		String date_start [] = {
				statisticIntervalDateStartDay.getSelectionModel().getSelectedItem(), 
				statisticIntervalDateStartMonth.getSelectionModel().getSelectedItem(),
				statisticIntervalDateStartYear.getSelectionModel().getSelectedItem()
		};
		String date_end [] = {
				statisticIntervalDateEndDay.getSelectionModel().getSelectedItem(), 
				statisticIntervalDateEndMonth.getSelectionModel().getSelectedItem(),
				statisticIntervalDateEndYear.getSelectionModel().getSelectedItem()
		};
		if(date_start[0] != null && date_start[1] != null && date_start[2] != null) {
			if(date_end[0] != null && date_end[1] != null && date_end[2] != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String startChain = date_start[2]+"-"+Variable.month(date_start[1])+"-"+date_start[0];
				String endChain = date_end[2]+"-"+Variable.month(date_end[1])+"-"+date_end[0];
				try {
					Date dateStart = sdf.parse(startChain);
					Date dateEnd = sdf.parse(endChain);
					
					Calendar start = dateToCalendar(dateStart);
					Calendar end = dateToCalendar(dateEnd);
					
					String s1 = toString(start);
					String s2 = toString(end);
					
					long initialDate = start.getTime().getTime();
			        long finalDate   = end.getTime().getTime();
			        /***
					 * Series
					 */
			        XYChart.Series<String, Number> series = new XYChart.Series<>();
					series.setName(s1 + " \n" + s2);
					
					StatisticsController statisticsController = new StatisticsController();
					
					series.getData().add(new XYChart.Data<String, Number>("Venta",
							statisticsController.getValorVendaEm(initialDate, finalDate)));
					series.getData().add(new XYChart.Data<String, Number>("Compra",
							statisticsController.getValorCompraEm(initialDate, finalDate)));
					series.getData().add(new XYChart.Data<String, Number>("Lucro",
							statisticsController.getValorLucroEm(initialDate, finalDate)));
					statisticIntervalChart.getData().add(series);
					
				} catch (ParseException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	
	@FXML
	public void onButtonFindClear(ActionEvent event) {
		if(statisticIntervalChart != null) {
			statisticIntervalChart.getData().removeAll(statisticIntervalChart.getData());
			Alert a = new Alert( AlertType.CONFIRMATION);
			a.setTitle(Variable.ERP_SYSTEM_NAME);
			a.setContentText("Se ha limpiado la grafica.");
			a.show();
		}
	}
	
	///////////////////////////////////////////////////////
	// Method - Private
	///////////////////////////////////////////////////////
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
	
	private Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

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
	public StackedBarChart<String, Number> getStadistChartDay() {
		return stadistChartDay;
	}

	public BarChart<String, Number> getStatisticIntervalChart() {
		return statisticIntervalChart;
	}

	public void setStatisticIntervalChart(BarChart<String, Number> statisticIntervalChart) {
		this.statisticIntervalChart = statisticIntervalChart;
	}

	public CategoryAxis getStatisticIntervalChartCategory() {
		return statisticIntervalChartCategory;
	}

	public void setStatisticIntervalChartCategory(CategoryAxis statisticIntervalChartCategory) {
		this.statisticIntervalChartCategory = statisticIntervalChartCategory;
	}

	public NumberAxis getStatisticIntervalChartNumber() {
		return statisticIntervalChartNumber;
	}

	@SuppressWarnings("rawtypes")
	public ComboBox getStatisticIntervalDateStartDay() {
		return statisticIntervalDateStartDay;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setStatisticIntervalDateStartDay(ComboBox statisticIntervalDateStartDay) {
		this.statisticIntervalDateStartDay = statisticIntervalDateStartDay;
	}
	
	@SuppressWarnings("rawtypes")
	public ComboBox getStatisticIntervalDateStartMonth() {
		return statisticIntervalDateStartMonth;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setStatisticIntervalDateStartMonth(ComboBox statisticIntervalDateStartMonth) {
		this.statisticIntervalDateStartMonth = statisticIntervalDateStartMonth;
	}
	
	@SuppressWarnings("rawtypes")
	public ComboBox getStatisticIntervalDateStartYear() {
		return statisticIntervalDateStartYear;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setStatisticIntervalDateStartYear(ComboBox statisticIntervalDateStartYear) {
		this.statisticIntervalDateStartYear = statisticIntervalDateStartYear;
	}
	
	@SuppressWarnings("rawtypes")
	public ComboBox getStatisticIntervalDateEndDay() {
		return statisticIntervalDateEndDay;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setStatisticIntervalDateEndDay(ComboBox statisticIntervalDateEndDay) {
		this.statisticIntervalDateEndDay = statisticIntervalDateEndDay;
	}
	@SuppressWarnings("rawtypes")
	public ComboBox getStatisticIntervalDateEndMonth() {
		return statisticIntervalDateEndMonth;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setStatisticIntervalDateEndMonth(ComboBox statisticIntervalDateEndMonth) {
		this.statisticIntervalDateEndMonth = statisticIntervalDateEndMonth;
	}
	@SuppressWarnings("rawtypes")
	public ComboBox getStatisticIntervalDateEndYear() {
		return statisticIntervalDateEndYear;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setStatisticIntervalDateEndYear(ComboBox statisticIntervalDateEndYear) {
		this.statisticIntervalDateEndYear = statisticIntervalDateEndYear;
	}

	public Button getStatisticIntervalButtonFind() {
		return statisticIntervalButtonFind;
	}

	public void setStatisticIntervalButtonFind(Button statisticIntervalButtonFind) {
		this.statisticIntervalButtonFind = statisticIntervalButtonFind;
	}

	public void setStatisticIntervalChartNumber(NumberAxis statisticIntervalChartNumber) {
		this.statisticIntervalChartNumber = statisticIntervalChartNumber;
	}

	public void setStadistChartDay(StackedBarChart<String, Number> stadistChartDay) {
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
