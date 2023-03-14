public class StudentD {
  private  String id;
  private  String name;
  private  int prf;
  private  int dbm;

    public  StudentD(String i,String n){
        id=i;
        name=n;
        prf=-1;
        dbm=-1;
    }
    public String getid(){
        return id;
    }
    public void addMarksPD(int p,int d){
        prf=p;
        dbm=d;
    }
    public String getname(){
        return name;
    }
    public int getprf(){
        return prf;
    }
    public int getdbm(){
        return dbm;
    }
    public void onlyprf(int mark){
        prf=mark;
    }
    public void onlydbm(int mark){
        dbm=mark;
    }
    public void setName(String n){
        name=n;
    }
    public void setId(String n){
        id=n;
    }
}
