package com.zekerijah.eventdemo.controller;

import com.zekerijah.eventdemo.controller.dto.CreateEventDto;
import com.zekerijah.eventdemo.domain.Event;
import com.zekerijah.eventdemo.domain.Period;
import com.zekerijah.eventdemo.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    private final EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventService.findAllEvent();
    }

    @RequestMapping("/events/{id}")
    public Event getEvent(@PathVariable Long id){
        return eventService.findEvent(id);
    }

    @PostMapping("/events")
    public void createEvent(@RequestBody @Validated CreateEventDto req){
        log.info("Create event " + req.toString());

        Period period = Period.builder()
                .startDate(req.getPeriod().getStart().toLocalDate())
                .endDate(req.getPeriod().getEnd().toLocalDate())
                .startTime(Time.valueOf(req.getPeriod().getStart().toLocalTime()))
                .endTime(Time.valueOf(req.getPeriod().getEnd().toLocalTime()))
                .build();


        Event event = Event.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .period(period)
                .build();

        eventService.saveEvent(event);
    }

    @PutMapping("/events/{id}/update")
    public void updateEvent(@RequestBody CreateEventDto req, @PathVariable Long id){

        Period period = Period.builder()
                .startDate(req.getPeriod().getStart().toLocalDate())
                .endDate(req.getPeriod().getEnd().toLocalDate())
                .startTime(Time.valueOf(req.getPeriod().getStart().toLocalTime()))
                .endTime(Time.valueOf(req.getPeriod().getEnd().toLocalTime()))
                .build();



        Event event = Event.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .period(period)
                .build();

        eventService.updateEvent(id, event);
    }

    @DeleteMapping("/events/{id}/delete")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
