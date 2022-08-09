package electricitybillpaymentsystem.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reading")
public class Reading {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long readingId;
	private int unitsConsumed;
	private String readingPhoto;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate readingDate;
	private int pricePerUnits;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_fk",referencedColumnName = "billId")
	private Bill bill;
	
	public Reading() {
		super();
	}

	public Reading(Long readingId, int unitsConsumed, String readingPhoto, LocalDate readingDate, int pricePerUnits) {
		super();
		this.readingId = readingId;
		this.unitsConsumed = unitsConsumed;
		this.readingPhoto = readingPhoto;
		this.readingDate = readingDate;
		this.pricePerUnits = pricePerUnits;
	}

	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitConsumed) {
		this.unitsConsumed = unitConsumed;
	}

	public String getReadingPhoto() {
		return readingPhoto;
	}

	public void setReadingPhoto(String readingPhoto) {
		this.readingPhoto = readingPhoto;
	}

	public LocalDate getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(LocalDate readingDate) {
		this.readingDate = readingDate;
	}

	public int getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(int pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}
	
	
}
