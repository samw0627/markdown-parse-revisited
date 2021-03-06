import static org.junit.Assert.*;

import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void getLinksTestFile() throws IOException{
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks("file/Users/nonsensical_sam/Documents/GitHub/markdown-parse-revisited/test-file.md"));
    }
    @Test
    public void getLinksTestFile2() throws IOException{
        Path fileName = Path.of("no-link.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinksBracketFile() throws IOException{
        Path fileName = Path.of("bracket-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
    @Test
    public void getLinksEmptyFile() throws IOException{
        Path fileName = Path.of("imagelink.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinksnew1() throws IOException{
        Path fileName = Path.of("new1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("url.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }
}