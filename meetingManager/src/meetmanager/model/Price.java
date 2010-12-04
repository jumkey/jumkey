package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Price entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Price implements java.io.Serializable {

    // Fields

    private Integer id;

    private String unitsname;

    private Double price;

    private Date date;

    private String address;

    private String hotel;

    private MeetingInfo meetingInfo;

    // 添加
    private String hotelTraffic; // 酒店交通（1000，字符串）

    private String hotelenvironment; // 周边环境（2000，字符串）

    private Integer minnumber; // 会议人数最小（整型）

    private Integer maxnumber; // 会议人数最大（整型）

    private Integer roomNumber; // 客房数（整型）

    private Date registTime; // 报到时间

    private Integer roomMinSize;// 会议室规模min（2000，字符串）

    private Integer roomMaxSize;// 会议室规模max（2000，字符串）

    private String travel; // 会议行程（大文本）

    private Integer mealMinSize;// 餐厅规模min（2000，字符串）

    private Integer mealMaxSize;// 餐厅规模max（2000，字符串）

    private Integer mealType1; // 用餐形式 自助餐0无1有

    private Integer mealType2; // 用餐形式 桌餐0无1有

    private String meal; // 餐谱（大文本）

    // （以下为报价字段）
    private Double meetingspaceFee; // 会议室场地费

    private Double housingFee; // 住房费

    private Double productionFee; // 背板制作费

    private Double bannersFee; // 条幅费

    private Double projectorFee1; // 投影仪费半天

    private Double projectorFee2; // 投影仪费一天

    private Double teaFee; // 茶水费

    private Double fruitFee; // 水果费

    private Double mealFee; // 餐费标准

    private Double fareFee1; // 车费

    private Double fareFee2; // 车费

    private Double fareFee3; // 车费

    // private Double admissionFee; //门票费
    // private Double guideFee; //导游费
    // private Double insuranceFee; //保险费

    private Double travelFee1;// 旅游费1
    
    private Double travelFee2;// 旅游费2
    
    private Double travelFee3;// 旅游费3

    private Integer meetingType;// 会议类型

    private Integer meetingDays;// 会议天数

    private String activities;// 活动

    private Double bookingFee; // 订票

    private Double taxesFee; // 税金

    private Set<PriceRoomType> priceRoomTypes = new HashSet<PriceRoomType>(0);

    // Constructors

    /** default constructor */
    public Price() {
    }

    /** minimal constructor */
    public Price(Double price, Date date, String address, String hotel) {
        this.price = price;
        this.date = date;
        this.address = address;
        this.hotel = hotel;
    }

    /** full constructor */
    public Price(Double price, Date date, String address, String hotel,
            MeetingInfo meetingInfo) {
        this.price = price;
        this.date = date;
        this.address = address;
        this.hotel = hotel;
        this.meetingInfo = meetingInfo;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTravelFee1() {
        return travelFee1;
    }

    public void setTravelFee1(Double travelFee1) {
        this.travelFee1 = travelFee1;
    }

    public Double getTravelFee2() {
        return travelFee2;
    }

    public void setTravelFee2(Double travelFee2) {
        this.travelFee2 = travelFee2;
    }

    public Double getTravelFee3() {
        return travelFee3;
    }

    public void setTravelFee3(Double travelFee3) {
        this.travelFee3 = travelFee3;
    }

    public Integer getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(Integer meetingType) {
        this.meetingType = meetingType;
    }

    public Integer getMeetingDays() {
        return meetingDays;
    }

    public void setMeetingDays(Integer meetingDays) {
        this.meetingDays = meetingDays;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotel() {
        return this.hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    @JSON(serialize = false)
    public MeetingInfo getMeetingInfo() {
        return this.meetingInfo;
    }

    public void setMeetingInfo(MeetingInfo meetingInfo) {
        this.meetingInfo = meetingInfo;
    }

    public String getHotelTraffic() {
        return hotelTraffic;
    }

    public void setHotelTraffic(String hotelTraffic) {
        this.hotelTraffic = hotelTraffic;
    }

    public String getHotelenvironment() {
        return hotelenvironment;
    }

    public void setHotelenvironment(String hotelenvironment) {
        this.hotelenvironment = hotelenvironment;
    }

    public Integer getMinnumber() {
        return minnumber;
    }

    public void setMinnumber(Integer minnumber) {
        this.minnumber = minnumber;
    }

    public Integer getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(Integer maxnumber) {
        this.maxnumber = maxnumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Integer getRoomMinSize() {
        return roomMinSize;
    }

    public Integer getRoomMaxSize() {
        return roomMaxSize;
    }

    public void setRoomMaxSize(Integer roomMaxSize) {
        this.roomMaxSize = roomMaxSize;
    }

    public Integer getMealMaxSize() {
        return mealMaxSize;
    }

    public void setMealMaxSize(Integer mealMaxSize) {
        this.mealMaxSize = mealMaxSize;
    }

    public void setRoomMinSize(Integer roomMinSize) {
        this.roomMinSize = roomMinSize;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public Integer getMealMinSize() {
        return mealMinSize;
    }

    public void setMealMinSize(Integer mealMinSize) {
        this.mealMinSize = mealMinSize;
    }

    public Integer getMealType1() {
        return mealType1;
    }

    public void setMealType1(Integer mealType1) {
        this.mealType1 = mealType1;
    }

    public Integer getMealType2() {
        return mealType2;
    }

    public void setMealType2(Integer mealType2) {
        this.mealType2 = mealType2;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Double getMeetingspaceFee() {
        return meetingspaceFee;
    }

    public void setMeetingspaceFee(Double meetingspaceFee) {
        this.meetingspaceFee = meetingspaceFee;
    }

    public Double getHousingFee() {
        return housingFee;
    }

    public void setHousingFee(Double housingFee) {
        this.housingFee = housingFee;
    }

    public Double getProductionFee() {
        return productionFee;
    }

    public void setProductionFee(Double productionFee) {
        this.productionFee = productionFee;
    }

    public Double getBannersFee() {
        return bannersFee;
    }

    public void setBannersFee(Double bannersFee) {
        this.bannersFee = bannersFee;
    }

    public Double getProjectorFee1() {
        return projectorFee1;
    }

    public void setProjectorFee1(Double projectorFee1) {
        this.projectorFee1 = projectorFee1;
    }

    public Double getProjectorFee2() {
        return projectorFee2;
    }

    public void setProjectorFee2(Double projectorFee2) {
        this.projectorFee2 = projectorFee2;
    }

    public Double getTeaFee() {
        return teaFee;
    }

    public void setTeaFee(Double teaFee) {
        this.teaFee = teaFee;
    }

    public Double getFruitFee() {
        return fruitFee;
    }

    public void setFruitFee(Double fruitFee) {
        this.fruitFee = fruitFee;
    }

    public Double getMealFee() {
        return mealFee;
    }

    public void setMealFee(Double mealFee) {
        this.mealFee = mealFee;
    }

    public Double getFareFee1() {
        return fareFee1;
    }

    public void setFareFee1(Double fareFee1) {
        this.fareFee1 = fareFee1;
    }

    public Double getFareFee2() {
        return fareFee2;
    }

    public void setFareFee2(Double fareFee2) {
        this.fareFee2 = fareFee2;
    }

    public Double getFareFee3() {
        return fareFee3;
    }

    public void setFareFee3(Double fareFee3) {
        this.fareFee3 = fareFee3;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public Double getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(Double bookingFee) {
        this.bookingFee = bookingFee;
    }

    public Double getTaxesFee() {
        return taxesFee;
    }

    public void setTaxesFee(Double taxesFee) {
        this.taxesFee = taxesFee;
    }

    public String getUnitsname() {
        return unitsname;
    }

    public void setUnitsname(String unitsname) {
        this.unitsname = unitsname;
    }
    @JSON(serialize = false)
    public Set<PriceRoomType> getPriceRoomTypes() {
        return priceRoomTypes;
    }

    public void setPriceRoomTypes(Set<PriceRoomType> priceRoomTypes) {
        this.priceRoomTypes = priceRoomTypes;
    }

}