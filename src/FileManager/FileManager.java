package FileManager;

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

    public List<String> readFromFile(String path) {
        List<String> content = new ArrayList<>();
        String data;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            data = bufferedReader.readLine();
            content.add(data);
        }catch (IOException e){
            System.out.println("IOException::readFromFile");
        }
        return content;
    }

    public List<String> getDataByDate(List<String> paths, LocalDate date, String regex, int index) {
        List<String> data = new ArrayList<>();
        for(String path : paths){
            List<String> content = readFromFile(path);
            for(String string : content){
                String[] fields = string.split(regex);
                if(fields[index].equals(String.valueOf(date))){
                    data.add(string);
                    System.out.println("getDataByDate");
                }
            }
        }
        return data;
    }
}
