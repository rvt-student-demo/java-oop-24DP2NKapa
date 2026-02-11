package streg;

import java.io.*;
import java.util.*;
import java.time.*;

public class Student {
    private String vards;
    private String uzvards;
    private String epasts;
    private String perskods;
    private LocalDateTime timestamp;

    public Student (String name, String surname, String email, String code, LocalDateTime stamp) {
        this.vards = name;
        this.uzvards = surname;
        this.epasts = email;
        this.perskods = code;
        this.timestamp = stamp;
    }
}
