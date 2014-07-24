package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.shared.SeriesType;

public enum ChartType {
	bar(SeriesType.BAR),
	column(SeriesType.COLUMN),
	barStack(SeriesType.BAR),
	columnStack(SeriesType.COLUMN),
	pie(SeriesType.PIE),
	combo(null);
	
	SeriesType seriesType;
	
	private ChartType(SeriesType seriesType){
		this.seriesType=seriesType;
	}
	
	public SeriesType getSeriesType(){
		return seriesType;
	}
	
	//Provide default plotOptions
	public PlotOptions getPlotOptions(){
		PlotOptions plotOptions = new PlotOptions();
		if("bar".equals(this.name()))
			plotOptions.getBar();		
		if("column".equals(this.name()))
			plotOptions.getColumn().setBorderWidth(0);
		if("barStack".equals(this.name()))
			plotOptions.getBar().setStacking("normal").setBorderWidth(0);
		if("columnStack".equals(this.name()))
			plotOptions.getColumn().setStacking("normal").setBorderWidth(0);
		if("pie".equals(this.name()))
			plotOptions.getPie().setAllowPointSelect(true).setBorderWidth(0);
		if("combo".equals(this.name()))
			plotOptions.getColumn().setStacking("normal").setBorderWidth(0);
		return plotOptions;
	}
}
