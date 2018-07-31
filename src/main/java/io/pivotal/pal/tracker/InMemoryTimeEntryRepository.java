package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    public HashMap<Long,TimeEntry> timeEntryRepo = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        Long id = timeEntryRepo.size() +1L;

        TimeEntry createTimeEntry = new TimeEntry(
          id,timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours());

        timeEntryRepo.put(id, createTimeEntry);

        return createTimeEntry;
    }

    @Override
    public TimeEntry find (long id){

        return timeEntryRepo.get(id);


    }
    @Override
    public List<TimeEntry> list() {


        return new ArrayList<TimeEntry> (timeEntryRepo.values());

    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        TimeEntry existingEntry = timeEntryRepo.get(id);
        TimeEntry updateEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntryRepo.put(id,updateEntry);
        return updateEntry;

    }


    public void delete(long id) {

        timeEntryRepo.remove(id);

    }
}
