package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.MeetingInfoDAO;
import com.onegrid.meetmanager.dao.PriceDAO;
import com.onegrid.meetmanager.dao.PriceRoomTypeDAO;
import com.onegrid.meetmanager.dao.RoomTypeDAO;
import com.onegrid.meetmanager.dao.UnitsDAO;
import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.PriceRoomType;
import com.onegrid.meetmanager.model.RoomType;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.service.PriceService;

public class PriceServiceImpl implements PriceService {
	private PriceDAO priceDAO;
	private UnitsDAO unitsDAO;
    private RoomTypeDAO roomTypeDAO;
    private PriceRoomTypeDAO priceRoomTypeDAO;
	private MeetingInfoDAO meetingInfoDAO;
	public PriceDAO getPriceDAO() {
		return priceDAO;
	}

	public void setPriceDAO(PriceDAO priceDAO) {
		this.priceDAO = priceDAO;
	}

	public PriceRoomTypeDAO getPriceRoomTypeDAO() {
        return priceRoomTypeDAO;
    }

    public void setPriceRoomTypeDAO(PriceRoomTypeDAO priceRoomTypeDAO) {
        this.priceRoomTypeDAO = priceRoomTypeDAO;
    }

    public UnitsDAO getUnitsDAO() {
		return unitsDAO;
	}

	public void setUnitsDAO(UnitsDAO unitsDAO) {
		this.unitsDAO = unitsDAO;
	}

	public RoomTypeDAO getRoomTypeDAO() {
        return roomTypeDAO;
    }

    public void setRoomTypeDAO(RoomTypeDAO roomTypeDAO) {
        this.roomTypeDAO = roomTypeDAO;
    }

    public void addInstance(Price price, List<PriceRoomType> prts) {
		priceDAO.save(price);

		for(PriceRoomType prt:prts) {
		    prt.setPrice(price);
		    priceRoomTypeDAO.save(prt);
		}
	}

	public void deleteInstance(Price price) throws Exception {
		price = priceDAO.get(price.getId());
		priceDAO.delete(price);
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		Price sysa = null;
		for (int id : selected) {
			sysa=priceDAO.get(id);
			priceDAO.delete(sysa);
		}
	}

	public Price updateInstance(Price price) throws Exception {
		Price sysa = priceDAO.get(price.getId());
		// PropertyUtils.copyProperties
		// BeanUtils.copyProperties(sysa, account);
		sysa.setPrice(price.getPrice());
		sysa.setUnitsname(price.getUnitsname());
		sysa.setDate(price.getDate());
		sysa.setAddress(price.getAddress());
		sysa.setHotel(price.getHotel());

		//添加
		sysa.setHotelTraffic(price.getHotelTraffic());
		sysa.setHotelenvironment(price.getHotelenvironment());
		sysa.setMinnumber(price.getMinnumber());
        sysa.setMaxnumber(price.getMaxnumber());
		sysa.setRoomNumber(price.getRoomNumber());
		sysa.setRegistTime(price.getRegistTime());
		sysa.setRoomMinSize(price.getRoomMinSize());
        sysa.setRoomMaxSize(price.getRoomMaxSize());
		sysa.setTravel(price.getTravel());
		sysa.setMealMinSize(price.getMealMinSize());
        sysa.setMealMaxSize(price.getMealMaxSize());
		sysa.setMealType1(price.getMealType1());
        sysa.setMealType2(price.getMealType2());
		sysa.setMeal(price.getMeal());
        sysa.setMeetingType(price.getMeetingType());
        sysa.setMeetingDays(price.getMeetingDays());
        sysa.setTravelFee1(price.getTravelFee1());
        sysa.setTravelFee2(price.getTravelFee2());
        sysa.setTravelFee3(price.getTravelFee3());
		//报价
		sysa.setMeetingspaceFee(price.getMeetingspaceFee());
		sysa.setHousingFee(price.getHousingFee());
		sysa.setProductionFee(price.getProductionFee());
		sysa.setBannersFee(price.getBannersFee());
		sysa.setProjectorFee1(price.getProjectorFee1());
        sysa.setProjectorFee2(price.getProjectorFee2());
		sysa.setTeaFee(price.getTeaFee());
		sysa.setFruitFee(price.getFruitFee());
		sysa.setMealFee(price.getMealFee());
		sysa.setFareFee1(price.getFareFee1());
        sysa.setFareFee2(price.getFareFee2());
        sysa.setFareFee3(price.getFareFee3());
		sysa.setActivities(price.getActivities());
		sysa.setBookingFee(price.getBookingFee());
		sysa.setTaxesFee(price.getTaxesFee());
		return sysa;
	}

	public Price updateaskprice(Price price) {
		Price sysa = priceDAO.get(price.getId());
		
		sysa.setPrice(price.getPrice());
		//报价
		sysa.setMeetingspaceFee(price.getMeetingspaceFee());
		sysa.setHousingFee(price.getHousingFee());
		sysa.setProductionFee(price.getProductionFee());
		sysa.setBannersFee(price.getBannersFee());
        sysa.setProjectorFee1(price.getProjectorFee1());
        sysa.setProjectorFee2(price.getProjectorFee2());
		sysa.setTeaFee(price.getTeaFee());
        sysa.setTravelFee1(price.getTravelFee1());
        sysa.setTravelFee2(price.getTravelFee2());
        sysa.setTravelFee3(price.getTravelFee3());
		sysa.setFruitFee(price.getFruitFee());
		sysa.setMealFee(price.getMealFee());
        sysa.setFareFee1(price.getFareFee1());
        sysa.setFareFee2(price.getFareFee2());
        sysa.setFareFee3(price.getFareFee3());
        sysa.setActivities(price.getActivities());
		sysa.setBookingFee(price.getBookingFee());
		sysa.setTaxesFee(price.getTaxesFee());
		return sysa;
	}

	public List<Price> getAllPrice() {
		return priceDAO.findAll();
	}

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public List<Price> getPriceAll() {
		return priceDAO.findAll();
	}

	public String checkUnits(String unitsname) {
		StringBuffer ss=new StringBuffer("[");
		List<Units> l = unitsDAO.find("from Units where name LIKE '%"+unitsname+"%'");
		for(Units u:l){
			ss.append("{\"id\":\""+u.getId()+"\",\"name\":\""+u.getName()+"\"},");
		}
		ss.append("]");
		if(ss.length()-2!=0){
			ss.deleteCharAt(ss.length()-2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public Price getInstance(Integer id) {
		return priceDAO.get(id);
	}

    @Override
    public List<RoomType> getAllRoomType() {
        return roomTypeDAO.findAll();
    }

}
