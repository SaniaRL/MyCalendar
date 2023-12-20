package FileManager;

public interface FileOperation {
    FileManager fileManager = FileManager.getInstance();
    String regex = ";;";
    void fileOperations(FileOperationType fileOperationType);
}
