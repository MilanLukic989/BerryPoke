public class Berry {
	private int id;
	private String name;
	private String url;
	private int growthTime;
	private int size;
	private double growthPerHour;
	
	
//	public Berry(String name, String url) {
//		this.name = name;
//		this.url = url;
//	}

	public Berry(int id, String name, String url, int growthTime, int size) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.growthTime = growthTime;
		this.size = size;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getGrowthTime() {
		return growthTime;
	}
	public void setGrowthTime(int growthTime) {
		this.growthTime = growthTime;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public double getGrowthPerHour() {
		return growthPerHour;
	}

	public void setGrowthPerHour(double growthPerHour) {
		this.growthPerHour = growthPerHour;
	}

	@Override
	public String toString() {
		return "Id: " +  this.getId() +"\t" 
				+ "Name: " + this.getName() + "\t" 
				+ "Growth time: " + this.getGrowthTime() + "\t" 
				+ "Size: " +  this.getSize() + "\t" 
				+ "Growth per hour: " + this.getGrowthPerHour();
	}
	
}