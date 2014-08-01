package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.utils.JsonArray;

@XmlRootElement( name = "chartOptions" )
@XmlAccessorType( XmlAccessType.NONE )
public class ChartOptions extends BaseObject {

    @XmlTransient
    private Chart             chart;

    @XmlElement
    private Credits           credits;

    @XmlElement
    private Labels            labels;

    @XmlElement
    private Legend            legend;

    @XmlElement
    private PlotOptions       plotOptions;

    // @XmlTransient
    @XmlElements( @XmlElement( name = "series", type = Series.class ) )
    private JsonArray<Series> series;

    @XmlElement
    private Title             title;

    @XmlElement
    private Title             subtitle;

    @XmlElement
    private Tooltip           tooltip;

    @XmlElement
    private Axis              xAxis;

    @XmlElement
    private Axis              yAxis;
    
    public ChartOptions(){};
    
    //Set up defaults, and set chart options from a definition
    public ChartOptions(ChartDefinition chartDef){
    	if(chartDef!=null){
    		//By default it will look for a div named chartdiv
        	this.getChart().setRenderTo("chartdiv");
        	//Set chartType
        	if(chartDef.getChartType().getSeriesType()!=null){
        		this.getChart().setDefaultSeriesType(chartDef.getChartType().getSeriesType());
        	}
        	//Set plotOptions
        	this.setPlotOptions(chartDef.getChartType().getPlotOptions());
        	//Set up titles
        	this.getTitle().setText(chartDef.getTitle());
        	this.getSubtitle().setText(chartDef.getSubtitle());
        	
        	if(chartDef.getChartType()!=ChartType.pie){//These options don't apply to pie
    	    	this.getXAxis().setTitle(new Title(chartDef.getxAxisTitle()));
    	    	this.getYAxis().setTitle(new Title(chartDef.getyAxisTitle()));
    	    	this.getYAxis().getLabels().setEnabled(true);
    	    	this.getXAxis().getLabels().setEnabled(true);
    	    	//Set so it doesn't cut off incomplete data - may not want this
    	    	this.getXAxis().setMax(chartDef.getCategories().size()-1);
    	    	this.getChart().setMarginLeft(110);
    	    	this.getChart().setMarginRight(20);
    	    	this.getChart().setMarginTop(75);
    	    	this.getChart().setMarginBottom(75);
    	    	
    	    	if(chartDef.isCurrency()){
    	    		this.getTooltip().setPointFormat("${point.y:.2f}");
    	    		this.getYAxis().getLabels().setFormat("${value}");
    	    	}
        	}
        	else{//Pie chart
        		this.getChart().setMarginTop(50);
        		this.getTooltip().setValueSuffix("%");
        		this.getTooltip().setShared(true);
        		if(chartDef.isIs3d()){
        			this.getPlotOptions().getPie().setDepth(35);
        		}
        	}
        	
        	if(chartDef.isIs3d()){
        		Options3d options3d = new Options3d();
        		options3d.setEnabled(true);
        		options3d.setAlpha(15);
        		options3d.setBeta(15);
        		options3d.setDepth(50);
        		options3d.setViewDistance(25);
        		if(chartDef.getChartType()==ChartType.pie){
        			options3d.setAlpha(45);
        			options3d.setBeta(0);
        		}
        		this.getChart().setOptions3d(options3d);
        		this.getChart().setMarginRight(50);
        	}
        	
        	//Set up categories
        	for(String category : chartDef.getCategories()){
        		this.getXAxis().getCategories().add(category);
        	}
        	
        	//Set up series
        	for(Series series : chartDef.getSeries()){
        		this.getSeries().pushElement(series);
        	}
    	}
    }
    
	public void addSeries(String name, double[] data ) {
        this.getSeries().pushElement( new Series(name, data) );
    }

    public Chart getChart() {
        if ( chart == null ) {
            chart = new Chart();
        }
        return chart;
    }

    public Credits getCredits() {
        if ( credits == null ) {
            credits = new Credits();
        }
        return credits;
    }

    public Labels getLabels() {
        if ( labels == null ) {
            labels = new Labels();
        }
        return labels;
    }

    public Legend getLegend() {
        if ( legend == null ) {
            legend = new Legend();
        }
        return legend;
    }

    public PlotOptions getPlotOptions() {
        if ( plotOptions == null ) {
            plotOptions = new PlotOptions();
        }
        return plotOptions;
    }

    @XmlTransient
    public JsonArray<Series> getSeries() {
        if ( series == null ) {
            series = new JsonArray<Series>();
        }
        return series;
    }

    public Title getSubtitle() {
        if ( subtitle == null ) {
            subtitle = new Title();
        }
        return subtitle;
    }

    public Title getTitle() {
        if ( title == null ) {
            title = new Title();
        }
        return title;
    }

    public Tooltip getTooltip() {
        if ( tooltip == null ) {
            tooltip = new Tooltip();
        }
        return tooltip;
    }

    public Axis getXAxis() {
        if ( xAxis == null ) {
            xAxis = new Axis();
        }
        return xAxis;
    }

    public Axis getYAxis() {
        if ( yAxis == null ) {
            yAxis = new Axis();
        }
        return yAxis;
    }

	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}

}
