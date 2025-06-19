package CreationalPatterns.AbstractFactory;

import java.awt.desktop.AppForegroundListener;

public class Main {
      interface Button{
        void render();
    }
    interface CheckBox{
          void render();
    }
    public static class WindowButton implements Button{
        @Override
        public void render() {
            System.out.println("usage of window button");
        }
    }
    public static class WindowCheckBox implements CheckBox{
        @Override
        public void render() {
            System.out.println("usage of window on click");
        }
    }
    public static class MACButton implements Button{
        @Override
        public void render() {
            System.out.println("usage of mac button");
        }
    }
    public static class MACCheckBox implements CheckBox{
        @Override
        public void render() {
            System.out.println("usage of the mac check box");
        }
    }
    interface GUIFactory{
          Button createButton();
          CheckBox createCheckBox();

    }
    public static class WindowFactory implements GUIFactory{
        @Override
        public Button createButton() {
            return new WindowButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new WindowCheckBox();
        }
    }
    public static class MACFactory implements GUIFactory{
        @Override
        public Button createButton() {
            return new MACButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new MACCheckBox();
        }
    }
    public static class Application{
          private Button button;
          private CheckBox checkBox;
          Application(GUIFactory factory){
              this.button=factory.createButton();
              this.checkBox=factory.createCheckBox();
          }
          public void renderUI(){
              button.render();
              checkBox.render();
          }
    }
    public static void main(String[] args) {
         GUIFactory windowFactor=new WindowFactory();
         GUIFactory MACFactory=new MACFactory();
         Application windowAPP=new Application(windowFactor);
         Application MACAPP=new Application(MACFactory);
         windowAPP.renderUI();
         //MACAPP.renderUI();
    }
}
