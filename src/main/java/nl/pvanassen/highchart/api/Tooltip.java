package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.BaseObject;

@XmlAccessorType( XmlAccessType.NONE )
public class Tooltip extends BaseObject {

    @XmlElement
    private Boolean crosshairs;

    @XmlElement
    private Boolean shared;
    
    @XmlElement
    private String pointFormat;

    public boolean isCrosshairs() {
        return crosshairs;
    }

    public boolean isShared() {
        return shared;
    }

    public Tooltip setCrosshairs( boolean b ) {
        crosshairs = b;
        return this;
    }

    public Tooltip setShared( boolean shared ) {
        this.shared = shared;
        return this;
    }

	public String getPointFormat() {
		return pointFormat;
	}

	public void setPointFormat(String pointFormat) {
		this.pointFormat = pointFormat;
	}

}
