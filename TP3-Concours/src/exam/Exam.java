package exam;

import factory.ExamFactory;

public class Exam {

    private String supervisor;
    private String name;
    private ExamFactory factory;

    public Exam(ExamFactory ea) {
        factory=ea;
    }

}
