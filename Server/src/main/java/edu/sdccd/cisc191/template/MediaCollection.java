package edu.sdccd.cisc191.template;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaCollection
{
    // A filename for use by the BinarySearchTree
    private String fileName;

    /**
     * Construct a new MediaCollection based on the file at fileName
     * @param fileName relative file path for MediaCollection
     */
    public MediaCollection(String fileName)
    {
        this.fileName = new File(fileName).getAbsolutePath();
    }

    /** Load media info provided in file to a BinarySearchTree
     *
     * @return BinarySearchTree<Media>
     * @throws FileNotFoundException
     */
    private BinarySearchTree<Media> addToTree() throws FileNotFoundException {
        // Declare a Scanner to read from the fileName
        Scanner fileIn;
        // Declare a BinarySearchTree to eventually represent media found in the file
        BinarySearchTree<Media> tree;

        // Assign the proper Scanner object to fileIn
        fileIn = new Scanner(new FileReader(fileName));
        // The tree should start out with no nodes and gradually be populated with them
        tree = null;

        // As long as there are more lines in the file, process them...
        while (fileIn.hasNextLine())
        {
            // Set the next line in the file to a variable called line
            String line = fileIn.nextLine();

            // Split  line  into a title, director, duration, and type of media
            String[] values = line.split(" ");
            String title = values[0];
            String director = values[1];
            int duration = Integer.parseInt(values[2]);
            String type = values[3];
            // Create a new media object with these values
            Media media = new Media(title, director, duration, MediaType.valueOf(type));

            // If this is the first iteration of the while loop, then this will run
            if (tree == null)
            {
                // Assign a newly constructed BinarySearchTree as tree, with media as its root
                tree = new BinarySearchTree<Media>(media);
            }
            // If a tree already exists and has media,
            else
            {
                // then just add media as one of the values
                tree.insert(media);
            }
        }
        // close the scanner
        fileIn.close();

        // TODO delete
        System.out.println("DEBUG Tree : " + tree);
        return tree;
    }

    /** Print tree in its entirety
     *
     * @return ArrayList<Media>
     */
    public ArrayList<Media> displayTree()
    {
        // Declare a PrintWriter object for eventual file output
        PrintWriter fileOut = null;
        try
        {
            // Initialize fileOut to write to output.txt
            fileOut = new PrintWriter(new FileWriter("output.txt"));

            // Process the lines in media.txt into a BinarySearchTree called tree
            BinarySearchTree<Media> tree = addToTree();
            // Save the media, in order, to an ArrayList called list
            ArrayList<Media> list = tree.inOrderList();

            // Finally, write each of these to output.txt
            for (Media Media : list)
            {
                fileOut.write(Media.getTitle() + System.getProperty("line.separator"));
            }
            // And why not return list too.
            return list;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
                fileOut.close();
        }
        // If nothing previously returned, return null pointer
        return null;
    }
}