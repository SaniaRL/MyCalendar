package GUI.CalendarEntry;

import FileManager.FileManager;
import FileManager.FileOperation;

import java.util.ArrayList;
import java.util.List;

public class CategoryList implements FileOperation {
    String path;
    List<Category> categoryList;

    public CategoryList(){
        path = "Persistence/Categories.txt";
        categoryList = new ArrayList<>();
    }

    public void getCategoriesFromFile(){
        List<String> content = fileManager.readFromFile(path);
    }
}
