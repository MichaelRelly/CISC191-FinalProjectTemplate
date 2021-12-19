package edu.sdccd.cisc191.template;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ImprovedVideoCollection{
    private LinkedList<Video>[] database;
    private LinkedList<Video> orderedList;
    private int size;
    private int capacity;

    private void loadVideos() {
        VideoCollection a = new VideoCollection("movies.txt");
        ArrayList<Video> videos = a.displayTree();
        for (Video currentVideo : videos) {
            add(currentVideo);
        }
    }

    public ImprovedVideoCollection() {
        this.capacity = 10;
        this.size = 0;
        this.database = new LinkedList[this.capacity];
        this.orderedList = new LinkedList();
        loadVideos();
    }

    /**
     * Constructor to create a ImprovedVideoCollection object
     *
     * @param capacity Instantiates this.capacity to capacity.
     */
    public ImprovedVideoCollection(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.database = new LinkedList[this.capacity];
        this.orderedList = new LinkedList();
        loadVideos();
    }

    /**
     * Creates a string of the videos in the database based on the order they were added
     *
     * @return a string of the video in the order they were added
     */
    public String filter() {
        String retString = "";
        for (Video video : this.orderedList) {
            retString += "name: "
                    + video.getTitle() + "\n" + " Director: " + video.getDirector() + "]\n";
        }
        return retString;
    }

    /**
     * Adds a videoTitle-videoDirector pair object to the hash table.
     *
     * @param video video object
     */
    public boolean add(Video video) {
        if (video == null) {
            return false;
        }
        int index = hash(video.getTitle());
        this.size++;
        if (this.database[index] == null) {
            this.database[index] = new LinkedList();
            this.database[index].addFirst(video);
            if (this.getLoadCapacity() >= 0.80) {
                expand();
            }
            addToList(video);
            return true;
        } else if ((this.database[index] != null) && (!videoExists(video.getTitle(), this.database[index]))) {
            this.database[index].add(video);
            if (this.getLoadCapacity() >= 0.80) {
                expand();
            }
            addToList(video);
            return true;
        }
        this.size--;
        return false;
    }

    /**
     * Retrieves a videoTitle-videoDirector pair object from the hash table and return the name
     *
     * @param videoTitle the object's videoTitle that will be return if it exists
     * @throws throws a NoSuchElementException if the is null or doesn't exist
     * @return returns the videoTitle of the object whose videoTitle matches
     */
    public String search(String videoTitle) throws NoSuchElementException {
        if (videoTitle == null) {
            throw new NoSuchElementException("videoTitle cannot be null");
        }
        int index = hash(videoTitle);
        if (this.database[index] != null) {
            return getTitleHelper(videoTitle, this.database[index]);
        }
        throw new NoSuchElementException("No such element exists");
    }

    private void addToList(Video newVideo) {
        if (this.orderedList == null) {
            this.orderedList.addFirst(newVideo);
        } else if (!videoExists((String) newVideo.getTitle(), this.orderedList)) {
            this.orderedList.add(newVideo);
        }
    }

    /**
     * Helper method to look for a video name
     *
     * @param videoTitle the videoTitle to look for
     * @param list      the linkedlist to look in
     * @return returns the videoDirector from the videoTitle if found, otherwise throws a
     *         NoSuchElementException
     */
    private String getTitleHelper(String videoTitle, LinkedList<Video> list)
            throws NoSuchElementException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(videoTitle)) {
                return (String) list.get(i).getTitle();
            }
        }
        throw new NoSuchElementException("No such element exists");
    }

    private String getDirectorHelper(String videoTitle, LinkedList<Video> list)
            throws NoSuchElementException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().toString().toLowerCase().equals(videoTitle.toString().toLowerCase())) {
                return (String) list.get(i).getDirector();
            }
        }
        throw new NoSuchElementException("No such element exists");
    }

    /**
     * Helper method to check if a videoTitle exists.
     *
     * @param videoTitle  videoTitle to check for
     * @param linkedList linkedlist to check in
     * @return returns true if the videoTitle is found, false otherwise
     */
    private boolean videoExists(String videoTitle, LinkedList<Video> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).getTitle().toString().toLowerCase().equals(videoTitle.toString().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the load capacity to determine if the table should expand or not.
     *
     * @return returns the load capacity as a float.
     */
    private float getLoadCapacity() {
        return ((float) this.size) / this.capacity;
    }

    /**
     * Expands the hash table, doubling its current capacity and rehashes all objects within it.
     */
    private void expand() {
        LinkedList<Video>[] oldDatabase = this.database;
        this.capacity *= 2;
        this.size = 0;
        this.database = new LinkedList[this.capacity];
        for (int i = 0; i < oldDatabase.length; i++) {
            if (oldDatabase[i] != null) {
                for (int j = 0; j < oldDatabase[i].size(); j++) {
                    Video video = oldDatabase[i].get(j);
                    add(video);
                }
            }
        }
    }

    /**
     * Gets the hash index of a videoTitle
     *
     * @param videoTitle videoTitle to obtain the hash videoDirector from
     * @return returns the hash index
     */
    private int hash(String videoTitle) {
        videoTitle =  videoTitle.toString().toLowerCase();
        return Math.abs(videoTitle.hashCode() % this.capacity);
    }

    /**
     * Creates and insert a video into the database with the specified video
     *
     * @param video name of the video
     * @return returns true if successfully added, false otherwise
     */
    public boolean put(Video video) {
        return add(video);
    }

    /**
     * Gets and returns the Director of a move. To search for a video, use search("videoTitle")
     */
    public String get(String videoTitle) throws NoSuchElementException {
        if (videoTitle == null) {
            throw new NoSuchElementException("videoTitle cannot be null");
        }
        int index = hash(videoTitle);
        if (this.database[index] != null) {
            return getDirectorHelper(videoTitle, this.database[index]);
        }
        throw new NoSuchElementException("No such element exists");
    }

    /**
     * Gets the size of the database
     *
     * @return returns the size
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks whether a video is in the database or not
     *
     * @param videoTitle video to look for
     * @return returns true if video exists, false otherwise
     */
    public boolean containsKey(String videoTitle) {
        if (videoTitle == null) {
            return false;
        }
        int index = hash(videoTitle);
        if (this.database[index] != null) {
            return videoExists(videoTitle, this.database[index]);
        }
        return false;
    }

    /**
     * Removes the video from the hashtable and in the ordered list
     *
     * @param videoTitle name of the video
     * @return returns the eidr of the video removed
     */
    public String remove(String videoTitle) {
        if (!containsKey(videoTitle)) {
            return null;
        }
        int index = hash(videoTitle);
        for (int i = 0; i < this.database[index].size(); i++) {
            if (this.database[index].get(i).getTitle().equals(videoTitle)) {
                String returnVal = (String) this.database[index].get(i).getDirector();
                removeFromList(this.database[index].get(i));
                this.database[index].remove(i);
                this.size--;

                return returnVal;
            }
        }
        return null;
    }

    /**
     * Removes a video from the ordered list
     *
     * @param Video video to remove
     */
    private void removeFromList(Video Video) {
        this.orderedList.removeFirstOccurrence(Video);
    }

    /**
     * Clears everything in the database and ordered list
     */
    public void clear() {
        this.database = new LinkedList[this.capacity];
        this.orderedList = new LinkedList();
        this.size = 0;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
