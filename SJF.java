import java.util.Scanner;
class SJF
{
public static void main(String args[])
{
    Scanner sc  = new Scanner(System.in);

int i,n,p[]=new int[10],min,k=1,btime=0,tot_tat=0,tot_wt=0;
int bt[]=new int[10],temp,j,at[]=new int[10],wt[]=new int[10],tat[]=new int[10],ct[] = new int[10];
float avg_tat=0,avg_wt=0;


System.out.println("\nEnter the No. of processes :");
n = sc.nextInt();
for(i=0;i<n;i++)
{
    p[i] = i+1;
}
System.out.println("Arrival Time  Burst Time");
for(i=0;i<n;i++)
{

at[i] = sc.nextInt();
bt[i] = sc.nextInt();
}
 
/*Sorting According to Arrival Time*/
 
for(i=0;i<n;i++)
{
    for(j=0;j<n;j++)
    {
        if(at[i]<at[j])
        {
            temp=p[j];
            p[j]=p[i];
            p[i]=temp;
            temp=at[j];
            at[j]=at[i];
            at[i]=temp;
            temp=bt[j];
            bt[j]=bt[i];
            bt[i]=temp;
        }
    }
}

 
/*Arranging the table according to Arrival time
and Burst time
*/
 
for(i=0;i<n;i++)
{
    btime = btime + bt[i];
    min = bt[k];
    
    for(j=k;j<n;j++)
    {
        if (btime>=at[j] && bt[j]<min)
        {
            temp=p[k];
            p[k]=p[j];
            p[j]=temp;
            temp=at[k];
            at[k]=at[j];
            at[j]=temp;
            temp=bt[k];
            bt[k]=bt[j];
            bt[j]=temp;
        }
    }
    k++;
}



for(i=0;i<n;i++)
{
    if(i==0)
        ct[i] = at[i] + bt[i];
    else
    {
        if(at[i]>ct[i-1])
        {
            ct[i] = at[i] + bt[i];
        }
        else{
            ct[i] = ct[i-1] + bt[i];
        }
    }
}
 

for(i=0;i<n;i++)
{
    tat[i] = ct[i]-at[i];
    wt[i] = tat[i]-bt[i];
    tot_tat = tot_tat + tat[i];
    tot_wt = tot_wt + wt[i];
}
for(i=0;i<n;i++)
{
    avg_tat = (float)tot_tat/n;
    avg_wt = (float)tot_wt/n;
}
 
System.out.println("************************");
System.out.println("\n RESULT:-"); 
System.out.println("Process  Arrival Time   Burst Time   Completion Time   Turn-Around Time   Worst Time" );
for(i=0;i<n;i++)
{
    System.out.println(p[i] + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i]);
}
 
System.out.println("\n\nAVERAGE WAITING TIME : "+ avg_wt);
System.out.println("\nAVERAGE TURN AROUND TIME :" + avg_tat);


}
}