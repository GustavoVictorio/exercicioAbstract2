package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {

		double anualIncome = getAnualIncome();
		if (anualIncome < 20000.0) {
			anualIncome = (anualIncome * 0.15) - (getHealthExpenditures() * 0.50);
		} else {
			anualIncome = (anualIncome * 0.25) - (getHealthExpenditures() * 0.50);
		}
		return anualIncome;
	}

	public String toString() {
		return getName() + ": $ " + String.format("%.2f", tax());
	}

}
