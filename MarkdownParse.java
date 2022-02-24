// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//Reference to Joe's implementation
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        System.out.println(markdown);
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            System.out.println(markdown.length());
            System.out.println("first "+ currentIndex);
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            System.out.println("nextOpenBracket "+ nextOpenBracket);

            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            System.out.println("nextCloseBracket "+ nextCloseBracket);

            int openParen = markdown.indexOf("(", nextCloseBracket);
            System.out.println("openParen "+ openParen);

            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpenBracket == -1 || nextCloseBracket == -1
                  || closeParen == -1 || openParen == -1) {
                return toReturn;
            }
            String potentialLink = markdown.substring(openParen + 1, closeParen);
            if(potentialLink.indexOf(" ") == -1 && potentialLink.indexOf("\n") == -1) {
                toReturn.add(potentialLink);
                currentIndex = closeParen + 1;
            }
            else {
                currentIndex = currentIndex + 1;
            }
            
            

            /**if (openParen !=-1 && closeParen !=-1){
            String substring = markdown.substring(openParen, closeParen);
            if(!substring.contains(" ")){
                if(nextOpenBracket !=0 && markdown.charAt(nextOpenBracket-1)!= '!'){
                    toReturn.add(markdown.substring(openParen+1, closeParen));
                    System.out.println("Hi!");
                } 
            } 
        }
        
        if(closeParen == -1){
            break;
        }
            currentIndex = closeParen + 1;
            System.out.println("second "+ toReturn); */
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}