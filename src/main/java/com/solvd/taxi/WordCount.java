package com.solvd.taxi;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/article.txt");
        File outputFile = new File("src/main/resources/wordCount.txt");

        String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
        String[] wordsToCount = {"I", "day", "give"};
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : wordsToCount) {
            int count = StringUtils.countMatches(content, word);
            wordCounts.put(word, count);
        }

        StringBuilder outputContent = new StringBuilder();
        wordCounts.forEach((word, count) -> outputContent.append(word).append(" = ").append(count).append("\n"));

        FileUtils.writeStringToFile(outputFile, outputContent.toString(), StandardCharsets.UTF_8);
    }
}