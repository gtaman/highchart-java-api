package nl.pvanassen.highchart.api.axis;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.BaseObject;

@XmlAccessorType( XmlAccessType.NONE )
@XmlType( namespace = "axis" )
public class AxisLabels extends BaseObject {

    @XmlElement
    private Double rotation;

    @XmlElement
    private String align;
    
    @XmlElement
    private boolean enabled;
    
    @XmlElement
    private String format;
    
    @XmlElement
    private String formatter;

    public String getAlign() {
        return align;
    }

    public Double getRotation() {
        return rotation;
    }

    public AxisLabels setAlign( String align ) {
        this.align = align;
        return this;
    }

    public AxisLabels setRotation( double rotation ) {
        this.rotation = rotation;
        return this;
    }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setRotation(Double rotation) {
		this.rotation = rotation;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

}