package multiagent.utility.others;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransferTime {

	  /**
     * �Ѻ���ת��������
     * @param dateFormat(���ڸ�ʽ�����磺MM/ dd/yyyy HH:mm:ss)
     * @param millSec(������)
     * @return
     */
    public String transferLongToDate(String dateFormat,Long millSec){
     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
     Date date= new Date(millSec);
            return sdf.format(date);
    } 
}
