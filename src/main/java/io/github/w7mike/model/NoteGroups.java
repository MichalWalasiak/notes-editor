package io.github.w7mike.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "note_groups")
public class NoteGroups extends BaseNote {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "noteGroups")
    private Set<Note> noteSet;

    @Embedded
    private Audit audit = new Audit();

    public NoteGroups() {
    }

    public Set<Note> getNoteSet() {
        return noteSet;
    }

    void setNoteSet(final Set<Note> noteSet) {
        this.noteSet = noteSet;
    }
}
