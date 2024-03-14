package com.ensolvers.notes.repository;

import com.ensolvers.notes.model.NotesEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class NotesRepository implements PanacheRepository<NotesEntity> {

    public List<NotesEntity> findByArchived(Byte archived) {
        return list("archived", archived);
    }

    public List<NotesEntity> listActive() {
        return list("archived", (byte) 0);
    }





}
