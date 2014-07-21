package nl.pvanassen.highchart.api.label;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.Style;

@XmlAccessorType( XmlAccessType.NONE )
@XmlType( namespace = "labels" )
public class LabelsItems {

    private String html;

    private Style  style;
    
    private String color;

    public LabelsItems() {
        style = new Style();
    }

    public LabelsItems center( int centerPosition, double top ) {
        getStyle().setProperty( "left", ( centerPosition - ( ( getHtml().length() * 6 ) / 2 ) ) + "px" );
        getStyle().setProperty( "top", top + "px" );
        return this;
    }

    public String getHtml() {
        return html;
    }

    public Style getStyle() {
        return style;
    }

    public LabelsItems setHtml( String html ) {
        this.html = html;
        return this;
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

}