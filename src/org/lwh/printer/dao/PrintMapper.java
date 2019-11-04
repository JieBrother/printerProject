package org.lwh.printer.dao;

import org.apache.ibatis.annotations.Select;
import org.lwh.printer.pojo.PrintInformation;

import java.util.List;

public interface PrintMapper {

//    @Select("select * from printinformation where status like '%中'")
    List<PrintInformation> getPrintLine();

    List<PrintInformation> historyList();

    List<PrintInformation> userHistoryList(String id);

    Integer updateStatus(String fileName);

    Integer addPrint(PrintInformation printInformation);

    Integer delHistoryData(String fileName);

}
