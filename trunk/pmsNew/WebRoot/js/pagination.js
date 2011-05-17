  document.write("<table cellpadding='0' cellspacing='0' class='table-width'>");
    document.write("<tr>");
      document.write("<td align='right'>共168条记录｜总计9页｜每页</td><td width='54' align='center'>");
        document.write("<select name='select'>");
          document.write("<option>15</option>");
          document.write("<option>25</option>");
          document.write("<option>50</option>");
          document.write("<option>100</option>");
        document.write("</select>");
      document.write("</td><td width='218' align='center'>条｜<a href='#'>首页</a>｜<a href='#'>上一页</a>｜<a href='#'>下一页</a>｜<a href='#'>尾页</a>｜转到</td>");
      document.write("<td width='50' align='center'><input name='pageid' type='text' class='page_input' maxlength='5'></td>");
      document.write("<td width='22'><input name='pagego' type='submit' class='btn-pagego' value='GO'></td>");
    document.write("</tr></table>");


