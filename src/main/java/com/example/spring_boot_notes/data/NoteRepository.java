package com.example.spring_boot_notes.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoteRepository {
    private List<Note> notes = new ArrayList<Note>();

    public List<Note> findAll() {
        return this.notes;
    }

    public void save(Note note){
        int index = 0;

        for(Note nt : notes){
            if(nt.getId().equals(note.getId())) {
                notes.set(index, note);
                return;
            }
            index++;
        }
        // Note is not in list, add to list.
        this.notes.add(note);
    }

    public Note findById(Long id){
        for(Note nt : notes){
            if(nt.getId().equals(id)){
                return nt;
            }
        }
        // Note with such ID doesn't exist
        return null;
    }

    public void deleteById(Long id){
        for(Note nt : notes){
            if(nt.getId().equals(id)){
                this.notes.remove(nt);
                return;
            }
        }
    }
}
