package com.fundoo.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoo.dao.NoteDao;
import com.fundoo.models.Note;
import com.fundoo.models.User;
import com.fundoo.utility.UserToken;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	NoteDao noteDao;
	@Autowired
	UserService userService;

	
	
	
	
	
	@Override
	public boolean addnote(String token, Note note) {
		// TODO Auto-generated method stub
		try {
			 int id=UserToken.tokenVerify(token);
			 
			  
			 User user=userService.getUser(id);
			 if(user!=null)
				{
					note.setUser(user);
					boolean check=noteDao.saveNote(note);
						if(check)
							return true;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		
		
	
	@Override
	public boolean deleteNote(int id, String token) {
		// TODO Auto-generated method stub
		try {
			int userId=UserToken.tokenVerify(token);
			Note note=noteDao.getNote(id);
			if(userId==note.getUser().getUserId())
			{
				System.out.println(note.getNoteId());
			boolean check=noteDao.deleteNote(note);
		
			return check;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return false;
	}

		
	
	@Override
	public boolean updateNote(Note note, String token) {
		// TODO Auto-generated method stub
		{
			try {
				int userId=UserToken.tokenVerify(token);
			    
				
				if(userId==note.getUser().getUserId())
				{
					boolean check=noteDao.updateNote(note);
					return check;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		
		}

		
		
		

	
	
}
	
	
	
	
	





	
		





	





	
//	@Override
//	public boolean addNote(String token, Note note) {
//		
//		try {
//			int id=UserToken.tokenVerify(token);
//			System.out.println("check1");
//			System.out.println("Entered id is" +id);
//			System.out.println("check2");
//			User user=userService.getUser(id);
//			if(user!=null)
//			{
//				note.setUser(user);
//				boolean check=noteDao.saveNote(note);
//				if(check)
//				{
//					return true;
//				}
//			}
//			
//		} catch (Exception e) {
//	
//		
//			e.printStackTrace();
//		}
//		
//		
//		
//		return false;
//	}
//
//	@Override
//	public boolean editNote(Note note, Integer id) {
//             
//		
//		
//		
//		return false;
//	}
//
//	@Override
//	public Note getNote(String token) {
//		try {
//			int id=UserToken.tokenVerify(token);
//			System.out.println("entered id is "+id);
//			User user=userService.getUser(id);
//			
//			
//			Note userNote=noteDao.getNote(user);
//			return userNote;
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
//
//	@Override
//	public List<Note> getAllNote(String token) {
//
//		try {
//			int id=UserToken.tokenVerify(token);
//			User user=userService.getUser(id);
//
//			List<Note> userNoteList=noteDao.getAllNotes(user);
//			System.out.println("userNote "+userNoteList);
//		
//		
//		
//		
//		
//		return userNoteList;
//	}
//		 catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		 }
//			return null;
//	}
//	@Override
//	public boolean archiveNote(String token, Note note) {
//		
//		
//		
//		
//		
//		return false;
//	}
//
//	@Override
//	public List<Note> getArchiveNote(String token) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		
//		return null;
//	}
//
//	@Override
//	public boolean updateArchive(Note note) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean trashUpdateNote(Note note) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<Note> getTrashNote(String token) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean colorUpdateNote(Note note) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean deleteNote(Note note) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean updateNote(Note note) {
//		noteDao.updateNote(note);
//		return true;
//		
//		
//		
//		
//	}
//
//	
//
//
//	@Override
//	public int getNoteId(String token) {
//		// TODO Auto-generated method stub
//		noteDao.getNoteId(token, null);
//		return 0;
//	}


