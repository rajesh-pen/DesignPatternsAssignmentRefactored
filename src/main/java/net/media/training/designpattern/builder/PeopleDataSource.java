package net.media.training.designpattern.builder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        XmlElement rootElement = new XmlElement("People");
        rootElement.addAttribute("number", String.valueOf(persons.size()));
        for(Person person: persons){
            XmlElement personElement = new XmlElement("Person");
            personElement.addAttribute("id", String.valueOf(person.getId()));
            personElement.addAttribute("name", person.getName());

            XmlElement addressElement = new XmlElement("Address");
            addressElement.addChild(new XmlElement("City", person.getCity()));
            addressElement.addChild(new XmlElement("Country", person.getCountry()));

            personElement.addChild(addressElement);
            rootElement.addChild(personElement);
        }

        return XmlBuilder.build(rootElement);
    }
}