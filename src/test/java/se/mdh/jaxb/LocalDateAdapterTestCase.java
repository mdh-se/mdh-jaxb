package se.mdh.jaxb;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocalDateAdapterTestCase {
  static final LocalDate LOCAL_DATE = LocalDate.of(2016, Month.MAY, 5);
  static final String LOCAL_DATE_STRING = "2016-05-05";
  static final String ZONED_DATE_STRING = "2016-05-05Z";

  @Test
  public void should_marshal_localdate_to_string() throws Exception {
    LocalDateAdapter localDateAdapter = new LocalDateAdapter();
    String marshalled = localDateAdapter.marshal(LOCAL_DATE);
    assertEquals(LOCAL_DATE_STRING, marshalled);
  }

  @Test
  public void should_unmarshal_string_to_localdate() throws Exception {
    LocalDateAdapter localDateAdapter = new LocalDateAdapter();
    LocalDate unmarshalled = localDateAdapter.unmarshal(LOCAL_DATE_STRING);
    assertEquals(LOCAL_DATE, unmarshalled);
  }

  @Test
  public void should_unmarshal_z_string_to_localdate() throws Exception {
    LocalDateAdapter localDateAdapter = new LocalDateAdapter();
    LocalDate unmarshalled = localDateAdapter.unmarshal(ZONED_DATE_STRING);
    assertEquals(LOCAL_DATE, unmarshalled);
  }
}

