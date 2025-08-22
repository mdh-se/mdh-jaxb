package se.mdh.jaxb;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * En adapter som konverterar mellan Java-datatypen <code>LocalDate</code> och
 * XML-datatypen <code>date</code>.
 *
 * @author Johan Nilsson
 * @author Dennis Lundberg
 * @since 1.0.0
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
  private static final int Z_DATE_LENGTH = 11;
  private static final int Z_POSITION = 10;
  /**
   * Returnera värdet av en Java-datatyp som text för användning i XML.
   *
   * {@inheritDoc}
   */
  @Override
  public String marshal(final LocalDate value) throws Exception {
    if(value == null) {
      return null;
    }
    else {
      return value.toString();
    }
  }

  /**
   * Returnera en Java-datatyp som motsvarar angiven text från XML.
   *
   * {@inheritDoc}
   */
  @Override
  public LocalDate unmarshal(final String value) throws Exception {
    if(value == null) {
      return null;
    }
    // Vissa externa parter (vi tittar på er Alma) lägger på ett Z på sina
    // xml-datumsträngar "2025-08-22Z" som måste ignoreras...
    else if (value.length() == Z_DATE_LENGTH
        && value.charAt(Z_POSITION) == 'Z') {
      return LocalDate.parse(value.substring(0, value.length() - 1));
    }
    else {
      return LocalDate.parse(value);
    }
  }
}
