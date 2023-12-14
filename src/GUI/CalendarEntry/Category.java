package GUI.CalendarEntry;

import java.awt.*;

public class Category {
    String categoryName;
    String path;
    Color color;

    public Category(String categoryName, String path, Color color){
        this.categoryName = categoryName;
        this.path = path;
        this.color = color;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getPath() {
        return path;
    }

    public Color getColor() {
        return color;
    }
}