package br.com.webApp.servletpt1.classes;
import br.com.webApp.servletpt1.classes.exceptions.excpetions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BD {

    public static ArrayList<Nome> listNomes = new ArrayList<Nome>();
    private Date dataCadastro;

    public void adicionarNaLista (Nome nome){
        BD.listNomes.add(nome);
    }

    public List<Nome> getListNomes (){
        return BD.listNomes;
    }
    public Nome getListNomeByID(int index){
        return BD.listNomes.get(index);
    }

    public int getIndex (int id) throws RuntimeException{
        int i = 0;
        for (Nome nome: listNomes) {
            if (listNomes.get(i).getId() == id){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void deletaNome (int index){
        BD.listNomes.remove(index);
    }

    public void editarNome (int index,  String nome, Date data){
            BD.listNomes.set(index, new Nome(nome, data));
    }

}
