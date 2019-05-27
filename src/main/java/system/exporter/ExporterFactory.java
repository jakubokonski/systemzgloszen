package system.exporter;

public class ExporterFactory {

    public static DefaultFileIssueExporter getExporter(short type) {
        switch (type) {
            case 0:
                return JsonFileIssueExporter.getInstance();
            case 1:
                return DefaultFileIssueExporter.getInstance();
            default:
                return DefaultFileIssueExporter.getInstance();
        }
    }

}
