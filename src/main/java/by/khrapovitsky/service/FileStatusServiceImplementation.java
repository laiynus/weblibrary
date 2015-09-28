package by.khrapovitsky.service;

import by.khrapovitsky.dao.FileStatusDAO;
import by.khrapovitsky.model.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FileStatusServiceImplementation implements FileStatusService{

    @Autowired
    FileStatusDAO fileStatusDAO;

    @Override
    public void create(FileStatus fileStatus) {
        fileStatusDAO.create(fileStatus);
    }

    @Override
    public FileStatus read(Integer fileStatusId) {
        return fileStatusDAO.read(fileStatusId);
    }

    @Override
    public void update(FileStatus fileStatus) {
        fileStatusDAO.update(fileStatus);
    }

    @Override
    public void delete(FileStatus fileStatus) {
        fileStatusDAO.delete(fileStatus);
    }

    @Override
    public List getAllFileStatuses() {
        return fileStatusDAO.getAllFileStatuses();
    }
}
