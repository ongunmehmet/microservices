package com.microserviceproject.repository;

import com.microserviceproject.entity.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;



public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {

}
