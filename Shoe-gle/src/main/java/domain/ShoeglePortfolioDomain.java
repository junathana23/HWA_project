package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoeglePortfolioDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long shoeID;
	
	@Column(nullable = false)
	private String Brand;
	
	@Column(nullable = false)
	private String Sillouhette;

	@Column(nullable = false)
	private String Colourway;
	
	@Column(nullable = false)
	private int Size;
	
	@Column()
	private boolean collab;
	
	@Column(nullable = false)
	private double RetailPrice;
	
	@Column(nullable = false)
	private double AftermarketPrice;
	
	//Default constructor
	public ShoeglePortfolioDomain() {}
	
	// Constructor with No ID
	public ShoeglePortfolioDomain(String Brand,String Sillouhette,String Colourway,int Size,boolean collab, int RetailPrice, int AftermarketPrice ) {
		this.Brand = Brand;
		this.Sillouhette = Sillouhette;
		this.Colourway = Colourway;
		this.Size = Size;
		this.collab = collab;
		this.RetailPrice = RetailPrice;
		this.AftermarketPrice = AftermarketPrice;
	}
	
	// Constructor with No ID
		public ShoeglePortfolioDomain(Long shoeID,String Brand,String Sillouhette,String Colourway,int Size,boolean collab, int RetailPrice, int AftermarketPrice ) {
			this.shoeID = shoeID;
			this.Brand = Brand;
			this.Sillouhette = Sillouhette;
			this.Colourway = Colourway;
			this.Size = Size;
			this.collab = collab;
			this.RetailPrice = RetailPrice;
			this.AftermarketPrice = AftermarketPrice;
		}

		public long getShoeID() {
			return shoeID;
		}

		public void setShoeID(long shoeID) {
			this.shoeID = shoeID;
		}

		public String getBrand() {
			return Brand;
		}

		public void setBrand(String brand) {
			Brand = brand;
		}

		public String getSillouhette() {
			return Sillouhette;
		}

		public void setSillouhette(String sillouhette) {
			Sillouhette = sillouhette;
		}

		public String getColourway() {
			return Colourway;
		}

		public void setColourway(String colourway) {
			Colourway = colourway;
		}

		public int getSize() {
			return Size;
		}

		public void setSize(int size) {
			Size = size;
		}

		public boolean isCollab() {
			return collab;
		}

		public void setCollab(boolean collab) {
			this.collab = collab;
		}

		public double getRetailPrice() {
			return RetailPrice;
		}

		public void setRetailPrice(double d) {
			RetailPrice = d;
		}

		public double getAftermarketPrice() {
			return AftermarketPrice;
		}

		public void setAftermarketPrice(double d) {
			AftermarketPrice = d;
		}

		@Override
		public int hashCode() {
			return Objects.hash(AftermarketPrice, Brand, Colourway, RetailPrice, Sillouhette, Size, collab, shoeID);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ShoeglePortfolioDomain other = (ShoeglePortfolioDomain) obj;
			return AftermarketPrice == other.AftermarketPrice && Objects.equals(Brand, other.Brand)
					&& Objects.equals(Colourway, other.Colourway) && RetailPrice == other.RetailPrice
					&& Objects.equals(Sillouhette, other.Sillouhette) && Size == other.Size && collab == other.collab
					&& shoeID == other.shoeID;
		}
		
		
	
}
