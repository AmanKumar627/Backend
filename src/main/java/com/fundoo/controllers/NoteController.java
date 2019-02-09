package com.fundoo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo.models.Note;
import com.fundoo.models.Response;
import com.fundoo.services.NoteService;
import com.fundoo.utility.UserToken;


@RestController
public class NoteController {
    
	Response response;
	@Autowired
	NoteService noteService;

    
  
   @RequestMapping(value="/addNote", method=RequestMethod.POST )
   public ResponseEntity<Response>addNote(@RequestBody Note note, @RequestHeader("token") String token){
	   
	  try {
		   
			noteService.addnote(token, note);
			
			response=new Response();
			response.setStatus("note added successfully");
			return new ResponseEntity<Response>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  
 }
  

  
   
//   @RequestMapping(value="getNotes",method=RequestMethod.GET)
//   public ResponseEntity<List<Note>> getNotes(@RequestHeader("token") String token){
//		  
//	try {	
//	     List<Note> list= noteService.getNotes(token);
//	  
//	      return new ResponseEntity<List<Note>>(list, HttpStatus.OK);
//	  
//	} catch(Exception e) {
//		  
//		  e.printStackTrace();
//
//			return new ResponseEntity<List<Note>>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//   
//   
   @RequestMapping(value="note/delete/{noteId}",method=RequestMethod.DELETE)
   public ResponseEntity<Response> deleteNotes(@PathVariable  int noteId,@RequestHeader String token){
	   
	  try { 
	   
	   noteService.deleteNote(noteId, token);
	   
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  
	  
	      return new ResponseEntity<Response>(HttpStatus.OK);  
	   
	  }
	return null;
   }
   }
         
//   @RequestMapping(value="note/isArchive/{noteId}")
//   public ResponseEntity<Response> archiveNotes(@PathVariable int noteId,@RequestHeader("token") String token){
//   {
//       try {
//    	   
//    	   noteService.archive(noteId, token);
//    	   
//    	   response=new Response();
//    	   response.setStatus("note archives successfully");
//    	   
//       }catch(Exception e) {
// 		  e.printStackTrace();
// 	  }
// 	  
// 	      return new ResponseEntity<Response>(HttpStatus.OK);
//       }
//    
//   }
//   
//   
//   
//   
//   
//   
//} 
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
 
	  
  

//	@RequestMapping(value="/addNote/",method=RequestMethod.POST) 
//	public ResponseEntity<Response> addNoteToUser(@RequestBody Note note,String token)
//	{
//		
//	
//		System.out.println("check "+note);
//
//		System.out.println("entered token is "+token);
//		noteService.addNote(token,note);
//		
//		response=new Response();
//
//		response.setStatusCode(166);
//		response.setStatus("note added successfully");
//		return new ResponseEntity<Response>(response,HttpStatus.OK);
//	}
//	
//	@RequestMapping(value="/updateNote",method=RequestMethod.POST)
//	public ResponseEntity<Response> editNote(@RequestBody Note note)
//	{
//		boolean check=noteService.updateNote(note);
//		response=new Response();
//		if(check)
//		{
//			response.setStatusCode(166);
//			response.setStatus("note updated successfully");
//			return new ResponseEntity<Response>(response,HttpStatus.OK);
//		}
//		response.setStatusCode(0);
//		response.setStatus("note is not present");
//		return new ResponseEntity<Response>(response,HttpStatus.NOT_FOUND);
//	}
//	
//	@RequestMapping(value="/getAllNote",method=RequestMethod.GET)
//	public ResponseEntity<List<Note>> getAllNote(@RequestHeader("token") String token)
//	{	
//		List<Note> noteList=noteService.getAllNote(token);	
//		System.out.println("return Note "+noteList);
//		return new ResponseEntity<List<Note>>(noteList,HttpStatus.OK);
//	}
//	@RequestMapping(value="/archiveNote",method=RequestMethod.POST)
//	public ResponseEntity<Response> archiveNote(@RequestBody Note note,@RequestHeader("token") String token)
//	{
//		System.out.println(token);
//		noteService.archiveNote(token,note);
//		response=new Response();
//		response.setStatusCode(200);
//		response.setStatus("archive successfully");
//		System.out.println("conroller");
//		return new ResponseEntity<Response>(response,HttpStatus.OK);
//	}
//     
//	@RequestMapping(value="/getArchiveNote",method=RequestMethod.GET)
//	public ResponseEntity<List<Note>> getArchiveNote(@RequestHeader("token")String token)
//	{
//		
//		List<Note> userNote=noteService.getArchiveNote(token);
//		response=new Response();
//		response.setStatusCode(166);
//		response.setStatus("note get successfully");
//		System.out.println("before send "+userNote);
//		return new ResponseEntity<List<Note>>(userNote,HttpStatus.OK);
//	}
//	
//	
//	
//	@RequestMapping(value="note/getArchiveNote/noteId",method=RequestMethod.GET)
//	public ResponseEntity<?> getNoteId(@RequestHeader("Token")String token,PathVariable Integer noteId ) {
//		int userNote=noteService.getNoteId(token,noteId);
//		{
//			int NodeId=noteService.getNoteId(token);
//		}
//		return new ResponseEntity<>(userNote,HttpStatus.OK);
//		
//		
//		
//	}
//	
//	@RequestMapping(value="/updateArchiveNote" , method=RequestMethod.POST)
//	public ResponseEntity<Response> updateArchive(@RequestBody Note note)
//	{
//		System.out.println("archive "+note.isArchive());
//		noteService.updateArchive(note);
//		response=new Response();
//		response.setStatusCode(166);
//		response.setStatus("note updated successfully");
//		return new ResponseEntity<Response>(response,HttpStatus.OK);
//	}
//	
//	 
//	
//}
//  

		
	
	
	

