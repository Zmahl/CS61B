package gitlet;

import java.io.File;
import static gitlet.Utils.*;
import java.io.IOException;
import java.util.Date;


// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */

    /**
     * TODO: create initial commit
     * TODO: create the .gitlet directory
     * TODO: create all the rest of the things in gitlet
     * TODO: Fail if .gitlet alread exists in the current directory
     */
    public static void initializeRepo(){
        GITLET_DIR.mkdir();
        Commit initialCommit = new Commit();
        File initialCommitFile = join(GITLET_DIR, "initialCommit");
        writeObject(initialCommitFile, initialCommit);
    }

    public static void add(File f) {

    }

    public static void makeBlob() {

    }

    public static void newCommit(String message, Date timestamp) {

    }
}
