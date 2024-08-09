package net.media.training.designpattern.builder;

public class XmlBuilder {

    public static String build(XmlElement element, String version, String encoding){
        return String.format("<?xml version=\"%s\" encoding=\"%s\"?>", version, encoding) + element.build();
    }

    public static String build(XmlElement element){
        return build(element, "1.0", "UTF-8");
    }
}
