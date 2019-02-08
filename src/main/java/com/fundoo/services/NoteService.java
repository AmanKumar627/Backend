package com.fundoo.services;

import java.util.List;


import com.fundoo.models.Note;

public interface NoteService {
//	boolean addNote(String token,Note note);
//
//	boolean editNote(Note note, Integer id);
//
//	Note getNote(String token);
//
//	List<Note> getAllNote(String token);
//
//	boolean archiveNote(String token,Note note);
//
//	List<Note> getArchiveNote(String token);
//
//	boolean updateArchive(Note note);
//
//	boolean trashUpdateNote(Note note);
//
//	List<Note> getTrashNote(String token);
//
//	boolean colorUpdateNote(Note note);
//
//	boolean deleteNote(Note note);
//
//	boolean updateNote(Note note);
//
//	int getNoteId(String token);
	
	public Note getNotebyId(int noteId);
	
	public Note addNote(Note notes, String token);

	public List<Note> getNotes(String token); 

	public int deleteNote(int noteId, String token); 

	public int updateNote(Note note, String token);

	public int archive(int noteId, String token);

	public int pin(int noteId, String token);

	public int trash(int noteId, String token);

	public int color(int noteId, String color, String token);

	public int reminder(int noteId, String reminder, String token);
}
	
	


