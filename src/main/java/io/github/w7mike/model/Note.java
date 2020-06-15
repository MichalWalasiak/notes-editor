package io.github.w7mike.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "notes")
public class Note extends BaseNote {

    @NotBlank(message = "note Contents should not be empty")
    private String content;

    @ManyToOne
    @JoinColumn(name = "note_groups_id")
    private NoteGroups noteGroups;

    @Embedded
    private Audit audit = new Audit();

    public Note() {
    }

    public String getContent() {
        return content;
    }

    void setContent(final String content) {
        this.content = content;
    }

    NoteGroups getNoteGroups() {
        return noteGroups;
    }

    void setNoteGroups(final NoteGroups noteGroups) {
        this.noteGroups = noteGroups;
    }

    @Override
    public void updateFrom(final Note source) {
        super.updateFrom(source);
        content = source.content;
        noteGroups = source.noteGroups;
    }
}
