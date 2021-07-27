package model.bo;

public class Personal extends Pessoa {
   private int id;
   private String rg;
   private String cpf;
   private String dtNasc;

   public Personal() {
   }

   public Personal(int id, String rg, String cpf, String dtNasc, Cep cep, String nome, String compleEndereco, String fone1, String fone2, String email, String obs) {
      super(cep, nome, compleEndereco, fone1, fone2, email, obs);
      this.id = id;
      this.rg = rg;
      this.cpf = cpf;
      this.dtNasc = dtNasc;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getRg() {
      return rg;
   }

   public void setRg(String rg) {
      this.rg = rg;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getDtNasc() {
      return dtNasc;
   }

   public void setDtNasc(String dtNasc) {
      this.dtNasc = dtNasc;
   }
}
