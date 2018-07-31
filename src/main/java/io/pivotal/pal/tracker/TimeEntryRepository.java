package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {


    abstract TimeEntry create(TimeEntry any);

    abstract TimeEntry find(long l);

    abstract List<TimeEntry> list();

    abstract TimeEntry update(long eq, TimeEntry any);

    abstract void delete(long l);


}
