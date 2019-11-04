package se.iuh.lop_sinhvien;

public class SinhVien {
    private int id;
    private String name;
    private String classname;
    private String subject;

    public int getId() {
        return id;
    }

    public SinhVien(int id, String name, String classname, String subject) {
        this.id = id;
        this.name = name;
        this.classname = classname;
        this.subject = subject;
    }

    public SinhVien() {

    }

    public SinhVien(String name, String classname, String subject) {
        this.name = name;
        this.classname = classname;
        this.subject = subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

