import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

    class Lab_12_File_Away {
    public static void main(String[] args) {
        // Create a file chooser dialog to get the file from the user
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                wordCount += countWords(line);
                charCount += line.length();
            }

            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWords(String line) {
        String[] words = line.split("\\s+");
        return words.length;
    }
}