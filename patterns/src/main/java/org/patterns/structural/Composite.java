package org.patterns.structural;

import java.util.ArrayList;
import java.util.List;

// Composite Pattern = Tree structure where single and group treated uniformly

// Common Component
interface FileSystemComponent {

    void display();
}

// Leaf Class
class File implements FileSystemComponent {

    private String name;
    public File(String name){
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + this.name);
    }
}

// Composite Class
class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(FileSystemComponent fileSystemComponent){
        components.add(fileSystemComponent);
    }

    public void remove(FileSystemComponent fileSystemComponent){
        components.remove(fileSystemComponent);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + this.name);

        for(FileSystemComponent component : components){
            component.display();
        }
    }
}

public class Composite {
    public static void main(String[] args) {

        File file1 = new File("img1");
        File file2 = new File("img2");
        File file3 = new File("notes.txt");
        File file4 = new File("doc.pdf");

        Folder folder1 = new Folder("Images Folder");
        Folder folder2 = new Folder("Documents Folder");

        Folder root = new Folder("root");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(file4);

        root.add(folder1);
        root.add(folder2);

        root.display();
    }
}
