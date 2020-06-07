package com.example.journal.repo;

import com.example.journal.models.EntryJournal;
import org.springframework.data.repository.CrudRepository;

public interface EntryJournalRepository extends CrudRepository<EntryJournal, Long> {
}
