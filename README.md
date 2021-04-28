# mdh-jaxb
Innehåller adapters för att konvertera mellan Java-datatyper och XML-datatyper.

Används normalt i filen ```bindings.xml``` så här:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<jaxb:bindings jaxb:extensionBindingPrefixes="xjc"
               version="2.1"
               xmlns:jaxb="http://java.sun.com/xml/ns/jaxb"
               xmlns:xjc="http://java.sun.com/xml/ns/jaxb/xjc"
               xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <jaxb:globalBindings>
    <!-- Den genererade Java-koden ska använda LocalDate-objekt för xs:date -->
    <xjc:javaType adapter="se.mdh.jaxb.LocalDateAdapter"
                  name="java.time.LocalDate" xmlType="xs:date"/>
    <!-- Den genererade Java-koden ska använda LocalDateTime-objekt för xs:dateTime -->
    <xjc:javaType adapter="se.mdh.jaxb.LocalDateTimeAdapter"
                  name="java.time.LocalDateTime" xmlType="xs:dateTime"/>
  </jaxb:globalBindings>
</jaxb:bindings>
```