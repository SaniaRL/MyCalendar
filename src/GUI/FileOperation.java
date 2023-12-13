package GUI;

public interface FileOperation {
    FileManager fileManager = FileManager.getInstance();
    void fileOperations(FileOperationType fileOperationType);
}
