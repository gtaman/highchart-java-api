package nl.pvanassen.highchart.api;

import java.net.URI;
import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

import nl.pvanassen.highchart.api.base.BaseObject;

/**
 * Contains only data
 * Basically used for a canned chart to have dynamic data
 */
@XmlRootElement
public class ChartData extends BaseObject{
	private List<Series> series = new ArrayList<Series>();
	private List<String> categories = new ArrayList<String>();
	private URI dataURI;
	
	public ChartData(){}
	
	public ChartData(ChartOptions chartOptions){
		this.setCategories(chartOptions.getXAxis().getCategories());
		this.setSeries(chartOptions.getSeries());
	}
	
	public ChartData(List<Series> series,List<String> categories){
		this.series=series;
		this.categories=categories;
	}
	
	public ChartData(ChartDefinition chartDef){
		this.series=chartDef.getSeries();
		this.categories=chartDef.getCategories();
	}
	
	public List<Series> getSeries() {
		return series;
	}
	public void setSeries(List<Series> series) {
		this.series = series;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> columns) {
		this.categories = columns;
	}
	public URI getDataURI() {
		return dataURI;
	}
	public void setDataURI(URI dataURI) {
		this.dataURI = dataURI;
	}
	
}
