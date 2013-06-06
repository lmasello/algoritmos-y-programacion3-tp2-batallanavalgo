package disparos;

public class MomentoDeImpacto {
	
	int momento;
	
	public MomentoDeImpacto(int tiempo){
		
		momento = tiempo;
	}
	
	public void DisminuirMomentoDeImpacto(){
		
		momento = momento -1 ;
	}
	
	public int obtenerMomentoDeImpacto(){
		
		return momento;
	}
}
