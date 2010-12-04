package com.onegrid.meetmanager.service;

import java.util.List;
import com.onegrid.meetmanager.model.Fete;
import com.onegrid.meetmanager.model.Meal;


public interface MealService {

	public void addInstance(Meal meal);
	public List<Meal> findByMeal(Integer meetingInfoId);
	public void deleteInstance(Meal meal) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public Meal updateInstance(Meal meal) throws Exception;

}
