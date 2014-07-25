package nl.pvanassen.highchart.api;

import javax.xml.bind.annotation.*;

@XmlRootElement//(name="options3d")
public class Options3d {
	@XmlElement
	private boolean enabled;
	
	@XmlElement
	private Integer alpha;
	
	@XmlElement
	private Integer beta;
	
	@XmlElement
	private Integer depth;
	
	@XmlElement
	private Integer viewDistance;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Integer getAlpha() {
		return alpha;
	}
	public void setAlpha(Integer alpha) {
		this.alpha = alpha;
	}
	public Integer getBeta() {
		return beta;
	}
	public void setBeta(Integer beta) {
		this.beta = beta;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public Integer getViewDistance() {
		return viewDistance;
	}
	public void setViewDistance(Integer viewDistance) {
		this.viewDistance = viewDistance;
	}
}
