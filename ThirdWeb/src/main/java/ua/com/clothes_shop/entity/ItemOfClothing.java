package ua.com.clothes_shop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

//@NamedQueries({
//	@NamedQuery(name = "findQuantity", query = "select i from ItemOfClothing i where i.quantity =:paramQuantity"),
//	@NamedQuery(name = "findMarking", query = "select i from ItemOfClothing i where i.marking =:paramMarking")
//})


//Означає що це сутність БД
@Entity
//для того щоб таблиці мали назву як і в БД
@Table(name="item_of_clothing")

public class ItemOfClothing {
	
	//Первинний ключ
		@Id
		//AUTO_INCTEMENT
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		//для того щоб стовпці мали назву як і в БД
		@Column(name="_name")
		private String name;
		
		@Column(name="marking")
		private int marking;
		
		@Column(name="price")
		private BigDecimal price;
		
		@Column(name="quantity")
		private int quantity;
		
		@ManyToOne
		private TargetAudience targetAudience;
		
		@ManyToOne
		private TypeOfClothing typeOfClothing;
		
		@ManyToOne
		private Brand brand;
		
		@ManyToMany
		@JoinTable(name="item_color_connection",
		joinColumns=@JoinColumn(name="id_item_of_clothing"),
		inverseJoinColumns=@JoinColumn(name="id_color"))
		private List<Color> colors = new ArrayList<>();
		
		//написали @BatchSize(size = 20) після того як зробили в сервіс імпл Hibernate.initialize(itemOfClothing.getSizes()); ...
		@BatchSize(size = 20)
		@ManyToMany
		@JoinTable(name="item_size_connection",
		joinColumns=@JoinColumn(name="id_item_of_clothing"),
		inverseJoinColumns=@JoinColumn(name="id_size"))
		private List<Size> sizes = new ArrayList<>();
		
		@ManyToMany
		@JoinTable(name="item_customer_connection",
		joinColumns=@JoinColumn(name="id_item_of_clothing"),
		inverseJoinColumns=@JoinColumn(name="id_customer"))
		private List<Customer> customers = new ArrayList<>();
		
		public ItemOfClothing() {
			// TODO Auto-generated constructor stub
		}

		public ItemOfClothing(String name, int marking, BigDecimal price,int quantity) {
			super();
			this.name = name;
			this.marking = marking;
			this.price = price;
			this.quantity = quantity;
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

		public int getMarking() {
			return marking;
		}

		public void setMarking(int marking) {
			this.marking = marking;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public TargetAudience getTargetAudience() {
			return targetAudience;
		}

		public void setTargetAudience(TargetAudience targetAudience) {
			this.targetAudience = targetAudience;
		}

		public TypeOfClothing getTypeOfClothing() {
			return typeOfClothing;
		}

		public void setTypeOfClothing(TypeOfClothing typeOfClothing) {
			this.typeOfClothing = typeOfClothing;
		}

		public Brand getBrand() {
			return brand;
		}

		public void setBrand(Brand brand) {
			this.brand = brand;
		}

		public List<Color> getColors() {
			return colors;
		}

		public void setColors(List<Color> colors) {
			this.colors = colors;
		}

		public List<Size> getSizes() {
			return sizes;
		}

		public void setSizes(List<Size> sizes) {
			this.sizes = sizes;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}

		//не треба писати toString включаючи лісти в обох класах які зв'язані зв'язком ManyToMany бо буде зациклення!
//		@Override
//		public String toString() {
//			return "ItemOfClothing [id=" + id + ", name=" + name + ", marking="
//					+ marking + ", price=" + price + ", quantity=" + quantity
//					+ ", targetAudience=" + targetAudience
//					+ ", typeOfClothing=" + typeOfClothing + ", brand=" + brand
//					+ ", colors=" + colors + ", sizes=" + sizes
//					+ ", customers=" + customers + "]";
//		}

		@Override
		public String toString() {
			return "ItemOfClothing [id=" + id + ", name=" + name + ", marking="
					+ marking + ", price=" + price + ", quantity=" + quantity
					+ "]";
		}

}
