package com.example.spring_boot_notes.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_boot_notes.business.NoteService;
import com.example.spring_boot_notes.data.Note;

@Controller
public class AppController {
    
    @Autowired
    private NoteService service;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @RequestMapping(value = "/")
    public String viewHomePage(Model model){
        List<Note> listNotes = service.listAll();
        model.addAttribute("listNotes", listNotes);
        return "index";
    }

    @RequestMapping(value = "/new")
    public String showNewNotePage(Model model){
        Note note = new Note();
        model.addAttribute("note", note);
        return "new_note";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNote(@ModelAttribute("note") Note note){
        LocalDateTime now = LocalDateTime.now();
        note.setDate(dtf.format(now));
        service.save(note);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditNotePage(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_note");
        Note note = service.get(id);
        mav.addObject("note", note);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteNote(@PathVariable(name="id") Long id){
        this.service.delete(id);

        return "redirect:/";
    }

    
}
