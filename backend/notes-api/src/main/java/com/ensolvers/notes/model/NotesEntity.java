package com.ensolvers.notes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "notes", schema = "notesdb", catalog = "")
public class NotesEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "note_id", nullable = true)
    private int noteId;
    @Basic
    @Column(name = "title", nullable = true, length = 255)
    private String title;
    @Basic
    @Column(name = "content", nullable = true, length = -1)
    private String content;
    @Basic
    @Column(name = "archived", nullable = true)
    private Byte archived;
    @Basic
    @Column(name = "user_name", nullable = true, length = 50)
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "notes_categories",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoriesEntity> category;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getArchived() {
        return archived;
    }

    public void setArchived(Byte archived) {
        this.archived = archived;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<CategoriesEntity> getCategories() {
        return category;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.category = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotesEntity that = (NotesEntity) o;
        return noteId == that.noteId && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(archived, that.archived) && Objects.equals(userName, that.userName) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, title, content, archived, userName, category);
    }
}
