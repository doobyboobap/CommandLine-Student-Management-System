public class StudentList {
   private StudentD[] stArray=new StudentD[0];

   public void extendAr(){
      StudentD[] temp=new StudentD[stArray.length+1];
      for (int i=0;i<stArray.length;i++){
         temp[i]=stArray[i];
      }
      
      stArray=temp;
   }
   public void addNewStudent(String i,String n){
    StudentD s1=new StudentD(i,n);
    extendAr();
    stArray[stArray.length-1]=s1;
   }
    public  boolean sIdcheck(String dd){
        boolean x=true;
        for (int i = 0; i <stArray.length; i++)
        {
            if(dd.equals(stArray[i].getid())){
                x=false;
                break;
            }
        }
        return x;
    }
    public void addMarksprf_dbm(int[] m){
       stArray[stArray.length-1].addMarksPD(m[0],m[1]);
    }

    public  boolean search(String id){
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                return true;
            }
        }
        return false;
    }
    public  String getName(String id){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
                break;
            }
        }
        String name =stArray[index].getname();
        return name;
    }
    public  boolean checkMarks(String id){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
                break;
            }
        }
        if((stArray[index].getprf())==-1 && (stArray[index].getdbm())==-1){
            return true;
        }
        return false;
    }
    public  void onlyMarksprf(String id,int m){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
                break;
            }
        }
        stArray[index].onlyprf(m);

    }
    public  void onlyMarksdbm(String id,int m){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
                break;
            }
        }
        stArray[index].onlydbm(m);
    }
    public  void updateName(String id,String name){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
            }
        }
        stArray[index].setName(name);
    }
    public  int getprfMarks(String id){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
                break;
            }
        }
        return stArray[index].getprf();
    }
    public  int getdbmMarks(String id){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
                break;
            }
        }
        return stArray[index].getdbm();
    }
    public  void deleteS(String id){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
            }
        }

        StudentD[] temp=new StudentD[stArray.length-1];
        stArray[index].setId("delete");
        int c=0;
        L1:		for (int i = 0; i <stArray.length; i++)
        {
            if("delete".equals(stArray[i].getid())){
                continue L1;
            }

            temp[c]=stArray[i];
            c++;

        }
        stArray=temp;
    }
    public  void  printStudentD(String id){
        int index=-1;
        for (int i = 0; i <stArray.length; i++)
        {
            if(id.equals(stArray[i].getid())){
                index=i;
            }
        }
        int tot=stArray[index].getprf()+stArray[index].getdbm();
        double avg=tot/2.0;
        System.out.println("+----------------------------------+---------------+");
        System.out.printf("%-1s%-32s%3s%15d%1s\n","|","Programming Fundamentals Marks","|",stArray[index].getprf(),"|");
        System.out.printf("%-1s%-32s%3s%15d%1s\n","|","Database Management System Marks","|",stArray[index].getdbm(),"|");
        System.out.printf("%-1s%-32s%3s%15d%1s\n","|","Total Marks","|",tot,"|");
        System.out.printf("%-1s%-32s%3s%15.2f%1s\n","|","Avg. Marks","|",avg,"|");
        System.out.printf("%-1s%-32s%3s%15s%1s\n","|","Rank","|",rank(id),"|");
        System.out.println("+----------------------------------+---------------+");
    }
    public  String rank(String id){
        int[] tot=new int[stArray.length];
        for (int i = 0; i <stArray.length; i++)
        {
            tot[i]=stArray[i].getprf()+stArray[i].getdbm();
        }

        String[] idn=new String[stArray.length];
        for (int i = 0; i <stArray.length; i++)
        {
            idn[i]=stArray[i].getid();
        }

        for (int i =tot.length-1; i>0; i--)
        {
            for (int j =i-1; j>=0; j--)
            {
                if(tot[j]<tot[i]){
                    int t=tot[j];
                    tot[j]=tot[i];
                    tot[i]=t;

                    String x=idn[j];
                    idn[j]=idn[i];
                    idn[i]=x;
                }
            }

        }
        int index=-1;
        for (int i = 0; i <idn.length; i++)
        {
            if(id.equals(idn[i])){
                index=i;
            }
        }
        if(index==0){
            return "1 (First)";
        }else if(index==1){
            return "2 (Second)";
        }else if(index==2){
            return "3 (Third)";
        }else if(index==idn.length-1){
            String f="";
            f +=(index+1)+" (Last)";
            return f;
        }
        String r="";
        r +=index+1;
        return r;

    }
    public  void printrank(){
        int[] total=new int[0];

        for (int i = 0; i <stArray.length; i++)
        {
            int[] temptot=new int[total.length+1];
            for (int j = 0; j<temptot.length; j++)
            {
                temptot[j]=stArray[j].getprf()+stArray[j].getdbm();
            }
            total=temptot;
        }
        double[] avarage=new double[0];
        for (int i = 0; i <total.length; i++)
        {
            double[] tempavg=new double[avarage.length+1];
            for (int j = 0; j<tempavg.length; j++)
            {
                tempavg[j]=total[j]/2.0;
            }
            avarage=tempavg;
        }
        //---------------------copy--------------------
        StudentD[] temp=new StudentD[stArray.length];

        for (int j = 0; j <temp.length; j++)
        {
            temp[j]=stArray[j];
        }

        //--------------sort---------------------------

        for (int i =0; i<avarage.length-1; i++)
        {
            for (int  j=i+1; j<avarage.length; j++)
            {

                if(avarage[i]>avarage[j]){

                    double te=avarage[i];
                    avarage[i]=avarage[j];
                    avarage[j]=te;

                    StudentD ob=temp[i];
                    temp[i]=temp[j];
                    temp[j]=ob;

                    int t=total[i];
                    total[i]=total[j];
                    total[j]=t;
                }
            }
        }
        int v=0;
        System.out.println("+-------+-------+------------------------------+------------+------------+");
        System.out.println("Rank    |ID     |Name                          | Total Marks| Avg. Marks |");
        System.out.println("+-------+-------+------------------------------+------------+------------+");
        for (int i = avarage.length-1; i>=0; i--)
        {
            if(avarage[i]!=-1.00){
                v++;
                System.out.printf("%-1s%-7d%-1s%-7s%-1s%-30s%-1s%12d%-1s%12.2f%-1s\n","|",v,"|",temp[i].getid(),"|",temp[i].getname(),"|",total[i],"|",avarage[i],"|");
            }
        }
        System.out.println("+-------+-------+------------------------------+------------+------------+\n");
    }
    public  void  printBestprf(){
        StudentD[] temp=new StudentD[stArray.length];

        for (int i = 0; i <stArray.length; i++)
        {
            temp[i]=stArray[i];
        }

        for (int i =temp.length-1; i>0; i--)
        {
            for (int j=i-1; j>=0; j--)
            {
                if(temp[i].getprf()>temp[j].getprf()){
                    StudentD p=temp[j];
                    temp[j]=temp[i];
                    temp[i]=p;
                }
            }
        }
        System.out.println("+--------+----------------------------+--------+----------+");
        System.out.println("|ID      |Name                        |PF Marks|DBMS Marks|");
        System.out.println("+--------+----------------------------+--------+----------+");
        for (int i = 0; i <temp.length; i++)
        {
            if(temp[i].getprf()!=-1){
                System.out.printf("%-1s%-8s%-1s%-28s%-1s%-8d%-1s%-10d%-1s\n","|",temp[i].getid(),"|",temp[i].getname(),"|",temp[i].getprf(),"|",temp[i].getdbm(),"|");
            }
        }
        System.out.println("+--------+----------------------------+--------+----------+");
    }
    public  void  printBestdbm(){
        StudentD[] temp=new StudentD[stArray.length];

        for (int i = 0; i <stArray.length; i++)
        {
            temp[i]=stArray[i];
        }

        for (int i =temp.length-1; i>0; i--)
        {
            for (int j=i-1; j>=0; j--)
            {
                if(temp[i].getdbm()>temp[j].getdbm()){
                    StudentD v=temp[j];
                    temp[j]=temp[i];
                    temp[i]=v;
                }
            }

        }
        System.out.println("+--------+----------------------------+----------+--------+");
        System.out.println("|ID      |Name                        |DBMS Marks|PF Marks|");
        System.out.println("+--------+----------------------------+----------+--------+");
        for (int i = 0; i <temp.length; i++)
        {
            if(temp[i].getdbm()!=-1){
                System.out.printf("%-1s%-8s%-1s%-28s%-1s%-10d%-1s%-8d%-1s\n","|",temp[i].getid(),"|",temp[i].getname(),"|",temp[i].getdbm(),"|",temp[i].getprf(),"|");
            }
        }
        System.out.println("+--------+----------------------------+----------+--------+");
    }

}
