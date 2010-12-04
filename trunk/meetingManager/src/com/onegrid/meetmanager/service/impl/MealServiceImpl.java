package com.onegrid.meetmanager.service.impl;

import java.util.List;
import com.onegrid.meetmanager.dao.FeteDAO;
import com.onegrid.meetmanager.dao.MealDAO;
import com.onegrid.meetmanager.model.Fete;
import com.onegrid.meetmanager.model.Meal;
import com.onegrid.meetmanager.service.FeteService;
import com.onegrid.meetmanager.service.MealService;

public class MealServiceImpl implements MealService{
	private MealDAO mealDAO;

	public void setMealDAO(MealDAO mealDAO) {
		this.mealDAO = mealDAO;
	}

	public void addInstance(Meal meal) {
		mealDAO.save(meal);
	}
	
	public List<Meal> findByMeal(Integer meetingInfoId) {
		// TODO Auto-generated method stub
		return mealDAO.find("from Meal where meetingInfo.id="+meetingInfoId);
	}

	public void deleteInstance(Meal meal) throws Exception{
		meal = mealDAO.get(meal.getId());
		if(meal.getId()!=null){
			mealDAO.delete(meal);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		Meal meal=null;
		for (int id : selected) {
			meal=mealDAO.get(id);
			if(meal!=null){
				mealDAO.delete(meal);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
		
	}

	public Meal updateInstance(Meal meal) throws Exception {
		Meal fe = mealDAO.get(meal.getId());
		if(fe.getId()!=null){
			fe.setAddress(meal.getAddress());
			fe.setDate(meal.getDate());
			fe.setMoney(meal.getMoney());
			fe.setDrinkscost(meal.getDrinkscost());
			fe.setExpenses(meal.getExpenses());
			fe.setMealtime(meal.getMealtime());
			fe.setType(meal.getType());
			fe.setNumber(meal.getNumber());
			return fe;
		}else{
			throw new Exception("此记录不是你创建");
		}
	}

}
