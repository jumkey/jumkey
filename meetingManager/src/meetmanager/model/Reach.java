package meetmanager.model;

public class Reach implements java.io.Serializable {
	private Income income;
	private SendNotificationPlan snp;
	private Register register;

	public Reach(Income income, SendNotificationPlan snp, Register register) {
		this.income = income;
		this.snp = snp;
		this.register = register;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public SendNotificationPlan getSnp() {
		return snp;
	}

	public void setSnp(SendNotificationPlan snp) {
		this.snp = snp;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

}