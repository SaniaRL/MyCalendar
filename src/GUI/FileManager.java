package GUI;

import java.io.*;

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
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write(content);

        }
    }

    public String readFromFile(String path) throws IOException {
        String content = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            content = bufferedReader.readLine();
        }

        return content;
    }

}
