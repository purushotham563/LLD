package BehaviouralDesignPattern.Command;

import java.util.Stack;
import java.util.concurrent.ConcurrentMap;

public class Main {
    static class Editor{
        private String text="";
        private String selection="";

        public void setText(String text) {
            this.text = text;
        }

        public void setSelection(String selection) {
            this.selection = selection;
        }

        public String getText() {
            return text;
        }

        public String getSelection() {
            return selection;
        }

        public void deleteSelection (){
            if(selection!=null&&!selection.isEmpty()){
                text=text.replace(selection,"");
                selection="";
            }
        }
        public void replaceSelection(String text){
            if(selection!=null&&!selection.isEmpty()){
                this.text=this.text.replace(selection,text);
            }else{
                this.text+=text;
            }
            selection="";
        }
    }
    static class Application{
        private String clipBoard;
        private Editor[]editors;
        private Editor activeEditor;
        private CommandHistory history=new CommandHistory();
        public Application(){
            this.editors=new Editor[]{new Editor()};
            this.activeEditor=editors[0];
        }

        public String getClipBoard() {
            return clipBoard;
        }
        public void setClipBoard(String clipboard) {
            this.clipBoard = clipboard;
        }

        public Editor getActiveEditor() {
            return activeEditor;
        }
        public void executeCommand(Command command){
            if(command.execute()){
                history.push(command);
            }
        }
        public void undo(){
            Command command=history.pop();
            if (command != null) {
                command.undo();
            }
        }
        public  void createUI(){
            Runnable copy = () -> executeCommand(new CopyCommand(this, activeEditor));
            Runnable cut = () -> executeCommand(new CutCommand(this, activeEditor));
            Runnable paste = () -> executeCommand(new PasteCommand(this, activeEditor));
            Runnable undo = () -> executeCommand(new UndoCommand(this, activeEditor));

            System.out.println("UI created with command bindings");
            // Simulate user actions
            activeEditor.setText("Hello World");
            activeEditor.setSelection("World");
            System.out.println("Initial text: " + activeEditor.getText());

            cut.run();
            System.out.println("After cut: " + activeEditor.getText());

            paste.run();
            System.out.println("After paste: " + activeEditor.getText());

            undo.run();
            System.out.println("After undo: " + activeEditor.getText());
        }

    }
    static abstract class Command{
        protected  Application app;
        protected Editor editor;
        protected String backup;
        public Command(Application app,Editor editor){
            this.app=app;
            this.editor=editor;
        }
        public void saveBackup(){
            this.backup= editor.getText();
        }
        public void undo(){
            editor.setText(backup);
        }
        public abstract boolean execute();

    }
    static class CopyCommand extends Command{
        public CopyCommand(Application app,Editor editor){
            super(app,editor);
        }
        @Override
        public boolean execute(){
            app.setClipBoard(editor.getSelection());
            return false;
        }
    }
    static class CutCommand extends Command{
        public CutCommand(Application app,Editor editor){
            super(app,editor);
        }

        @Override
        public boolean execute() {
            saveBackup();
            app.setClipBoard(editor.getSelection());
            editor.deleteSelection();
            return true;
        }
    }
    static class PasteCommand extends Command{
        public PasteCommand(Application app,Editor editor){
            super(app,editor);
        }

        @Override
        public boolean execute() {
            saveBackup();
            editor.replaceSelection(app.getClipBoard());
            return true;

        }
    }
    static class UndoCommand extends Command{
        public UndoCommand(Application app, Editor editor) {
            super(app, editor);
        }

        @Override
        public boolean execute() {
            app.undo();
            return false;
        }
    }

    static class CommandHistory{
        private Stack<Command>history=new Stack<>();
        public void push(Command c){
            history.push(c);
        }
        public Command pop(){
            if(history.isEmpty())return null;
            return history.pop();
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.createUI();

    }
}
