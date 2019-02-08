package com.fundoo.dao;

import java.util.List;



import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fundoo.models.Note;



@Repository
public class NoteDaoImpl implements NoteDao{

	
	@Autowired
	SessionFactory factory;

	@Override
	public void addNote(Note note) {
		// TODO Auto-generated method stub
		factory.getCurrentSession().save(note);
		
		
		
		
	}

	@Override
	public List<Note> getNotes(int userId) {
		// TODO Auto-generated method stub
		System.out.println(userId );
		String hql= "FROM Note n WHERE n.user.userId=" + userId;
        @SuppressWarnings("rawtypes")
		Query query = factory.getCurrentSession().createQuery(hql);
        
        @SuppressWarnings("unchecked")
		List<Note> notelist= query.list();
        
		return notelist;
	}

	@Override
	public Note getNoteById(int noteId) {
		// TODO Auto-generated method stub
		 String hql= "FROM Note WHERE noteId=" + noteId;
		 @SuppressWarnings("rawtypes")
		 Query query= factory.getCurrentSession().createQuery(hql);
		 Note note= (Note) query.uniqueResult();
		
		return note;
	}

	@Override
	public int deletenote(int noteId, int userId) {
		// TODO Auto-generated method stub
		int result=0;
		
		String hql= "DELETE FROM Note WHERE noteId = :noteId userId = :userId";
		@SuppressWarnings("rawtypes")
		Query query=factory.getCurrentSession().createQuery(hql);
		query.setParameter("noteId", noteId);
		query.setParameter("userId", userId);
		result=query.executeUpdate();
		return result;
	}

	@Override
	public int updatenote(Note note) {
		// TODO Auto-generated method stub

	   factory.getCurrentSession().update(note);

		return note.getNoteId();
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
