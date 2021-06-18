package se.mdh.jaxb;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "se.mdh.jaxb.SimpleObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleObject implements Serializable {
  private static final long serialVersionUID = 5453661377262557148L;

  @XmlElement(name = "name")
  private String name;

  @XmlElement(name = "simpleObject2")
  private SimpleObject2 simpleObject2;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SimpleObject2 getSimpleObject2() {
    return simpleObject2;
  }

  public void setSimpleObject2(SimpleObject2 simpleObject2) {
    this.simpleObject2 = simpleObject2;
  }
}