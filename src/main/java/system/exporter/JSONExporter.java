package system.exporter;

import system.issue.Issue;

public class JSONExporter<T, R> extends IssueExporter<T, R> {

    @Override
    public R export(Issue issue) {
        return super.export(issue);
    }
}
