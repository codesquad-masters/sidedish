package com.example.be.service.dish;

import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.controller.exception.BusinessException;
import com.example.be.controller.exception.DishTypeException;
import com.example.be.domain.dish.Dish;
import com.example.be.repository.dish.DishReadRepository;
import com.example.be.repository.dish.DishRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DishService {

    private final DishReadRepository dishReadRepository;
    private final DishRepository dishRepository;

    public DishService(DishReadRepository dishReadRepository, DishRepository dishRepository) {
        this.dishReadRepository = dishReadRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional(readOnly = true)
    public List<PlanningDataRequest> getPlanningData() {
        return dishReadRepository.getPlanningData();
    }

    @Transactional(readOnly = true)
    public Dish getDishDetail(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new BusinessException(DishTypeException.DISH_NOT_FOUND_EXCEPTION));
    }
}
