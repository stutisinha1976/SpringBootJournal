package net.journalapp.journalApp.controller;

import net.journalapp.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/journal")
@RestController
public class JournalEntryController {
    private Map<Long,JournalEntry> journalEntries=new HashMap<>();
    @GetMapping
    public List<JournalEntry>getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

}
