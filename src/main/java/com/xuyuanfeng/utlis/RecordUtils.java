package com.xuyuanfeng.utlis;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class RecordUtils {

	// **記錄用戶的輸入 用於熱搜》》
	public static void record(HttpServletRequest req, String text) {
		String ip = req.getRemoteAddr();
		if(text.length()>30)
		{
			text=text.substring(0,30);
		}
		text=HTMLUtils.delHTMLTag(text);
		text=HTMLUtils.stripHtml(text);
		
		try {
			JDBCUtils.executeInsert("insert into t_searchkey (ip,text,createtime,isDeleted) values(?,?,?,?)", 
					ip,text, new Date(), false);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
