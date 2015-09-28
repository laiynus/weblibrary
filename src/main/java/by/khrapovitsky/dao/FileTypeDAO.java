package by.khrapovitsky.dao;

import by.khrapovitsky.model.FileType;

import java.util.List;

public interface FileTypeDAO {
    void create(FileType fileType);
    FileType read(String fileType);
    void update(FileType fileType);
    void delete(FileType fileType);
    List getAllFileTypes();
}
