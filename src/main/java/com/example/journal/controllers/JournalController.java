package com.example.journal.controllers;

import com.example.journal.models.EntryJournal;
import com.example.journal.repo.EntryJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class JournalController {

    @Autowired
    private EntryJournalRepository entryJournalRepository;

    @GetMapping("/journal")
    public String journalMain(Model model){
        Iterable<EntryJournal> entryJournal = entryJournalRepository.findAll();
        model.addAttribute("entry", entryJournal);
        return "journal-main";
    }
    @GetMapping("/journal/add")
    public String journalAdd(Model model){

        return "journal-add";
    }
    @PostMapping("/journal/add")
    @Nullable
    public String journalEntryAdd(@RequestParam String orders, @RequestParam String product_name, @RequestParam String type_of_test,
                                  @RequestParam int quantity, @RequestParam String testers_name, @RequestParam Date date,
                                  @RequestParam String note, Model model){
        EntryJournal entryJournal = new EntryJournal(orders, product_name, type_of_test,quantity,testers_name, date, note);
        entryJournalRepository.save(entryJournal);
        return "redirect:/journal";
    }

    @GetMapping("/journal/{id}")
    public String journalDetails(@PathVariable(value = "id") long id, Model model){
        if(!entryJournalRepository.existsById(id)){
            return "redirect:/journal";
        }
        Optional<EntryJournal> entry = entryJournalRepository.findById(id);
        ArrayList<EntryJournal> res = new ArrayList<>();
        entry.ifPresent(res::add);
        model.addAttribute("entry", res);
        return "journal-details";
    }

    @GetMapping("/journal/{id}/edit")
    public String journalEdit(@PathVariable(value = "id") long id, Model model){
        if(!entryJournalRepository.existsById(id)){
            return "redirect:/journal";
        }
        Optional<EntryJournal> entry = entryJournalRepository.findById(id);
        ArrayList<EntryJournal> res = new ArrayList<>();
        entry.ifPresent(res::add);
        model.addAttribute("entry", res);
        return "journal-edit";
    }

    @PostMapping("/journal/{id}/edit")
    public String journalEntryUpdate(@PathVariable(value = "id") long id, @RequestParam String orders, @RequestParam String product_name, @RequestParam String type_of_test,
                                  @RequestParam int quantity, @RequestParam String testers_name, @RequestParam Date date,
                                  @RequestParam String note, Model model){
        EntryJournal entryJournal = entryJournalRepository.findById(id).orElseThrow(RuntimeException::new);
        entryJournal.setOrders(orders);
        entryJournal.setProduct_name(product_name);
        entryJournal.setType_of_test(type_of_test);
        entryJournal.setQuantity(quantity);
        entryJournal.setTesters_name(testers_name);
        entryJournal.setDate(date);
        entryJournal.setNote(note);
        entryJournalRepository.save(entryJournal);
        return "redirect:/journal";
    }

    @PostMapping("/journal/{id}/remove")
    public String journalEntryDelete(@PathVariable(value = "id") long id, Model model){
        EntryJournal entryJournal = entryJournalRepository.findById(id).orElseThrow(RuntimeException::new);
        entryJournalRepository.delete(entryJournal);
        return "redirect:/journal";
    }
}
