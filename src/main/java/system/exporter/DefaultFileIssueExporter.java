package system.exporter;

import system.issue.Issue;

import java.io.*;
import java.util.List;

public class DefaultFileIssueExporter extends IssueAbstractExporter<File> {

    private static class Singleton {
        private static final DefaultFileIssueExporter INSTANCE =
                new DefaultFileIssueExporter();
    }

    protected DefaultFileIssueExporter() {

    }

    public static DefaultFileIssueExporter getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public File export(List<Issue> objectToExport) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(objectToExport);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            File file = new File("C:\\TEST\\file");
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(yourBytes);
            outputStream.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
            throw new RuntimeException("Can't create file");
    }
}
