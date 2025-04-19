package nit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nit.crud.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {

}
