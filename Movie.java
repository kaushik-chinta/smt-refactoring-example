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
        double result = 0;
        switch (getPriceCode()) {
        case Movie.REGULAR:
            result += 2;
            if (daysRented > 2) {
                result += (daysRented - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            result += daysRented * 3;
            break;
        case Movie.CHILDRENS:
            result += 1.5;
            if (daysRented > 3) {
                result += (daysRented - 3) * 1.5;
            }
            break;
        }
        
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2 ;
        }

        return 1;
    }
}