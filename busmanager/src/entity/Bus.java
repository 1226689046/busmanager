package entity;


/**
 * 
 * @author WangShirong
 * 
 */


public class Bus {
	private String id;
	private String type;
	private int engin_number;
	private int seating_capacity;
	private int route;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEngin_number() {
		return engin_number;
	}

	public void setEngin_number(int engin_number) {
		this.engin_number = engin_number;
	}

	public int getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(int seating_capacity) {
		this.seating_capacity = seating_capacity;
	}

	public int getRoute() {
		return route;
	}

	public void setRoute(int route) {
		this.route = route;
	}

	public Bus(String id, String type, int engin_number, int seating_capacity, int route) {
		super();
		this.id = id;
		this.type = type;
		this.engin_number = engin_number;
		this.seating_capacity = seating_capacity;
		this.route = route;
	}

	public Bus() {
	}

	@Override
	public String toString() {
		return "TYPE:" + type + "\nengin_number:" + engin_number + "\nseating_capactivy:" + seating_capacity
				+ "\nroute:" + route + "\n";
	}

}
