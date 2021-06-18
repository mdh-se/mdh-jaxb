package se.mdh.jaxb;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "se.mdh.jaxb.SimpleObject2")
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleObject2 implements Serializable {
  private static final long serialVersionUID = 5453661377262557147L;

  @XmlElement(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}