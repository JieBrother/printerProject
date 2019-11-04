package org.lwh.printer.controller;

import org.apache.ibatis.annotations.Param;
import org.lwh.printer.pojo.PrintInformation;
import org.lwh.printer.pojo.User;
import org.lwh.printer.service.Impl.PrintServiceImpl;
import org.lwh.printer.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PrintController {

    private static int length = 0;
    private List<PrintInformation> informationList = new ArrayList<>();

    @Autowired
    private PrintServiceImpl printService;

    @RequestMapping("/fileUpload")
    public String fileUpload(MultipartFile fileName) {
        System.out.println(fileName.getOriginalFilename());
        return "上传成功";
    }

    @RequestMapping("/exitPrint")
    @ResponseBody
    public String exitPrint(@Param("fileName") String fileName) {
        System.out.println(fileName);
        if (printService.delHistoryData(fileName)) {
            return "ok";
        }

        return "error";
    }

    @RequestMapping("/printInfo")
    @ResponseBody
    public Map<String, Object> printInfo() {
        Map<String, Object> map = new HashMap<>();
//        "code": 0,
//        "msg": "",
//        "count": 1000,
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1000);
        List<PrintInformation> list = printService.getPrintLine();
//        System.out.println(list);
        int i = 0;
        for (PrintInformation printInformation : list) {
            printInformation.setNumber(Integer.toString(++i));
        }
//        System.out.println(list);
        map.put("data", list);
//        System.out.println(map);
        return map;
    }

    @RequestMapping("/adminPrintList")
    @ResponseBody
    public Map<String, Object> adminPrintList() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1000);
        List<PrintInformation> list = printService.getPrintLine();
//        System.out.println(list);
        int i = 0;
        for (PrintInformation printInformation : list) {
            printInformation.setNumber(Integer.toString(++i));
        }
//        System.out.println(list);
        map.put("data", list);
//        System.out.println(map);
        return map;
    }

    @RequestMapping("/addPrint")
//    @ResponseBody
    public String addPrint(PrintInformation information, HttpSession session) {
        User user = (User) session.getAttribute("user");
        information.setNumber(Integer.toString(informationList.size()));
        information.setId(user.getId());
        information.setName(user.getName());

        information.setStatus("排队中");
//        System.out.println(user);
        System.out.println(information);
        if (printService.addPrint(information)) {
            return "redirect:/welcome";
        }
        return "redirect:/welcome";
    }

    @RequestMapping("/userHistoryList")
    @ResponseBody
    public Map<String, Object> userHistoryList(HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<PrintInformation> list = printService.userHistoryList(user.getId());
        int i = 0;
        for (PrintInformation printInformation : list) {
            printInformation.setNumber(Integer.toString(++i));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1000);
        map.put("data", list);
        System.out.println(map);
        return map;
    }

    @RequestMapping("/historyList")
    @ResponseBody
    public Map<String, Object> historyList(HttpSession session) {
        List<PrintInformation> list = printService.historyList();
        int i = 0;
        for (PrintInformation printInformation : list) {
            printInformation.setNumber(Integer.toString(++i));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1000);
        map.put("data", list);
        System.out.println(map);
        return map;
    }

    @RequestMapping("/delHistoryData")
    @ResponseBody
    public String delHistoryData(@Param("fileName") String fileName) {
        System.out.println("delHistoryData: " + fileName);
        Boolean bool = printService.delHistoryData(fileName);
        if (bool) {
            return "ok";
        }
        return "error";
    }

    @RequestMapping("/finishPrint")
    @ResponseBody
    public String finishPrint(String fileName) {
        System.out.println("finish: " + fileName);
        if (printService.finishPrint(fileName)) {
            return "ok";
        }

        return "error";
    }

}
