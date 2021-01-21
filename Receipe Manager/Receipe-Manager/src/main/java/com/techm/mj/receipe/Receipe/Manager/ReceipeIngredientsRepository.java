package com.techm.mj.receipe.Receipe.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.techm.mj.receipe.Receipe.Manager.ReceipeIngredients;

public interface ReceipeIngredientsRepository  extends JpaRepository<ReceipeIngredients, Long>  {

    List<ReceipeIngredients> findByReceiepeId(Long receipe_id);
    Optional<ReceipeIngredients> findByIdAndReceiepeId(Long ingredent_id, Long receipe_id);
}
