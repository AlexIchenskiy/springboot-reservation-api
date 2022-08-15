package com.agency04.devcademy.controller;

import com.agency04.devcademy.DTO.ReservationDTO;
import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final ReservationService reservationService;

    public ReservationController(@Qualifier("reservationServiceImpl") ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> add(@Valid @RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.save(reservation), HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(reservationService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReservationDTO> update(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody Reservation reservationDetails) {
        return new ResponseEntity<>(modelMapper.map(reservationService.update(id, reservationDetails), ReservationDTO.class), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        reservationService.deleteById(id);

        return new ResponseEntity<>("Reservation deleted", HttpStatus.OK);
    }

}
