import org.junit.*;

public class CustomerTest {

    Customer customer1;
    Customer customer2;
    Movie movie1;
    Movie movie2;
    Movie movie3;
    Movie movie4;

    @Before
    public void setUp() {
        movie1 = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
        movie2 = new Movie("Star Trek 27                   ", Movie.NEW_RELEASE);
        movie3 = new Movie("Star Wars                      ", Movie.REGULAR);
        movie4 = new Movie("Shrek                          ", Movie.CHILDRENS);
        customer1 = new Customer("Donald Duck");
        customer1.addRental(new Rental(movie1, 3));
        customer1.addRental(new Rental(movie2, 3));
        customer1.addRental(new Rental(movie3, 4));
        customer1.addRental(new Rental(movie4, 6));
        customer2 = new Customer("Mickey Mouse");
        customer2.addRental(new Rental(movie1, 1));
        customer2.addRental(new Rental(movie2, 4));
        customer2.addRental(new Rental(movie3, 2));
    }

    @Test
    public void testStatementForCustomer1() {
        String expected =
            "\nRental Record for Donald Duck\n" +
            "	Monty Python and the Holy Grail	3.5\n" +
            "	Star Trek 27                   	9.0\n" +
            "	Star Wars                      	5.0\n" +
            "	Shrek                          	6.0\n" +
            "Amount owed is 23.5\n" +
            "You earned 5 frequent renter points\n";
        String actual = customer1.statement();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testStatementForCustomer2() {
        String expected =
            "\nRental Record for Mickey Mouse\n" +
            "	Monty Python and the Holy Grail	2.0\n" +
            "	Star Trek 27                   	12.0\n" +
            "	Star Wars                      	2.0\n" +
            "Amount owed is 16.0\n" +
            "You earned 4 frequent renter points\n";
        String actual = customer2.statement();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHtmlStatementForCustomer1() {
        String expected =
            "\n<h1>Rental Record for Donald Duck</h1>\n" +
            "<table>\n" +
            "\t<tr><td>Monty Python and the Holy Grail</td><td>3.5</td></tr>\n" +
            "\t<tr><td>Star Trek 27                   </td><td>9.0</td></tr>\n" +
            "\t<tr><td>Star Wars                      </td><td>5.0</td></tr>\n" +
            "\t<tr><td>Shrek                          </td><td>6.0</td></tr>\n" +
            "</table>\n" +
            "<p>Amount owed is <b>23.5</b></p>\n" +
            "<p>You earned <b>5</b> frequent renter points</p>\n";
        String actual = customer1.htmlStatement();
        Assert.assertEquals(expected, actual);
    }
}
