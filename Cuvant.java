package spanzuratoarea;

import java.util.*;
import java.io.*;


public class Cuvant {
	
	private String cuvant_ales;
	private String cuvant_ghicit;
	private int vieti;
	
	
	public Cuvant()
	{
		
	}
	
	public int get_vieti()
	{
		return vieti;
	}
	
	public void set_vieti()
	{
		vieti=4;
	}
	
	public String get_cuvant_ales()
	{
		return cuvant_ales;
	}
	
	public String get_cuvant_ghicit()
	{
		return cuvant_ghicit;
	}
	
	/*se alege un numar aleator intre 1 si 4(cate cuvinte sunt in fisierul "cuvinte")*/
	public int numar_aleator()
	{
		//int numar_generat=0;
		
//		while(0==0)
//		{		
//		Random ra=new Random();
//		numar_generat=ra.nextInt();		
//		
//			if(numar_generat>=1&&numar_generat<=3)
//			{
//				return numar_generat;
//								
//			}			
//		}
		
		//incerc si altfel
		
//		Random ra=new Random();
//		
		//inconvenientul metodei este ca se genereaza un numar intre 0 si 3 cand de fapt se doreste 
		//sa se genereze un numar intre 1 si 3
		//deci fara 0
		
//		return ra.nextInt(4);
//		
		//si altfel
		int max=9;
		int min=1;
		
		return (int)Math.floor(Math.random() * (max - min + 1) + min);		
		
		
	}
	
	/*se alege un cuvant aleator din fisierul "cuvinte"*/
	public void alege_cuvant()
	{
		int numar_cuvant=numar_aleator();
		String s=new String("");
		
		//se va lua al ra cuvant din fisier
		
		try {
		
		BufferedReader in=new BufferedReader(new FileReader("cuvinte.txt"));
		
		int nr=0;
		
			while(nr<numar_cuvant)
			{
				nr++;
				s=in.readLine();			
			}
			
		in.close();
		 
		cuvant_ales=s;			
		
		}
		
		catch(Exception e)
		{
			System.out.println("Eroare 1: "+e);
		}		
	}
	
	/*initial se pastreaza doar prima si ultima litera din cuvant, celelalte sunt ascunse, inlocuite cu underscor "_"*/
	public void criptare_initiala()
	{
		char[] sir=new char[cuvant_ales.length()];
		
		sir[0]=cuvant_ales.charAt(0);
		sir[cuvant_ales.length()-1]=cuvant_ales.charAt(cuvant_ales.length()-1);
		
		for(int i=1;i<=cuvant_ales.length()-2;i++)
		{
			sir[i]='_';			
		}
		
		cuvant_ghicit=cuvant_ghicit.copyValueOf(sir);
		
	}
	
	/*variabila "litera" ce contine o litera, se cauta in cuvant_ales si daca este gasita, atunci se
	 * modifica "cuvant_ghicit"(in loc de underscor se pune litera corespunzatoare)*/	
	public void adauga_litera(String litera)
	{
		int[] pozitii=new int[20];
		char[] ca=new char[cuvant_ales.length()];
		char[] cg=new char[cuvant_ghicit.length()];
		char lit;
		
		lit=litera.charAt(0);
		
		/*verific daca "litera" se afla in "cuvant_ales"
		 * in cazul in care litera a fost ghicita se modifica "cuvant_ghicit".
		 * in caz contrar, scade numarul de vieti*/		
		if(cuvant_ales.contains(litera)==true)
		{
			ca=cuvant_ales.toCharArray();
			cg=cuvant_ghicit.toCharArray();
			
			/*caut "litera" in "cuvant_ales" si aflu pe ce pozitie sau pozitii se afla.
			 */
			
			for(int i=0;i<=cuvant_ales.length()-1;i++)
			{
				if(ca[i]==lit)
				{
					cg[i]=lit;
					
				}				
			}
			
			cuvant_ghicit=cuvant_ghicit.copyValueOf(cg);			
		}
		else
		{
			vieti--;
		}
		
		
	}
	
	/*verific daca jocul este terminat prin verificarea daca in vectorul "cuvant_ghicit"
	 * mai exista underscor.
	 * in cazul in care se afla caractere underscor functia returneaza true, altfel va returna false*/
	public boolean cuvant_gata_ghicit()
	{
		if(cuvant_ghicit.contains("_"))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	
	/*verific daca numarul de vieti este nenul, in acest caz returnez true.
	 * in cazul in care numarul de vieti este nul, returnez false*/
	public boolean vieti_posibile()
	{
		if(vieti!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	

}
