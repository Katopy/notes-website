package com.ensolvers.notes.controller;

import com.ensolvers.notes.model.NotesEntity;
import com.ensolvers.notes.service.NotesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/notes")
public class NotesController {

    @Inject
    public NotesService service;

    @GET
    public List<NotesEntity> getActiveNotes() {
        return service.getActiveNotes();
    }

    @GET
    @Path("/archived")
    public List<NotesEntity>  getArchivedNotes(){
        return service.getArchivedNotes();
    }

    @POST
    public NotesEntity addNote(NotesEntity note) {
        return service.addNote(note);

    }
    @GET
    @Path("{note_id}")
    public NotesEntity noteById(@PathParam("note_id") Long note_id) {
        return service.noteById(note_id);
    }

    @DELETE
    @Path("{note_id}")
    public String deleteNote(@PathParam("note_id") Long note_id) {
        return service.deleteNote(note_id);
    }

    @PUT
    @Path("{note_id}")
    public NotesEntity update(@PathParam("note_id") Long note_id, NotesEntity note) {
        return service.update(note_id, note);
    }

    @PATCH
    @Path("{note_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public NotesEntity partialUpdate(@PathParam("note_id") Long note_id, NotesEntity note) {
        return service.partialUpdate(note_id, note);
    }

    @POST
    @Path("/{note_id}/categories/{category_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public NotesEntity addCategoryToNote(
            @PathParam("note_id") Long note_id,
            @PathParam("category_id") Long category_id) {
        return service.addCategoryToNote(note_id, category_id);
    }
}
