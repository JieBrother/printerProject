package org.lwh.printer.pojo;

public class PrintInformation {

    private String number;
    private String id;
    private String name;
    private String fileName;
    private String paperSize;
    private String way;
    private String option;
    private String notes;
    private String status;

    public PrintInformation() {
    }

    public PrintInformation(String number, String id, String name, String fileName, String paperSize, String way, String option, String notes, String status) {
        this.number = number;
        this.id = id;
        this.name = name;
        this.fileName = fileName;
        this.paperSize = paperSize;
        this.way = way;
        this.option = option;
        this.notes = notes;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PrintInformation{" +
                "number='" + number + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fileName='" + fileName + '\'' +
                ", paperSize='" + paperSize + '\'' +
                ", way='" + way + '\'' +
                ", option='" + option + '\'' +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
