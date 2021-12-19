package edu.sdccd.cisc191.template;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoCollection {
    // For use in scanner
    private String fileName;

    // Constructor
    public VideoCollection(String fileName){
        this.fileName = fileName;
    }

    /** add to BinarySearchTree
     *
     * @return BinarySearchTree<Video>
     */
    private BinarySearchTree<Video> addToTree(){
        BinarySearchTree<Video> tree = null;
        Scanner fileIn=null;
        try{
            // read input from "file name"
            fileIn = new Scanner(new FileReader(fileName));
            if (fileIn.hasNextLine()){
                String line = fileIn.nextLine();

                while (line !=null){
                    String title = line.split("-")[0];
                    String director = line.split("-")[1];
                    int duration = Integer.parseInt(line.split("-")[2]);
                    String type = line.split("-")[3];
                    // String title, String director,int playingTime, Enum<VideoType> type
                    Video video = new Video(title, director, duration, VideoType.valueOf(type));
                    if(tree==null){
                        tree = new BinarySearchTree<Video>(video);
                    } else {
                        tree.insert(video);
                    }

                    line = fileIn.nextLine();

                }
            }
        } catch(Exception e){
            System.out.println(e);
        } finally {
            // close the scanner
            if (fileIn != null)
                fileIn.close();
        }
        return tree;
    }

    /** Print tree in its entirety
     *
     * @return ArrayList<Video>
     */
    public ArrayList<Video> displayTree(){
        PrintWriter fileOut = null;
        try {
            // save the output in "output.txt"
            fileOut = new PrintWriter(new FileWriter("output.txt"));

            // convert the films in our txt into a binary search
            BinarySearchTree<Video> tree = addToTree();
            // print movies in this tree in order
            ArrayList<Video> list = tree.inOrderList();

            for (Video video : list) {
                fileOut.write(video.getTitle() + System.getProperty("line.separator"));
            }
            return list;
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            // close the printWriter
            if(fileOut != null)
                fileOut.close();
        }

        return null;
    }
}
