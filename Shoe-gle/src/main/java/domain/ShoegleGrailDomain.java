package domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShoegleGrailDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long grailID;
	
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
	private int RetailPrice;
	
	@Column(nullable = false)
	private int AftermarketPrice;
	
	//Default constructor
	public ShoegleGrailDomain() {}
	
	// Constructor with No ID
	public ShoegleGrailDomain(String Brand,String Sillouhette,String Colourway,int Size,boolean collab, int RetailPrice, int AftermarketPrice ) {
		this.Brand = Brand;
		this.Sillouhette = Sillouhette;
		this.Colourway = Colourway;
		this.Size = Size;
		this.collab = collab;
		this.RetailPrice = RetailPrice;
		this.AftermarketPrice = AftermarketPrice;
	}
	
	// Constructor with No ID
		public ShoegleGrailDomain(Long grailID,String Brand,String Sillouhette,String Colourway,int Size,boolean collab, int RetailPrice, int AftermarketPrice ) {
			this.grailID = grailID;
			this.Brand = Brand;
			this.Sillouhette = Sillouhette;
			this.Colourway = Colourway;
			this.Size = Size;
			this.collab = collab;
			this.RetailPrice = RetailPrice;
			this.AftermarketPrice = AftermarketPrice;
		}

		public long getGrailID() {
			return grailID;
		}

		public void setGrailID(long shoeID) {
			this.grailID = shoeID;
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

		public int getRetailPrice() {
			return RetailPrice;
		}

		public void setRetailPrice(int retailPrice) {
			RetailPrice = retailPrice;
		}

		public int getAftermarketPrice() {
			return AftermarketPrice;
		}

		public void setAftermarketPrice(int aftermarketPrice) {
			AftermarketPrice = aftermarketPrice;
		}

		@Override
		public int hashCode() {
			return Objects.hash(AftermarketPrice, Brand, Colourway, RetailPrice, Sillouhette, Size, collab, grailID);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ShoegleGrailDomain other = (ShoegleGrailDomain) obj;
			return AftermarketPrice == other.AftermarketPrice && Objects.equals(Brand, other.Brand)
					&& Objects.equals(Colourway, other.Colourway) && RetailPrice == other.RetailPrice
					&& Objects.equals(Sillouhette, other.Sillouhette) && Size == other.Size && collab == other.collab
					&& grailID == other.grailID;
		}

		
}
