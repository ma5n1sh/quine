import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;


public class first {
    public static int ones(int x) {
        int n = 0;
        while (x > 0) {
            n += (x % 2);
            x /= 2;
        }
        return n;
    }

    public static int nextsec(int i, int[][] j) {
        while (j[i][0] != -1&&i<j.length-1) {
            i++;
        }
        return i + 1;

    }

    public static int istwo(int x) {
        int y = 2;
        if (x == y) return 1;
        while (x > y) {
            y *= 2;
            if (x == y) return 1;
        }
        return 0;
    }
    public static boolean longistwo(long x) {
        if(x==1){return true;}
        long y = 2;
        if (x == y) return true;
        while (x > y) {
            y *= 2;
            if (x == y) return true;
        }
        return false;
    }

    public static void arraycopier(int one[][], int two[][]) {
        int i, j;
        for (i = 0; i < one.length; i++) {
            for (j = 0; j < one[i].length; j++) {
                two[i][j] = one[i][j];
            }
        }
    }
    public static void onedarraycopier(int one[], int two[],int len) {
        int i, j;
        for (i = 0; i < len; i++) {
            two[i]= one[i];
        }
    }


    public static int piadder(int[][]arr,int[][]pi,int pilen,int len){
        int i,j;
        for(i=0;i<len;i++){
            if(arr[i][1]==0){pi[pilen][1]=arr[i][0];
                for (j=2;j<arr[0].length;j++){pi[pilen][j]=arr[i][j];}
                pilen++;
            }}
        return pilen;



    }

    public static int npiadder(int[][]arr,int[][]pi,int pilen,int len){
        int i,j;
        for(i=0;i<len;i++){if(arr[i][0]==-1){continue;}
            if(arr[i][1]==0){pi[pilen][1]=arr[i][0];
                for (j=2;j<pi[0].length;j++){pi[pilen][j]=arr[i][j];}
                pilen++;
            }}
        return pilen;



    }

    public static long tobinary(int a){
        long out=0,act=1;
        while(a!=0){out+=(a%2)*act;a=a/2;act=act*10;}
        return out;


    }
    public static int[] tobinaryarray(long a,int n){
        int[]array=new int[n];
        n--;
        BigInteger f =BigInteger.valueOf(a);
        while(!(f.equals((BigInteger.valueOf(0))))){
            array[n]=(f.remainder(BigInteger.valueOf(2))).intValue();
            n--;
            f=f.divide(BigInteger.TWO);
        }

        return array;
    }
    public static boolean maskcovers(int[][] pi,int[]mask,int[] pilist,int[]input){
        int [] ver=new int[input.length];
        for (int i=0;i<ver.length;i++){ver[i]=input[i];}
        for(int i=0;i<mask.length;i++){
            if(mask[i]==1){
                for(int j = 0; j<ver.length; j++){
                    if(isthere(pi[pilist[i]],ver[j])){ver[j]=-1;}
                }
            }
        }
        boolean check=true;
        for(int j=0;j<ver.length;j++){
            if(ver[j]!=-1){
                check=false;
            }
        }
        if(check){return true;}
        return false;
    }

    public static long[]possibilityruler(long a,int[][]pi,int[]pilist,int[]input,int n){
        if(a==0){return null;}
        long[] output=new long[(int)a];
        int q=0;
        for(int i=0;i<output.length;i++){output[i]=-1;}
        for(long g=0;g<=a;g++){
            int[]mask=tobinaryarray(g,n);
            if(maskcovers(pi,mask,pilist,input)){
                output[q]=g;
                q++;
            }
        }
        int z=0;
       /* for(int i=0;i<q;i++){if(output[i]==-1){continue;}
            for(int j=i+1;j<q;j++){if(output[j]==-1){continue;}
                if(longistwo(output[j]-output[i])){
                    output[j]=-1;
                    z++;
                }
            }
        }*/
        long[] output1=new long[q];

        for (int i=0;i<q;i++){output1[i]=output[i];}
        long[] output2=new long[q-z];
        int i=0;
        for(int j=0;j< output1.length;j++){
            if(output1[j]==-1){continue;}
            output2[i]=output1[j];
            i++;
        }
        return output2;
    }

    public static int[][] possibilitytomat(long[] output,int[]pilist){
        int[][] arr=new int[output.length][pilist.length+2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){arr[i][j]=-1;}
        }
        int act=0;
        for(int i=0;i<output.length;i++){act=0;
            int k[]=tobinaryarray(output[i],pilist.length);
            for(int j=0;j<pilist.length;j++){
                if(k[j]==1){arr[i][act]=pilist[j];act++;}
            }
        }
        return arr;
    }

    public static int[][] matcostadder(int[][] arr,int[][]pi){int j=0,i;
        for(i=0;i<arr.length;i++) {
            j = 0;
            arr[i][arr[i].length - 1] = 0;
            while (arr[i][j] != -1 && j<arr[i].length-1) {
                arr[i][arr[i].length - 1] += pi[arr[i][j]][0];
                j++;
            }
        }
        return arr;
    }

    public static String stringer(int[]arr,int n){
        int[]z=tobinaryarray((long)arr[1],n);
        int r=0;
        int[] q;
        while(2+r<arr.length&&arr[2+r]!=0){
          q=  tobinaryarray((long)arr[2+r],n);
          for (int i=0;i<q.length;i++){
              if(q[i]==1){
                  z[i]=-1;
              }
          }
          r++;
        }
        StringBuilder output=new StringBuilder();
        for(int i=0;i<z.length;i++){
            if(z[i]==1){output.append((char)(i+65));}
            else if(z[i]==0){output.append((char)(i+65));output.append((char)96);}
            else if(z[i]==-1){continue;}
        }
        return output.toString();
    }

    public static boolean isthere(int []a,int number){
        if(number==0){
            if(a[1]==0){return true;}
            else return false;
        }
        if(a[1]>number){return false;}
        number=number-a[1];
        long target=tobinary(number);
        int act=1,i,found,searched;
        while(target!=0){
            i=2;found=0;
            if(target%10==0){target=target/10;act=act*2;continue;}
            else{target=target/10;
                i=2;
                searched=(int)(act);
                while(i<a.length&&a[i]!=0){
                    if(a[i]==searched){
                        act=act*2;
                        found=1;
                        i++;
                    }
                    else{i++;}
                }
                if (found==0){return false;}
            }

        }
        return true;
    }





    public static void blanker(int arr[][]){
        int i,j;
        for (i = 0; i < arr.length; i++)
        {
            for (j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }

    }


    public static int stageonecount(int arr[][]){

        int counter=0,i;
        int c;
           for(i=0;i<arr.length-1;i++){
            c=0;
            if(arr[i][0]==-1){continue;}
            while(nextsec(i,arr)+c<arr.length&&arr[nextsec(i,arr)+c][0]!=-1){
                if(arr[nextsec(i,arr)+c][0]-arr[i][0]==1||((arr[nextsec(i,arr)+c][0]-arr[i][0])>0
                        &&istwo(arr[nextsec(i,arr)+c][0]-arr[i][0])==1))
                {counter++;}
                c++;
            }
        }
           return counter;

    }
    public static int niftycompare(int[][]arr,int i,int j){
        int c=0,k=0,flag;
        while(arr[i][2+k]!=0){flag=0;c=0;
            while(2+c<arr[j].length&&arr[j][2+c]!=0){
                if(arr[i][2+k]==arr[j][2+c]){flag=1;break;}
                c++;
            }
         if(flag==0){return 0;}
         k++;
        }
        return 1;
    }

    public static int stagencounter(int[][]arr,int len){
        int counter=0,i;
        int c;
        for(i=0;i<len;i++){
            c=0;
            if(arr[i][0]==-1){continue;}
            while(nextsec(i,arr)+c<len&&arr[nextsec(i,arr)+c][0]!=-1){
                if((arr[nextsec(i,arr)+c][0]-arr[i][0]==1&&niftycompare(arr,i,nextsec(i,arr)+c)==1)||((arr[nextsec(i,arr)+c][0]-arr[i][0])>0
                        &&istwo(arr[nextsec(i,arr)+c][0]-arr[i][0])==1&&niftycompare(arr,i,nextsec(i,arr)+c)==1))
                {counter++;}
                c++;
            }
        }
        return counter;

    }

    public static int comparator(int[][] current,int arr[][],int n){
        int c,i;
        int counter=0;
        for(i=0;i<arr.length-1;i++){
            c=0;
            if(arr[i][0]==-1){current[counter][0]=-1;counter++;continue;}
            while(nextsec(i,arr)+c<arr.length&&arr[nextsec(i,arr)+c][0]!=-1){
                if(arr[nextsec(i,arr)+c][0]-arr[i][0]==1||((arr[nextsec(i,arr)+c][0]-arr[i][0])>0
                        &&istwo(arr[nextsec(i,arr)+c][0]-arr[i][0])==1))
                {   arr[nextsec(i,arr)+c][1]=1;arr[i][1]=1;
                    current[counter][0]=arr[i][0];
                    current[counter][1]=0;
                    current[counter][2]=arr[nextsec(i,arr)+c][0]-arr[i][0];
                    counter++;
                }
                c++;
            }
        }
        return counter;

    }

    public static int ncomparator(int current[][],int arr[][],int len){
        int c,i,k,j;
        int counter=0;
        for(i=0;i<len;i++){
            c=0;
            if(arr[i][0]==-1){current[counter][0]=-1;counter++;continue;}
            while(nextsec(i,arr)+c<arr.length&&arr[nextsec(i,arr)+c][0]!=-1){
                if((arr[nextsec(i,arr)+c][0]-arr[i][0]==1&&niftycompare(arr,i,nextsec(i,arr)+c)==1)||((arr[nextsec(i,arr)+c][0]-arr[i][0])>0
                        &&istwo(arr[nextsec(i,arr)+c][0]-arr[i][0])==1&&niftycompare(arr,i,nextsec(i,arr)+c)==1))
                {   k=0;
                    arr[nextsec(i,arr)+c][1]=1;arr[i][1]=1;
                    current[counter][0]=arr[i][0];
                    current[counter][1]=0;
                    while(arr[i][2+k]!=0){current[counter][2+k]=arr[i][2+k];k++;}
                    current[counter][2+k]=arr[nextsec(i,arr)+c][0]-arr[i][0];
                    counter++;
                }
                c++;
            }
        }
        return counter;
    }
    public static void rowcopier(int[][] arr,int i,int j){//ban2el mn el j lel i
        int k;
        for(k=0;k<arr[i].length;k++){
            arr[i][k]=arr[j][k];
        }
    }

    public static int dedublicator(int[][] arr,int len){
        int i,j,k;
        for(i=0;i<len;i++){
            if(arr[i][0]==-1){continue;}
            for(j=i+1;arr[j][0]!=-1;j++){
                if(arr[i][0]==arr[j][0]&&niftycompare(arr,i,j)==1){
                    for(k=j;k<len;k++){
                        rowcopier(arr,k,k+1);
                    }
                    len--;
                }
            }
        }
        return len;
    }

    public static void costcalc(int arr[][],int len,int n){
        int i,j,cost=0;
        for(i=0;i<len;i++){j=0;
            cost=(n-ones(arr[i][1]))*2+ones(arr[i][1]);
            while(2+j<arr[i].length&&arr[i][2+j]!=0){cost-=2;j++;}
            cost++;
            arr[i][0]=cost;
        }

    }

    public static boolean lineliner(int[][]arr,int a,int b){
        int i=0,j=0,flag;
        while(i<arr[a].length&&arr[a][i]!=-1){
            j=0;flag=0;
            while(j<arr[b].length&&arr[b][j]!=-1&&i<arr[a].length){
                if(arr[a][i]==arr[b][j]){flag=1;}
                j++;
            }
            if(flag==0){return false;}
            else{i++;}
        }
        return true;
    }


    public static void main(String args[]){

       //getting input
        Scanner dis=new Scanner(System.in);
        int input1[];
        String line;
        String[] lineVector;
        line = dis.nextLine();
        lineVector = line.split(",");
        input1=new int[lineVector.length];
        int i;
        for(i=0;i<lineVector.length;i++){
            input1[i]=Integer.parseInt(lineVector[i]);
        }


        //______________________________________________________________
        int dc[];
        int[] input;
        String line2 = null;
        String[] lineVector2;
        line2 = dis.nextLine();
        if(line2.length()!=0) {
            lineVector2 = line2.split(",");
            dc = new int[lineVector2.length];
            for (i = 0; i < lineVector2.length; i++) {
                dc[i] = Integer.parseInt(lineVector2[i]);
            }
            input = new int[dc.length + input1.length];
            for (i = 0; i < input1.length; i++) {
                input[i] = input1[i];
            }
            for (i = input1.length; i < dc.length + input1.length; i++) {
                input[i] = dc[i - input1.length];
            }
        }
        else{input=new int[input1.length];
        for (i=0;i<input1.length;i++){input[i]=input1[i];}
        }
        //______________________________________________________________
        int large=input[0];
        for(i=0;i<input.length;i++){
            if(input[i]>large){large=input[i];}
        }
        int n=0;
        do{n++;large/=2;}while(large>0);
        System.out.println(n);
        //sorting them according to the number of ones
        int[] sorted =new int[input.length+n+1];
        int j,k=0;
        for(j=0;j<=n;j++){
            for(i=0;i<input.length;i++){
                if(ones(input[i])==j){
                    sorted[k]=input[i];
                    k++;
                }
            }
            sorted[k]=-1;
            k++;
        }


        int[][] arr=new int[input.length+n+1][n+1];

        for(j=0;j<input.length+n+1;j++){
            arr[j][0]=sorted[j];
            if(sorted[j]==-1){arr[j][1]=-1;}
            else{arr[j][1]=0;}
        }

        int counter=0;
       /* for(j=0;j<input.length+n+1;j++){
            System.out.println(arr[j][0]+" "+arr[j][1]);
        }*/
        counter=stageonecount(arr);
       // System.out.println(counter);
        int maxlen=input.length*input.length+n+1;
        int[][] current=new int [maxlen][n+1];
        int currentlen=comparator(current,arr,n);
        int[][] pi=new int [maxlen][n+1];
        int pilen=0;
        pilen=piadder(arr,pi,pilen,arr.length);


        /*    System.out.println(current[j][0]+" "+current[j][1]+" "+current[j][2]);
        }*/
        int currentwo[][]=new int[current.length][current[0].length];
        int two;
        counter = stagencounter(current, currentlen);
       // System.out.println(counter);
        for(i=0;i<n-1;i++) {
            arraycopier(current, currentwo);
            blanker(current);
            two=dedublicator(currentwo,currentlen);
            currentlen = ncomparator(current, currentwo, currentlen);
            pilen=npiadder(currentwo,pi,pilen,two);
            //currentlen = ncomparator(current, currentwo, currentlen);
            two=dedublicator(currentwo,currentlen);
            currentlen = dedublicator(current, currentlen);
            /*for (j = 0; j < currentlen; j++) {
                System.out.println(current[j][0] + " " + current[j][1] + " " + current[j][2] + " " + current[j][3]);
            }
            System.out.println("------------------------------------");*/
        }
        costcalc(pi,pilen,n);
       /* for (j = 0; j < pilen; j++) {
            System.out.println(pi[j][0] + " " + pi[j][1] + " " + pi[j][2] + " " + pi[j][3]);
        }*/
       System.out.println("Prime Implicants:");
        for (j = 0; j < pilen; j++) {i=0;
            System.out.print(pi[j][1]+" ");
            System.out.print("(");
            while(2+i<pi[j].length&&pi[j][2+i]!=0){
                System.out.print(pi[j][2+i]);
                i++;
                if(2+i<pi[j].length&&pi[j][2+i]!=0){System.out.print(",");}
            }
            System.out.print(")");
            System.out.println(" cost= "+pi[j][0]);
        }
        input=input1;

        //essential pi selector
        //__________________________________________________________________
        int inputcount[]=new int[input.length];
        for(i=0;i<input.length;i++){
            for(j=0;j<pilen;j++){
                if(isthere(pi[j],input[i])){inputcount[i]++;}
            }
        }
        //for(i=0;i<input.length;i++){System.out.print("%"+input[i]+"  ");}
       // System.out.println();
        //for(i=0;i<input.length;i++){System.out.print("%"+inputcount[i]+"   ");}
        int pilist[]=new int[pilen];
        int finallist[]=new int[pilen];
        int finalcount=0;
        int[] inputlist=new int[input.length];
        for(i=0;i<pilen;i++){pilist[i]=i;}
        for(i=0;i<input.length;i++){inputlist[i]=input[i];}
        for(i=0;i<inputcount.length;i++){
            if(inputcount[i]==1){
                inputlist[i]=-1;
                for(j=0;j<pilen;j++){
                        if(isthere(pi[j],input[i])){
                            pilist[j]=-1;
                            finallist[finalcount]=j;
                            finalcount++;
                            for(k=0;k<input.length;k++){
                                if(isthere(pi[j],inputlist[k])){inputlist[k]=-1;inputcount[k]=2;}
                            }
                        }
                }

            }


        }

        //System.out.println();
        //for(i=0;i<inputlist.length;i++){System.out.print("#"+inputlist[i]+"  ");}
       // System.out.println();
        //System.out.println("***************************------------------------------------");
       // for (i = 0; i < pilist.length; i++) {if(pilist[i]==-1){continue;}
       //     System.out.println(pi[pilist[i]][0] + " " + pi[pilist[i]][1] + " " + pi[pilist[i]][2] + " " + pi[pilist[i]][3]);
       // }
        //System.out.println("***************************------------------------------------");
        System.out.println("_________________________________________________________________");
        System.out.println("Essential Prime Implicants:");
        for (j = 0; j < finalcount; j++) {i=0;
            System.out.print(pi[finallist[j]][1]+" ");
            System.out.print("(");
            while(2+i<pi[j].length&&pi[j][2+i]!=0){
                System.out.print(pi[finallist[j]][2+i]);
                i++;
                if(2+i<pi[j].length&&pi[j][2+i]!=0){System.out.print(",");}
            }
            System.out.print(")");
            System.out.println(" cost= "+pi[finallist[j]][0]);
        }


        //end of essential pi selector
        //inputlist has the inputs not covered by essential pi-s and -1 for the ones covered by an essential pi
        //pilist has indexes of non essential pi-s and -1 for the indexes of the essential ones
        //finallist has all the essential pi-s and finalcount has their number
        //________________________________________________________________________________________________
        //this sections checks for row dominance
        int pilistcount=0,inputlistcount=0;
        for(i=0;i<pilist.length;i++){if(pilist[i]!=-1){pilistcount++;}}
        for(i=0;i<inputlist.length;i++){if(inputlist[i]!=-1){inputlistcount++;}}
        if(inputlistcount!=0) {
            int[][] tableau = new int[pilistcount][inputlistcount + 3];
            for (j = 0; j < tableau.length; j++) {
                for (i = 0; i < tableau[j].length; i++) {
                    tableau[j][i] = -1;
                }
            }
            int t, z = -1;
            for (i = 0; i < pilist.length; i++) {
                t = 0;
                if (pilist[i] == -1) {
                    continue;
                }
                z++;
                for (j = 0; j < inputlist.length; j++) {
                    if (inputlist[j] == -1) {
                        continue;
                    }
                    if (isthere(pi[pilist[i]], inputlist[j])) {
                        tableau[z][t] = inputlist[j];
                        t++;
                    }
                }
                tableau[z][inputlistcount] = t;
                tableau[z][inputlistcount + 1] = pi[pilist[i]][0];
                tableau[z][inputlistcount + 2] = pilist[i];
            }
           /* for (j = 0; j < tableau.length; j++) {
                for (i = 0; i < tableau[j].length; i++) {
                    System.out.print(tableau[j][i] + "  ");
                }
                System.out.println();
            }*/
            for (j = 0; j < tableau.length; j++) {
                for (i = 0; i < tableau.length; i++) {
                    if (i == j) {
                        continue;
                    }
                    if (pilist[tableau[j][inputlistcount + 2]] == -1) {
                        continue;
                    }
                    if (pilist[tableau[i][inputlistcount + 2]] == -1) {
                        continue;
                    }
                    if (lineliner(tableau, j, i)) {
                        if (tableau[j][inputlistcount] > tableau[i][inputlistcount]) {
                            pilist[tableau[i][inputlistcount + 2]] = -1;
                        } else if (tableau[j][inputlistcount] < tableau[i][inputlistcount]) {
                            pilist[tableau[j][inputlistcount + 2]] = -1;
                        } else {
                            if (tableau[j][inputlistcount + 1] < tableau[i][inputlistcount + 1]) {
                                pilist[tableau[j][inputlistcount + 2]] = -1;
                            } else if (tableau[j][inputlistcount + 1] > tableau[i][inputlistcount + 1]) {
                                pilist[tableau[i][inputlistcount + 2]] = -1;
                            } else {
                                pilist[tableau[i][inputlistcount + 2]] = -1;
                            }
                        }
                    }
                }
            }
            System.out.println("------------------------------------");
            //at the end of this section row dominance is checked
            //pilist contains indexes of non essential pi not eliminated by row dominance else -1
            //inputlist contains input not covered by essential pi else -1
            int pic = 0, inputc = 0;
            for (i = 0; i < pilist.length; i++) {
                if (pilist[i] != -1) {
                    pic++;
                }
            }
            for (j = 0; j < inputlist.length; j++) {
                if (inputlist[j] != -1) {
                    inputc++;
                }
            }
            long masklimit = (long) Math.pow(2, pic);
            masklimit--;
            int pimask[] = new int[pic];
            int inputmask[] = new int[inputc];
            k = 0;
            for (i = 0; i < pilist.length; i++) {
                if (pilist[i] == -1) {
                    continue;
                }
                pimask[k] = pilist[i];
                k++;
            }
            k = 0;
            for (i = 0; i < inputlist.length; i++) {
                if (inputlist[i] == -1) {
                    continue;
                }
                inputmask[k] = inputlist[i];
                k++;
            }


           /* for (i = 0; i < pilist.length; i++) {
                if (pilist[i] == -1) {
                    continue;
                } else {
                    System.out.println(pi[pilist[i]][0] + " " + pi[pilist[i]][1] + " " + pi[pilist[i]][2] + " " + pi[pilist[i]][3]);
                }

            }*/
            if (inputc != 0) {
                long eee[] = possibilityruler(masklimit, pi, pimask, inputmask, pic);

                int[][] qqq = possibilitytomat(eee, pimask);
                qqq = matcostadder(qqq, pi);
                /*for (i = 0; i < qqq.length; i++) {
                    j = 0;
                    while (qqq[i][j] != -1) {
                        System.out.println("f # " + pi[qqq[i][j]][0] + "  " + pi[qqq[i][j]][1] + "  " + pi[qqq[i][j]][2] + "  " + pi[qqq[i][j]][3]);
                        j++;
                    }
                    System.out.println(qqq[i][qqq[i].length - 1]);
                    System.out.println("_____________________________________________________________________");
                }*/
                int least = qqq[0][qqq[0].length - 1], leastindex = 0;
                for (i = 1; i < qqq.length; i++) {
                    if (qqq[i][qqq[0].length - 1] < least) {
                        least = qqq[i][qqq[0].length - 1];
                        leastindex = i;
                    }
                }
                j = 0;
                while (qqq[leastindex][j] != -1) {
                    finallist[finalcount] = qqq[leastindex][j];
                    j++;
                    finalcount++;
                }
            }
        }
        System.out.println(finalcount);
        for(i=0;i<finalcount;i++){
            System.out.print(stringer(pi[finallist[i]],n));
            if(i<finalcount-1){System.out.print(" + ");}
        }
        //for(i=0;i<tobinaryarray((long)pi[7][1],n).length;i++){System.out.print(tobinaryarray((long)pi[7][1],n)[i]);}

    }
}
