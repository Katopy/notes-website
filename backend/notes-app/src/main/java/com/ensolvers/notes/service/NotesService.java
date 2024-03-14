package com.ensolvers.notes.service;

import com.ensolvers.notes.model.CategoriesEntity;
import com.ensolvers.notes.model.NotesEntity;
import com.ensolvers.notes.repository.CategoryRepository;
import com.ensolvers.notes.repository.NotesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@ApplicationScoped
@Transactional
public class NotesService {

    @Inject
    public NotesRepository repo;

    @Inject
    public CategoryRepository repoCategory;

    public List<NotesEntity> getActiveNotes() {
        return repo.listActive();
    }

    //List archived notes
    public List<NotesEntity> getArchivedNotes() {
        return repo.findByArchived((byte) 1);
    }

    //Creating notes
    public NotesEntity addNote(NotesEntity note) {
        repo.persist(note);
        return note;
    }


    public String deleteNote(Long note_id) {
        if (repo.deleteById(note_id)) {
            return "Note was deleted.";

        } else {
            return "Error deleting note.";
        }

    }

    public NotesEntity noteById(Long note_id) {
        var note = repo.findById(note_id);
        if (note != null) {
            return note;
        }
        throw new NoSuchElementException("Note not found.");
    }

    public NotesEntity update(Long note_id, NotesEntity note) {
        var newNote = repo.findById(note_id);
        if (newNote != null) {
            newNote.setTitle(note.getTitle());
            newNote.setContent(note.getContent());
            newNote.setArchived(note.getArchived());
            repo.persist(newNote);
            return newNote;
        }
        throw new NoSuchElementException("Note could not be updated.");
    }

    public NotesEntity partialUpdate(Long note_id, NotesEntity note) {
        var newUpdate = repo.findById(note_id);

        if (newUpdate != null) {
            if (note.getTitle() != null) {
                newUpdate.setTitle(note.getTitle());
            }
            if (note.getContent() != null) {
                newUpdate.setContent(note.getContent());
            }
            if (note.getArchived() != null) {
                newUpdate.setArchived(note.getArchived());
            }

            repo.persist(newUpdate);
            return newUpdate;
        }

        throw new NoSuchElementException("It could not be updated");
    }

    //Category methods

    public NotesEntity addCategoryToNote(Long note_id, Long category_id){
        NotesEntity note = repo.findById(note_id);
        if(note == null){
            throw new NoSuchElementException("Note not found.");
        }
        CategoriesEntity category = repoCategory.findById(category_id);
        if (category == null) {
            throw new NoSuchElementException("Category not found.");
        }
        note.getCategories().add(category);

        repo.persist(note);

        return note;

    }


}
