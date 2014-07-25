package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.BaseObject;

@XmlAccessorType( XmlAccessType.NONE )
public class Point extends BaseObject {

    @XmlElement
    private Double x;

    @XmlElement
    private Double y;

    private Boolean selected, sliced;

    private String  color;

    private String  name;

    public Point() {
    }
    
    public Point(String name, Double y){
    	this.name=name;
    	this.y=y;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean getSelected() {
        return selected;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isSliced() {
        return sliced;
    }

    public Point setColor( String color ) {
        this.color = color;
        return this;
    }

    public Point setName( String name ) {
        this.name = name;
        return this;
    }

    public Point setSelected( boolean selected ) {
        this.selected = selected;
        return this;
    }

    public Point setSliced( boolean sliced ) {
        this.sliced = sliced;
        return this;
    }

    public Point setX( double x ) {
        this.x = x;
        return this;
    }

    public Point setY( double y ) {
        this.y = y;
        return this;
    }

}