package by.khrapovitsky.dao;

import by.khrapovitsky.model.Bookmark;

import java.util.List;

public interface BookMarkDAO {
    void create(Bookmark bookmark);
    Bookmark read(String bookmarkId);
    void update(Bookmark bookmark);
    void delete(Bookmark bookmark);
    List getAllBookMarks();
}
