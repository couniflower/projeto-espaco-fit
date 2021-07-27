package model.bo;

public class Pessoa {
   private Cep cep;
   private String nome;
   private String compleEndereco;
   private String fone1;
   private String fone2;
   private String email;
   private String obs;

   public Pessoa() {
   }

   public Pessoa(Cep cep, String nome, String compleEndereco, String fone1, String fone2, String email, String obs) {
      this.cep = cep;
      this.nome = nome;
      this.compleEndereco = compleEndereco;
      this.fone1 = fone1;
      this.fone2 = fone2;
      this.email = email;
      this.obs = obs;
   }

   public Cep getCep() {
      return cep;
   }

   public void setCep(Cep cep) {
      this.cep = cep;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCompleEndereco() {
      return compleEndereco;
   }

   public void setCompleEndereco(String compleEndereco) {
      this.compleEndereco = compleEndereco;
   }

   public String getFone1() {
      return fone1;
   }

   public void setFone1(String fone1) {
      this.fone1 = fone1;
   }

   public String getFone2() {
      return fone2;
   }

   public void setFone2(String fone2) {
      this.fone2 = fone2;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getObs() {
      return obs;
   }

   public void setObs(String obs) {
      this.obs = obs;
   }
}
