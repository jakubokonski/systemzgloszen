package system.exporter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import system.issue.Issue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFileIssueExporter extends DefaultFileIssueExporter{

    public static class Singleton {
        private static final JsonFileIssueExporter INSTANCE = new JsonFileIssueExporter();
    }

    public static JsonFileIssueExporter getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public File export(List<Issue> objectToExport) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(objectToExport);
            File file = new File("C:\\TEST\\json.json");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(s);
            writer.close();
            return file;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Can't create file");
    }
}
