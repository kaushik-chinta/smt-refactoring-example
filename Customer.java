import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental aRental) {
        rentals.add(aRental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "\nRental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getMovie().getCharge(rental.getDaysRented())) + "\n";
        }

        // Add footer line
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points\n";
        return result;
    }

    public String htmlStatement() {
		String result = "\n<h1>Rental Record for " + getName() + "</h1>\n";
		result += "<table>\n";

		for (Rental rental : rentals) {
			result += "\t<tr><td>" + rental.getMovie().getTitle() + "</td><td>" +
			String.valueOf(rental.getMovie().getCharge(rental.getDaysRented())) + "</td></tr>\n";
		}
        result += "</table>\n";

        // Add footer line
        result += "<p>Amount owed is <b>" + String.valueOf(getTotalCharge()) + "</b></p>\n";
        result += "<p>You earned <b>" + String.valueOf(getTotalFrequentRenterPoints()) +
                  "</b> frequent renter points</p>\n";
        return result;
	}

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getMovie().getCharge(rental.getDaysRented());
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());
        }
        return result;
    }
}
