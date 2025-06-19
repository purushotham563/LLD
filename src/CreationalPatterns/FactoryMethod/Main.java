package CreationalPatterns.FactoryMethod;

public class Main {
    interface Product{
        void doSomeThing();
    }
    public static class ProductA implements Product {

        @Override
        public void doSomeThing() {
            System.out.println("ProductA is doing something ");
        }

    }
    public static class ProductB  implements Product{

        @Override
        public void doSomeThing() {
            System.out.println("ProductB is doing something ");
        }

    }
    abstract static class Creator{
        public abstract Product CreateProduct();
    }
    public static class CreatorA extends Creator{
        @Override
        public Product CreateProduct() {
            return new ProductA();
        }
    }
    public static class CreatorB extends Creator{
        @Override
        public Product CreateProduct() {
            return new ProductB();
        }
    }
    public static void main(String[] args) {
     Creator creatorA=new CreatorA();
     Creator creatorB=new CreatorB();
     Product productA=creatorA.CreateProduct();
     Product productB=creatorB.CreateProduct();
     productB.doSomeThing();
     productA.doSomeThing();

    }
}
