public class Jatekos {
    private int dobasok[];
    private boolean dobhato[];
    private Pontok pontok;
    private int kor;
    private int pont;
    
    Jatekos(){
        dobasok=new int[5];
        dobhato=new boolean[dobasok.length];
        for (int i=0;i<dobhato.length;i++){
            this.dobhato[i]=true;
        }
        pontok=new Pontok();
        kor=0;
        pont=0;
    }
    public int getKor(){
        return this.kor;
    }
    public void Pontn(){
        pont=0;
    }
    public int Pont(int p){
        pont+=p;
        return pont;
    }
    public int Pont(){
        return pont;
    }
    public void Dobas(){
        for (int i=0;i<dobasok.length;i++){
            if (dobhato[i]){
                dobasok[i]=(int)(Math.random()*6)+1;
            }
        }
        kor++;
    }
    public boolean[] getDobhato(){
        return dobhato;
    }
    public int getDobasAt(int i){
        return dobasok[i];
    }
    public void setDobhatoAt(int i, boolean b){
        dobhato[i]=b;
    }
    public void ujKor(){
        for (int i=0;i<dobhato.length;i++){
            this.dobhato[i]=true;
        }
        kor=0;
    }
    public int Egyesek(){
        if (pontok.egyesek==-1) {
            pontok.egyesek=0;
        for (int i=0;i<dobasok.length;i++){
            if (dobasok[i]==1){
                pontok.egyesek++;
            }
        }
        return pontok.egyesek;
        }
        return 0;
    }
    public int Kettesek(){
        if (pontok.kettesek==-1) {
            pontok.kettesek=0;
        for (int i=0;i<dobasok.length;i++){
            if (dobasok[i]==2){
                pontok.kettesek++;
            }
        }
        return pontok.kettesek;
        }
        
        return 0;
    }
    public int Harmasok(){
        if (pontok.harmasok==-1) {
            pontok.harmasok=0;
        for (int i=0;i<dobasok.length;i++){
            if (dobasok[i]==3){
                pontok.harmasok++;
            }
        }
        return pontok.harmasok;
        }
        
        return 0;
    }
    public int Negyesek(){
        if (pontok.negyesek==-1) {
            pontok.negyesek=0;
        for (int i=0;i<dobasok.length;i++){
            if (dobasok[i]==4){
                pontok.negyesek++;
            }
        }
        return pontok.negyesek;
        }
        
        return 0;
    }
    public int Otosok(){
        if (pontok.otosok==-1) {
            pontok.otosok=0;
        for (int i=0;i<dobasok.length;i++){
            if (dobasok[i]==5){
                pontok.otosok++;
            }
        }
        return pontok.otosok;
        }
        
        return 0;
    }
    public int Hatosok(){
        if (pontok.hatosok==-1) {
            pontok.hatosok=0;
        for (int i=0;i<dobasok.length;i++){
            if (dobasok[i]==6){
                pontok.hatosok++;
            }
        }
        return pontok.hatosok;
        }
        
        return 0;
    }
    
    
    public boolean isUres(int i){
        switch (i){
            case 1:
                if (pontok.egyesek==-1){
                    return true;
                }
                else {
                    return false;
                }
            case 2:
                if (pontok.kettesek==-1){
                    return true;
                }
                else {
                    return false;
                }
            case 3:
                if (pontok.harmasok==-1){
                    return true;
                }
                else {
                    return false;
                }
            case 4:
                if (pontok.negyesek==-1){
                    return true;
                }
                else {
                    return false;
                }
            case 5:
                if (pontok.otosok==-1){
                    return true;
                }
                else {
                    return false;
                }
            case 6:
                if (pontok.hatosok==-1){
                    return true;
                }
                else {
                    return false;
                }
            default :{
                return false;
            }
                
        }
    }
    public boolean kovetkezoKOR(){
        if (pontok.egyesek!=-1 && pontok.kettesek!=-1 && pontok.harmasok!=-1 && pontok.negyesek!=-1 && pontok.otosok!=-1 && pontok.hatosok!=-1){
            return true;
        }
        return false;
    }
    
    public int Par(){
        pontok.par=0;
        int max=0;
        for (int i=0;i<dobasok.length-1;i++){
            for (int j=i+1;j<dobasok.length;j++){
                if (dobasok[i]==dobasok[j]){
                    if (dobasok[i]==6){
                        return 12;
                    }
                    else if (max<dobasok[i]){
                        max=dobasok[i];
                    }
                }
            }
        }
        pontok.par=max*2;
        return pontok.par;
    }
    
    public int Tripla(){
        pontok.tripla=0;
        int max=0;
        for (int i=0;i<dobasok.length-2;i++){
            for (int j=i+1;j<dobasok.length-1;j++){
                for (int k=j+1;k<dobasok.length;k++){
                    if (dobasok[i]==dobasok[j] && dobasok[j]==dobasok[k]){
                        if (dobasok[i]==6){
                            return 18;
                        }
                        else if (max<dobasok[i]){
                            max=dobasok[i];
                        }
                    }
                }
            }
        }
        pontok.tripla=max*3;
        return pontok.tripla;
    }
   
    public int Poker(){
        pontok.poker=0;
        if (dobasok[0]==dobasok[1] && dobasok[0]==dobasok[2] && dobasok[0]==dobasok[3] && dobasok[0]==dobasok[4] ){
            return dobasok[0]*5;
        }
        return 0;
    }
    
    public int Quadra(){
        pontok.quadra=0;
        int seged;
        int d[]=dobasok;
        for (int i=0;i<dobasok.length-1;i++){
            for (int j=i+1;j<dobasok.length;j++){
                if (d[i]<d[j]){
                    seged=d[i];
                    d[i]=d[j];
                    d[j]=seged;
                }
            }
        }
        if ((d[0]==d[1] && d[0]==d[2] && d[0]==d[3])||(d[4]==d[1] && d[4]==d[2] && d[4]==d[3])){
            return d[2]*4;
        }
        return 0;
    }
    public int kisSor(){
        pontok.kissor=0;
        int seged;
        int d[]=dobasok;
        for (int i=0;i<dobasok.length-1;i++){
            for (int j=i+1;j<dobasok.length;j++){
                if (d[i]<d[j]){
                    seged=d[i];
                    d[i]=d[j];
                    d[j]=seged;
                }
            }
        }
        if ((d[0]==5 && d[1]==4 && d[2]==3 && d[3]==2 && d[4]==1)){
            return 15;
        }
        return 0;
    }
    public int nagySor(){
        pontok.nagysor=0;
        int seged;
        int d[]=dobasok;
        for (int i=0;i<dobasok.length-1;i++){
            for (int j=i+1;j<dobasok.length;j++){
                if (d[i]<d[j]){
                    seged=d[i];
                    d[i]=d[j];
                    d[j]=seged;
                }
            }
        }
        if ((d[0]==6 && d[1]==5 && d[2]==4 && d[3]==3 && d[4]==2)){
            return 20;
        }
        return 0;
    }
    public int duplaPar(){
        pontok.duplapar=0;
        int seged;
        int d[]=dobasok;
        for (int i=0;i<dobasok.length-1;i++){
            for (int j=i+1;j<dobasok.length;j++){
                if (d[i]<d[j]){
                    seged=d[i];
                    d[i]=d[j];
                    d[j]=seged;
                }
            }
        }
        if (d[0]==d[1] && d[2]==d[3]){
            return (d[0]+d[1]+d[2]+d[3]);
        }
        else if (d[0]==d[1] && d[3]==d[4]){
            return (d[0]+d[1]+d[4]+d[3]);
        }
        else if (d[2]==d[1] && d[3]==d[4]){
            return (d[4]+d[1]+d[2]+d[3]);
        }
        else{
            return 0;
        }
        
    }
    public int fullHouse(){
        pontok.fullhouse=0;
        int seged;
        int d[]=dobasok;
        for (int i=0;i<dobasok.length-1;i++){
            for (int j=i+1;j<dobasok.length;j++){
                if (d[i]<d[j]){
                    seged=d[i];
                    d[i]=d[j];
                    d[j]=seged;
                }
            }
        }
        if ((d[0]==d[1] && d[1]==d[2] && d[3]==d[4])||(d[4]==d[3] && d[3]==d[2] && d[1]==d[0])){
            return 40;
        }
        return 0;
    }
    public int kuka(){
        pontok.kuka=0;
        return (dobasok[0]+dobasok[1]+dobasok[2]+dobasok[3]+dobasok[4]);
    }
    
    public boolean Vege(){
        if (pontok.duplapar!=-1 && pontok.par!=-1 && pontok.tripla!=-1 && pontok.quadra!=-1 && pontok.poker!=-1 && pontok.kissor!=-1 && pontok.nagysor!=-1 && pontok.fullhouse!=-1 && pontok.kuka!=-1){
            return true;
        }
        return false;
    }
    public int getduplapar(){return pontok.duplapar;}
    public int getpar(){return pontok.par;}
    public int gettripla(){return pontok.tripla;}
    public int getquadra(){return pontok.quadra;}
    public int getpoker(){return pontok.poker;}
    public int getkissor(){return pontok.kissor;}
    public int getnagysor(){return pontok.nagysor;}
    public int getfullhouse(){return pontok.fullhouse;}
    public int getkuka(){return pontok.kuka;}
    
    
    
}
