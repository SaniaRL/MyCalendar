package GUI;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static FileManager instance;

    private FileManager(){}

    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }

    public void writeToFile(String path, String content) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            bufferedWriter.write(content);
        }
    }

    public String readFromFile(String path) throws IOException {
        String content;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            content = bufferedReader.readLine();
        }
        return content;
    }

    public List<String> getDataByDate(List<String> paths, LocalDate date, String regex, int index) throws IOException {
        List<String> data = new ArrayList<>();
        for(String path : paths){
            String content = readFromFile(path);
            String[] fields = content.split(regex);
            if(fields[index].equals(String.valueOf(date))){
                data.add(content);
            }
        }
        return data;
    }
}
