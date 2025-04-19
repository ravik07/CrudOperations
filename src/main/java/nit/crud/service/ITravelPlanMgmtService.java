package nit.crud.service;

import java.util.Map;
import java.util.List;

import nit.crud.entity.TravelPlan;

public interface ITravelPlanMgmtService {
	public String registerTravelPlan(TravelPlan plan);
	public Map<Integer, String> getTravelPlanCategories();
	public List<TravelPlan> showAllTravelPlans();
	public TravelPlan showTravelPlanById(Integer planId);
	public String updateTravelPlan(TravelPlan plan);
	public String deleteTravelPlan(Integer planId);
	public String changeTravelPlanStatus(Integer planId, String status);
}
