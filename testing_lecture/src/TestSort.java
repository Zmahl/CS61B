

public class TestSort {
    public static void testSort() {
        //Create a random array of strings which will be used as a test
        String[] input = {"i", "have", "an", "egg"};
        //Create our "expected" value to use for checking correctness of function for the test
        String[] expected = {"an", "egg", "have", "i"};
        //Call our function
        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(input, expected);
    }

    /** Test the sort.findSmallest method. */
    public static void testFindSmallest(String[] x){
        //Create a random array of strings which will be used as a test
        String[] input = {"i", "have", "an", "egg"};
        //Create our "expected" value to use for checking correctness of function for the test
        String expected = "an";
        //Call our function
        String actual = Sort.findSmallest(input);
        //Test the output of the sort function on the expected value that we determined
        org.junit.Assert.assertEquals(expected, actual);
    }

    public static void main(String args[]){
        testSort();

    }
}
