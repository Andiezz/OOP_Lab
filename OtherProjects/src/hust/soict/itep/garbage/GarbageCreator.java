package hust.soict.itep.garbage;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;


public class GarbageCreator {
    String filename = "chrome.exe";
    byte[] inputBytes = { 0 };
    long startTime, endTime;

    public void garbageCreator() throws IOException {
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";

        // normally waste 5-10ms
//        for (byte b: inputBytes) {
//            outputString += (char)b;
//        }

        // normally waste 0
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b: inputBytes) {
            outputStringBuilder.append((char)b);
        }

        endTime = System.currentTimeMillis();
        System.out.println();
    }
}
