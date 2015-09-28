package by.khrapovitsky.dao;

import by.khrapovitsky.model.FileStatus;

import java.util.List;

public interface FileStatusDAO {
    void create(FileStatus fileStatus);
    FileStatus read(Integer fileStatusId);
    void update(FileStatus fileStatus);
    void delete(FileStatus fileStatus);
    List getAllFileStatuses();
}
