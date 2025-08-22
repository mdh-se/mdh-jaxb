package se.mdh.jaxb;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
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
  private static HashMap<String, JAXBContext> jaxbContextHashMap =
      new HashMap<>();

  /**
   * En privat konstruktor för att förhindra skapandet av instanser av
   * utilityklassen.
   */
  private JaxbUtils() {
  }

  /**
   * Hjälpmetod som konverterar ett JAXB-annoterat objekt till en XML-sträng.
   * (<a href="http://www.thinkcode.se/blog/2010/01/19/how-to-convert-a-pojo-
   * to-xml-with-jaxb">Blog post: how-to-convert-a-pojo-to-xml-with-jaxb</a>)
   *
   * @param objekt Det objekt som ska konverteras
   * @param typer Typer som objektet innehåller
   * @return En sträng med XML
   * @throws JAXBException Om det inte går att omvandla objektet till XML
   * @deprecated Använd {@link #toXml(Object)} istället
   */
  @Deprecated
  public static String toXml(final Object objekt, final Class... typer)
      throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(typer);
    return objectToString(objekt, context);
  }

  /**
   * Hjälpmetod som konverterar ett JAXB-annoterat objekt till en XML-sträng.
   * Använder sig av objektets klass för att skapa JAXBContext.
   *
   * @param objekt Det objekt som ska konverteras
   * @return En sträng med XML
   * @throws JAXBException Om det inte går att omvandla objektet till XML
   * @since 1.2.0
   */
  public static String toXml(final Object objekt)
      throws JAXBException {
    String className = objekt.getClass().getName();
    JAXBContext context = jaxbContextHashMap.get(className);
    if(context == null) {
      context = JAXBContext.newInstance(objekt.getClass());
      jaxbContextHashMap.put(className, context);
    }
    return objectToString(objekt, context);
  }

  private static String objectToString(final Object objekt,
                                       final JAXBContext context)
      throws JAXBException {
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
    Writer writer = new StringWriter();
    marshaller.marshal(objekt, writer);
    return writer.toString();
  }
}
