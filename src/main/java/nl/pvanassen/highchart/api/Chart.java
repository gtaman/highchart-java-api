package nl.pvanassen.highchart.api;

import nl.pvanassen.highchart.api.base.BaseObject;
import nl.pvanassen.highchart.api.shared.SeriesType;

public class Chart extends BaseObject {
    private String  zoomType;

    private String  backgroundColor;
    
    private String renderTo;

    private Integer marginRight;

    private Integer marginBottom;

    private Integer width;

    private Integer height;

    private String  defaultSeriesType;

    private int     marginLeft;

    private int     marginTop;
    
    private Options3d options3d;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getDefaultSeriesType() {
        return defaultSeriesType;
    }

    public int getHeight() {
        return height;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getWidth() {
        return width;
    }

    public String getZoomType() {
        return zoomType;
    }

    public Chart setBackgroundColor( String backgroundColor ) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Chart setDefaultSeriesType( SeriesType type ) {
        defaultSeriesType = type.name().toLowerCase();
        return this;
    }

    public Chart setHeight( int height ) {
        this.height = height;
        return this;
    }

    public Chart setMarginBottom( int marginBottom ) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Chart setMarginLeft( int marginLeft ) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Chart setMarginRight( int marginRight ) {
        this.marginRight = marginRight;
        return this;
    }

    public Chart setMarginTop( int marginTop ) {
        this.marginTop = marginTop;
        return this;
    }

    public Chart setWidth( int width ) {
        this.width = width;
        return this;
    }

    public Chart setZoomType( String zoomType ) {
        this.zoomType = zoomType;
        return this;
    }

	public String getRenderTo() {
		return renderTo;
	}

	public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}

	public void setMarginRight(Integer marginRight) {
		this.marginRight = marginRight;
	}

	public void setMarginBottom(Integer marginBottom) {
		this.marginBottom = marginBottom;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setDefaultSeriesType(String defaultSeriesType) {
		this.defaultSeriesType = defaultSeriesType;
	}

	public Options3d getOptions3d() {
		return options3d;
	}

	public void setOptions3d(Options3d options3d) {
		this.options3d = options3d;
	}

}
