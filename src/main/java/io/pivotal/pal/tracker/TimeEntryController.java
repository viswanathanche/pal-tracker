package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController  {

    public TimeEntryRepository timeEntryRepository;
    private TimeEntry timeEntryToCreate;

    public TimeEntryController (TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }



    @GetMapping ("/time-entries/{id}")
    public ResponseEntity read (@PathVariable long id) {

        TimeEntry readTimeEmtry = timeEntryRepository.find(id);

        if (null != readTimeEmtry) {

            return new ResponseEntity<>(readTimeEmtry, HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list () {

        List<TimeEntry> listTimeEntry = timeEntryRepository.list();

        return new ResponseEntity<>(listTimeEntry,HttpStatus.OK);

    }

    @PutMapping("/time-entries/{id}" )
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry any) {
        TimeEntry updateTimeEntry = timeEntryRepository.update(id,any);

        if(null != updateTimeEntry) {

            return new ResponseEntity<>(updateTimeEntry, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(updateTimeEntry, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id){

        timeEntryRepository.delete(id);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);

    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
       // this.timeEntryToCreate = timeEntryToCreate;
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(createdTimeEntry,HttpStatus.CREATED);

    }
}
