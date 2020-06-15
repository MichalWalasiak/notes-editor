package io.github.w7mike.service;

import io.github.w7mike.model.Note;
import io.github.w7mike.model.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
class NoteController {

    private final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private final NoteRepository repository;

    NoteController(final NoteRepository repository){
        this.repository = repository;
    }

    @PostMapping("/notes")
    ResponseEntity<Note> createNote(@RequestBody @Valid Note toCreate){
        Note result = repository.save(toCreate);
        logger.warn("custom post from controller");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);

    }

    @GetMapping(value = "/notes", params = {"!sort", "!size", "!page"})
    ResponseEntity<List<Note>> readAllNotes(){
        logger.warn("You are going to read all notes");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/notes")
    ResponseEntity<?> readAllNotes(Pageable pageable){
        logger.warn("custom Pageable");
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @GetMapping("/notes/{id}")
    ResponseEntity<Note> readSelectedNote(@PathVariable Integer id){
        return repository.findById(id)
                .map(note -> ResponseEntity.ok(note))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = ("/notes/{id}"))
    ResponseEntity<Note> updateNote(@PathVariable Integer id, @RequestBody Note toUpdate){
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.findById(id)
                .ifPresent(note -> {
                    note.updateFrom(toUpdate);
                    repository.save(note);
                });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = ("/notes/{id}"))
    ResponseEntity<Note> removeNote(@PathVariable Integer id){
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
