package nit.crud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nit.crud.entity.PlanCategory;
import nit.crud.entity.TravelPlan;
import nit.crud.repository.IPlanCategoryRepository;
import nit.crud.repository.ITravelPlanRepository;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {
	
	@Autowired
	private ITravelPlanRepository travelPlanRepo;
	
	@Autowired
	private IPlanCategoryRepository planCategoryRepo;

	@Override
	public String registerTravelPlan(TravelPlan plan) {
		// TODO Auto-generated method stub
		TravelPlan saved = travelPlanRepo.save(plan);
//		if(saved.getPlanId()!=null) {
//			return "TravelPlan is saved with the id value:"+saved.getPlanId();
//		}else {
//			return "Problem in saving the TravelPlan";
//		}
		
		return saved.getPlanId()!=null? "TravelPlan is saved with the id value:"+saved.getPlanId() : "Problem in saving the TravelPlan";
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		// TODO Auto-generated method stub
		List<PlanCategory> list = planCategoryRepo.findAll();
		Map<Integer,String> categoriesMap = new HashMap<>();
		list.forEach(category->{
			categoriesMap.put(category.getCategoryId(),category.getCategoryName());
		});
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlans() {
		// TODO Auto-generated method stub
		return travelPlanRepo.findAll();
		
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		// TODO Auto-generated method stub
		return travelPlanRepo.findById(planId).orElseThrow(()->new IllegalArgumentException("TravelPlan is not found"));
//		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
//		if(opt.isPresent()) {
//			return opt.get();
//		}else {
//			throw new IllegalArgumentException("TravelPlan is not found");
//		}
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		// TODO Auto-generated method stub
		Optional<TravelPlan> opt = travelPlanRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			travelPlanRepo.save(plan);
			return plan.getPlanId() +" Travel Plan is updated";
		}else {
			return plan.getPlanId() +" Travel Plan is updated";
		}
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		// TODO Auto-generated method stub
		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			travelPlanRepo.deleteById(planId);
			return planId +" Travel Plan is deleted";
		}else {
			return planId +" Travel Plan is not found";
		}
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		// TODO Auto-generated method stub
		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			TravelPlan plan = opt.get();
			plan.setActivateSW(status);
			travelPlanRepo.save(plan);
			return planId +" Travel Plan is updated";
		}else {
			return planId +" Travel Plan is not found for updation";
		}
	}

}
