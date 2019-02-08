package com.fundoo.dao;

import java.util.List;

import com.fundoo.models.Note;
import com.fundoo.models.User;

public interface NoteDao {
	//boolean saveNote(Note note);
     public void addNote(Note notes);
     public List<Note> getNotes(int userId);
     public Note getNoteById(int noteId);
     public int deletenote(int noteId, int userId);
     public int updatenote(Note note,int userId);
	
//	Note getNote(User user);
//
//	boolean updateNote(Note note);
//
//	List<Note> getAllNotes(User user);
//
//	Note getArchiveNote(User user);
//
//	boolean deleteNote(Note note);
//
//	Note getNoteId(String token,Integer noteId);
}
