package BehaviouralDesignPattern.Template;

public class Main {
    static abstract class Beverage{
        public final void prepareRecipe(){
          boilWater();
          pourInCup();
          brew();
          addCondiments();
          hook();
        }
        private void boilWater(){
            System.out.println("Boiling the water");
        }
        private void pourInCup(){
            System.out.println("Pouring into cup");
        }
        protected abstract void brew();
        protected abstract void addCondiments();
        protected void hook(){
      //Noting
        }
    }
    static class Tea extends Beverage{
        @Override
        protected void brew() {
            System.out.println("steeping the tea");
        }
        @Override
        protected void addCondiments() {
       System.out.println("Adding the lemon");
        }
        @Override
        protected void hook(){
            System.out.println("Custom step : Logging tea preparation");
        }


    }

    static class Coffee extends Beverage{
        @Override
        protected void brew() {
            System.out.println("Dripping coffee through filter");
        }
        @Override
        protected void addCondiments() {
             System.out.println("Adding the milk and sugar");
        }


    }
    public static void main(String[] args) {
        Beverage tea=new Tea();
        System.out.println("Preparing the tea");
        tea.prepareRecipe();
        System.out.println("\n----------");
        Beverage coffee=new Coffee();
        coffee.prepareRecipe();
    }
}
