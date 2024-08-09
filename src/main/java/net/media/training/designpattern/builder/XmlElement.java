package net.media.training.designpattern.builder;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class XmlElement {
    private final String name;
    private final String value;
    private final List<XmlElement> children = new ArrayList<XmlElement>();
    private final List<Pair<String, String>> attributes = new ArrayList<Pair<String, String>>();

    public XmlElement(String name) {
        this.name = name;
        value = null;
    }

    public XmlElement(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public void addChild(XmlElement xmlElement){
        this.children.add(xmlElement);
    }

    public void addAttribute(String key, String value){
        attributes.add(new Pair<String, String>(key, value));
    }

    public String build(){
        StringBuilder stringBuilder = new StringBuilder(String.format("<%s", name));
        for (Pair<String, String> attribute: attributes){
            stringBuilder.append(String.format(" %s=\"%s\"", attribute.getKey(), attribute.getValue()));
        }
        stringBuilder.append(">");
        if(value != null){
            stringBuilder.append(value);
        }else{
            for(XmlElement child: children){
                stringBuilder.append(child.build());
            }
        }
        stringBuilder.append(String.format("</%s>", name));

        return stringBuilder.toString();
    }
}
