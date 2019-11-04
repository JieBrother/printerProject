package org.lwh.printer.service;

import org.lwh.printer.pojo.PrintInformation;

import java.util.List;

public interface PrintService {

    List<PrintInformation> getPrintLine();

    Boolean finishPrint(String fileName);

    Boolean addPrint(PrintInformation information);

    List<PrintInformation> historyList();

    List<PrintInformation> userHistoryList(String id);

    Boolean delHistoryData(String fileName);
}
