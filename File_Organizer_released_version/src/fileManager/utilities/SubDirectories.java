package fileManager.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author baibars-barbarossa
 */
public class SubDirectories {
       public static void traverseSubDirectoryIteratively(File rootDir){
           ArrayList<File> listOfFiles = new ArrayList<File>();
           Queue<File> queue = new ArrayDeque<>();
           queue.add(rootDir);
           
           while(!queue.isEmpty()){
               File current = queue.poll();
               File[] listOfFilesAndDirectories = current.listFiles();
               
               for(File file : listOfFilesAndDirectories){
                   if(file.isDirectory()) queue.add(file);
                   else {
                       listOfFiles.add(file);
                   }
               }
           }
          
           try{
                String filename= "results.txt";
                FileWriter fwc = new FileWriter(filename,false);
                fwc.close();
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                for(File file : listOfFiles){
                    fw.write(file.getName()+" ("+file.getAbsolutePath()+")\n");
                 }
                fw.close();
                }
            catch(IOException ioe){
                System.err.println("IOException: " + ioe.getMessage());
                }
       }
       
       public static void traverseSubDirectoryIteratively(File rootDir,String regEx){
           ArrayList<File> listOfFiles = new ArrayList<File>();
           ArrayList<File> listOfMatchedFiles = new ArrayList<File>();
           Queue<File> queue = new ArrayDeque<>();
           queue.add(rootDir);
           
           while(!queue.isEmpty()){
               File current = queue.poll();
               File[] listOfFilesAndDirectories = current.listFiles();
               
               for(File file : listOfFilesAndDirectories){
                   if(file.isDirectory()) queue.add(file);
                   else {
                       listOfFiles.add(file);
                   }
               }
           }
           
           for(File file : listOfFiles){
                Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(file.getName());
                
                if(matcher.find()){
                    listOfMatchedFiles.add(file);
                }
           }
           try{
                String filename= "results.txt";
                FileWriter fwc = new FileWriter(filename,false);
                fwc.close();
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                for(File file : listOfMatchedFiles){
                    fw.write(file.getName()+" ("+file.getAbsolutePath()+")\n");
                 }
                fw.close();
                }catch(IOException ioe){
                System.err.println("IOException: " + ioe.getMessage());
                }
        }
}
