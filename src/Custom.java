import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Custom implements Serializable{
	private Sheet sheet;
	private FreshCream freshcream;
	private Topping topping;
	private int candle;
	private int fireCracker;
	private int priceSum;
	private Date reservationDate;
	private boolean reservationStatus;
	private Date pickupDate;

	public Custom(Sheet sheet, FreshCream freshcream, Topping topping, int candle, int fireCracker, int priceSum,
			Date reservationDate, boolean reservationStatus, Date pickupDate) {
		super();
		this.sheet = sheet;
		this.freshcream = freshcream;
		this.topping = topping;
		this.candle = candle;
		this.fireCracker = fireCracker;
		this.priceSum = priceSum;
		this.reservationDate = reservationDate;
		this.reservationStatus = reservationStatus;
		this.pickupDate = pickupDate;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public FreshCream getFreshcream() {
		return freshcream;
	}

	public Topping getTopping() {
		return topping;
	}

	public int getCandle() {
		return candle;
	}

	public int getFireCracker() {
		return fireCracker;
	}

	public int getPriceSum() {
		return priceSum;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public boolean isReservationStatus() {
		return reservationStatus;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public void setFreshcream(FreshCream freshcream) {
		this.freshcream = freshcream;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public void setCandle(int candle) {
		this.candle = candle;
	}

	public void setFireCracker(int fireCracker) {
		this.fireCracker = fireCracker;
	}

	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	
	   
    public String getUserRservationDate() {
        SimpleDateFormat sdfrd = new SimpleDateFormat("yyyy-MM-dd");
        return sdfrd.format(reservationDate);
    }
    
    public String getUserPickUpDate() {
        SimpleDateFormat sdfpd = new SimpleDateFormat("yyyy-MM-dd");
        return sdfpd.format(pickupDate);
    }
    
    public String customCakePrint() {
        return "   ~~~~~두~~~둥~~~등~~~장~~~~~~~\n"
                + "   ++++++케이크 완성!!!++++++\n"
                + ""
                + "예약하신 날짜: " + getUserRservationDate() + "\n"
                + "픽업하실 날짜: " + getUserPickUpDate() + "\n"
                + "   *                        \n"
                + "            *    *        * \n"
                + "       *              *     \n"
                + "                 *      *   \n"
                + "    *        *              \n"
                + "                     __     \n"
                + "          *          \\ \\  \n"
                + "      *       *       --         ->  주문하신 폭죽 갯수: " + fireCracker + "\n"
                + "                       \\   \n"
                + "                            \n"
                + "   <> <> <>   <>    <> <> <>     ->  주문하신 초 갯수: " + candle + "\n"
                + "   || || ||   ||    || || ||\n"
                + "   ** ** ** topping ** ** **     ->  주문하신 토핑: " + topping.getName() +"\n"
                + "   ~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "   ~~~~~~~~freshcream~~~~~~~~    ->  주문하신 생크림: "+ freshcream.getName() + "\n"
                + "   ==========================\n"
                + "   ==========sheet===========    ->  주문하신 시트" + sheet.getName() + "\n"
                + "   ==========================\n"
                + ""
                + "                                     커스텀 케이크 가격: " + priceSum + "원\n"
                + ""
                + ""
                + "";
    }
    public String reservationcustomCakePrint() {
        return "예약하실 날짜: " + getUserRservationDate() + "\n"
                + "픽업하실 날짜: " + getUserPickUpDate() + "\n"
                + "   *                         \n"
                + "            *    *        *  \n"
                + "       *              *      \n"
                + "                 *      *    \n"
                + "    *        *               \n"
                + "                     __      \n"
                + "          *          \\ \\   \n"
                + "      *       *       --         ->  주문하신 폭죽 갯수: " + fireCracker + "\n"
                + "                       \\    \n"
                + "                             \n"
                + "   <> <> <>   <>    <> <> <>     ->  주문하신 초 갯수: " + candle + "\n"
                + "   || || ||   ||    || || || \n"
                + "   ** ** ** topping ** ** **     ->  주문하신 토핑: " + topping.getName() +"\n"
                + "   ~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "   ~~~~~~~~freshcream~~~~~~~~    ->  주문하신 생크림: "+ freshcream.getName() + "\n"
                + "   ==========================\n"
                + "   ==========sheet===========    ->  주문하신 시트" + sheet.getName() + "\n"
                + "   ==========================\n"
                + ""
                + ""
                + "                                     커스텀 케이크 가격: " + priceSum + "원\n"
                + ""
                + ""
                + "";
    }
    
    public String changeReservationtoString() {
        
        return "선택하신 시트: " + sheet.name + "\n"
                + "선택하신 생크림: " + freshcream.name + "\n"
                + "선택하신 토핑: " + topping.name + "\n"
                + "선택하신 초의 갯수: " + candle + "\n"
                + "선택하신 폭죽의 갯수: " + fireCracker + "\n"
                + "예약하신 날짜: " + getUserRservationDate() + "\n"
                + "픽업하실 날짜: " + getUserPickUpDate() + "\n"
                + "총 결재 금액: " + priceSum
                + "";
    }

    @Override
    public String toString() {
        return "Custom [sheet=" + sheet + ", freshcream=" + freshcream + ", topping=" + topping + ", candle=" + candle
                + ", fireCracker=" + fireCracker + ", priceSum=" + priceSum + ", reservationDate=" + reservationDate
                + ", reservationStatus=" + reservationStatus + ", pickupDate=" + pickupDate + "]";
    }

	
	
	
	
	
	
}
