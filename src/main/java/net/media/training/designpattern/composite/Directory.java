package net.media.training.designpattern.composite;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:51 PM
 * To change this template use pre_refactoring.File | Settings | pre_refactoring.File Templates.
 */
public class Directory implements StorageObject{
    private final String name;
    private List<StorageObject> contents;
    private Directory parent;

    public String getName() {
        return name;
    }

    public Directory(String name, List<StorageObject> contents) {
        this.name = name;
        this.contents = contents;

        for (StorageObject storageObject : contents) {
            storageObject.setParent(this);
        }
    }

    public int getSize() {
        int sum = 0;

        for(StorageObject storageObject: getContents()){
            sum += storageObject.getSize();
        }

        return sum;
    }

    public List<StorageObject> getContents() {
        return contents;
    }

    public void setParent(Directory directory) {
        this.parent = directory;
    }

    public void delete() {

        while (getContents().size() > 0){
            StorageObject storageObject = getContents().get(0);
            storageObject.getParent().removeEntry(storageObject);
        }

        this.getParent().removeEntry(this);
    }

    public void removeEntry(StorageObject storageObject){
        contents.remove(storageObject);
    }

    public void add(StorageObject storageObject) {
        contents.add(storageObject);
    }

    public boolean exists(String name){
        if(getName().equals(name)){
            return true;
        }
        for(StorageObject storageObject: getContents()){
            if(storageObject.getName().equals(name) || storageObject.exists(name)) {
                return true;
            }
        }
        return false;
    }

    public Directory getParent() {
        return parent;
    }
}
