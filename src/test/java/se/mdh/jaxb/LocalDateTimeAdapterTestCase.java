package se.mdh.jaxb;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeAdapterTestCase {

  static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2016, Month.MAY, 5, 20, 00, 00);
  static final String LOCAL_DATE_TIME_STRING = "2016-05-05T20:00:00";

  @Test
  public void marshal() throws Exception {
    LocalDateTimeAdapter localDateTimeAdapter = new LocalDateTimeAdapter();
    String marshalled = localDateTimeAdapter.marshal(LOCAL_DATE_TIME);
    assertEquals(LOCAL_DATE_TIME_STRING, marshalled);
  }

  @Test
  public void unmarshal() throws Exception {
    LocalDateTimeAdapter localDateTimeAdapter = new LocalDateTimeAdapter();
    LocalDateTime unmarshalled = localDateTimeAdapter.unmarshal(LOCAL_DATE_TIME_STRING);
    assertEquals(LOCAL_DATE_TIME, unmarshalled);
  }
}