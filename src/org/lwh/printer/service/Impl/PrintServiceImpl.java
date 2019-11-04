package org.lwh.printer.service.Impl;

import org.lwh.printer.dao.PrintMapper;
import org.lwh.printer.pojo.PrintInformation;
import org.lwh.printer.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintServiceImpl implements PrintService {

    @Autowired
    PrintMapper printMapper;

    @Override
    public List<PrintInformation> getPrintLine() {
        List<PrintInformation> list = printMapper.getPrintLine();
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("已完成")) {
                System.out.println(list.get(i));
                list.remove(list.get(i));
            }
        }
        return list;
    }

    @Override
    public Boolean finishPrint(String fileName) {

        if (printMapper.updateStatus(fileName) > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public Boolean addPrint(PrintInformation information) {
        Integer integer = printMapper.addPrint(information);
        if (integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<PrintInformation> historyList() {
        List<PrintInformation> list = printMapper.historyList();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getStatus().trim().equals("已完成")) {
                System.out.println(list.get(i));
                list.remove(list.get(i));
            }
        }
        return list;
    }

    @Override
    public List<PrintInformation> userHistoryList(String id) {
        List<PrintInformation> list = printMapper.userHistoryList(id);
        return list;
    }

    @Override
    public Boolean delHistoryData(String fileName) {
        Integer integer = printMapper.delHistoryData(fileName);
        if (integer > 0)
            return true;
        else
            return false;
    }

}
