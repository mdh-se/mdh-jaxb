package se.mdh.jaxb;

import javax.xml.bind.JAXBException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JaxbUtilsTestCase {
  @Test
  public void toXml() throws JAXBException {
    SimpleObject simpleObject = new SimpleObject();
    String xml = JaxbUtils.toXml(simpleObject);
    assertTrue(xml.contains("simpleObject"));
  }

  @Test
  public void toXmlUtanExplicitaTyper() throws JAXBException {
    SimpleObject simpleObject = new SimpleObject();
    SimpleObject2 simpleObject2 = new SimpleObject2();

    simpleObject.setName("Main");
    simpleObject2.setName("Sub");
    simpleObject.setSimpleObject2(simpleObject2);

    String xml = JaxbUtils.toXml(simpleObject);
    assertTrue(xml.contains("simpleObject"));
    assertTrue(xml.contains("simpleObject2"));
  }
}