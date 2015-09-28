package by.khrapovitsky.service;


import by.khrapovitsky.model.FileType;

import java.util.List;

public interface FileTypeService {
    void create(FileType fileType);
    FileType read(String fileType);
    void update(FileType fileType);
    void delete(FileType fileType);
    List getAllFileTypes();
}
