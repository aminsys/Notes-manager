package com.example.spring_boot_notes.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_notes.data.Note;
import com.example.spring_boot_notes.data.NoteRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repo;

    public List<Note> listAll(){
        return this.repo.findAll();
    }

    public void save(Note note){
        this.repo.save(note);
    }

    public Note get(Long id){
        return this.repo.findById(id);
    }

    public void delete(Long id){
        this.repo.deleteById(id);
    }
    
}
