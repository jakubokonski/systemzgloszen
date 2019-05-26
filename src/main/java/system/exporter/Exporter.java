package system.exporter;

public interface Exporter<T, R> {

    T export(R objectToExport);
}
