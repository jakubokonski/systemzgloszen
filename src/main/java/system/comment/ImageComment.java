package system.comment;

import system.users.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class ImageComment extends Comment<File> {

//    Logger log = Logger

    public ImageComment(User creatorName, File content) {
        super(creatorName, content);
    }

    @Override
    public File getContent() {
//        File content = super.getContent();
//        try (FileReader fileReader = new FileReader(content)) {
//            char[] chars = new char[255];
//            int read = fileReader.read(chars, 0, chars.length);
//
//        } catch (FileNotFoundException fnfe) {
//            fnfe.printStackTrace();
//            throw new RuntimeException("Content unreadable");
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
        return content;
    }
}
