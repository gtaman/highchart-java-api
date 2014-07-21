package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.*;

@XmlAccessorType( XmlAccessType.NONE )
public class Title extends BaseObject {

    @XmlElement
    private String  text;

    private Style   style;

    @XmlElement
    private Integer margin;
    
    public Title(String title){
    	this.text=title;
    }

    public Title() {
        style = null;
        text = "";
    }

    public int getMargin() {
        return margin;
    }

    public Style getStyle() {
        if ( style == null ) {
            style = new Style();
        }
        return style;
    }

    public String getText() {
        return text;
    }

    public Title setMargin( int margin ) {
        this.margin = margin;
        return this;
    }

    public Title setText( String text ) {
        this.text = text;
        return this;
    }

}
