package StructuralDesignPattern.Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    interface Graphic{
        void move(int x,int y);
        void draw();
    }
    static class Dot implements Graphic{
        protected int x;
        protected int y;
        public Dot(int x,int y){
            this.x=x;
            this.y=y;

        }

        @Override
        public void move(int x, int y) {
             this.x+=x;
             this.y+=y;
        }


        @Override
        public void draw() {
            System.out.println("Draw a dot at (" + x + ", " + y + ")");
        }

    }
    static class Circle extends Dot{
        int radius;

        public Circle(int x, int y,int radius) {
            super(x, y);
            this.radius=radius;
        }



        @Override
        public void draw() {
            System.out.println("Draw a circle at (" + x + ", " + y + ") with radius " + radius);
        }

    }
    static class CompoundGraphic implements Graphic{
        private List<Graphic>children=new ArrayList<>();
        public void add(Graphic child){
            children.add(child);
        }
        public void remove(Graphic child){
            children.remove(child);
        }
        @Override
        public void move(int x,int y){
            for(Graphic child:children){
                child.move(x,y);
            }
        }
        @Override
        public void draw(){
            System.out.println("Drawing the compound graphic");
            for (Graphic child:children){
                child.draw();
            }
            System.out.println("Draw bounding box (dashed rectangle)\n");

        }
    }
    static class ImageEditor{
        private CompoundGraphic all=new CompoundGraphic();
        public void load(){
            all.add(new Dot(1,2));
            all.add(new Circle(1,3,4));
            System.out.println("Initial drawing");
            all.draw();
        }
        public void groupSelected(List<Graphic>component){
            CompoundGraphic group=new CompoundGraphic();
            for(Graphic comp:component ){
                group.add(comp);
                all.remove(comp);
            }
            all.add(group);
            System.out.println("After grouping selected components");
            all.draw();
        }
        public CompoundGraphic  getAll(){
            return all;
        }


    }

    public static void main(String[] args) {
      ImageEditor editor=new ImageEditor();
      editor.load();
        Dot d1 = new Dot(10, 20);
        Circle c1 = new Circle(30, 40, 15);
        editor.getAll().add(d1);
        editor.getAll().add(c1);
        editor.groupSelected(Arrays.asList(d1, c1));
    }
}
