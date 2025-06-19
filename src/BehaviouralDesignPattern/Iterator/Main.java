package BehaviouralDesignPattern.Iterator;


import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Main {
    public interface Iterator<T>{
        T next();
        T previous();
        boolean hasNext();
        boolean hasPrevious();
        int currentIndex();

    }
    public interface IterableCollection<T>{
        Iterator<T> createForwardIterator();
        Iterator<T> createBackwardIterator();
    }
    public static class NameCollection implements IterableCollection<String>{
        private String[]names;
        public NameCollection(String []names){
            this.names=names;
        }

        public String[] getNames() {
            return names;
        }

        @Override
        public Iterator<String> createForwardIterator() {
            return new NameIterator(this,false);
        }


        @Override
        public Iterator<String> createBackwardIterator() {
            return new NameIterator(this,true);
        }
    }
    public static class NameIterator implements Iterator<String>{
        private NameCollection collection;
        private int pos;
        public NameIterator(NameCollection collection,boolean reverse){
            this.collection=collection;
            this.pos=reverse?collection.getNames().length-1:0;
        }

        @Override
        public String next() {
            return collection.getNames()[pos++];
        }


        @Override
        public String previous() {
            return collection.getNames()[pos--];
        }


        @Override
        public boolean hasNext() {
            return pos<collection.getNames().length;
        }

        @Override
        public boolean hasPrevious() {
            return pos>=0;
        }

        @Override
        public int currentIndex() {
            return pos;
        }
    }


    public static void main(String[] args) {
        String[] names = { "Puli", "Reddy", "Anil", "Sneha" };
        NameCollection nameCollection=new NameCollection(names);
        System.out.println("Forward Iteration");
        Iterator<String>forwardIterator= nameCollection.createForwardIterator();
        while (forwardIterator.hasNext()){
            System.out.print(forwardIterator.next()+" ");
        }
        System.out.println("\n Backward Iteration");
        Iterator<String>backwardIterator= nameCollection.createBackwardIterator();
        while (backwardIterator.hasPrevious()){
            System.out.print(backwardIterator.previous()+" ");
        }
    }
}
