package quiz.dao;

import java.time.LocalDate;
import java.util.List;

import quiz.entity.Reports;

public interface reportDao {
boolean addEntry(int sid,int eid,String sname,String ename,String lang,String marks, LocalDate date, char flag);
List<Reports> getbyExamID(int eid);

boolean clearAll();
List<Reports> getTopper(int eid);
public List<Reports> getallExamsForId(int id);
}
