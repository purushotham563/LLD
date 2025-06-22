package Relationships.Compostion;

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface  FileSystemComponent{
        void showDetails();
    }
    static class File implements FileSystemComponent{
        private String name;

        public File(String name) {
            this.name = name;
        }

        @Override
        public void showDetails() {
           System.out.println("File"+name);
        }
    }
    static class Folder implements FileSystemComponent{
        private String name;
        private List<FileSystemComponent>components=new ArrayList<>();
        public Folder(String name){
            this.name=name;
        }
        public void addComponent(FileSystemComponent component){
            components.add(component);
        }
        public void showDetails(){
            System.out.print("Folder"+name);
            for (FileSystemComponent c:components){
                c.showDetails();
            }
        }

    }

    public static void main(String[] args) {
      Folder root=new Folder("root");
      File resume=new File("resume.pdf");
      Folder photos=new Folder("photos");
      File holiday=new File("holiday.jpg");
      photos.addComponent(holiday);
      root.addComponent(resume);
      root.addComponent(photos);
      root.showDetails();

    }

}
