package PD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The current and future tax rates
 */
public class TaxRate implements Comparable<TaxRate>{

	/**
	 * The tax rate
	 */
	private BigDecimal taxRate;
	/**
	 * When the rate is effective
	 */
	private LocalDate effectiveDate;

	/**
	 * The constructor
	 */
	public TaxRate() {
		this.taxRate = new BigDecimal(0);
		this.effectiveDate = LocalDate.now();
		this.taxRate.setScale(2, RoundingMode.HALF_UP);
		
	}

	/**
	 * The constructor
	 * @param effectiveDate - Date the rate becomes effective
	 * @param rate - Given tax rate
	 */
	public TaxRate(String effectiveDate, String rate) {
		this.taxRate = BigDecimal.valueOf(Double.parseDouble(rate));
		this.taxRate.setScale(2, RoundingMode.HALF_UP);
		this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yy"));
	}

	/**
	 * When its effective
	 * @param date
	 * @return True if effective. False if not
	 */
	public boolean isEffective(LocalDate date) {
		if (this.effectiveDate.isBefore(date.plusDays(1)))
			return true;
		else
			return false;
	}

	/**
	 * Compares to another tax rate
	 * @param taxRate
	 * @return The result of the comparison
	 */
	public int compareTo(TaxRate taxRate) {
		return this.taxRate.compareTo(taxRate.getTaxRate());
	}

	/**
	 * Converts to a string
	 * @return The rate and effective date
	 */
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
		return "Rate: " + taxRate.toString() + " Effective:" + effectiveDate.format(formatter); 
	}

	public BigDecimal getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	
	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}
	
	public void setEffectiveDate(String date) {
		this.effectiveDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yy"));
	}

}