package esun.voteSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esun.voteSystem.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, String>{

}
