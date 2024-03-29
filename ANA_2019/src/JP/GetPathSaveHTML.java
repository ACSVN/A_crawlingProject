/**
 * Created on Wed Jun 19 20:17:50 JST 2019
 * HeartCore Robo Desktop v5.0.2 (Build No. 5.0.2-20190417.1)
 **/
package JP;
import com.tplan.robot.scripting.*;
import com.tplan.robot.*;
import java.awt.*;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class GetPathSaveHTML extends DefaultJavaTestScript  {

    public void test() {
        String web_name = getContext().getVariableAsString("web_name");
        String out_file = getContext().getVariableAsString("out_file");
        try {
            String path = this.getClass().getClassLoader().getResource("").getPath();
            String fullPath = URLDecoder.decode(path, "UTF-8");
            if(fullPath.indexOf("classes") >= 0){
                fullPath = fullPath.replace("classes/",  out_file);
            }
            if(fullPath.indexOf("src") >= 0){
                fullPath = fullPath.replace("src/",  out_file);
            }
            
            String fullPathSave = fullPath.replace(out_file,  "data_page_source/HTML/" + web_name + "/" + "HTML");
            fullPathSave = fullPathSave.substring(1, fullPathSave.length()).replace("/", "\\");
            
            getContext().setVariable("path_save_html", fullPathSave);
            
        } catch (IOException e) {
            getContext().setVariable("path_save", "path_save save page source error. " + e.toString());
        }
    }
   
    public static void main(String args[]) {
        GetPathSaveHTML script = new GetPathSaveHTML();
        ApplicationSupport robot = new ApplicationSupport();
        AutomatedRunnable runnable = robot.createAutomatedRunnable(script, "GetPathSaveHTML@" + Integer.toHexString(script.hashCode()), args, System.out, false);
        new Thread(runnable).start();
    }
}
