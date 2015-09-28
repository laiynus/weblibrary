package by.khrapovitsky.service;

import by.khrapovitsky.dao.FileTypeDAO;
import by.khrapovitsky.model.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FileTypeServiceImplementation implements FileTypeService{

    @Autowired
    FileTypeDAO fileTypeDAO;

    @Override
    public void create(FileType fileType) {
        fileTypeDAO.create(fileType);
    }

    @Override
    public FileType read(String fileType) {
        return fileTypeDAO.read(fileType);
    }

    @Override
    public void update(FileType fileType) {
        fileTypeDAO.update(fileType);
    }

    @Override
    public void delete(FileType fileType) {
        fileTypeDAO.delete(fileType);
    }

    @Override
    public List getAllFileTypes() {
        return fileTypeDAO.getAllFileTypes();
    }
}
