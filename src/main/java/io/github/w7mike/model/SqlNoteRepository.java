package io.github.w7mike.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface SqlNoteRepository extends NoteRepository, JpaRepository<Note, Integer> {

    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from notes where id=:id")
    boolean existsById(Integer id);
}
