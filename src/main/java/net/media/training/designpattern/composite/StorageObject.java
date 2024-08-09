package net.media.training.designpattern.composite;

public interface StorageObject {

    void setParent(Directory directory);

    String getName();

    int getSize();

    Directory getParent();

    boolean exists(String name);
}
