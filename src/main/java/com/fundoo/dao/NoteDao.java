package com.fundoo.dao;

import java.util.List;

import com.fundoo.models.Note;
import com.fundoo.models.User;

public interface NoteDao {
	boolean saveNote(Note note);

	Note getNote(User user);

	boolean updateNote(Note note);

	List<Note> getAllNotes(User user);

	Note getArchiveNote(User user);

	boolean deleteNote(Note note);
}
