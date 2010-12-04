package meetmanager.model;

public class Page implements java.io.Serializable {
	private int totalPage = 1; // 总页数 4
	private int totalNum = 0; // 总记录数 3
	private int maxResult = 20; // 每页行数 1
	private int currentPage = 1; // 当前页码 2
	private int selectRows = 0;// 当前查询获得的数据行数 5

	/**
	 * 得到从数据库查询时记录的起始行号，注意从0开始计算
	 */
	public int getFirstResult() {
		if (getCurrentPage() <= 0)
			return 0;

		return getMaxResult() * (getCurrentPage() - 1);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage < 1){
			this.currentPage = 1;
		}
		else{
			this.currentPage = currentPage;
		}
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		this.totalPage=this.totalNum/this.maxResult;
		if(this.totalNum%this.maxResult!=0){
			this.totalPage++;
		}
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}

	public int getSelectRows() {
		return selectRows;
	}

	public void setSelectRows(int selectRows) {
		this.selectRows = selectRows;
	}

}