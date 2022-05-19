package pl.tworek.patryk.fileHandlerSQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.tworek.patryk.fileHandlerSQL.data.ReportData;
import pl.tworek.patryk.fileHandlerSQL.model.Report;


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        String csvFile = "d:\\Sopra-Steria_File_Handling\\ItemX.csv";

        ReportData reportData = new ReportData();
        Report report = reportData.readAndReport(csvFile);
        reportData.createReport(report);
    }
}
