package com.fundoo.services;

import java.util.List;


import com.fundoo.models.Note;

public interface NoteService {

	//public boolean saveNote(Note note);
	boolean addnote(String token, Note note);
	boolean deleteNote(int id,String token);

	boolean updateNote(Note note,String token);
	
//	public Note getNotebyId(int noteId);
//	
//	public Note addNote(Note notes, String token);
//
//	public List<Note> getNotes(String token); 
//
//	public int deleteNote(int noteId, String token); 
//
//	public int updateNote(Note note, String token);
//
//	public int archive(int noteId, String token);
//
//	public int pin(int noteId, String token);
//
//	public int trash(int noteId, String token);
//
//	public int color(int noteId, String color, String token);
//
//	public int reminder(int noteId, String reminder, String token);
}
	
	


