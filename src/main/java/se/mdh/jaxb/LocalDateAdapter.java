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
  /**
   * Returnera värdet av en Java-datatyp som text för användning i XML.
   *
   * {@inheritDoc}
   */
  @Override
  public String marshal(LocalDate value) throws Exception {
    return value.toString();
  }

  /**
   * Returnera en Java-datatyp som motsvarar angiven text från XML.
   *
   * {@inheritDoc}
   */
  @Override
  public LocalDate unmarshal(String value) throws Exception {
    return LocalDate.parse(value);
  }
}
