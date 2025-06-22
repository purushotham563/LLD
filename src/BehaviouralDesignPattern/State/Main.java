package BehaviouralDesignPattern.State;

public class Main {
    interface State{
        void clickLock();
        void clickPlay();
        void clickNext();
        void ClickPrevious();
    }
    static class AudioPlayer{
        private State state;
        private String playList;
        private String currentSong;
        private int volume;
        private boolean playing;
        public  AudioPlayer(){
            this.state=new ReadyState(this);
            this.playList="Default PlayList";
            this.currentSong="song 1";
            this.volume=50;
            this.playing=false;
        }
        public void changeState(State state){
            this.state=state;
        }
        public void clickLock(){
            state.clickLock();
        }
        public void clickPlay(){
            state.clickPlay();
        }
        public void clickNext(){
            state.clickNext();
        }
        public void clickPrevious(){
            state.ClickPrevious();
        }
        public void startPlayback(){
            this.playing=true;
            System.out.println("Playing"+currentSong);
        }
        public void stopPlayback(){
            this.playing=false;
            System.out.println("Playback stopped");
        }
        public void nextSong() {
            // Simplified song switching logic
            if (currentSong.equals("Song 1")) {
                currentSong = "Song 2";
            } else if (currentSong.equals("Song 2")) {
                currentSong = "Song 3";
            } else {
                currentSong = "Song 1";
            }
            System.out.println("Switched to next song: " + currentSong);
            if (playing) {
                startPlayback(); // Restart playback if we were playing
            }
        }
        public void previousSong() {
            // Simplified song switching logic
            if (currentSong.equals("Song 3")) {
                currentSong = "Song 2";
            } else if (currentSong.equals("Song 2")) {
                currentSong = "Song 1";
            } else {
                currentSong = "Song 3";
            }
            System.out.println("Switched to previous song: " + currentSong);
            if (playing) {
                startPlayback(); // Restart playback if we were playing
            }
        }
        public void fastForward(int second){
            System.out.println("Fast forwarding"+second+" Seconds");
        }
        public void rewind(int seconds){
            System.out.println("Rewinding "+seconds+"seconds");
        }
        public boolean isPlaying(){
            return playing;
        }
        public String getCurrentSong(){
            return currentSong;
        }
    }
    static class ReadyState implements State{
        private AudioPlayer player;
        public ReadyState(AudioPlayer player){
            this.player=player;
        }

        @Override
        public void clickLock() {
           System.out.println("Locking the player");
           player.changeState(new LockedState(player));
        }


        @Override
        public void clickPlay() {
          System.out.println("Starting playback");
          player.startPlayback();
          player.changeState(new PlayingState(player));
        }


        @Override
        public void clickNext() {
            System.out.println("next song in ready state");
            player.nextSong();
        }

        @Override
        public void ClickPrevious() {
         System.out.println("Previous song in ready state");
         player.previousSong();
        }
    }
    static class PlayingState implements State{
        private AudioPlayer player;
        public PlayingState(AudioPlayer player){
            this.player=player;
        }
        @Override
        public void clickLock() {
            System.out.println("Locking the player while locking");
            player.changeState(new LockedState(player));
        }
        @Override
        public void clickPlay() {
          System.out.println("Stopping playback");
          player.stopPlayback();
          player.changeState(new ReadyState(player));
        }


        @Override
        public void clickNext() {
            System.out.println("Fast forwarding 5 seconds (single click)");
            player.fastForward(5);

            // For demo purposes, we'll also show what double click would do
            System.out.println("(Double click would switch to next song)");
        }

        @Override
        public void ClickPrevious() {
            System.out.println("Rewinding 5 seconds (single click)");
            player.rewind(5);

            // For demo purposes, we'll also show what double click would do
            System.out.println("(Double click would switch to previous song)");

        }
    }
    static class LockedState implements State{
        private AudioPlayer player;
        public LockedState(AudioPlayer player){
            this.player=player;
        }
        @Override
        public void clickLock() {
            if(player.isPlaying()){
                System.out.println("Unlocking the player resume playing");
                player.changeState(new PlayingState(player));
            }else{
                System.out.println("Unlocking player ready state");
                player.changeState(new ReadyState(player));
            }
        }

        @Override
        public void clickPlay() {
            System.out.println("Player is locked - play action ignored");
        }

        @Override
        public void clickNext() {
            System.out.println("Player is locked - next action ignored");
        }

        @Override
        public void ClickPrevious() {
            System.out.println("Player is locked - previous action ignored");
        }
    }


    public static void main(String[] args) {
        AudioPlayer player=new AudioPlayer();
        System.out.println("==== Initial State(Ready)");
        System.out.println("Current song"+player.currentSong);
        player.clickPlay();
        System.out.println("\n=== Now Playing ===");
        player.clickNext();
        player.clickPrevious();
        player.clickLock();
        System.out.println("\n=== Locked State ===");
        player.clickPlay();
        player.clickNext();
        player.clickLock();

        System.out.println("\n=== Back to Playing State ===");
        player.clickPlay(); // Should stop playback

        System.out.println("\n=== Ready State ===");
        player.clickNext();
        player.clickLock();

        System.out.println("\n=== Locked State Again ===");
        player.clickLock();
    }
}
