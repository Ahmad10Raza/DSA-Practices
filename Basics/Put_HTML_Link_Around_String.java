import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Put_HTML_Link_Around_String {
    public static String[] parseUrlInString(String text){
    
        // Create a Pattern object
        Pattern originalPattern = Pattern.compile("\\b(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
      
        // Now create matcher object.
        Matcher m = originalPattern.matcher(text);
        while(m.find()){
            String url = m.group();
            text = text.replace(url, "<a href=\""+url+"\">"+url+"</a>");
        }            
        
        return text.split(" ");
    }
}
