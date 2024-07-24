	package CommonLibs.Implementation;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utilities {
	public static PropertiesConfiguration config = null;

	public static String getProperty(String key) throws IOException {
		FileReader reader = new FileReader(".\\src\\main\\resources\\Config.properties");
		Properties props = new Properties();
		props.load(reader);
		return props.getProperty(key);
	}
	
	public static void setConfigProperty(String key, String value) {
		try {
			config = new PropertiesConfiguration(".\\src\\main\\resources\\Config.properties");
			config.setProperty(key, value);
			config.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static String getAdjustedData(String format, int unit, int count) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date currentDate = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(unit, count);

		Date currentDatesOne = c.getTime();
		return sdf.format(currentDatesOne);
	}

	public List<String> dateAdded(String count) {
		String year = getAdjustedData("YYYY", Calendar.DAY_OF_MONTH, Integer.parseInt(count));
		String month = getAdjustedData("MM", Calendar.DAY_OF_MONTH, Integer.parseInt(count));
		String date = getAdjustedData("DD", Calendar.DAY_OF_MONTH, Integer.parseInt(count));

		String Month = month;
		switch (Month) {
		case "01":
			Month = "January";
			break;

		case "February":
			Month = "02";
			break;

		case "03":
			Month = "March";
			break;

		case "04":
			Month = "April";
			break;

		case "05":
			Month = "May";
			break;

		case "06":
			Month = "June";
			break;

		case "07":
			Month = "July";
			break;

		case "08":
			Month = "August";
			break;

		case "09":
			Month = "September";
			break;

		case "10":
			Month = "October";
			break;

		case "11":
			Month = "November";
			break;

		case "12":
			Month = "December";
			break;

		}

		List<String> givenDateList = new ArrayList<String>();

		givenDateList.add(year);
		givenDateList.add(Month);
		givenDateList.add(date);

		return givenDateList;
	
	
		/*
		 * ******************* NEED TO RUN IN MAIN TEST CLASS TO SELECT DATE USE THIS FORMAT ***************
		 * 
		 * public void testData() {
		 * 
		 * click(on calendar icon);
		 * 
		 * List<String> dateSelected = dateAdded("-2");
		 * 
		 * String YEAR= dateSelected.get(0); // year String 
		 * MONTH =dateSelected.get(1);       // month String
		 * Month String DATE = dateSelected.get(2); // date string
		 * 
		 * selectByName(element, YEAR); 
		 * selectByName(element, Month); 
		 * ClickAction(date);
		 */
	
	}

}