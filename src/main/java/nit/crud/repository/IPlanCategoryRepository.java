package nit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nit.crud.entity.PlanCategory;

public interface IPlanCategoryRepository  extends JpaRepository<PlanCategory, Integer>{

}
