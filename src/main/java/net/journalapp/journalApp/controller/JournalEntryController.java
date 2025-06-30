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

    @GetMapping("id/{myId}")
    public JournalEntry getJournalentrybyId (@PathVariable long myId){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalentrybyId (@PathVariable long myId){
        return journalEntries.remove(myId);
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalbyId(@PathVariable long id, @RequestBody JournalEntry myEntry ){
        return journalEntries.put(id, myEntry);
    }

}
