package com.microserviceproject.service;

import com.microserviceapp.client.AccountServiceClient;
import com.microserviceapp.client.contract.AccountDto;
import com.microserviceproject.dto.TicketDto;
import com.microserviceproject.entity.PriorityType;
import com.microserviceproject.entity.Ticket;
import com.microserviceproject.entity.TicketStatus;
import com.microserviceproject.entity.TicketModel;
import com.microserviceproject.repository.TicketElasticRepository;
import com.microserviceproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StandartTicketApplication implements TicketService{


    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final TicketElasticRepository elasticsearchRepository;
    private final AccountServiceClient accountServiceClient;


    @Override
    public TicketDto save(TicketDto ticketDto) {


        Ticket ticket= new Ticket();
        //TODO Accoınt API den Doğrula
        ResponseEntity<AccountDto> accountDtoResponseEntity =accountServiceClient.get(ticketDto.getAssignee());
        accountDtoResponseEntity.getBody().getFullName();

        if(ticketDto.getDescription()==null)
            throw  new IllegalArgumentException("Description can not be empty");


        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());
        ticket=ticketRepository.save(ticket);

        TicketModel model= TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .priortiyType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate())
                .assignee(accountDtoResponseEntity.getBody().getFullName()).build();


        elasticsearchRepository.save(model);

        ticketDto.setId(ticket.getId());
        return  ticketDto;
    }

    @Override
    public TicketDto update(String id,TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
