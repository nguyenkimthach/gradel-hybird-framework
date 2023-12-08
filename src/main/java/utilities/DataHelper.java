package utilities;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstname() {
		return faker.address().firstName();
	}

	public String getLastname() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}

	public String getCityName() {
		return faker.address().cityName();
	}

	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getState() {
		return faker.address().state();
	}

	public String getZipCode() {
		return faker.address().zipCodeByState(faker.address().state());
	}

	public String getZipCodeByState() {
		return faker.address().zipCode();
	}

	public String getCapital() {
		return faker.country().capital();
	}

	public String getCompanyName() {
		return faker.company().name();
	}

	public String getCreditCardNumber() {
		return faker.business().creditCardNumber();
	}

	public String getBirthDay() {
		return new SimpleDateFormat("MM/dd/yyyy").format(faker.date().birthday());
	}
}
