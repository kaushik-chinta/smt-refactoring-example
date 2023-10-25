public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private PriceCalculator calculator;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return calculator.getPriceCode();
    }

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case CHILDRENS:
			calculator = new ChildrenPriceCalculator();
			break;
		case REGULAR:
			calculator = new RegularPriceCalculator();
			break;
		case NEW_RELEASE:
			calculator = new NewReleasePriceCalculator();
			break;
		}
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return calculator.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2 ;
        }

        return 1;
    }
}