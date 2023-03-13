package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest { 
	@Test
	public void getMilliseconds() 
	{
		int milliseconds = 	Time.getMilliseconds("05:05:05:005");
		assertTrue("The Milliseconds were not calculated properly", milliseconds==005);
	}
	@Test
	public void testgetTotalMilliseconds() 
	{
		int milliseconds = 	Time.getTotalMilliseconds("05:05:05:005");
		assertTrue("The Milliseconds were not calculated properly", milliseconds==18305005);
	}

	@Test
	public void testGetTotalSecondsGood() 
	{
		int seconds = 	Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	
	
	@Test
	public void testGetTotalSecondsBad() 
	{
		assertThrows(
	 	StringIndexOutOfBoundsException.class, 
	 	()-> {Time.getTotalSeconds("00:00:00");});
	}



	@Test
	void testGetSecondsGood() {
		int seconds = 	Time.getSeconds("05:05:05");
		assertTrue("The seconds were not calculated 	properly", seconds==5);
	}
	@Test
	void testGetSecondsBad() {
		assertThrows( 
			 	StringIndexOutOfBoundsException.class, 
			 	()-> {Time.getSeconds("00:00:00");});
	}

	@Test
	void testGetTotalMinutesGood() {
		int minutes = 	Time.getTotalMinutes("05:10:00");
		assertTrue("The minutess were not calculated 	properly", minutes==10);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
			 	StringIndexOutOfBoundsException.class, 
			 	()-> {Time.getTotalMinutes("10.00");});
	}

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	 void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", 	hours ==5);
	}


}
