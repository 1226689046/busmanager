package entity;

/**
 * 
 * @author WangShirong
 *
 */
public class Route {
	private String id;
	private String routeDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRouteDesc() {
		return routeDesc;
	}

	public void setRouteDesc(String routeDesc) {
		this.routeDesc = routeDesc;
	}

	public Route() {

	}

	public Route(String id, String routeDesc) {
		this.id = id;
		this.routeDesc = routeDesc;
	}

	@Override
	public String toString() {
		return "routeDesc:" + routeDesc + "\n";
	}
}
