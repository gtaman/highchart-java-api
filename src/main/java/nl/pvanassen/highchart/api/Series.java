package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.plotoption.PlotMarkerStates;
import nl.pvanassen.highchart.api.serie.SeriesCenter;
import nl.pvanassen.highchart.api.utils.JsonArray;

@XmlAccessorType( XmlAccessType.NONE )
@XmlType( namespace = "chartoptions" )
public class Series extends BaseObject {

    @XmlElement( type = PlotMarkerStates.class )
    private PlotMarkerStates states;

    @XmlElements( @XmlElement( name = "data", type = Point.class ) )
    private Object           data;

    @XmlElement
    private String           color;

    @XmlElement
    private String           name;

    @XmlElement
    private String           type;

    @XmlElement
    private String           size;

    private SeriesCenter     center;
    
    public Series(){};
    
    public Series(String name, String type, double[] data){
    	this(name, data);
    	this.type=type;
    }
    
    public Series(String name, double[] data){
    	this.name=name;
    	this.data=new JsonArray<Point>();
        pushData(data);
    }
    
    private void pushData(double[] data){
    	for ( double d : data ) {
            this.getData().pushElement( new Point().setY( d ) );
        }
    }

    public String getCenterX() {
        return ( center != null ) ? center.getX() : null;
    }

    public String getCenterY() {
        return ( center != null ) ? center.getY() : null;
    }

    public String getColor() {
        return color;
    }

    @SuppressWarnings( "unchecked" )
    public JsonArray<Point> getData() {
        if ( data == null ) {
            data = new JsonArray<Point>();
        }
        return ( JsonArray<Point> ) data;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public PlotMarkerStates getStates() {
        if ( states == null ) {
            states = new PlotMarkerStates();
        }
        return states;
    }

    public String getType() {
        return type;
    }

    public Series setCenter( String x, String y ) {
        if ( center == null ) {
            center = new SeriesCenter();
        }
        center.setX( x );
        center.setY( y );
        return this;
    }

    public Series setColor( String color ) {
        this.color = color;
        return this;
    }

    @XmlTransient
    public Series setData( JsonArray<Point> data ) {
        this.data = data;
        return this;
    }

    public Series setName( String name ) {
        this.name = name;
        return this;
    }

    public Series setSize( String size ) {
        this.size = size;
        return this;
    }

    public Series setStates( PlotMarkerStates states ) {
        this.states = states;
        return this;
    }

    public Series setType( String type ) {
        this.type = type;
        return this;
    }
}
