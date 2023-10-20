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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "\nRental Record for " + getName() + "\n";
        for (Rental rental : rentals) {

            double thisAmount = amountFor(rental);

            // Add frequent renter points
            frequentRenterPoints++;
            // Add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // Show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // Add footer line
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
        return result;
    }

    private double amountFor(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            result += 2;
            if (rental.getDaysRented() > 2) {
                result += (rental.getDaysRented() - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            result += rental.getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            result += 1.5;
            if (rental.getDaysRented() > 3) {
                result += (rental.getDaysRented() - 3) * 1.5;
            }
            break;
        }
        
        return result;
    }
}
