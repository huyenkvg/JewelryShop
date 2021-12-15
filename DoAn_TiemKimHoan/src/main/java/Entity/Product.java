package Entity;

public class Product {
	private int id;
	private String name;
	private int idCaterogy;
	private String description;
	private String image;
	private int size;
	private double price;
	private int quantity;
	public Product() {
		
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
	public int getIdCaterogy() {
		return idCaterogy;
	}
	public void setIdCaterogy(int idCaterogy) {
		this.idCaterogy = idCaterogy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(int id, String name, int idCaterogy, String description, String image, int size, double price,
			int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.idCaterogy = idCaterogy;
		this.description = description;
		this.image = image;
		this.size = size;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
	public Product(int id, String name, int idCaterogy, String description, String image, double price
			) {
		super();
		this.id = id;
		this.name = name;
		this.idCaterogy = idCaterogy;
		this.description = description;
		this.image = image;
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", idCaterogy=" + idCaterogy + ", description=" + description
				+ ", image=" + image + ", size=" + size + ", price=" + price + ", quantity=" + quantity
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
}
