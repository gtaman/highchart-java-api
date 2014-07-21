package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.axis.*;
import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.format.DateTimeLabelFormats;
import nl.pvanassen.highchart.api.utils.*;

@XmlAccessorType( XmlAccessType.NONE )
public class Axis extends BaseObject {

    @XmlElement
    private Integer                  maxZoom;

    @XmlElement
    private Boolean                  startOnTick;

    @XmlElement
    private Double                   tickInterval;

    @XmlElement
    private Boolean                  showFirstLabel;

    @XmlElement
    private Double                   min;

    @XmlElement
    private Double                   max;

    @XmlElement
    private String                   type;

    @XmlElement( type = AxisLabels.class )
    private AxisLabels               labels;

    private DateTimeLabelFormats     dateTimeLabelFormats;

    @XmlTransient
    private ArrayString              categories;

    private JsonArray<AxisPlotLines> plotLines;

    private Title                    title;

    public Axis() {
        labels = null;
        dateTimeLabelFormats = null;
        categories = null;
        title = null;
    }

    @XmlTransient
    public ArrayString getCategories() {
        if ( categories == null ) {
            categories = new ArrayString();
        }
        return categories;
    }

    public int getCategoriesLength() {
        return ( categories != null ) ? categories.size() : 0;
    }

    public DateTimeLabelFormats getDateTimeLabelFormats() {
        if ( dateTimeLabelFormats == null ) {
            dateTimeLabelFormats = new DateTimeLabelFormats();
        }
        return dateTimeLabelFormats;
    }

    public AxisLabels getLabels() {
        if ( labels == null ) {
            labels = new AxisLabels();
        }
        return labels;
    }

    public double getMax() {
        return max;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public double getMin() {
        return min;
    }

    public JsonArray<AxisPlotLines> getPlotLines() {
        return plotLines;
    }

    public double getTickInterval() {
        return tickInterval;
    }

    public Title getTitle() {
        if ( title == null ) {
            title = new Title();
        }
        return title;
    }

    public String getType() {
        return type;
    }

    public boolean isShowFirstLabel() {
        return showFirstLabel;
    }

    public boolean isStartOnTick() {
        return startOnTick;
    }

    public Axis setMax( double max ) {
        this.max = max;
        return this;
    }

    public Axis setMaxZoom( int maxZoom ) {
        this.maxZoom = maxZoom;
        return this;
    }

    public Axis setMin( double min ) {
        this.min = min;
        return this;
    }

    public Axis setPlotLines( JsonArray<AxisPlotLines> plotLines ) {
        this.plotLines = plotLines;
        return this;
    }

    public Axis setShowFirstLabel( boolean showFirstLabel ) {
        this.showFirstLabel = showFirstLabel;
        return this;
    }

    public Axis setStartOnTick( boolean startOnTick ) {
        this.startOnTick = startOnTick;
        return this;
    }

    public Axis setTickInterval( double tickInterval ) {
        this.tickInterval = tickInterval;
        return this;
    }

    public Axis setType( String type ) {
        this.type = type;
        return this;
    }

	public Boolean getStartOnTick() {
		return startOnTick;
	}

	public void setStartOnTick(Boolean startOnTick) {
		this.startOnTick = startOnTick;
	}

	public Boolean getShowFirstLabel() {
		return showFirstLabel;
	}

	public void setShowFirstLabel(Boolean showFirstLabel) {
		this.showFirstLabel = showFirstLabel;
	}

	public void setMaxZoom(Integer maxZoom) {
		this.maxZoom = maxZoom;
	}

	public void setTickInterval(Double tickInterval) {
		this.tickInterval = tickInterval;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public void setLabels(AxisLabels labels) {
		this.labels = labels;
	}

	public void setDateTimeLabelFormats(DateTimeLabelFormats dateTimeLabelFormats) {
		this.dateTimeLabelFormats = dateTimeLabelFormats;
	}

	public void setCategories(ArrayString categories) {
		this.categories = categories;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

}
