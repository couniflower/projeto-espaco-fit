package model.bo;

public class Venda {
   private Personal personal;
   private Aluno aluno;
   private int id;
   private String identificacao;
   private String data;
   private float valorTotal;
   private String obs;

   public Venda() {
   }

   public Venda(Personal personal, Aluno aluno, int id, String identificacao, String data, float valorTotal, String obs) {
      this.personal = personal;
      this.aluno = aluno;
      this.id = id;
      this.identificacao = identificacao;
      this.data = data;
      this.valorTotal = valorTotal;
      this.obs = obs;
   }

   public Personal getPersonal() {
      return personal;
   }

   public void setPersonal(Personal personal) {
      this.personal = personal;
   }

   public Aluno getAluno() {
      return aluno;
   }

   public void setAluno(Aluno aluno) {
      this.aluno = aluno;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getIdentificacao() {
      return identificacao;
   }

   public void setIdentificacao(String identificacao) {
      this.identificacao = identificacao;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public float getValorTotal() {
      return valorTotal;
   }

   public void setValorTotal(float valorTotal) {
      this.valorTotal = valorTotal;
   }

   public String getObs() {
      return obs;
   }

   public void setObs(String obs) {
      this.obs = obs;
   }
}