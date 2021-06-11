package se.mdh.jaxb;

import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * En klass med hjälpmetoder som rör JAXB.
 *
 * @author Dennis Lundberg
 * @since 1.1.0
 */
public final class JaxbUtils {

  /**
   * En privat konstruktor för att förhindra skapandet av instanser av
   * utilityklassen.
   */
  private JaxbUtils() {
  }

  /**
   * Hjälpmetod som konverterar ett JAXB-annoterat objekt till en XML-sträng.
   * http://www.thinkcode.se/blog/2010/01/19/how-to-convert-a-pojo-to-xml-with-jaxb
   *
   * @param objekt Det objekt som ska konverteras
   * @param typer Typer som objektet innehåller
   * @return En sträng med XML
   * @throws JAXBException Om det inte går att omvandla objektet till XML
   */
  public static String toXml(final Object objekt, final Class... typer)
      throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(typer);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
    Writer writer = new StringWriter();
    marshaller.marshal(objekt, writer);
    return writer.toString();
  }
}
