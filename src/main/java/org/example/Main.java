package org.example;

import java.io.IOException;
import java.util.List;
import org.example.model.Comment;
import org.example.service.FileWriter;
import org.example.service.Report;
import org.example.service.UpdateTime;
import org.example.service.UsernameMod;
import org.example.service.impl.FileWriterImpl;
import org.example.service.impl.ReportImpl;
import org.example.service.impl.UpdateTimeImpl;
import org.example.service.Parser;
import org.example.service.impl.JsonReaderImpl;
import org.example.service.impl.ParserImpl;
import org.example.service.impl.UsernameModImpl;
import org.json.JSONArray;

public class Main {
    private static final String PATH_OF_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        JsonReaderImpl reader = new JsonReaderImpl();
        JSONArray jsonArray = null;
        try {
            jsonArray = reader.readJsonFromUrl("https://dummyjson.com/comments");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parser parser = new ParserImpl();
        List<Comment> commentList = parser.parse(jsonArray);

        UpdateTime updateTime = new UpdateTimeImpl();
        updateTime.addTime(commentList);

        UsernameMod usernameMod = new UsernameModImpl();
        usernameMod.upFirstCharacter(commentList);


        Report reportMaker = new ReportImpl();
        String report = reportMaker.makeReport(commentList);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(PATH_OF_REPORT_FILE, report);
    }
}