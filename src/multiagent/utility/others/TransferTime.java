package multiagent.utility.others;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransferTime {

	  /**
     * 把毫秒转化成日期
     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @param millSec(毫秒数)
     * @return
     */
    public String transferLongToDate(String dateFormat,Long millSec){
     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
     Date date= new Date(millSec);
            return sdf.format(date);
    } 
}
