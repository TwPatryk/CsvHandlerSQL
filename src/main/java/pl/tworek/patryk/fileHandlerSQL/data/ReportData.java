package pl.tworek.patryk.fileHandlerSQL.data;

import pl.tworek.patryk.fileHandlerSQL.configurations.AppConfiguration;
import pl.tworek.patryk.fileHandlerSQL.model.Report;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReportData {

    public static Report readAndReport(String csvFile) {
        String delimiter = ",";
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            int supply = 0;
            int buy = 0;
            int result = 0;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr[0].equals("supply")) {
                    supply += Integer.valueOf(arr[1]);
                } else {
                    buy += Integer.valueOf(arr[1]);
                }
                result = supply - buy;
            }
            br.close();
            Report reportObj = new Report(supply, buy, result);
            return reportObj;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createReport(Report result) {
        try {
            String SQL = "INSERT INTO tresult (buy, supply, result) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = AppConfiguration.connection().prepareStatement(SQL);
            preparedStatement.setInt(1, result.getBuy());
            preparedStatement.setInt(2, result.getSupply());
            preparedStatement.setInt(3, result.getResult());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
