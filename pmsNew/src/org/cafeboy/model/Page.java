package org.cafeboy.model;

@SuppressWarnings("serial")
public class Page implements java.io.Serializable {
	private int totalPage = 1; // ��ҳ�� 4
	private int totalNum = 0; // �ܼ�¼�� 3
	private int maxResult = 20; // ÿҳ���� 1
	private int currentPage = 1; // ��ǰҳ�� 2
	private int selectRows = 0;// ��ǰ��ѯ��õ��������� 5

	/**
	 * �õ������ݿ��ѯʱ��¼����ʼ�кţ�ע���0��ʼ����
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