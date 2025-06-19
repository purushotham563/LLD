package StructuralDesignPattern.Proxy;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    interface ThirdPartyYouTubeLin{
        List<String> listVideos();
        String getVideoInfo(String id);
        void downloadVideo(String id);
    }
    static class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLin{
        @Override
        public List<String> listVideos(){
            System.out.println("Fetching video list from youtube");
            return List.of("video1","video2","video3");
        }
        @Override
        public String getVideoInfo(String id){
            System.out.println("Fetching the metadata for video "+id+"from youtube");
            return "metadata"+id;
        }

        @Override
        public void downloadVideo(String id) {
            System.out.println("Downloading video "+id+"from youtube");
        }
    }
    static class CachedYouTubeClass implements ThirdPartyYouTubeLin{
        private ThirdPartyYouTubeLin service;
        private List<String> listCache;
        private Map<String,String> videoCache=new HashMap<>();
        private boolean needReset=false;
        private HashSet<String>downloadExits=new HashSet<>();

        public CachedYouTubeClass(ThirdPartyYouTubeLin service) {
            this.service = service;
        }
        @Override
        public List<String> listVideos(){
            if(listCache==null||needReset){
                listCache=service.listVideos();
            }
            return listCache;
        }

        @Override
        public String getVideoInfo(String id) {
            if(!videoCache.containsKey(id)||needReset){
                videoCache.put(id,service.getVideoInfo(id));
            }
            return videoCache.get(id);
        }


        @Override
        public void downloadVideo(String id) {
            if(!downloadExits.contains(id)||needReset){
                service.downloadVideo(id);
            }
            downloadExits.add(id);
        }
    }
    static class YouTubeManager{
        protected ThirdPartyYouTubeLin service;
        public  YouTubeManager(ThirdPartyYouTubeLin service){
            this.service=service;
        }
        public void renderVideoPage(String id){
            String info=service.getVideoInfo(id);
            System.out.println("Rendering video page with "+info);
        }
        public void renderListPanel(){
            List<String>list=service.listVideos();
            System.out.println("Rendering video list"+list);
        }
        public void renderOnUserInput(){
            renderVideoPage("video1");
            renderListPanel();
        }



    }
    public static void main(String[] args) {
     ThirdPartyYouTubeLin youtubeService=new ThirdPartyYouTubeClass();
     ThirdPartyYouTubeLin youTubeProxy=new CachedYouTubeClass(youtubeService);
     YouTubeManager manager=new YouTubeManager(youTubeProxy);
     manager.renderOnUserInput();
     System.out.println("/n Second call (should cache)");
     manager.renderOnUserInput();

    }
}
