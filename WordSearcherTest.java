import junit.framework.TestCase;

import java.io.File;

public class WordSearcherTest extends TestCase {


    //Test Cases for
    //1. Directory not empty
    //2. Directory empty.
    public void testCountFilesInDirectory() {
        File folder = new File("C:\\Test\\TestDirectory");
        WordSearcher.countFilesInDirectory(folder);
        assertEquals(34,WordSearcher.files.size());
    }

    public void testNoFilesInDirectory() {
        File folder = new File("C:\\Test\\TestDirectory12");
        WordSearcher.countFilesInDirectory(folder);
        assertEquals(0,WordSearcher.files.size());
    }

    //Search returning files and percentage match for
    //1. When search keyword is in any of the files.
    //2. When search keyword is not in any file.
    public void testSearch() {
        File folder = new File("C:\\Test\\TestDirectory");
        WordSearcher.countFilesInDirectory(folder);
        WordSearcher.search("quick dog");
        WordSearcher.search("people");
    }
}