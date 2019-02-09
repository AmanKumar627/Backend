package com.fundoo.dao;

import java.util.List;



import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fundoo.models.Note;
import com.fundoo.models.User;



@Repository
public class NoteDaoImpl implements NoteDao{

	
	@Autowired
	SessionFactory factory;

	@Override
	public boolean saveNote(Note note) {
		// TODO Auto-generated method stub
		if(factory!=null)
		{
			factory.getCurrentSession().save(note);
			System.out.println("after save "+note);

			System.out.println("note added successfull");
			return true;
		}
	//factory.getCurrentSession().save(user);
	return false;

	}
		
		
		
	

	@Override
	public Note getNote(int id) {
		// TODO Auto-generated method stub
		 Note note=(Note) factory.getCurrentSession().get(Note.class,id);
		 return note;
		
		
	}

	@Override
	public boolean updateNote(Note note) {
		// TODO Auto-generated method stub
		if(factory!=null)
		{
			factory.getCurrentSession().update(note);
			System.out.println("update  " +note);
			System.out.println("Note updated successfully");
			return true;
		}
		
	
		
		return false;
	}

//	@Override
//	public List<Note> getAllNotes(int userId) {
//		// TODO Auto-generated method stub
//		if(factory!=null)
//		{	
//		
//			  @SuppressWarnings("unchecked")
//			List<Note> noteList =factory. getCurrentSession().createCriteria(Note.class).createCriteria("user").add(Restrictions.eq("userId", userId)).list();
//			  System.out.println("get all notes call finish");
//			  return noteList;
//		}
//		return null;
//	}
//		
//		
	

	@Override
	public Note getArchiveNote(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNote(Note note) {
		// TODO Auto-generated method stub
		if(factory!=null)
		{
			System.out.println(note);
			factory.getCurrentSession().delete(note);
			return true;
		}
		return false;
	}





	@Override
	public List<Note> getAllNotes(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

		

	
}
	
	
	
	
	
	
	
	
	
//	
//	@Override
//	public boolean saveNote(Note note) {
//		if(factory!=null)
//		{
//		
//			factory.getCurrentSession().save(note);
//			System.out.println("after save "+note);
//
//			System.out.println("note added successfull");
//			return true;
//
//		}
//		
//		return false;
//	}
//
//	@Override
//	public Note getNote(User user) {
//		System.out.println(user.getUserId());
//		Note userNote=(Note) factory.getCurrentSession().get(Note.class,user.getUserId());
//		System.out.println("user new note "+userNote);
//		return userNote;
//	}
//		
//		
//		
//		
//
//	
//
//	@Override
//	public boolean updateNote(Note note) {
//		if(factory!=null)
//		{
//			factory.getCurrentSession().update(note);
//			System.out.println("delete " +note);
//			System.out.println("Note updated successfully");
//			return true;
//		}
//		return false;
//	}
//		
//		
//		
//	
//
//	@Override
//	public List<Note> getAllNotes(User user) {
//		if(factory!=null)
//		{	
//			System.out.println(user.getUserId());
//			  @SuppressWarnings({ "unchecked", "deprecation" })
//			List<Note> noteList =factory. getCurrentSession().createCriteria(Note.class).createCriteria("user").add(Restrictions.eq("userId", user.getUserId())).list();
//			  System.out.println("get all notes call finish");
//			  return noteList;
//		}
//		
//	
//		
//		
//		
//		return null;
//	}
//
//	@Override
//	public Note getArchiveNote(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean deleteNote(Note note) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public Note getNoteId(Note note,int  tokenId) {
//		// TODO Auto-generated method stub
//		System.out.println(note.getNoteId());
//	        int noteid=note.getNoteId();
//    	    if(noteid==tokenId)
//    	    
//		     return note;
//    	    
//			return null;
//	}
//}
//			
//	
//
//	
