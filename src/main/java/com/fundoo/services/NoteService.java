package com.fundoo.services;

import java.util.List;

import com.fundoo.models.Note;

public interface NoteService {
	boolean addNote(String token,Note note);

	boolean editNote(Note note, Integer id);

	Note getNote(String token);

	List<Note> getAllNote(String token);

	boolean archiveNote(String token,Note note);

	List<Note> getArchiveNote(String token);

	boolean updateArchive(Note note);

	boolean trashUpdateNote(Note note);

	List<Note> getTrashNote(String token);

	boolean colorUpdateNote(Note note);

	boolean deleteNote(Note note);

	boolean updateNote(Note note);

}
