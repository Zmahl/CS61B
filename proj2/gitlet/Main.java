package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: handle the `init` command
                Repository.initializeRepo();
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                break;
            // TODO: FILL THE REST IN
            case "checkout":
                // TODO handle the commit command
                break;
            case "log":
                // TODO handle the log command
                break;
            case "rm":
                // TODO handle the rm command
                break;
            case "global-log":
                // TODO handle the global-log command
                break;
            case "find":
                // TODO handle the find command
                break;
            case "status":
                // TODO handle the status command
                break;
            case "branch":
                // TODO handle the branch command
                break;
            case "rm-branch":
                // TODO handle the rm-branch command
                break;
            case "reset":
                // TODO handle the reset command
                break;
            case "merge":
                // TODO handle the merge command
                break;
        }
    }
}
