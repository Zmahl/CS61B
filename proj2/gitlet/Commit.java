package gitlet;

// TODO: any imports you need here

import java.util.Date; // TODO: You'll likely use this in this class
import java.io.Serializable;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable{
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;

    /** The timestamp for the commit */
    private Date timestamp;

    /** Something with the files to track */
    // TODO: add variable for this here

    /** Has a pointer to the parent of the current commit */
    Commit parent;

    /** Makes the initial commit */
    public Commit() {
        this.message = "initial commit";
        this.timestamp = new Date(0); //Creates a date object for the epoch date
    }
    /* TODO: fill in the rest of this class. */

    /** Constructor for all other commits */
    public Commit(String message, Date timestamp, Commit parent){
        this.message = message;
        this.timestamp = timestamp;
        this.parent = parent;
    }

}
