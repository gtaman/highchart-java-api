package nl.pvanassen.highchart.api;

import java.util.*;

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
	private String description;
	private Date dateCreated;
	private ChartType chartType;
	private boolean showEmptyCategories = false;
	private boolean is3d = false;
	private boolean isRemoteDefinition = false;
	
	public ChartDefinition(){}
	
	public ChartDefinition(List<Series> series, List<String> categories, String title, String subtitle, String xAxisTitle, String yAxisTitle, ChartType chartType, Boolean is3d){
		this(series,categories,title,subtitle,xAxisTitle,yAxisTitle,chartType);
		this.is3d=is3d;
	}
	
	public ChartDefinition(List<Series> series, List<String> categories, String title, String subtitle, String xAxisTitle, String yAxisTitle, ChartType chartType){
		this(series,title,subtitle,xAxisTitle,yAxisTitle,chartType);
		super.setCategories(categories);
	}
	
	public ChartDefinition(List<Series> series, String title, String subtitle, String xAxisTitle, String yAxisTitle, ChartType chartType, Boolean is3d){
		this(series,title,subtitle,xAxisTitle,yAxisTitle,chartType);
		this.is3d=is3d;
	}
	
	public ChartDefinition(List<Series> series, String title, String subtitle, String xAxisTitle, String yAxisTitle, ChartType chartType){
		super.setSeries(series);
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

	public String toHtml(){
		StringBuilder html= new StringBuilder();
		html.append("<span id='data-table-title'>"+this.title+" - "+this.subtitle+"</span><br/>");
		html.append(super.toHtmlTable());
		return html.toString();
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
	
	public ChartData getChartData(){
		return new ChartData(this);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isShowEmptyCategories() {
		return showEmptyCategories;
	}

	public void setShowEmptyCategories(boolean showEmptyCategories) {
		this.showEmptyCategories = showEmptyCategories;
	}

	public boolean isIs3d() {
		return is3d;
	}

	public void setIs3d(boolean is3d) {
		this.is3d = is3d;
	}

	public boolean isRemoteDefinition() {
		return isRemoteDefinition;
	}

	public void setRemoteDefinition(boolean isRemoteDefinition) {
		this.isRemoteDefinition = isRemoteDefinition;
	}
}
