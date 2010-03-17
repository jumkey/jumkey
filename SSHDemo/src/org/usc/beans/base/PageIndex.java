package org.usc.beans.base;

/**
 * 页索引，主要是起始页和终止页
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
public class PageIndex
{
	/** 开始索引 **/
	private int startIndex;
	/** 结束索引 **/
	private int endIndex;

	public PageIndex(int startIndex, int endIndex)
	{
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getStartIndex()
	{
		return startIndex;
	}

	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}

	public int getEndIndex()
	{
		return endIndex;
	}

	public void setEndIndex(int endIndex)
	{
		this.endIndex = endIndex;
	}

	/**
	 * 起始页和终止页
	 * 
	 * @param viewPageCount
	 *            显示多少页
	 * @param currentPage
	 *            当前页
	 * @param totalpage
	 *            总页数
	 * @return PageIndex 起始页和终止页
	 */
	public static PageIndex getPageIndex(int viewPageCount, int currentPage, int totalpage)
	{
		int startpage = currentPage - (viewPageCount % 2 == 0 ? viewPageCount / 2 - 1 : viewPageCount / 2);
		int endpage = currentPage + viewPageCount / 2;
		if (startpage < 1)
		{
			startpage = 1;
			if (totalpage >= viewPageCount)
				endpage = viewPageCount;
			else
				endpage = totalpage;
		}
		if (endpage > totalpage)
		{
			endpage = totalpage;
			if ((endpage - viewPageCount) > 0)
				startpage = endpage - viewPageCount + 1;
			else
				startpage = 1;
		}
		return new PageIndex(startpage, endpage);
	}
}
