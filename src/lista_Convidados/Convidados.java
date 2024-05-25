
package lista_Convidados;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Convidados {
    
    private String nome;
    private String email;
    private static List<Convidados>listaConvidados = new ArrayList<>();
  
    
    public Convidados(){}
    
    public Convidados(String nome, String email){
        this.email = email;
        this.nome = nome;
    }
            
    public static void adicionarParticipante (String nome, String email){
        Convidados convidado =  new Convidados(nome, email);
        if(!nome.isEmpty() && !email.isEmpty()){
            listaConvidados.add(convidado);
            JOptionPane.showMessageDialog(null,
                    "Obrigado por aceitar o convite!!!!\n"+nome+"\n"+"Email: "+email);
        }else{
             JOptionPane.showMessageDialog(null,
                     "Os campos não podem estar vazios.");
        }
    }
    
    public static void listarParticipantes(){ 
        List<Convidados> ordemAlfabetica = listaConvidados.stream().sorted
        (Comparator.comparing(Convidados::getNome)).collect
        (Collectors.toList());
        
        String colunas [] = {"nome", "email"};  
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        
        for(Convidados convidados: ordemAlfabetica){
            modelo.addRow(new Object[]{convidados.getNome(),convidados.getEmail()});
        }
    
        JTable tabela = new JTable(modelo);
        JFrame telaTabela = new JFrame("Lista de Convidados");
        telaTabela.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(tabela);
        telaTabela.add(scrollPane, BorderLayout.CENTER);
        telaTabela.setSize(400, 300);
        telaTabela.setVisible(true);
        telaTabela.setLocationRelativeTo(null);
        ordemAlfabetica.clear();
        
    }

 
    public static void removerParticipantes(String email){
        for(Convidados convidado : listaConvidados){
          if(convidado.getEmail().equals(email)){
              listaConvidados.remove(convidado);
              JOptionPane.showMessageDialog(null,"Convidado '" + convidado.nome + "' removido com sucesso!");             
              return;
              
          }
              
        }
       
        JOptionPane.showMessageDialog(null, "Convidado Não Encontrado.");      
    }
  
     public static void alterarinformacoes(String nome, String novoEmail){
     for (Convidados convidado:listaConvidados){
            if(convidado.getNome().equals(nome)){
                convidado.setEmail(novoEmail);
                JOptionPane.showMessageDialog(null, "Email alterado com sucesso!");
                return;
            }
                                                                
        } 
        JOptionPane.showMessageDialog(null, "Convidado Não Encontrado.");
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
    
    
}
