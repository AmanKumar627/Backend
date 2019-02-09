package com.fundoo.dao;

import java.util.List;



import com.fundoo.models.Note;
import com.fundoo.models.User;

public interface NoteDao {
	boolean saveNote(Note note);

	Note getNote(int id);

	boolean updateNote(Note note);

	List<Note> getAllNotes(int userId);

	Note getArchiveNote(User user);

	boolean deleteNote(Note note);

	

}
