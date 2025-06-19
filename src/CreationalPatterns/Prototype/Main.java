package CreationalPatterns.Prototype;

import org.w3c.dom.UserDataHandler;

import javax.swing.*;
import java.util.*;
import java.util.Objects;

public class Main {
    static abstract class Shape{
        public int x;
        public int y;
        public String color;
        public Shape(){

        }
        public Shape(Shape target){
            if(target!=null){
                this.x=target.x;
                this.y=target.y;
                this.color=target.color;
            }

        }
        public abstract Shape clone();

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Shape))return false;
            Shape shape2=(Shape) obj;
            return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
        }
    }
    public static class Circle extends Shape{
        public int radius;
        public Circle(){

        }
        public Circle(Circle tar){
            super(tar);
            if(tar!=null){
                this.radius=tar.radius;
            }
        }
        @Override
        public Shape clone(){
            return new Circle(this);
        }
        @Override
        public boolean equals(Object object2) {
            if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
            Circle shape2 = (Circle) object2;
            return shape2.radius == radius;
        }
    }
    public static class Rectangle extends Shape{
        public int wid;
        public int hei;
        public Rectangle(){};
        public Rectangle(Rectangle tar){
            super(tar);
            if(tar!=null){
                this.hei= tar.hei;
                this.wid=tar.wid;
            }
        }
        @Override
        public Shape clone() {
            return new Rectangle(this);
        }
        @Override
        public boolean equals(Object object2) {
            if (!(object2 instanceof Rectangle) || !super.equals(object2)) return false;
            Rectangle shape2 = (Rectangle) object2;
            return shape2.wid == wid && shape2.hei == hei;
        }

    }
    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);
        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.wid = 10;
        rectangle.hei = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }
}
