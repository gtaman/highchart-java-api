package nl.pvanassen.highchart.api;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import nl.pvanassen.highchart.api.shared.SeriesType;

/**
 * Everything you needed to remotely render a Chart
 */
@XmlRootElement( name = "chartDefinition" )
public class ChartDefinition extends ChartData{
	private String title;
	private String subtitle;
	private String xAxisTitle;
	private String yAxisTitle;
	private ChartType chartType;
	private Boolean showEmptyCategories;
	
	public ChartDefinition(){}
	
	public ChartDefinition(List<Series> series, List<String> categories, String title, String subtitle, String xAxisTitle, String yAxisTitle, ChartType chartType){
		super.setSeries(series);
		super.setCategories(categories);
		this.title=title;
		this.subtitle=subtitle;
		this.xAxisTitle=xAxisTitle;
		this.yAxisTitle=yAxisTitle;
		this.chartType=chartType;
	}
	
	public ChartDefinition(ChartOptions chartOptions){
		String seriesType = chartOptions.getChart().getDefaultSeriesType();
		PlotOptions plotOptions = chartOptions.getPlotOptions();
		
		//TODO, Make this better by a function on ChartType that takes in Series String and PlotOptions
		for(ChartType chartType : ChartType.values()){
			if(chartType.getSeriesType().equals(seriesType)){
				if(chartType.getSeriesType().equals(SeriesType.BAR) && plotOptions.getBar().getStacking().equals("normal")){
					this.chartType=ChartType.barStack;
				}
				else if(chartType.getSeriesType().equals(SeriesType.BAR)){
					this.chartType=ChartType.bar;
				}
				else if(chartType.getSeriesType().equals(SeriesType.COLUMN) && plotOptions.getColumn().getStacking().equals("normal")){
					this.chartType=ChartType.columnStack;
				}
				else if(chartType.getSeriesType().equals(SeriesType.COLUMN)){
					this.chartType=ChartType.column;
				}
				else{
					this.chartType = ChartType.combo;
				}
			}
		}
		
		this.title=chartOptions.getTitle().getText();
		this.subtitle=chartOptions.getSubtitle().getText();
		this.xAxisTitle=chartOptions.getXAxis().getTitle().getText();
		this.yAxisTitle=chartOptions.getYAxis().getTitle().getText();
    	
		super.setCategories(chartOptions.getXAxis().getCategories());
		super.setSeries(chartOptions.getSeries());
	}
	
	public void toTableHtml(){
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String graphTitle) {
		this.title = graphTitle;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String graphSubtitle) {
		this.subtitle = graphSubtitle;
	}
	public String getxAxisTitle() {
		return xAxisTitle;
	}
	public void setxAxisTitle(String xAxisTitle) {
		this.xAxisTitle = xAxisTitle;
	}
	public String getyAxisTitle() {
		return yAxisTitle;
	}
	public void setyAxisTitle(String yAxisTitle) {
		this.yAxisTitle = yAxisTitle;
	}

	public ChartType getChartType() {
		return chartType;
	}

	public void setChartType(ChartType chartType) {
		this.chartType = chartType;
	}

	public Boolean getShowEmptyCategories() {
		return showEmptyCategories;
	}

	public void setShowEmptyCategories(Boolean showEmptyCategories) {
		this.showEmptyCategories = showEmptyCategories;
	}
	
	public ChartData getChartData(){
		return new ChartData(this);
	}
}
