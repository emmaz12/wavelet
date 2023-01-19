import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class SearchEngine implements URLHandler{

    ArrayList <String> words = new ArrayList<String>();

    public String handleRequest(URI url) {
        String result = "";
        if(url.getPath().equals("/add")) {
            String [] arr = url.getQuery().split("=");
            words.add(arr[1]);
        }

        else if (url.getPath().equals("/search")) {
            String [] arr = url.getQuery().split("=");
            
            for (String word: words){
                if (word.contains(arr[1])) {
                    result = result + word;
                }
            }
        }
        return result;
    }

    class NumberServer {
        public static void main(String[] args) throws IOException {
            if(args.length == 0){
                System.out.println("Missing port number! Try any number between 1024 to 49151");
                return;
            }
    
            int port = Integer.parseInt(args[0]);
    
            Server.start(port, new Handler());
        }
    }
    
}
